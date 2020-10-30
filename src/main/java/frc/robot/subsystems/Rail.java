package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rail extends SubsystemBase {

    private WPI_TalonSRX railMotor;
    private final double motorSpeed = 0.3;
    private int currentCapacity;
    public static final int MAX_CAPACITY = 3;

    public Rail(WPI_TalonSRX railMotor) {
        this.railMotor = railMotor;
        this.currentCapacity = 0;
    }

    public void move() {
        railMotor.set(motorSpeed);
    }

    public void stop() {
        railMotor.stopMotor();
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void incrementCurrentCapacity(){
        currentCapacity++;
    }

    public void decrementCurrentCapacity(){
        currentCapacity--;
    }
}
