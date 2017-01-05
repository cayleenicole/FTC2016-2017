package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by TigeRobots on 12/1/2016.
 */
@Disabled
@TeleOp(name = "Arcade", group = "TeleOp")
public class DoodleBobArcade extends LinearOpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;

    public void runOpMode(){

        roboInit();

        while (opModeIsActive()){

            drive();

        }

    }

    public void roboInit(){

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft  = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight  = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft   = hardwareMap.dcMotor.get("BACK_LEFT");

    }

    public void drive(){

        double forward = gamepad1.left_stick_y;
        double turn    = gamepad1.left_stick_x;

        frontRight.setPower(forward + turn);
        frontLeft.setPower(forward - turn);
        backRight.setPower(forward + turn);
        backLeft.setPower(forward - turn);

    }
}
