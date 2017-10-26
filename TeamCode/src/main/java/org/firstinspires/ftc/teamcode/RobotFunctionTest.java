package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by guydu on 10/24/2017.
 */

public class RobotFunctionTest extends LinearOpMode{
    Robot robot;
    public void runOpMode(){
        robot.setHardwareMap(hardwareMap);
        waitForStart();

        robot.moveDistance(5, 0.5, this);
    }
}
