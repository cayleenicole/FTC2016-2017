package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by cicada02 on 1/18/17.
 */
@Disabled
@Autonomous(name = "RedAuto", group = "Cayles")
public class CompetitionReadyAutoRed extends LinearOpMode{

    private ElapsedTime runtime                     = new ElapsedTime();

    //Drive Train Motors
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;

    //IUO
    private DcMotor inTake;
    private DcMotor upTake;
    private DcMotor outTake;

    //Servos
    private Servo rightBeaconButton;
    private Servo leftBeaconButton;
    private Servo gate;

    //Gyro
    ModernRoboticsI2cGyro gyro;

    //Color Sensor
    ColorSensor lineColor;
    ColorSensor beaconColor;

    //Touch Sensors
    TouchSensor rightTouch;
    TouchSensor leftTouch;


    //Beacon Variables
    double  leftBeaconPosIn;
    double  leftBeaconPosOut;
    double  rightBeaconPosIn;
    double  rightBeaconPosOut;

    //Gate Variables
    double  gatePosUp;
    double  gatePosDown;
    double  gateTime;
    boolean loadIsReady;

    //Color Sensor Variables
    double colorOffset;
    double red;

    //Touch Sensor Variables
    boolean leftButton;
    boolean rightButton;

    //Gyro Variables
    boolean curResetState;
    boolean lastResetState;
    int     headingEncoder;
    int     headingOffset;
    double  turnPower;

    //Time Variables
    double currentTime;
    double strafeTime;
    double strafeSpeed;

    static final double     COUNTS_PER_MOTOR_REV    = 1680;
    static final double     DRIVE_GEAR_REDUCTION    = 1.0;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 3.94;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;

    //SwitchCase Variables
    int    value = 1;

    public void runOpMode(){

        roboInit();
        gyroInit();

        waitForStart();

        while (opModeIsActive()){

            driveSwitchCase();
            debug();

            idle();

        }

    }

    public void roboInit(){

        //Drive Train Motors
        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft  = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight  = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft   = hardwareMap.dcMotor.get("BACK_LEFT");

        //IOU
        inTake  = hardwareMap.dcMotor.get("INTAKE");
        upTake  = hardwareMap.dcMotor.get("UPTAKE");
        outTake = hardwareMap.dcMotor.get("SHOOTER");

        //MOTOR REVERSE
        outTake.setDirection(DcMotor.Direction.REVERSE);

        //BEACON
        rightBeaconButton   = hardwareMap.servo.get("RIGHT_BEACON");
        leftBeaconButton    = hardwareMap.servo.get("LEFT_BEACON");
        leftBeaconPosIn     = 0.3;
        leftBeaconPosOut    = 0.75;
        rightBeaconPosIn    = 0.75;
        rightBeaconPosOut   = 0.3;
        rightBeaconButton.setPosition(rightBeaconPosIn);
        leftBeaconButton.setPosition(leftBeaconPosIn);

        //Gate
        gate              = hardwareMap.servo.get("LOAD_FRONT");
        gatePosUp         = 0.0;
        gatePosDown       = 1.0;
        gateTime          = 0.5;
        loadIsReady       = false;
        gate.setPosition(gatePosDown);

        //GYRO INIT
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("GYRO");

        //COLOR SENSOR
        lineColor   = hardwareMap.colorSensor.get("LINE_COLOR");
        beaconColor = hardwareMap.colorSensor.get("BEACON_COLOR");
        beaconColor.enableLed(false);
        lineColor.enableLed(false);
        colorOffset = 0;
        red       = 2.0;

        //TOUCH SENSOR
        rightTouch = hardwareMap.touchSensor.get("RIGHT_TOUCH");
        leftTouch  = hardwareMap.touchSensor.get("LEFT_TOUCH");
        leftButton  = false;
        rightButton = false;

    }

    public void gyroInit(){

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


    }

    public void driveSwitchCase(){



    }

    public void debug(){



    }

    public void strafe(double speed, String direction){

        if(direction == "right"){

            frontRight.setPower(speed);
            backRight.setPower(-speed);
            frontLeft.setPower(speed);
            backLeft.setPower(-speed);

        }

        else if(direction == "left"){

            frontRight.setPower(-speed);
            backRight.setPower(speed);
            frontLeft.setPower(-speed);
            backLeft.setPower(speed);

        }

        else{

            robotStop();

        }

    }

    public void robotStop(){

        frontRight.setPower(0.0);
        backRight.setPower(0.0);
        frontLeft.setPower(0.0);
        backLeft.setPower(0.0);


    }

}
