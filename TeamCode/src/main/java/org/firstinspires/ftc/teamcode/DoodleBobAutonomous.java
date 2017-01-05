package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by cicada02 on 12/9/16.
 */
@Disabled
@Autonomous(name = "Autonomous", group = "Auto")
public class DoodleBobAutonomous extends LinearOpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor upTake;
    DcMotor inTake;
    DcMotor shooter;

    double motorOne;
    double motorTwo;
    double motorThree;
    double motorFour;//Mecanum drive
    double motorFive;//upTake
    double motorSix;//inTake
    double motorSeven;//shooter
    double distanceTraveled;
    double currentTime;

    int    value = 1;
    int    encoderValue = 0;

    public void runOpMode(){

        roboInit();

        waitForStart();

        while(opModeIsActive()){



        }

    }

    public void roboInit(){

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft  = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight  = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft   = hardwareMap.dcMotor.get("BACK_LEFT");
        upTake     = hardwareMap.dcMotor.get("UP_TAKE");
        inTake     = hardwareMap.dcMotor.get("IN_TAKE");
        shooter    = hardwareMap.dcMotor.get("SHOOTER");

    }

    public void drive(double motor1, double motor2, double motor3, double motor4, int distance){

        motorOne           = motor1;
        motorTwo           = motor2;
        motorThree         = motor3;
        motorFour          = motor4;
        distanceTraveled   = distance;

        if(Math.abs(frontRight.getCurrentPosition() - encoderValue) <= distance) {
            frontRight.setPower(motorOne);
            frontLeft.setPower(motorTwo);
            backRight.setPower(motorThree);
            backLeft.setPower(motorFour);
        }
        else {
            frontRight.setPower(0.0);
            frontLeft.setPower(0.0);
            backRight.setPower(0.0);
            backLeft.setPower(0.0);
            encoderValue = frontRight.getCurrentPosition();
            value++;
        }

    }
}
