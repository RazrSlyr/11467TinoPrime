package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by guydu on 10/10/2017.
 */

@Autonomous(name="Encoder test", group=" ")
public class Encoders extends LinearOpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    final int CIRCUMFERENCE = (int)Math.round(3.54331 * Math.PI);
    final int NUM_TICKS = 2240;
    public void runOpMode() {

        Servo servo;
        leftMotor = hardwareMap.dcMotor.get("leftMotor");

        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Step", "1");
            telemetry.update();
            runWithEncoder(7, 0.25);
            while(leftMotor.isBusy() && rightMotor.isBusy() && opModeIsActive()){
                continue;
            }
            stop();
        }

    }

    public void runWithEncoder(int distance, double speed){

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.addData("Step", "2");
        telemetry.update();

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Step", "3");
        telemetry.update();

        int numTicks = distance / CIRCUMFERENCE * NUM_TICKS;

        leftMotor.setTargetPosition(numTicks);



        telemetry.addData("Step", "4");
        telemetry.update();

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Step", "5");
        telemetry.update();

        leftMotor.setPower(speed);
        rightMotor.setPower(speed);

        telemetry.addData("Step", "6");
        telemetry.update();

        /*while(opModeIsActive() && (leftMotor.isBusy() && rightMotor.isBusy())){
            telemetry.addData("Distance Left", leftMotor.getCurrentPosition() * CIRCUMFERENCE / NUM_TICKS);
            telemetry.addData("Distance Right", rightMotor.getCurrentPosition() * CIRCUMFERENCE / NUM_TICKS);
            telemetry.update(); //lol.
        }*/

        long time = System.currentTimeMillis();
        while(opModeIsActive() && System.currentTimeMillis() - time < 2000) continue;



        leftMotor.setPower(0);
        rightMotor.setPower(0);



    }

}


/*3.54331
2240 */




/*
camel case
ex Color Sensor
colorSensor
dcMotor - good!
DcMotor - wrong
Dc Motor - wrong
 */