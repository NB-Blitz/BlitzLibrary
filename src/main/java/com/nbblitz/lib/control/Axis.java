package com.nbblitz.lib.control;

public class Axis
{
    private double rampRate = 0;
    private double center = 0;
    private double deadband = 0;
    private double value = 0;
    private double rampedValue = 0;

    /**
     * Updates the axis with given input data
     * @param inputValue - New input number between -1 - 1
     */
    public void update(double inputValue)
    {
        this.value = inputValue;
        if (rampRate > 0)
            rampAxis();
    }

    /**
     * Grabs the latest value from the axis
     * @return current axis position
     */
    public double get()
    {
        if (rampRate <= 0)
            return value;
        else
            return rampedValue;
    }

    /**
     * Centers the axis at it's current position
     */
    public void recenter()
    {
        this.center = this.value;
    }

    /**
     * Sets the deadband of the axis
     * @param deadband - Value to set to between (0 - 1)
     */
    public void setDeadband(double deadband)
    {
        this.deadband = deadband;
    }

    /**
     * Sets the ramp rate of the axis
     * @param deadband - Value to set to between (0 - 1)
     */
    public void setRampRate(double rampRate)
    {
        this.rampRate = rampRate;
    }

    /**
     * Applies deadband, rampRate, and center onto the axis
     */
    private void rampAxis()
    {
        double expectedValue = value + center;

        if(Math.abs(expectedValue) < deadband)
            return;

        if(rampedValue < expectedValue)
        {
            if((expectedValue - rampedValue) < rampRate)
            {
                rampedValue = expectedValue;
            }
            else
            {
                rampedValue += rampRate;
            }
        }

        if(rampedValue > expectedValue)
        {
            if((rampedValue - expectedValue) < rampRate)
            {
                rampedValue = expectedValue;
            }
            else
            {
                rampedValue -= rampRate;
            }
        }
    }
}
