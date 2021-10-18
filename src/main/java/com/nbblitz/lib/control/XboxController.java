package com.nbblitz.lib.control;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick
{

    // Buttons
    public Button AButton = new Button();
    public Button BButton = new Button();
    public Button XButton = new Button();
    public Button YButton = new Button();
    public Button LeftBumper = new Button();
    public Button RightBumper = new Button();
    public Button StartButton = new Button();
    public Button SelectButton = new Button();
    public Button LeftStickButton = new Button();
    public Button RightStickButton = new Button();

    private final int A_BUTTON_ID = 1;
    private final int B_BUTTON_ID = 2;
    private final int X_BUTTON_ID = 3;
    private final int Y_BUTTON_ID = 4;
    private final int LEFT_BUMPER_ID = 5;
    private final int RIGHT_BUMPER_ID = 6;
    private final int SELECT_BUTTON_ID = 7;
    private final int START_BUTTON_ID = 8;
    private final int LEFT_STICK_BUTTON_ID = 9;
    private final int RIGHT_STICK_BUTTON_ID = 10;

    // Axis
    public Axis LeftXAxis = new Axis();
    public Axis LeftYAxis = new Axis();
    public Axis RightXAxis = new Axis();
    public Axis RightYAxis = new Axis();
    public Axis LeftTrigger = new Axis();
    public Axis RightTrigger = new Axis();

    private final int LEFT_X_AXIS_ID = 0;
    private final int LEFT_Y_AXIS_ID = 1;
    private final int RIGHT_X_AXIS_ID = 4;
    private final int RIGHT_Y_AXIS_ID = 5;
    private final int LEFT_TRIGGER_ID = 2;
    private final int RIGHT_TRIGGER_ID = 3;

    /**
     * Defines an Xbox Controller
     * @param port - Port ID the controller is plugged in to
     */
    public XboxController(int port)
    {
        super(port);
    }

    /**
     * Updates all buttons and axis with the latest information. Only run this function once per loop!
     */
    public void update()
    {
        // Buttons
        AButton         .update(this.getRawButton(A_BUTTON_ID));
        BButton         .update(this.getRawButton(B_BUTTON_ID));
        XButton         .update(this.getRawButton(X_BUTTON_ID));
        YButton         .update(this.getRawButton(Y_BUTTON_ID));
        LeftBumper      .update(this.getRawButton(LEFT_BUMPER_ID));
        RightBumper     .update(this.getRawButton(RIGHT_BUMPER_ID));
        StartButton     .update(this.getRawButton(START_BUTTON_ID));
        SelectButton    .update(this.getRawButton(SELECT_BUTTON_ID));
        LeftStickButton .update(this.getRawButton(LEFT_STICK_BUTTON_ID));
        RightStickButton.update(this.getRawButton(RIGHT_STICK_BUTTON_ID));

        // Axis
        LeftXAxis   .update(this.getRawAxis(LEFT_X_AXIS_ID));
        LeftYAxis   .update(this.getRawAxis(LEFT_Y_AXIS_ID));
        RightXAxis  .update(this.getRawAxis(RIGHT_X_AXIS_ID));
        RightYAxis  .update(this.getRawAxis(RIGHT_Y_AXIS_ID));
        LeftTrigger .update(this.getRawAxis(LEFT_TRIGGER_ID));
        RightTrigger.update(this.getRawAxis(RIGHT_TRIGGER_ID));
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
