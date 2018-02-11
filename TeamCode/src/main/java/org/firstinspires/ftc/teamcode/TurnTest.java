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
        /*robot.myroTurn(-90, this);
        robot.calibrateGyro();
        robot.myroTurn(90, this);
        robot.calibrateGyro();
        robot.myroTurn(-90, this);
        robot.calibrateGyro();
        while (opModeIsActive());*/

   /*     robot.encoderTurn(90, 0.35, this);
        robot.myWait(1000);*/
        robot.encoderTurn(-30, 0.2125, this);
        while(opModeIsActive());


    }

}
