package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by guydu on 21/69/420.
 */

public class Robot {

    final double CIRCUMFERENCE = 3.54331 * Math.PI;
    final double TICKS_PER_ROTATION = 2460 * 12/53.5 * 24/25.5;

    Servo leftClawServo;
    Servo rightClawServo;

    DcMotor leftMotor;
    DcMotor rightMotor;

    ModernRoboticsI2cGyro gyro;

    static final double     HEADING_THRESHOLD       = 1 ;      // As tight as we can make it with an integer gyro
    static final double     P_TURN_COEFF            = 0.1;     // Larger is more responsive, but also less stable
    static final double     P_DRIVE_COEFF           = 0.15;     // Larger is more responsive, but also less stable

    public Robot() {

    }


    public void setHardwareMap(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");

   ;//     leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

     /*   leftClawServo = hardwareMap.servo.get("leftCLawServo");
        rightClawServo = hardwareMap.servo.get("rightClawServo");

        gyro = (ModernRoboticsI2cGyro)hardwareMap.i2cDevice.get("Gyro");*/
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

    public void gyroTurn (double speed, double angle, LinearOpMode linearOpMode) {

        // keep looping while we are still active, and not on heading.
        while (linearOpMode.opModeIsActive() && !onHeading(speed, angle, P_TURN_COEFF, linearOpMode)) {
            // Update telemetry & Allow time for other processes to run.
            linearOpMode.telemetry.update();
        }
    }

    boolean onHeading(double speed, double angle, double PCoeff, LinearOpMode linearOpMode) {
        double   error ;
        double   steer ;
        boolean  onTarget = false ;
        double leftSpeed;
        double rightSpeed;

        // determine turn power based on +/- error
        error = getError(angle);

        if (Math.abs(error) <= HEADING_THRESHOLD) {
            steer = 0.0;
            leftSpeed  = 0.0;
            rightSpeed = 0.0;
            onTarget = true;
        }
        else {
            steer = getSteer(error, PCoeff);
            rightSpeed  = speed * steer;
            leftSpeed   = -rightSpeed;
        }

        // Send desired speeds to motors.
        leftMotor.setPower(leftSpeed);
        rightMotor.setPower(rightSpeed);

        // Display it for the driver.
        linearOpMode.telemetry.addData("Target", "%5.2f", angle);
        linearOpMode.telemetry.addData("Err/St", "%5.2f/%5.2f", error, steer);
        linearOpMode.telemetry.addData("Speed.", "%5.2f:%5.2f", leftSpeed, rightSpeed);

        return onTarget;
    }

    public double getError(double targetAngle) {

        double robotError;

        // calculate error in -179 to +180 range  (
        robotError = targetAngle - gyro.getIntegratedZValue();
        while (robotError > 180)  robotError -= 360;
        while (robotError <= -180) robotError += 360;
        return robotError;
    }

    public double getSteer(double error, double PCoeff) {
        return Range.clip(error * PCoeff, -1, 1);
    }

}
