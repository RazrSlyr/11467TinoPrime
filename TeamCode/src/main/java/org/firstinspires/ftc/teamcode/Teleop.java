package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by guydu on 12/1/2017.
 */

@TeleOp(name = "Main Tele", group = " ")
public class Teleop extends OpMode{

    final double CIRCUMFERENCE = 0.721 * Math.PI;
    final double TICKS_PER_ROTATION = 500 * 5/2.5 * 5/4.5 * 9/8; //Pretend it's 5 inches, scale later.

    double speed = 0.5;

    Robot robot = new Robot();
    private boolean rBumpPressed = false;
    private boolean lBumpPressed = false;
    private boolean up = false;

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
        double turnConst = gamepad1.right_bumper ? 1 : (gamepad1.left_bumper ? -1 : 0);


        robot.leftMotor.setPower((ly + turnConst) * speed);
        robot.rightMotor.setPower((ly - turnConst) * speed);




       //robot.slide.setPower(gamepad1.right_stick_y);

        if(gamepad1.left_trigger > 0){
            //robot.iterateOpening();
            robot.claw.setPower(1);
        }else if(gamepad1.right_trigger > 0){
            //robot.iterateClosing();
            robot.claw.setPower(-1);
        } else {
            robot.claw.setPower(0);
        }

        /*if (gamepad1.right_bumper && !(rBumpPressed || lBumpPressed) && !up) {
            startMoveUp();
        }

        if (gamepad1.left_bumper && !(rBumpPressed || lBumpPressed) && up) {
            startMoveDown();
        }

        if(rBumpPressed || lBumpPressed) {
            checkPos();
        }*/

        robot.slide.setPower(-ry);


        telemetry.addData("L Power", robot.leftMotor.getPower());
        telemetry.addData("R Power", robot.rightMotor.getPower());
        telemetry.addData("Slide", robot.slide.getPower());
        telemetry.update();




    }
/*    private void startMoveUp() {
        robot.slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.slide.setTargetPosition((int)((7 / CIRCUMFERENCE) * TICKS_PER_ROTATION));
        robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slide.setPower(0.5);
        rBumpPressed = true;
        up = true;
    }

    private void startMoveDown() {
        robot.slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.slide.setTargetPosition((int)((-7 / CIRCUMFERENCE) * TICKS_PER_ROTATION));
        robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slide.setPower(0.5);
        lBumpPressed = true;
        up = false;
    }

    private void checkPos() {
        if(robot.slide.isBusy()) {
            if(rBumpPressed) {
                telemetry.addData("Moving:", "Up");
            } else {
                telemetry.addData("Moving:", "Down");
            }
            telemetry.update();
        } else {
            telemetry.addData("Moving:", "None");
            telemetry.update();
            robot.slide.setPower(0);
            rBumpPressed = false;
            lBumpPressed = false;
        }

    }*/
}
