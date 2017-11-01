package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Gargi on 10/31/2017.
 */

@TeleOp(name="TeleOp Test", group="Iterative Opmode")
public class TeleOpTest extends OpMode

{

    Robot robot = new Robot();

    public void loop(){
        if(gamepad1.a){
            robot.gyroTurn(0.5, 90, (LinearOpMode)(OpMode)this);
        }
        else if (gamepad1.b){
            robot.moveClaw(90);
        }
        else if (gamepad1.x){
            robot.moveDistance(4.0, 0.5, (LinearOpMode) (OpMode)this);
        }
    }

    public void init(){
        robot.setHardwareMap(hardwareMap);
    }
}
