package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareDevice;

/**
 * Created by Gargi on 11/9/2017.
 */

@Autonomous (name = "TurnTest", group = "")
public class TurnTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.setHardwareMap(hardwareMap);
        final GyroSensor gyroSensor = new GyroSensor() {
            @Override
            public void calibrate() {

            }

            @Override
            public boolean isCalibrating() {
                return false;
            }

            @Override
            public int getHeading() {
                return 0;
            }

            @Override
            public double getRotationFraction() {
                return 0;
            }

            @Override
            public int rawX() {
                return 0;
            }

            @Override
            public int rawY() {
                return 0;
            }

            @Override
            public int rawZ() {
                return 0;
            }

            @Override
            public void resetZAxisIntegrator() {

            }

            @Override
            public String status() {
                return null;
            }

            @Override
            public Manufacturer getManufacturer() {
                return null;
            }

            @Override
            public String getDeviceName() {
                return null;
            }

            @Override
            public String getConnectionInfo() {
                return null;
            }

            @Override
            public int getVersion() {
                return 0;
            }

            @Override
            public void resetDeviceConfigurationForOpMode() {

            }

            @Override
            public void close() {

            }
        }
    }

}
