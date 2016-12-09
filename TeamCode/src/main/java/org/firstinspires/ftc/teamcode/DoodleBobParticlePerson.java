package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by TigeRobots on 12/8/2016.
 */
@TeleOp(name = "ParticlePerson", group = "TeleOp")
public class DoodleBobParticlePerson extends LinearOpMode {

    private ElapsedTime runtime     = new ElapsedTime();

    DcMotor capBall;
    DcMotor inTake;
    DcMotor upTake;

    Servo ballRelease;
    Servo forksRelease;
    Servo forksStage;


    public void runOpMode(){

        roboInit();

        while (opModeIsActive()){

            particlePerson();
            debug();

        }

    }

    public void roboInit(){

        capBall      = hardwareMap.dcMotor.get("CAP_BALL");
        inTake       = hardwareMap.dcMotor.get("IN_TAKE");
        upTake       = hardwareMap.dcMotor.get("UP_TAKE");

        ballRelease  = hardwareMap.servo.get("BALL_RELEASE");
        forksRelease = hardwareMap.servo.get("FORKS_RELEASE");
        forksStage   = hardwareMap.servo.get("FORKS_STAGE");

    }

    public void particlePerson(){


        if(gamepad2.a){

            inTake.setPower(0.5);
            upTake.setPower(0.5);

        }
        else if(gamepad2.y){

            inTake.setPower(-0.5);
            upTake.setPower(-0.5);

        }
        else{

            inTake.setPower(0.0);
            upTake.setPower(0.0);

        }

        if(gamepad2.dpad_up){

            capBall.setPower(0.5);

        }
        else if (gamepad2.dpad_down){

            capBall.setPower(-0.5);

        }
        else{

            capBall.setPower(0.0);

        }

    }

    double constrain(double x) {

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }

    public void debug(){

        telemetry.addData("Status", "Run Time: " + runtime.toString());

    }
}
