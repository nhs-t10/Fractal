package org.firstinspires.ftc.teamcode.statics;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by robotics on 4/14/16.
 */
public class Hardware {
    public static String MotorLeftRear, MotorRightRear, MotorLeftFront, MotorRightFront, ModuleMotor1, ModuleMotor2;

    public static Servo ServoTop;

    public static String IMU, Color, Ultra;

    private static HardwareMap hardwareMap;

    public static HardwareMap getHardwareMap() { return hardwareMap; }

    public static void init(HardwareMap h) {
        hardwareMap = h;

        MotorLeftRear = "m1";
        MotorRightRear = "m2";
        MotorLeftFront = "m3";
        MotorRightFront = "m4";

        //Temporarily commented unused hardware
        //ModuleMotor1 = hardwareMap.dcMotor.get("m5");
        /*GimbalVertical = hardwareMap.dcMotor.get("m6");

        ServoTop = himport org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;ardwareMap.servo.get("s1");*/

        IMU = "g1";
        /*Color = "c1";*/
        Ultra = "u1";
    }
}
