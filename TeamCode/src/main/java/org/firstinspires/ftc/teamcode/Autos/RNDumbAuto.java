package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by mylesoleary on 12/5/17.
 */

@Autonomous(name = "Red North Dumb", group = "Dumb")
public class RNDumbAuto extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        waitForStart();
        robot.moveDistance(24, 0.5, this);
        robot.myroTurn(90, this);
        robot.moveDistance(12, 0.5, this);
        robot.myroTurn(-90, this);
        robot.moveDistance(12, 0.5, this);
    }
}
