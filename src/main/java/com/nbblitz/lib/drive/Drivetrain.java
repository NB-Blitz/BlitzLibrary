package com.nbblitz.lib.drive;

import java.util.EnumMap;
import java.util.HashMap;

public class Drivetrain
{
    private EnumMap<MotorLocation, SparkMotor> motors = new EnumMap<MotorLocation, SparkMotor>(new HashMap<>());

    public Drivetrain()
    {
        motors.put(MotorLocation.BackLeft,   new SparkMotor(DriveReference.BACK_LEFT_MOTOR_ID));
        motors.put(MotorLocation.BackRight,  new SparkMotor(DriveReference.BACK_RIGHT_MOTOR_ID));
        motors.put(MotorLocation.FrontLeft,  new SparkMotor(DriveReference.FRONT_LEFT_MOTOR_ID));
        motors.put(MotorLocation.FrontRight, new SparkMotor(DriveReference.FRONT_RIGHT_MOTOR_ID));
    }

    /**
     * Sets the direction of a motor
     * @param motorLocation - The location of the motor
     * @param direction - The number 1 or -1 refering to the direction of the motor
     */
    public void setMotorDirection(MotorLocation motorLocation, double direction)
    {
        motors.get(motorLocation).setDirection(direction);
    }

    /**
     * Sets the value of a motor
     * @param motorLocation - The location of the motor
     * @param value - The number 1 or -1 refering to the value of the motor
     */
    public void setMotorValue(MotorLocation motorLocation, double value)
    {
        motors.get(motorLocation).setValue(value);
    }

    /**
     * Gets the set value of the motor
     * @param motorLocation - The location of the motor
     * @return A number -1 - 1 refering to the value given to the motor
     */
    public double getMotorSetValue(MotorLocation motorLocation)
    {
        return motors.get(motorLocation).getSetValue();
    }

    /**
     * Gets the velocity of a given motor
     * @param motorLocation - The location of the motor
     * @return The velocity of the motor in RPM
     */
    public double getMotorVelocity(MotorLocation motorLocation)
    {
        return motors.get(motorLocation).getVelocity();
    }

    /**
     * Enables PID on the drivetrain
     */
    public void enablePID()
    {
        motors.get(MotorLocation.FrontLeft) .enablePID();
        motors.get(MotorLocation.FrontRight).enablePID();
        motors.get(MotorLocation.BackLeft)  .enablePID();
        motors.get(MotorLocation.BackRight) .enablePID();
    }

    /**
     * Tunes the feed-forward gain in a given motor
     * @param motorLocation - The location of the motor
     * @param gain - F gain to set to
     */
    public void tuneF(MotorLocation motorLocation, double gain)
    {
        motors.get(motorLocation).tuneF(gain);
    }

    /**
     * Tunes the proportional gain in a given motor
     * @param motorLocation - The location of the motor
     * @param gain - P gain to set to
     */
    public void tuneP(MotorLocation motorLocation, double gain)
    {
        motors.get(motorLocation).tuneP(gain);
    }

    /**
     * Tunes the integral gain in a given motor
     * @param motorLocation - The location of the motor
     * @param gain - I gain to set to
     */
    public void tuneI(MotorLocation motorLocation, double gain)
    {
        motors.get(motorLocation).tuneI(gain);
    }

    /**
     * Tunes the derivative gain in a given motor
     * @param motorLocation - The location of the motor
     * @param gain - I gain to set to
     */
    public void tuneD(MotorLocation motorLocation, double gain)
    {
        motors.get(motorLocation).tuneD(gain);
    }
}
