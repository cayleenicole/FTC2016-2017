package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by cicada02 on 12/9/16.
 */
@Disabled
@TeleOp(name = "Servo", group = "TeleOp")
public class Servos extends LinearOpMode{

    //Beacons
    Servo leftBeaconPress;
    Servo rightBeaconPress;

    /*//ScissorLift
    Servo ballRelease;
    Servo forksRelease;
    Servo iFSServo;*/

    //Uptake Gates
    Servo gateOne;
    /*Servo gateTwo;*/

    public void runOpMode(){

        roboInit();

        while(opModeIsActive()){

            beacons();

        }


    }

    public void roboInit(){

        leftBeaconPress  = hardwareMap.servo.get("LEFT_BEACON");
        rightBeaconPress = hardwareMap.servo.get("RIGHT_BEACON");

        /*ballRelease      = hardwareMap.servo.get("BALL_LEASE");
        forksRelease     = hardwareMap.servo.get("FORKS_RELEASE");
        iFSServo         = hardwareMap.servo.get("FORKS_STAGE");*/

        gateOne          = hardwareMap.servo.get("GATE_ONE");

        /*gateTwo          = hardwareMap.servo.get("GATE_TWO");*/

    }

    public void beacons(){



    }
}
