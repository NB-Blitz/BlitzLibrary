package com.nbblitz.lib.drive;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SparkMotor
{
    private double direction = 0;
    private double value = 0;
    private boolean usePID = false;

    private CANSparkMax motor;
    private CANPIDController pidController;
    private CANEncoder encoder;

    /**
     * Initializes a Spark Max motor
     * @param motorID - CAN ID of the spark motor
     */
    public SparkMotor(int motorID)
    {
        motor = new CANSparkMax(motorID, MotorType.kBrushless);
        pidController = motor.getPIDController();
        encoder = motor.getEncoder();

        pidController.setOutputRange(-1, 1);
        motor.setClosedLoopRampRate(DriveReference.RAMP_RATE);
    }

    /**
     * Sets the direction of the motor
     * @param direction - The number -1 or 1 referring to the direction of the motor
     */
    public void setDirection(double direction)
    {
        this.direction = direction; 
    }

    /**
     * Gets the current set value of the motor
     * @return A number -1 - 1 referring to the value given to the motor controller
     */
    public double getSetValue()
    {
        return this.value;
    }

    /**
     * Gets the current velocity of the motor
     * @return The velocity of the motor in RPM
     */
    public double getVelocity()
    {
        return this.encoder.getVelocity();
    }

    /**
     * Tunes the feed-forward gain in PID
     * @param gain - F gain to set to
     */
    public void tuneF(double gain)
    {
        this.pidController.setFF(gain);
    }

    /**
     * Tunes the proportional gain in PID
     * @param gain - P gain to set to
     */
    public void tuneP(double gain)
    {
        this.pidController.setP(gain);
    }

    /**
     * Tunes the integral gain in PID
     * @param gain - I gain to set to
     */
    public void tuneI(double gain)
    {
        this.pidController.setI(gain);
    }

    /**
     * Tunes the derivative gain in PID
     * @param gain - I gain to set to
     */
    public void tuneD(double gain)
    {
        this.pidController.setD(gain);
    }

    public void enablePID()
    {
        this.usePID = true;
    }

    /**
     * Sets the value of the motor
     * @param value - A number -1 - 1 refering to the motor power & direction
     */
    public void setValue(double value)
    {
        if (usePID)
            this.pidController.setReference(value * this.direction * DriveReference.MAX_RPM, ControlType.kVelocity);
        else
            this.motor.set(value * this.direction);
    }
}
