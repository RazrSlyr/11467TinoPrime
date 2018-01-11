package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by guydu on 1/8/2018.
 */

@TeleOp(name = "SlideEncoder", group = "")
public class SlideEncoder extends OpMode {

    private boolean rBumpPressed = false;
    private boolean lBumpPressed = false;

    Robot robot = new Robot();
    public void init() {
        robot.setHardwareMap(hardwareMap);
    }

    public void loop() {

        if (gamepad1.right_bumper && !(rBumpPressed || lBumpPressed)) {
            startMoveUp();
        }

        if (gamepad1.left_bumper && !(rBumpPressed || lBumpPressed)) {
            startMoveDown();
        }

        if(rBumpPressed || lBumpPressed) {
            checkPos();
        }

    }


    private void startMoveUp() {
        robot.slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.slide.setTargetPosition(-750 * 5);
        robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slide.setPower(0.5);
        rBumpPressed = true;
    }

    private void startMoveDown() {
        robot.slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.slide.setTargetPosition(750 * 5);
        robot.slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.slide.setPower(0.5);
        lBumpPressed = true;
    }

    private void checkPos() {
        if(robot.slide.isBusy()) {
             telemetry.addData("Moving:", "Up");
             telemetry.update();
        } else {
            telemetry.addData("Moving:", "None");
            telemetry.update();
            robot.slide.setPower(0);
            rBumpPressed = false;
            lBumpPressed = false;
        }

    }

}