package com.nbblitz.lib.drive;

public class Mecanum extends Drivetrain
{

    /**
     * Stops the robot from moving
     */
    public void drive()
    {
        drive(0, 0, 0);
    }

    /**
     * Drives a robot with a mecanum drivetrian
     * @param x - X axis (Left - Right)
     * @param y - Y axis (Up - Down)
     * @param z - Z axis (Rotation)
     */
    public void drive(double x, double y, double z)
    {
        double[] motorValues = {
            x + y - z,
            -x + y - z,
            -x + y + z,
            x + y + z
        };

        double maxMagnitude = 0;

        for (int i = 0; i < 4; i++)
        {
            motorValues[i] = Math.abs(motorValues[i]);
            if (maxMagnitude < motorValues[i])
                maxMagnitude = motorValues[i];
        }

        if (maxMagnitude < DriveReference.MAX_OUTPUT)
            for (int i = 0; i < 4; i++)
                motorValues[i] /= maxMagnitude;
        
        this.setMotorValue(MotorLocation.FrontLeft , motorValues[0]);
        this.setMotorValue(MotorLocation.FrontRight, motorValues[1]);
        this.setMotorValue(MotorLocation.BackLeft  , motorValues[2]);
        this.setMotorValue(MotorLocation.BackRight , motorValues[3]);
    }    
}
