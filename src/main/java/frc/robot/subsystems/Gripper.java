package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;


public class Gripper extends SubsystemBase {

    private SpeedController gripFirst;
    private final double speed = 0.7;
    private DigitalInput limit;

    public Gripper(SpeedController gripFirst, DigitalInput limit) {
        this.gripFirst = gripFirst;
        this.limit = limit;
    }

    public boolean isFull() {
        return this.limit.get();
    }

    public void grip() {
        this.gripFirst.set(speed);
    }

    public void ungrip() {
        this.gripFirst.set(-speed);
    }

    public void stop() {
        this.gripFirst.stopMotor();
    }
}
