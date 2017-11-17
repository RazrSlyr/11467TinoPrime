package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by kristinemclaughlin on 11/14/17.
 */
@TeleOp(name = "CRServoTest", group = "")
public class CRServoTest extends OpMode {

    CRServo crServo;
    public void init() {

        crServo = hardwareMap.crservo.get("crServo");
    }

    public void loop(){

        crServo.setPower(0.5);

    }

}
