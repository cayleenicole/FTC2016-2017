package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by cicada02 on 12/16/16.
 */
@TeleOp(name = "CompetitionReady", group = "Cayles")
public class CompTest extends LinearOpMode{

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor inTake;
    DcMotor upTake;
    DcMotor shooter;

    Servo rightButton;
    Servo leftButton;
    Servo gate;

    double driveX;
    double driveY;
    double driveRotate;
    double expoCurve;

    boolean shooterButton;

    public void runOpMode(){

        roboInit();

        while (opModeIsActive()){

            drive();
            shooter();

        }

    }

    public void roboInit(){

        frontRight  = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft   = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight   = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft    = hardwareMap.dcMotor.get("BACK_LEFT");
        inTake      = hardwareMap.dcMotor.get("INTAKE");
        upTake      = hardwareMap.dcMotor.get("UPTAKE");
        shooter     = hardwareMap.dcMotor.get("SHOOTER");

        rightButton    = hardwareMap.servo.get("RIGHT_BUTTON");
        leftButton     = hardwareMap.servo.get("LEFT_BUTTON");
        gate           = hardwareMap.servo.get("LOAD_FRONT");

    }

    public void drive(){

        driveRotate = gamepad1.right_stick_x;
        driveY      = gamepad1.left_stick_y;
        driveX      = gamepad1.left_stick_x;

        frontRight.setPower(expo(constrain(driveRotate + driveY + driveX),expoCurve));
        frontLeft.setPower(expo(constrain(driveRotate - driveY + driveX),expoCurve));
        backRight.setPower(expo(constrain(driveRotate + driveY - driveX),expoCurve));
        backLeft.setPower(expo(constrain(driveRotate - driveY  - driveX),expoCurve));

    }
    public void shooter(){



    }

    double expo(double x, double a){

        double y = x;
        y = a * Math.pow(y, 3) + (1-a)*y;
        return y;

    }

    double constrain(double x){

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }
}
