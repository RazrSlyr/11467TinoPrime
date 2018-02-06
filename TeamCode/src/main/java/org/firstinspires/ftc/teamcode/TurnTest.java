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
        robot.myroTurn(-90, this);
        robot.calibrateGyro();
        robot.myroTurn(90, this);
        robot.calibrateGyro();
        double val = robot.myroTurn(-90, this);
        telemetry.addData("Trig Val",val);
        telemetry.update();
        robot.calibrateGyro();
        while (opModeIsActive());


    }

}
