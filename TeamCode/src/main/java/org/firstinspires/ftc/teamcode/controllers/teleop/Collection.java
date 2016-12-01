package org.firstinspires.ftc.teamcode.controllers.teleop;

import org.firstinspires.ftc.teamcode.controllers.Controller;
import org.firstinspires.ftc.teamcode.neurons.DebouncingButton;
import org.firstinspires.ftc.teamcode.neurons.HumanDriving;
import org.firstinspires.ftc.teamcode.organs.Flicker;
import org.firstinspires.ftc.teamcode.organs.Spinner;
import org.firstinspires.ftc.teamcode.organs.Stopper;
import org.firstinspires.ftc.teamcode.statics.ControlParser;
import org.firstinspires.ftc.teamcode.statics.Controls;
import org.firstinspires.ftc.teamcode.statics.Hardware;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by robotics on 5/31/16.
 */
public class Collection implements Controller {
    private Flicker flicker;
    private Stopper stopper;
    private ArrayList<Spinner> spinner;
    private DebouncingButton stopperBtn = new DebouncingButton(Controls.Stopper);
    private DebouncingButton spinnerInBtn = new DebouncingButton(Controls.SpinnerIn);
    private DebouncingButton spinnerOutBtn = new DebouncingButton(Controls.SpinnerOut);

    @Deprecated
    public Collection(Flicker f, Spinner sp) {
        this(f, new Stopper(), new ArrayList<Spinner>(Arrays.asList(sp)));
    }

    public Collection(Flicker f, Stopper st, Spinner sp) {
        this(f, st, new ArrayList<Spinner>(Arrays.asList(sp)));
    }

    public Collection(Flicker f, Stopper st, ArrayList<Spinner> sp) {
        flicker = f;
        stopper = st;
        spinner = sp;
    }
    
    public boolean tick() {
        if(ControlParser.range(Controls.Flicker).get(0) > 0.6) flicker.engage();
        else flicker.stop();

        if(stopperBtn.getToggle()) {
            stopper.toggle();
        }

        if(ControlParser.button("DU1")) {
            spinner.get(1).toggle(1);
        }

        if(spinnerInBtn.getToggle()) {
            for (Spinner s: spinner) {
                s.toggle(1);
            }
        } else if(spinnerOutBtn.getToggle()) {
            for (Spinner s: spinner) {
                s.toggle(-1);
            }
        }
        return false;
    }
}
