package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.lang.Math;

/**
 * Created by TigeRobots on 11/18/2016.
 *
 * Final TeleOp code for Ftc 2016-2017
 *
 * Next meeting I need to switch the motors on
 * their ports, either on the phones or on the
 * hardware because the motors are switched. Like
 * frontRight motor is actually frontLeft motor,
 * and vice versa. backRight is actually backLeft
 * and vice verca.
 */
@TeleOp (name = "FinalTeleOp", group = "TeleOp")
public class FinalTeleOp extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();


    ModernRoboticsI2cGyro gyro;   // Hardware Device Object
    int xVal, yVal, zVal = 0;     // Gyro rate Values
    int heading = 0;              // Gyro integrated heading
    int angleZ = 0;
    boolean lastResetState = false;
    boolean curResetState  = false;

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;



    public void runOpMode(){

        roboInit();

        // start calibrating the gyro.
        telemetry.addData(">", "Gyro Calibrating. Do Not move!");
        telemetry.update();
        gyro.calibrate();

        // make sure the gyro is calibrated.
        while (!isStopRequested() && gyro.isCalibrating())  {
            sleep(50);
            idle();
        }

        telemetry.addData(">", "Gyro Calibrated.  Press Start.");
        telemetry.update();

        runtime.reset();

        waitForStart();// Wait for the game to start (driver presses PLAY)

        while (opModeIsActive()){

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            drive(gamepad1.right_stick_x, gamepad1.left_stick_x, gamepad1.left_stick_y);

            gyrostuff();

            debug();

            idle();

        }

    }

    public void roboInit() {

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft = hardwareMap.dcMotor.get("BACK_LEFT");
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("GYRO");

    }

    double constrain(double x) {

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }

    public void drive(double x, double y, double z) {

        double gyroOffset = 0.0;//(gyro.getIntegratedZValue()*0.03)-0.00;

        frontRight.setPower(constrain((x + y + z)+gyroOffset));
        frontLeft.setPower(constrain((x + y - z)+gyroOffset));
        backRight.setPower(constrain((x - y + z)+gyroOffset));
        backLeft.setPower(constrain((x - y - z)+gyroOffset));

        telemetry.addData("1", "Int. Ang. %03d", gyro.getIntegratedZValue());

    }

    public void debug(){



    }

    public void gyrostuff(){

        // if the A and B buttons are pressed just now, reset Z heading.
        curResetState = (gamepad1.a);
        if(curResetState && !lastResetState)  {
            gyro.resetZAxisIntegrator();
        }
        lastResetState = curResetState;

        // get the x, y, and z values (rate of change of angle).
        xVal = gyro.rawX();
        yVal = gyro.rawY();
        zVal = gyro.rawZ();

        // get the heading info.
        // the Modern Robotics' gyro sensor keeps
        // track of the current heading for the Z axis only.
        heading = gyro.getHeading();
        angleZ  = gyro.getIntegratedZValue();

        telemetry.addData(">", "Press A & B to reset Heading.");
        telemetry.addData("0", "Heading %03d", heading);

        telemetry.addData("2", "X av. %03d", xVal);
        telemetry.addData("3", "Y av. %03d", yVal);
        telemetry.addData("4", "Z av. %03d", zVal);
        telemetry.update();
    }

    public void rotate() {

        frontRight.setPower(constrain(gamepad1.right_stick_x));
        frontLeft.setPower(constrain(gamepad1.right_stick_x));
        backRight.setPower(constrain(gamepad1.right_stick_x));
        backLeft.setPower(constrain(gamepad1.right_stick_x));

    }
}
