package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by owner on 10/13/2016.
 */
@Disabled
@TeleOp(name = "TEST", group = "TeleOp")
public class MecanumTest extends OpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;



    @Override
    public void init(){

        frontRight = hardwareMap.dcMotor.get("FRONT_RIGHT");
        frontLeft = hardwareMap.dcMotor.get("FRONT_LEFT");
        backRight = hardwareMap.dcMotor.get("BACK_RIGHT");
        backLeft = hardwareMap.dcMotor.get("BACK_LEFT");

    }

    @Override
    public void loop(){

    drive();

}

    public void drive(){

        double x = gamepad1.right_stick_x;
        double y = gamepad1.left_stick_x;
        double z = gamepad1.left_stick_y;

        backLeft.setPower(constrain(x - y  + z));
        frontRight.setPower(constrain(x + y  - z));
        frontLeft.setPower(constrain(x + y  + z));
        backRight.setPower(constrain(x - y  - z));

    }

    double constrain(double x){

        double speed;
        speed = x;

        speed = Range.clip(speed, -1, 1);

        return speed;

    }
}
