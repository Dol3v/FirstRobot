package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;


public class Grip extends CommandBase {
    //grip command

    private Gripper gripper;

    public Grip(Gripper gripper) {
        addRequirements(gripper);
        this.gripper = gripper;
    }

    @Override
    public void execute() {
        this.gripper.grip();
    }

    @Override
    public boolean isFinished() {
        return this.gripper.isFull();
    }

    @Override
    public void end(boolean interrupted) {
        this.gripper.stop();

    }


}
