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
        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        waitForStart();
        robot.moveDistance(12, 0.5, this);

    }
}


