package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by TigeRobots on 12/8/2016.
 */
@Disabled
@TeleOp(name = "FinalServo", group = "TeleOp")
public class DoodleBobFinalServo extends LinearOpMode {

    //Beacons
    Servo leftBeaconPress;
    Servo rightBeaconPress;

    //ScissorLift
    Servo ballRelease;
    Servo forksRelease;
    Servo iFSServo;

    //Uptake Gates
    Servo gateOne;
    Servo gateTwo;

    double leftBeaconPosition;
    /*double leftBeaconPosOut;*/
    boolean leftBeaconLastState;
    boolean leftBeaconCurrentState;

    double rightBeaconPosition;
    /*double rightBeaconPosOut;*/
    boolean rightBeaconLastState;
    boolean rightBeaconCurrentState;

    double ballReleasePosition;
    /*double ballReleasePosOut;*/
    boolean ballReleaseLastState;
    boolean ballReleaseCurrentState;

    double forksReleasePosition;
    /*double forksReleasePosOut;*/
    boolean forksReleaseLastState;
    boolean forksReleaseCurrentState;

    double iFSePosition;
    /*double iFSePosOut;*/
    boolean iFSLastState;
    boolean iFSCurrentState;

    double gateOnePosition;
    /*double gateOnePosOut;*/
    boolean gateOneLastState;
    boolean gateOneCurrentState;

    double gateTwoPosition;
    /*double gateTwoPosOut;*/
    boolean gateTwoLastState;
    boolean gateTwoCurrentState;

    public void runOpMode(){

        roboInit();

        while(opModeIsActive()){

            beacons();
            scissorLift();
            upTake();

        }

    }

    public void roboInit(){

        leftBeaconPress  = hardwareMap.servo.get("LEFT_BEACON");
        rightBeaconPress = hardwareMap.servo.get("RIGHT_BEACON");

        ballRelease      = hardwareMap.servo.get("BALL_RELEASE");
        forksRelease     = hardwareMap.servo.get("FORKS_RELEASE");
        iFSServo         = hardwareMap.servo.get("FORKS_STAGE");

        gateOne          = hardwareMap.servo.get("GATE_ONE");
        gateTwo          = hardwareMap.servo.get("GATE_TWO");

        leftBeaconCurrentState   = gamepad1.b;
        rightBeaconCurrentState  = gamepad1.x;

        ballReleaseCurrentState  = gamepad2.right_bumper;
        forksReleaseCurrentState = gamepad2.b;
        iFSCurrentState          = gamepad2.x;

        gateOneCurrentState      = gamepad1.a;
        gateTwoCurrentState      = gamepad1.y;

        double leftBeaconPosition;
        double rightBeaconPosition;
        double ballReleasePosition;
        double forksReleasePosition;
        double iFSePosition;
        double gateOnePosition;
        double gateTwoPosition;

    }

    public void beacons(){

        final double minRange = 0.3;
        final double maxRange = 0.8;

        if(leftBeaconCurrentState && !leftBeaconLastState){



        }

    }

    public void scissorLift(){



    }

    public void upTake(){



    }
}
