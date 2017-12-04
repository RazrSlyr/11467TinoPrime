package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by guydu on 12/1/2017.
 */

@TeleOp(name = "Main Tele", group = " ")
public class Teleop extends OpMode{
    double speed = 0.5;

    Robot robot = new Robot();
    public void init() {
        robot.setHardwareMap(hardwareMap);
        telemetry.addData("Ready", "");

        telemetry.update();
    }

    public void loop(){
        double ly = -gamepad1.left_stick_y;
        double ry = -gamepad1.right_stick_y;
        double rx = gamepad1.right_stick_x;
        double lx = gamepad1.left_stick_x;


        robot.leftMotor.setPower(Range.clip(ly + lx, -1 ,1));
        robot.rightMotor.setPower(Range.clip(ly - lx, -1 ,1));

        robot.slide.setPower(-gamepad2.right_stick_y);

        if(gamepad2.right_trigger > 0){
            robot.claw.setPower(0.5);
        }else if(gamepad2.left_trigger > 0){
            robot.claw.setPower(-0.5);
        } else {
            robot.claw.setPower(0);
        }








    }
}
