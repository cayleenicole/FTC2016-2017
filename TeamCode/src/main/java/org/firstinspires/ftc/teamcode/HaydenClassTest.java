package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by TigeRobots on 11/29/2016.
 */
@TeleOp(name = "Hayden", group = "TeleOp")
public class HaydenClassTest extends LinearOpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor middleRight;
    DcMotor middleLeft;
    DcMotor backRight;
    DcMotor backLeft;

    public void runOpMode(){

        roboInit();

        while (opModeIsActive()){

            drive();

        }

    }

    public void roboInit(){

        frontRight  = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft   = hardwareMap.dcMotor.get("FRONT_LEFT");
        middleRight = hardwareMap.dcMotor.get("MIDDLE_RIGHT");
        middleLeft  = hardwareMap.dcMotor.get("MIDDLE_LEFT");
        backRight   = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft    = hardwareMap.dcMotor.get("BACK_LEFT");

    }

    public void drive(){

        double forward = gamepad1.left_stick_y;
        double turn    = gamepad1.left_stick_x;

        frontRight.setPower(constrain(forward + turn));
        frontLeft.setPower(constrain(forward - turn));
        middleRight.setPower(constrain(forward + turn));
        middleLeft.setPower(constrain(forward - turn));
        backRight.setPower(constrain(forward + turn));
        backLeft.setPower(constrain(forward - turn));

    }

    double constrain(double x) {

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }
}
