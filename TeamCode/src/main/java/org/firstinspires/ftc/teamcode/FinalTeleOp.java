package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by cicada02 on 12/9/16.
 */
@TeleOp(name = "TeleOp", group = "TeleOp")
public class FinalTeleOp extends LinearOpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor flicker;
    DcMotor upTake;
    DcMotor inTake;

    Servo leftBeacon;
    Servo rightBeacon;
    Servo shooterGate;

    double in                       = 0.2;
    double out                      = 0.5;

    double gateIn                   = 0.2;
    double gateOut                  = 0.7;

    double leftBeaconPosition;
    boolean leftBeaconLastState;
    boolean leftBeaconCurrentState;

    double rightBeaconPosition;
    boolean rightBeaconLastState;
    boolean rightBeaconCurrentState;

    double gatePosition;
    boolean gateLastState;
    boolean gateCurrentState;

    public void runOpMode(){

        roboInit();

        waitForStart();

        while (opModeIsActive()){

            drive();
            beacons();
            inTakeAndUpTake();
            shoot();

            idle();

        }

    }

    public void roboInit(){

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft  = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight  = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft   = hardwareMap.dcMotor.get("BACK_LEFT");
        flicker    = hardwareMap.dcMotor.get("FLICKER");
        upTake     = hardwareMap.dcMotor.get("UP_TAKE");
        inTake     = hardwareMap.dcMotor.get("IN_TAKE");



    }

    public void drive(){

        double turn         = gamepad1.right_stick_x;
        double strafe       = gamepad1.left_stick_x;
        double forward      = gamepad1.left_stick_y;

        frontRight.setPower(constrain(turn + strafe - forward));
        frontLeft.setPower(constrain(turn + strafe + forward));
        backRight.setPower(constrain(turn - strafe - forward));


    }

    double constrain(double x) {

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }
    
    public void beacons(){

        leftBeaconCurrentState  = gamepad1.b;
        rightBeaconCurrentState = gamepad1.x;

        if (leftBeaconCurrentState && !leftBeaconLastState && leftBeaconPosition == in){

            leftBeaconPosition = out;

        }

        else if (leftBeaconCurrentState && !leftBeaconLastState && leftBeaconPosition == out){

            leftBeaconPosition = in;

        }
        leftBeaconLastState = leftBeaconCurrentState;
        leftBeacon.setPosition(leftBeaconPosition);

        if (rightBeaconCurrentState && !rightBeaconLastState && rightBeaconPosition == in){

            rightBeaconPosition = out;

        }
        else if (rightBeaconCurrentState && !rightBeaconLastState && rightBeaconPosition == out){

            rightBeaconPosition = in;

        }
        rightBeaconLastState = leftBeaconCurrentState;
        rightBeacon.setPosition(leftBeaconPosition);

    }
    
    public void inTakeAndUpTake(){
        
        if(gamepad1.a){
            
            inTake.setPower(0.5);
            upTake.setPower(0.5);
            
        }
        else if(gamepad1.y){
            
            inTake.setPower(-0.5);
            upTake.setPower(-0.5);
            
        }
        else{
            
            inTake.setPower(0.0);
            upTake.setPower(0.0);
            
        }

    }

    public void shoot(){

        flicker.setPower(gamepad1.right_trigger);

        gateCurrentState = gamepad1.right_bumper;

        if (gateCurrentState && !gateLastState && gatePosition == gateIn){

            gatePosition = out;

        }
        else if (gateCurrentState && !gateLastState && gatePosition == gateOut){

            gatePosition = in;

        }

    }
}
