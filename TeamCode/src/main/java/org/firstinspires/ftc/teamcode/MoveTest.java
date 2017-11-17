package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Gargi on 11/9/2017.
 */

@Autonomous (name = "MoveTest", group = "")
public class MoveTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {

        double quarter = Math.PI * Math.hypot(12.98, 9.75) / 8;


        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        waitForStart();
        robot.moveDistance(quarter, 0.5, this);

    }
}


