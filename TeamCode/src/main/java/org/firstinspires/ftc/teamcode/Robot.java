package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by guydu on 10/17/2017.
 */

public class Robot {

    Servo leftClawServo;
    Servo rightClawServo;

    DcMotor leftMotor;
    DcMotor rightMotor;

    public Robot() {

    }


    public void setHardwareMap(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");

        leftClawServo = hardwareMap.servo.get("leftCLawServo");
        rightClawServo = hardwareMap.servo.get("rightClawServo");
    }

    public void moveClaw(double angle){
        leftClawServo.setPosition(angle / 180);
        rightClawServo.setPosition(angle / 180);

    }

}
