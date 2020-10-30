package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Grip;
import frc.robot.commands.MoveRail;
import frc.robot.commands.ShootPID;
import frc.robot.commands.UnGrip;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.Rail;
import frc.robot.subsystems.Shooter;


public class OI {
    //oi

    private Joystick joystickRight = new Joystick(0);
    private Joystick joystickLeft = new Joystick(1);
    private JoystickButton gripButton = new JoystickButton(joystickLeft, 3);
    private JoystickButton shootButton = new JoystickButton(joystickLeft, 4);

    public OI(Gripper gripper, Rail rail, Shooter shooter){
        gripButton.whenPressed(new Grip(gripper).andThen(new MoveRail(rail),
                new InstantCommand(rail::incrementCurrentCapacity, rail)));
        shootButton.whenPressed(new MoveRail(rail).andThen(new ShootPID(shooter, Shooter.KP,
                        Shooter.KI, Shooter.KD, Shooter.TOLERANCE, Shooter.SETPOINT),
                new InstantCommand(rail::decrementCurrentCapacity, rail)));
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
