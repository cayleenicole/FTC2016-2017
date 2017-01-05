package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by TigeRobots on 12/1/2016.
 */
@Disabled
@TeleOp(name = "Flicker", group = "TeleOp")
public class Flicker extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor flicker;

    int    encoderValue = 0;

    public void runOpMode(){

        roboInit();

        waitForStart();

        while (opModeIsActive()){

            telemetry.addData("Status", "Run Time: " + runtime.toString());

            debug();
            drive();

        }

    }

    public void roboInit(){

        flicker = hardwareMap.dcMotor.get("FLICKER");

    }

    public void debug(){

        telemetry.addData("FLICKER", flicker.getCurrentPosition());

    }

    public void drive(){

        flicker.setPower(gamepad1.left_stick_x);

    }
}
