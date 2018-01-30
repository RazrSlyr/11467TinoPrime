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

    @Override
    public void runOpMode() {
        Robot robot = new Robot();
        robot.openClaw2(this);
        while(opModeIsActive());
    }
}