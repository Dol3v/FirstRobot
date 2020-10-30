package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {

    private WPI_TalonSRX leftUp;
    private WPI_TalonSRX rightUp;

    public DriveTrain(WPI_TalonSRX leftUp, WPI_VictorSPX leftDown, WPI_TalonSRX rightUp, WPI_VictorSPX rightDown) {
        this.leftUp = leftUp;
        this.rightUp = rightUp;

        rightUp.setInverted(true);
        rightDown.follow(rightUp);
        leftDown.follow(leftUp);
    }

    public void move(double speedLeft, double speedRight) {
        leftUp.set(speedLeft);
        rightUp.set(speedRight);
    }

    public void stop() {
        leftUp.stopMotor();
        rightUp.stopMotor();
    }


}
