package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by mylesoleary on 12/5/17.
 */

@Autonomous(name = "Red South Dumb", group = "Dumb")
public class RSDumbAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        robot.turn(-90, 0.5, this);
        robot.moveDistance(36, 0.5, this);
    }
}
