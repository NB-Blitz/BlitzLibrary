package com.nbblitz.lib.control;

import edu.wpi.first.wpilibj.Joystick;

public class TwoAxisJoystick {

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

    // Joystick
    Joystick joystick;

    /**
     * Defines a 2-Axis Joystick
     * 
     * @param port - Port ID the joystick is plugged in to
     */
    public TwoAxisJoystick(int port) {
        this.joystick = new Joystick(port);
    }

    /**
     * Updates all buttons and axis with the latest information. Only run this
     * function once per loop!
     */
    public void update() {
        // Buttons
        Trigger.update(joystick.getRawButton(TRIGGER_ID));
        Button2.update(joystick.getRawButton(BUTTON2_ID));
        Button3.update(joystick.getRawButton(BUTTON3_ID));
        Button4.update(joystick.getRawButton(BUTTON4_ID));
        Button5.update(joystick.getRawButton(BUTTON5_ID));
        Button6.update(joystick.getRawButton(BUTTON6_ID));
        Button7.update(joystick.getRawButton(BUTTON7_ID));
        Button8.update(joystick.getRawButton(BUTTON8_ID));

        // Axis
        XAxis.update(joystick.getRawAxis(X_AXIS_ID));
        YAxis.update(joystick.getRawAxis(Y_AXIS_ID));
        Dial.update(joystick.getRawAxis(DIAL_ID));
    }
}
