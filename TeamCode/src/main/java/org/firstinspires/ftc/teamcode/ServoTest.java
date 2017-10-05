package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.MotorType;
import com.qualcomm.robotcore.hardware.configuration.UnspecifiedMotor;

/**
 * Created by kristinemclaughlin on 10/5/17.
 */

public class ServoTest extends LinearOpMode{
    Servo servo;
    DcMotor dcMotor;
    @Override
    public void runOpMode() {
        servo = hardwareMap.servo.get("servo");
        while (opModeIsActive()){
            servo.setPosition(0.5);
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis() - time < 1000 && opModeIsActive()) continue;
            servo.setPosition(0);
            stop();
        }
    }
}
