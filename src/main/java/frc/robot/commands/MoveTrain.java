package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveTrain;

import java.util.function.Supplier;

public class MoveTrain extends CommandBase {
    //move train

    private DriveTrain train;
    private double leftSpeed;
    private double rightSpeed;


    public MoveTrain(DriveTrain train, Supplier<Double> leftSpeed, Supplier<Double> rightSpeed) {
        addRequirements(train);
        this.train = train;

        this.leftSpeed = leftSpeed.get();
        this.rightSpeed = rightSpeed.get();
    }


    public void execute(){
        this.train.move(leftSpeed, rightSpeed);
    }


    public void end(boolean interrupted){
        this.train.stop();
    }

}
