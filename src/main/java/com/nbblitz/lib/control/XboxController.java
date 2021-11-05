package com.nbblitz.lib.control;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

public class XboxController {

    // Buttons
    public Button aButton = new Button();
    public Button bButton = new Button();
    public Button xButton = new Button();
    public Button yButton = new Button();
    public Button leftBumper = new Button();
    public Button rightBumper = new Button();
    public Button startButton = new Button();
    public Button selectButton = new Button();
    public Button leftStickButton = new Button();
    public Button rightStickButton = new Button();

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
    public Axis leftXAxis = new Axis();
    public Axis leftYAxis = new Axis();
    public Axis rightXAxis = new Axis();
    public Axis rightYAxis = new Axis();
    public Axis leftTrigger = new Axis();
    public Axis rightTrigger = new Axis();

    private final int LEFT_X_AXIS_ID = 0;
    private final int LEFT_Y_AXIS_ID = 1;
    private final int RIGHT_X_AXIS_ID = 4;
    private final int RIGHT_Y_AXIS_ID = 5;
    private final int LEFT_TRIGGER_ID = 2;
    private final int RIGHT_TRIGGER_ID = 3;

    // Joystick
    Joystick joystick;

    /**
     * Defines an Xbox Controller
     * 
     * @param port - Port ID the controller is plugged in to
     */
    public XboxController(int port) {
        joystick = new Joystick(port);
    }

    /**
     * Updates all buttons and axis with the latest information. Only run this
     * function once per loop!
     */
    public void update() {
        // Buttons
        aButton.update(joystick.getRawButton(A_BUTTON_ID));
        bButton.update(joystick.getRawButton(B_BUTTON_ID));
        xButton.update(joystick.getRawButton(X_BUTTON_ID));
        yButton.update(joystick.getRawButton(Y_BUTTON_ID));
        leftBumper.update(joystick.getRawButton(LEFT_BUMPER_ID));
        rightBumper.update(joystick.getRawButton(RIGHT_BUMPER_ID));
        startButton.update(joystick.getRawButton(START_BUTTON_ID));
        selectButton.update(joystick.getRawButton(SELECT_BUTTON_ID));
        leftStickButton.update(joystick.getRawButton(LEFT_STICK_BUTTON_ID));
        rightStickButton.update(joystick.getRawButton(RIGHT_STICK_BUTTON_ID));

        // Axis
        leftXAxis.update(joystick.getRawAxis(LEFT_X_AXIS_ID));
        leftYAxis.update(joystick.getRawAxis(LEFT_Y_AXIS_ID));
        rightXAxis.update(joystick.getRawAxis(RIGHT_X_AXIS_ID));
        rightYAxis.update(joystick.getRawAxis(RIGHT_Y_AXIS_ID));
        leftTrigger.update(joystick.getRawAxis(LEFT_TRIGGER_ID));
        rightTrigger.update(joystick.getRawAxis(RIGHT_TRIGGER_ID));
    }

    /**
     * Vibrates the controller
     * 
     * @param intensity - A value between 0 - 1 relating to the intensity
     */
    public void rumble(double intensity) {
        joystick.setRumble(RumbleType.kLeftRumble, intensity);
        joystick.setRumble(RumbleType.kRightRumble, intensity);
    }

    /**
     * Sets the deadband for all controller axis
     * 
     * @param deadband - The deadband value
     */
    public void setUniversalDeadband(double deadband) {
        leftXAxis.setDeadband(deadband);
        leftYAxis.setDeadband(deadband);
        rightXAxis.setDeadband(deadband);
        rightYAxis.setDeadband(deadband);
        leftTrigger.setDeadband(deadband);
        rightTrigger.setDeadband(deadband);
    }
}
