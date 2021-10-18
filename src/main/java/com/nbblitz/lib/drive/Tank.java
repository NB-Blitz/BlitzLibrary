package com.nbblitz.lib.drive;

public class Tank extends Drivetrain
{

    /**
     * Stops the robot from moving
     */
    public void drive()
    {
        drive(0, 0);
    }

    /**
     * Drives a robot with a tank drivetrain
     * @param left - Left input
     * @param right - Right input
     */
    public void drive(double left, double right)
    {
        double[] motorValues = {
            left,
            left,
            right,
            right
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
