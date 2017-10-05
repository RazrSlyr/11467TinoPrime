import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.MotorType;
import com.qualcomm.robotcore.hardware.configuration.UnspecifiedMotor;

/**
 * Created by kristinemclaughlin on 10/5/17.
 */

public class ServoTest extends LinearOpMode{
    Servo test;
    DcMotor dcMotor;
    @Override
    public void runOpMode() {
        test = hardwareMap.servo.get("servo");
        while (opModeIsActive()){


        }
    }
}
