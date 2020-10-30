package frc.robot;

public class RobotMap {
    //robot map

    public interface CAN {
        int DRIVE_TRAIN_MOTOR_UP_LEFT = 0;
        int DRIVE_TRAIN_MOTOR_DOWN_LEFT = 1;
        int DRIVE_TRAIN_MOTOR_UP_RIGHT = 2;
        int DRIVE_TRAIN_MOTOR_DOWN_RIGHT = 3;
        int SHOOTER_MOTOR = 4;

    }

    public interface PWM {
        int GRIP_MOTOR = 0;
    }

    public interface DIO {
        int GRIP_LIMIT = 0;
        int ENCODER_SHOOTER_POS = 1;
        int ENCODER_SHOOTER_NEG = 2;
        int SHOOTER_LIMIT = 3;
    }
}
