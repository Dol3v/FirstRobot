package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Rail;

public class MoveRail extends CommandBase {
    //move rail command

    private Rail rail;
    private double time;

    public MoveRail(Rail rail) {
        this.rail = rail;
    }

    @Override
    public void initialize() {
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        rail.move();
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() - time >= 3;
    }

    @Override
    public void end(boolean interrupted) {
        rail.stop();
    }


}
