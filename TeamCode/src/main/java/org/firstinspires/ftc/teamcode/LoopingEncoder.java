package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by guydu on 1/5/2018.
 */


@Autonomous(name = "Hella loopy doopy i want to commit", group = "")
public class LoopingEncoder extends LinearOpMode {
    Robot robot = new Robot();

    private boolean rBumpPressed = false;
    private boolean lBumpPressed = false;

    public void runOpMode() {
        robot.setHardwareMap(hardwareMap);

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        while (opModeIsActive()) {
            robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            robot.leftMotor.setTargetPosition(500);
            robot.rightMotor.setTargetPosition(500);

            robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.leftMotor.setPower(0.3);
            robot.rightMotor.setPower(0.3);

            if(!(robot.leftMotor.isBusy() && robot.rightMotor.isBusy() && opModeIsActive())) {
                robot.leftMotor.setPower(0);
                robot.rightMotor.setPower(0);
            }





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
