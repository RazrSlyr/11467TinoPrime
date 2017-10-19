package org.firstinspires.ftc.teamcode;

import android.test.MoreAsserts;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

/**
 * Created by guydu on 10/17/2017.
 */

@Autonomous(name="Copied Encoders", group=" ")
public class CopiedEncoders extends LinearOpMode {
    static final double     COUNTS_PER_MOTOR_REV    = 2440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    MultifunctionCart multifunctionCart = new MultifunctionCart();

    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode(){



        multifunctionCart.setHardwareMap(hardwareMap);

        multifunctionCart.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        multifunctionCart.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        multifunctionCart.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        multifunctionCart.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Path0",  "Starting at %7d :%7d",
                multifunctionCart.leftMotor.getCurrentPosition(),
                multifunctionCart.rightMotor.getCurrentPosition());
        telemetry.update();

        waitForStart();

        encoderDrive(.25,  5,  48, 5.0);

    }
    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = multifunctionCart.leftMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = multifunctionCart.rightMotor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            multifunctionCart.leftMotor.setTargetPosition(newLeftTarget);
            multifunctionCart.rightMotor.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            multifunctionCart.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            multifunctionCart.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            multifunctionCart.leftMotor.setPower(Math.abs(speed));
            multifunctionCart.rightMotor.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (multifunctionCart.leftMotor.isBusy() && multifunctionCart.rightMotor.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d",
                        multifunctionCart.leftMotor.getCurrentPosition(),
                        multifunctionCart.rightMotor.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            multifunctionCart.leftMotor.setPower(0);
            multifunctionCart.rightMotor.setPower(0);

            // Turn off RUN_TO_POSITION
            multifunctionCart.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            multifunctionCart.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }

}
