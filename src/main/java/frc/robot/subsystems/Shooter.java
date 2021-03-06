package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Shooter extends SubsystemBase {
    //shooter subsystem

    private WPI_TalonSRX motor;
    private DigitalInput limit;
    private Encoder encoder;

    public static final Supplier<Double> KP = () -> 0.1, KI = () -> 0.01, KD = () -> 0.01,
            TOLERANCE = () -> 5., SETPOINT = () -> 720.;

    public Shooter(WPI_TalonSRX shooterMotor, DigitalInput limit, Encoder encoder) {
        this.motor = shooterMotor;
        this.limit = limit;
        this.encoder = encoder;

        this.encoder.setDistancePerPulse(4096. / 360);
    }

    public boolean limitIsPressed() {
        return limit.get();
    }

    public void shoot(double speed) {
        this.motor.set(speed);
    }

    public void stop() {
        this.motor.stopMotor();
    }

    public void resetEncoder() {
        this.encoder.reset();
    }

    public double getAngle() {
        return this.encoder.getDistance();
    }
}
