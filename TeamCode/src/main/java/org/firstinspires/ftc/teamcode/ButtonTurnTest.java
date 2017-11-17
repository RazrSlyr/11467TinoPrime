package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by kristinemclaughlin on 11/16/17.
 */

@TeleOp
public class ButtonTurnTest extends OpMode {
    Robot robot = new Robot();
    public void init(){
        robot.setHardwareMap(hardwareMap);
    }

    public void loop(){
        if(gamepad1.a){
            double quarter = Math.PI * Math.hypot(12.98, 9.75) / 4;
            robot.moveDistance(quarter, 0.5, (LinearOpMode)(OpMode)this);
        }
        if(gamepad1.b){
            double quarter = Math.PI * Math.hypot(16, 14.5) / 8;
            robot.moveDistance(quarter, 0.5, (LinearOpMode)(OpMode)this);
        }
        if(gamepad1.x){
            double quarter = Math.PI * Math.hypot(16, 14.5) / 4;
            robot.moveDistance(quarter, 0.5, (LinearOpMode)(OpMode)this);
        }
    }
}
