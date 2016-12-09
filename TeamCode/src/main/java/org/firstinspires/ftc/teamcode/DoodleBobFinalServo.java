package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by TigeRobots on 12/8/2016.
 */
@TeleOp(name = "FinalServo", group = "TeleOp")
public class DoodleBobFinalServo extends LinearOpMode {

    //Beacons
    Servo leftBeaconPress;
    Servo rightBeaconPress;

    //ScissorLift
    Servo ballRelease;
    Servo forksRelease;
    Servo intermediateForksStage;

    //Uptake Gates
    Servo gateOne;
    Servo gateTwo;

    double leftBeaconPosIn;
    double leftBeaconPosOut;
    boolean leftBeaconLastState;
    boolean leftBeaconCurrentState;

    double RightBeaconPosIn;
    double RightBeaconPosOut;
    boolean rightBeaconLastState;
    boolean rightBeaconCurrentState;

    double ballReleasePosIn;
    double ballReleasePosOut;
    boolean ballReleaseLastState;
    boolean ballReleaseCurrentState;

    double forksReleasePosIn;
    double forksReleasePosOut;
    boolean forksReleaseLastState;
    boolean forksReleaseCurrentState;

    double iFSePosIn;
    double iFSePosOut;
    boolean iFSLastState;
    boolean iFSCurrentState;

    double gateOnePosIn;
    double gateOnePosOut;
    boolean gateOneLastState;
    boolean gateOneCurrentState;

    double gateTwoPosIn;
    double gateTwoPosOut;
    boolean gateTwoLastState;
    boolean gateTwoCurrentState;

    public void runOpMode(){

        roboInit();

    }

    public void roboInit(){

        leftBeaconPress = hardwareMap.servo.get("LEFT_BEACON");

    }
}
