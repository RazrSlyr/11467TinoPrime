package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by guydu on 10/17/2017.
 */

public class Robot {

    final double CIRCUMFERENCE = 10;
    final double TICKS_PER_ROTATION = 2460;

    Servo leftClawServo;
    Servo rightClawServo;

    DcMotor leftMotor;
    DcMotor rightMotor;

    public Robot() {

    }


    public void setHardwareMap(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");

        leftClawServo = hardwareMap.servo.get("leftCLawServo");
        rightClawServo = hardwareMap.servo.get("rightClawServo");
    }

    public void moveClaw(double angle){
        leftClawServo.setPosition(angle / 180);
        rightClawServo.setPosition(angle / 180);

    }

    public void moveDistance(double distance, double speed, LinearOpMode linearOpMode){
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int numTicks = (int)(distance / CIRCUMFERENCE * TICKS_PER_ROTATION);

        leftMotor.setTargetPosition(numTicks);
        rightMotor.setTargetPosition(numTicks);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setPower(speed);
        rightMotor.setPower(speed);

        while (leftMotor.isBusy() && rightMotor.isBusy() && linearOpMode.opModeIsActive()){
            linearOpMode.telemetry.addData("Left Motor Position", leftMotor.getCurrentPosition());
            linearOpMode.telemetry.update();
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }

}
