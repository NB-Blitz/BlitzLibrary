package com.nbblitz.lib.control;

import edu.wpi.first.wpilibj.Joystick;

public class ThreeAxisJoystick extends Joystick
{

    // Buttons
    public Button Trigger = new Button();
    public Button Button2 = new Button();
    public Button Button3 = new Button();
    public Button Button4 = new Button();
    public Button Button5 = new Button();
    public Button Button6 = new Button();
    public Button Button7 = new Button();
    public Button Button8 = new Button();
    public Button Button9 = new Button();
    public Button Button10 = new Button();
    public Button Button11 = new Button();
    public Button Button12 = new Button();

    private final int TRIGGER_ID = 1;
    private final int BUTTON2_ID = 2;
    private final int BUTTON3_ID = 3;
    private final int BUTTON4_ID = 4;
    private final int BUTTON5_ID = 5;
    private final int BUTTON6_ID = 6;
    private final int BUTTON7_ID = 7;
    private final int BUTTON8_ID = 8;
    private final int BUTTON9_ID = 8;
    private final int BUTTON10_ID = 8;
    private final int BUTTON11_ID = 8;
    private final int BUTTON12_ID = 8;

    // Axis
    public Axis XAxis = new Axis();
    public Axis YAxis = new Axis();
    public Axis ZAxis = new Axis();
    public Axis Dial = new Axis();

    private final int X_AXIS_ID = 0;
    private final int Y_AXIS_ID = 1;
    private final int Z_AXIS_ID = 2;
    private final int DIAL_ID = 3;

    /**
     * Defines a 2-Axis Joystick
     * @param port - Port ID the joystick is plugged in to
     */
    public ThreeAxisJoystick(int port)
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
        Button9.update(this.getRawButton(BUTTON9_ID));
        Button10.update(this.getRawButton(BUTTON10_ID));
        Button11.update(this.getRawButton(BUTTON11_ID));
        Button12.update(this.getRawButton(BUTTON12_ID));

        // Axis
        XAxis.update(this.getRawAxis(X_AXIS_ID));
        YAxis.update(this.getRawAxis(Y_AXIS_ID));
        ZAxis.update(this.getRawAxis(Z_AXIS_ID));
        Dial .update(this.getRawAxis(DIAL_ID));
    }
}
