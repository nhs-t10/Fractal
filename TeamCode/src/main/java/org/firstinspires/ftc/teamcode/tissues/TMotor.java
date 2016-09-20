package org.firstinspires.ftc.teamcode.tissues;
import org.firstinspires.ftc.teamcode.debug.Component;
import org.firstinspires.ftc.teamcode.lib.Sleep;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by robotics on 4/12/16.
 */
public class TMotor implements Component {
    private DcMotor motor;
    public String getName(){return  "Motor";}
    public TMotor(DcMotor m) {
        motor = m;
    }

    /**
     * Sets the direction of the motor
     * @param dir true = forward; false = backward
     */
    public void setDirection(Boolean dir) {
        motor.setDirection((dir ? DcMotor.Direction.FORWARD : DcMotor.Direction.REVERSE));
    }

    /**
     * Sets the TMotor's power to a given amount.
     * @param power value between -1.0 and 1.0. Negative values move motor in reverse
     *              direction.
     */
    public void move(double power) {
        power = (float) Range.clip(power, -1.0, 1.0);
        motor.setPower(power);
    }

    /**
     * Sets the TMotor's power to 0.
     */
    public void stop() {
        motor.setPower(0);
    }

    public Boolean test() {
        this.move(0.5f);
        Sleep.secs(2);
        this.stop();
        return true;
    }
}

//TODO: Encoder support