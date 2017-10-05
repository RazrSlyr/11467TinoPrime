package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by guydu on 10/3/2017.
 */
@TeleOp(name="Color Test", group="Iterative Opmode")
public class ColorTest extends OpMode{
    ColorSensor colorSensor;
    @Override
    public void init() {
        colorSensor = hardwareMap.get(ColorSensor.class, "oOkish");
        colorSensor.enableLed(false);
    }
    @Override
    public void loop() {
        telemetry.addData("Red Value",colorSensor.red());
        telemetry.addData("Blue Value",colorSensor.blue());
        telemetry.addData("Green Value", colorSensor.green());
        telemetry.addData("Alpha Value", colorSensor.alpha());
        telemetry.update();
    }
}
