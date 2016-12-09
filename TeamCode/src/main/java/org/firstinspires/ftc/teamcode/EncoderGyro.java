package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by TigeRobots on 11/26/2016.
 */
@Autonomous(name = "EncoderGyro",group = "Auto")
public class EncoderGyro extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();


    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;

    ModernRoboticsI2cGyro gyro;

    double motorOne;
    double motorTwo;
    double motorThree;
    double motorFour;
    double distanceTraveled;
    double currentTime;

    int    value                = 1;
    int    encoderFR            = 0;
    int    encoderFL            = 0;
    int    encoderBR            = 0;
    int    encoderBL            = 0;
    int    xVal, yVal, zVal     = 0;
    int    heading              = 0;
    int    angleZ               = 0;

    public void runOpMode(){

        roboInit();

        telemetry.addData(">", "Gyro Calibrating. Do Not move!");
        telemetry.update();
        gyro.calibrate();

        while (!isStopRequested() && gyro.isCalibrating()) {
            sleep(50);
            idle();
        }

        telemetry.addData(">", "Gyro Calibrated.  Press Start.");
        telemetry.update();

        runtime.reset();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            gyrostuff();
            switchCase();

        }
    }

    public void roboInit(){

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft  = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight  = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft   = hardwareMap.dcMotor.get("BACK_LEFT");
        gyro       = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("GYRO");

    }

    public void gyrostuff(){



    }

    public void switchCase(){



    }

    public void drive(double motor1, double motor2, double motor3, double motor4, int distance){
        motorOne           = motor1;
        motorTwo           = motor2;
        motorThree         = motor3;
        motorFour          = motor4;
        distanceTraveled   = distance;

        if(Math.abs(frontRight.getCurrentPosition() - encoderFR) <= distance) {
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
            encoderFR = frontRight.getCurrentPosition();
            encoderFL = frontLeft.getCurrentPosition();
            encoderBR = backRight.getCurrentPosition();
            encoderBL = backLeft.getCurrentPosition();
            value++;
        }

    }
}
