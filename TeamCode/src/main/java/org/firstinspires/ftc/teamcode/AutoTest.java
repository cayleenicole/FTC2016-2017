package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * Created by owner on 10/21/2016.
 */
@Disabled
@Autonomous(name = "AutoTest",group = "Auto")
public class AutoTest extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    double motorOne;
    double motorTwo;
    double motorThree;
    double motorFour;
    double distanceTraveled;
    double currentTime;

    @Override
    public void init() {

        frontLeft = hardwareMap.dcMotor.get("FRONT_LEFT");
        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        backLeft = hardwareMap.dcMotor.get("BACK_LEFT");
        backRight = hardwareMap.dcMotor.get("BACK_RIGHT");

    }

    @Override
    public void loop() {

        autonomous();
        /*debug();*/

    }

    public void autonomous() {

        switchCase();
    }

    public void switchCase() {

        /*switch(value){

            case 1: drive(-0.5, 0.5, -0.5, 0.5, 2650 );
                break;
            case 2: delay(0.5);value++;encoderValue = frontRight.getCurrentPosition();
                break;
            case 3: drive(-0.5, -0.5 , 0.5, 0.5, 3000);
                break;
            case 4: delay(0.5);value++;encoderValue = frontRight.getCurrentPosition();
                break;
            case 5:drive(-0.5, 0.5, -0.5, 0.5, 5250);
                break;
            case 6:delay(0.5);value++;encoderValue = frontRight.getCurrentPosition();
                break;
            case 7:drive(0.5, 0.5, -0.5, -0.5, 6500);
                break;
            case 8:delay(0.5);value++;encoderValue = frontRight.getCurrentPosition();
                break;
            case 9:drive(0.5, -0.5, 0.5, -0.5, 8000);
                break;
            default:frontLeft.setPower(0.0);frontRight.setPower(0.0);backLeft.setPower(0.0);backRight.setPower(0.0);
                break;

        }

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

    }*/

        /*public void delay ( double time){

            currentTime = getRuntime();

            while (getRuntime() - currentTime < time) {

                frontLeft.setPower(0.0);
                frontRight.setPower(0.0);
                backLeft.setPower(0.0);
                backRight.setPower(0.0);

            }

        }


   /* public void debug(){

        telemetry.addData("FRONT_RIGHT", frontRight.getCurrentPosition());
        telemetry.addData("DISTANCE", distanceTraveled);
        telemetry.addData("WHAT_IS_COMPARED", Math.abs(frontRight.getCurrentPosition()-encoderValue));
        telemetry.addData("CASE", value);

    }*/
    }
}