package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by mylesoleary on 12/5/17.
 */

@Autonomous(name = "Red North Dumb", group = "Dumb")
public class RNDumbAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        robot.myroTurn(-90, 0.5, this);
        robot.moveDistance(24, 0.5, this);
        robot.myroTurn(90, 0.5, this);
        robot.moveDistance(12, 0.5, this);
    }
}
