package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by guydu on 1/9/2018.
 */

@TeleOp(name = "SlideConfigure", group = "")
public class SlideConfigure extends OpMode {
    Robot robot = new Robot();

    public void init() {
        robot.setHardwareMap(hardwareMap);
    }

    public void loop() {
        robot.slide.setPower(gamepad1.right_stick_y);
    }

}