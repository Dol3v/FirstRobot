package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;



public class UnGrip extends CommandBase {
    //ungrip command
    private Gripper gripper;


    public UnGrip(Gripper gripper) {
        this.gripper = gripper;

    }

    @Override
    public void execute() {
        gripper.ungrip();
    }

    @Override
    public boolean isFinished() {
        return !gripper.isFull();
    }

    @Override
    public void end(boolean interrupted) {
        gripper.stop();
    }


}
