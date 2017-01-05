package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by TigeRobots on 12/2/2016.
 */
@Disabled
@TeleOp(name = "Driver", group = "TeleOp")
public class DoodleBobDriver extends LinearOpMode {

    private ElapsedTime runtime     = new ElapsedTime();

   /* final static double minRange    = 0.3;
    final static double maxRange    = 0.8;

    double in                       = 0.3;
    double out                      = 0.7;
    double position                 = in;

    boolean lastState = false;
    boolean currentState  = false;
    boolean servoPosition  = false;*/

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor flicker;

    Servo rightPress;
    Servo leftPress;

    public void runOpMode(){

        roboInit();

        waitForStart();

        while (opModeIsActive()){

            driver();

        }

        debug();

    }

    public void roboInit(){

        frontRight   = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft    = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight    = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft     = hardwareMap.dcMotor.get("BACK_LEFT");
        flicker      = hardwareMap.dcMotor.get("FLICKER");

        rightPress   = hardwareMap.servo.get("RIGHT_PRESS");
        leftPress    = hardwareMap.servo.get("LEFT_PRESS");


    }

    public void driver(){

        double turn         = gamepad1.right_stick_x;
        double strafe       = gamepad1.left_stick_x;
        double forward      = gamepad1.left_stick_y;

        frontRight.setPower(constrain(turn + strafe - forward));
        frontLeft.setPower(constrain(turn + strafe + forward));
        backRight.setPower(constrain(turn - strafe - forward));
        backLeft.setPower(constrain(turn - strafe + forward));

        flicker.setPower(gamepad1.right_trigger);


    }

    double constrain(double x) {

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }

    public void debug(){

        telemetry.addData("Status", "Run Time: " + runtime.toString());

    }
}
