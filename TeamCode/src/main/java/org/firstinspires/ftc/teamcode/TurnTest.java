package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareDevice;

/**
 * Created by Gargi on 11/9/2017.
 */

@Autonomous (name = "TurnTest", group = "")
public class TurnTest extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.setHardwareMap(hardwareMap);
        waitForStart();
        for (int i = 60; i < 150 && opModeIsActive(); i+= 10) {
            robot.myroTurn(i, this);
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 2000);
        }
        while (opModeIsActive());



    }

}
