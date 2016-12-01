package org.firstinspires.ftc.teamcode.opmodes.bonnie;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.controllers.teleop.ButtonPusher;
import org.firstinspires.ftc.teamcode.controllers.teleop.Collection;
import org.firstinspires.ftc.teamcode.controllers.teleop.OneStickMecanum;
import org.firstinspires.ftc.teamcode.debug.Logger;
import org.firstinspires.ftc.teamcode.opmodes.T10Opmode;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Pusher;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.organs.drivetrains.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by max on 10/19/16.
 */
@TeleOp(name="BonnieOp", group="Bonnie")
public class bonnie extends T10Opmode {
    private MecanumDrivetrain drivetrain;
    private Flicker flicker;
    private Stopper stopper;
    private Spinner spinner;
    private Spinner liftSpinner;
    private Pusher pusher;

    private ArrayList<Controller> controllers = new ArrayList<Controller>();
    public void run() {
        Logger.logLine("Chassis 1 initialized.");
        drivetrain = new MecanumDrivetrain();
        flicker = new Flicker();
        stopper = new Stopper();
        spinner = new Spinner();
        liftSpinner = new Spinner(Hardware.LiftSpinner);
        liftSpinner.direction = 1;
        //pusher = new Pusher();

        controllers.add(new OneStickMecanum(drivetrain));
        controllers.add(new Collection(flicker, stopper, new ArrayList<Spinner>(Arrays.asList(spinner, liftSpinner))));
        //controllers.add(new ButtonPusher(pusher));
    }
    public void tick() {
        for(int i=0; i<controllers.size(); i++) {
            controllers.get(i).tick();
        }
    }
}
