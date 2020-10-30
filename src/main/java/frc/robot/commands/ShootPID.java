package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

import java.util.function.Supplier;

public class ShootPID extends CommandBase {
    //shoot with PID

    private Shooter shooter;
    private PIDController pidController;
    private Supplier<Double> kp, ki, kd, tolerance, setpoint;

    public ShootPID(Shooter shooter, Supplier<Double> kp, Supplier<Double> ki, Supplier<Double> kd,
                    Supplier<Double> tolerance, Supplier<Double> setpoint) {
        addRequirements(shooter);
        this.tolerance = tolerance;
        this.setpoint = setpoint;
        this.shooter = shooter;
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.pidController = new PIDController(kp.get(), ki.get(), kd.get());
    }

    @Override
    public void initialize() {
        shooter.resetEncoder();
    }

    @Override
    public void execute() {
        pidController.setPID(kp.get(), ki.get(), kd.get());
        pidController.setTolerance(tolerance.get());
        shooter.shoot(pidController.calculate(shooter.getAngle(), setpoint.get()));
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
        pidController.close();
    }
}
