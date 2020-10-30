package frc.robot;

public class RobotMap {
    //robot map

    public interface CAN {
        int driveTrainMotorUpLeft = 0;
        int driveTrainMotorDownLeft = 1;
        int driveTrainMotorUpRight = 2;
        int driveTrainMotorDownRight = 3;
        int shooterMotor = 4;

    }

    public interface PWM {
        int gripMotor = 0;
    }

    public interface DIO {
        int gripLimit = 0;
        int encoderShooterPos = 1;
        int encoderShooterNeg = 2;
        int shooterLimit = 3;
    }
}
