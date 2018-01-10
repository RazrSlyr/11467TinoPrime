package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by Gargi on 1/9/2018.
 */
@Autonomous (name = "JewelMechanism", group = "")
public class JewelMechanism extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        CRServo jewelMech;
        jewelMech = hardwareMap.crservo.get("jewelMech");

        ColorSensor colorSensor = hardwareMap.get(ColorSensor.class, "colorsensor");


        waitForStart();
        while (opModeIsActive()){
            int blue = colorSensor.blue();

            if(blue == 225){
                robot.gyroTurn(0.5, 90, this);
            }
            else{
                robot.gyroTurn(0.5, -90, this);
            }
        }

    }
}

