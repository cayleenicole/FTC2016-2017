package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by TigeRobots on 12/1/2016.
 */
@TeleOp(name = "InTakeSystem", group = "TeleOp")
public class DoodleBobParticleSystem extends LinearOpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;


    DcMotor upTake;
    DcMotor flicker;
    DcMotor capBall;
    DcMotor inTake;

    public void runOpMode(){

        roboInit();

        while (opModeIsActive()){

            system();

        }

    }

    public void roboInit(){

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft  = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight  = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft   = hardwareMap.dcMotor.get("BACK_LEFT");

        upTake     = hardwareMap.dcMotor.get("UP_TAKE");
        flicker    = hardwareMap.dcMotor.get("FLCKER");
        capBall    = hardwareMap.dcMotor.get("CAP_BALL");
        inTake     = hardwareMap.dcMotor.get("IN_TAKE");

    }

    public void system(){

       /* inTake.setPower();*/

    }
}
