package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by guydu on 10/19/2017.
 */

@Autonomous (name="Move Claw", group=" ")
public class MoveClaw extends LinearOpMode {

    Robot r = new Robot();

    @Override
    public void runOpMode() throws InterruptedException{

        r.setHardwareMap(hardwareMap);

        waitForStart();

        if(!opModeIsActive()) stop();

        r.moveClaw(21);

    }
}
