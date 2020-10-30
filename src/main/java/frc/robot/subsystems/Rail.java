package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rail extends SubsystemBase {

    private WPI_TalonSRX railMotor;
    private final double motorSpeed = 0.3;
    private static int currrentCapacity;
    public static final int MAX_CAPACITY = 3;

    public Rail(WPI_TalonSRX railMotor) {
        this.railMotor = railMotor;
        this.currrentCapacity = 0;
    }

    public void move() {
        railMotor.set(motorSpeed);
    }

    public void stop() {
        railMotor.stopMotor();
    }

    public static int getCurrentCapacity() {
        return currrentCapacity;
    }
}
