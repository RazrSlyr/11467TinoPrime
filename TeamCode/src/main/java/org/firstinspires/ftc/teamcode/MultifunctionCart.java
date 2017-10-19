package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by guydu on 10/17/2017.
 */

public class MultifunctionCart{

    DcMotor leftMotor;
    DcMotor rightMotor;

    public MultifunctionCart() {

    }


    public void setHardwareMap(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");


    }


}
