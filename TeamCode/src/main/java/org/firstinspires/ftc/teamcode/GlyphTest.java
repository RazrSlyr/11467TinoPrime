package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by guydu on 12/1/2017.
 */
@TeleOp(name = "Glyph Test", group = "")
public class GlyphTest extends LinearOpMode {
    private Robot robot = new Robot();

    public void runOpMode() throws InterruptedException {
        robot.setHardwareMap(hardwareMap);
        waitForStart();
        robot.openClaw2(this);
        while(opModeIsActive());
    }
}
