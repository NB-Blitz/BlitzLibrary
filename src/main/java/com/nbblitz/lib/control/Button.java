package com.nbblitz.lib.control;

public class Button
{
    private boolean isPressed = false;
    private boolean prePressed = false;
    private boolean isToggled = false;
    private boolean useToggle = false;

    public void update(boolean isPressed)
    {
        this.prePressed = this.isPressed;
        if (this.prePressed && isPressed)
            this.isToggled = !this.isToggled;
        this.isPressed = isPressed;
    }

    public boolean get()
    {
        if (useToggle)
            return isToggled;
        return isPressed;
    }
}
