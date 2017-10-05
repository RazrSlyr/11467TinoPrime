package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.MotorType;
import com.qualcomm.robotcore.hardware.configuration.UnspecifiedMotor;

/**
 * Created by kristinemclaughlin on 10/5/17.
 */
@Autonomous(name="Servo Test", group="")
public class ServoTest extends LinearOpMode{
    Servo servo;
    DcMotor dcMotor;
    @Override
    public void runOpMode() {
        servo = hardwareMap.servo.get("servo");
        servo.setPosition(0);

        waitForStart();

        while (opModeIsActive()){
            servo.setPosition(0.5);
            telemetry.addData("Servo Position Step 1", servo.getPosition());
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis() - time < 1000 && opModeIsActive()) continue;
            servo.setPosition(0);
            telemetry.addData("Servo Position Step 2", servo.getPosition());
            while(System.currentTimeMillis() - time < 2000 && opModeIsActive()) continue;
            telemetry.update();
            while(System.currentTimeMillis() - time < 4000 && opModeIsActive()) continue;
            stop();
        }
    }
}
