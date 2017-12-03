package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by guydu on 11/21/2017.
 */
@Autonomous(name = "Square",group = "this doesnt matter")
public class Square extends LinearOpMode {
    Robot robot = new Robot();
    public void runOpMode() throws InterruptedException{
        robot.setHardwareMap(hardwareMap);
        waitForStart();

        for(int i = 0; i < 4; i++){
           robot.moveDistance(12, 0.5, (LinearOpMode) this);
           robot.myroTurn(0.5, 90, this);
        }
    }
}
