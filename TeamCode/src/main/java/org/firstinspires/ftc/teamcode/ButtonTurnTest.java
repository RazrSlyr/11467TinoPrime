package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by kristinemclaughlin on 11/16/17.
 */

@TeleOp(name = "Button Turn Test", group = "This actually doesnt matter")
public class ButtonTurnTest extends LinearOpMode {
    Robot robot = new Robot();
    public void runOpMode() throws InterruptedException{
        initial();
        waitForStart();
        while (opModeIsActive()){
            looping();
        }
    }





    public void initial(){
        robot.setHardwareMap(hardwareMap);

    }

    public void looping(){
        if(gamepad1.a){
            double quarter = Math.PI * Math.hypot(12.98, 9.75) / 4;
            robot.moveDistance(quarter, 0.5, this);
        }
        if(gamepad1.b){
            double quarter = Math.PI * Math.hypot(16, 14.5) / 8;
            robot.moveDistance(quarter, 0.5, this);
        }
        if(gamepad1.x){
            double quarter = Math.PI * Math.hypot(16, 14.5) / 4;
            robot.moveDistance(quarter, 0.5, this);
        }
        if(gamepad1.y){
            double quarter =  Math.PI * Math.hypot(12.98, 9.75) / 8;
            robot.moveDistance(quarter, 0.5, this);
        }

    }
}
