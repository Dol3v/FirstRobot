package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Grip;
import frc.robot.commands.UnGrip;
import frc.robot.subsystems.Gripper;


public class OI {

    private Joystick joystickRight = new Joystick(0);
    private Joystick joystickLeft = new Joystick(1);
    private JoystickButton gripButton = new JoystickButton(joystickLeft, 3);
    private JoystickButton ungripButton = new JoystickButton(joystickLeft, 4);

    public OI(Gripper gripper){
        gripButton.whileHeld(new Grip(gripper));
        ungripButton.whileHeld(new UnGrip(gripper));
    }

    public double getLeftX() {
        return this.joystickLeft.getX();
    }

    public double getLeftY() {
        return -this.joystickLeft.getY();
    }

    public double getRightX() {
        return this.joystickRight.getX();
    }

    public double getRightY() {
        return -this.joystickRight.getY();
    }

}
