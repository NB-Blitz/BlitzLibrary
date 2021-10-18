package com.nbblitz.lib.control;

import edu.wpi.first.wpilibj.Joystick;

public class TwoAxisJoystick extends Joystick {

    // Buttons
    public Button Trigger = new Button();
    public Button Button2 = new Button();
    public Button Button3 = new Button();
    public Button Button4 = new Button();
    public Button Button5 = new Button();
    public Button Button6 = new Button();
    public Button Button7 = new Button();
    public Button Button8 = new Button();

    private final int TRIGGER_ID = 1;
    private final int BUTTON2_ID = 2;
    private final int BUTTON3_ID = 3;
    private final int BUTTON4_ID = 4;
    private final int BUTTON5_ID = 5;
    private final int BUTTON6_ID = 6;
    private final int BUTTON7_ID = 7;
    private final int BUTTON8_ID = 8;

    // Axis
    public Axis XAxis = new Axis();
    public Axis YAxis = new Axis();
    public Axis Dial = new Axis();

    private final int X_AXIS_ID = 0;
    private final int Y_AXIS_ID = 1;
    private final int DIAL_ID = 2;

    /**
     * Defines a 2-Axis Joystick
     * @param port - Port ID the joystick is plugged in to
     */
    public TwoAxisJoystick(int port)
    {
        super(port);
    }

    /**
     * Updates all buttons and axis with the latest information. Only run this function once per loop!
     */
    public void update()
    {
        // Buttons
        Trigger.update(this.getRawButton(TRIGGER_ID));
        Button2.update(this.getRawButton(BUTTON2_ID));
        Button3.update(this.getRawButton(BUTTON3_ID));
        Button4.update(this.getRawButton(BUTTON4_ID));
        Button5.update(this.getRawButton(BUTTON5_ID));
        Button6.update(this.getRawButton(BUTTON6_ID));
        Button7.update(this.getRawButton(BUTTON7_ID));
        Button8.update(this.getRawButton(BUTTON8_ID));

        // Axis
        XAxis.update(this.getRawAxis(X_AXIS_ID));
        YAxis.update(this.getRawAxis(Y_AXIS_ID));
        Dial .update(this.getRawAxis(DIAL_ID));
    }

    /**
     * Rumbles the controller
     * @param intensity - A value between 0 - 1 relating to the intensity
     */
    public void rumble(double intensity)
    {
        this.setRumble(RumbleType.kLeftRumble, intensity);
        this.setRumble(RumbleType.kRightRumble, intensity);
    }
}
