/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Grip;
import frc.robot.commands.MoveTrain;
import frc.robot.commands.UnGrip;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.Rail;
import frc.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        DriveTrain train;
        WPI_VictorSPX driveTrainDownLeft;
        WPI_VictorSPX driveTrainDownRight;
        WPI_TalonSRX driveTrainUpLeft;
        WPI_TalonSRX driveTrainUpRight;
        VictorSP gripMotor;
        DigitalInput gripLimit;
        MoveTrain moveCmd;

        Gripper gripper;
        Grip grip;
        UnGrip ungrip;

        Encoder encoderShooter;
        WPI_TalonSRX motorShooter;
        DigitalInput limitShooter;
        Shooter shooter;
        //initializing robot
        driveTrainDownLeft = new WPI_VictorSPX(RobotMap.CAN.DRIVE_TRAIN_MOTOR_DOWN_LEFT);
        driveTrainDownRight = new WPI_VictorSPX(RobotMap.CAN.DRIVE_TRAIN_MOTOR_DOWN_RIGHT);
        driveTrainUpLeft = new WPI_TalonSRX(RobotMap.CAN.DRIVE_TRAIN_MOTOR_UP_LEFT);
        driveTrainUpRight = new WPI_TalonSRX(RobotMap.CAN.DRIVE_TRAIN_MOTOR_UP_RIGHT);

        train = new DriveTrain(driveTrainUpLeft, driveTrainDownLeft, driveTrainUpRight, driveTrainDownRight);

        Rail rail = new Rail(new WPI_TalonSRX(RobotMap.CAN.RAIL_MOTOR));
        gripMotor = new VictorSP(RobotMap.PWM.GRIP_MOTOR);
        gripLimit = new DigitalInput(RobotMap.DIO.GRIP_LIMIT);
        gripper = new Gripper(gripMotor, gripLimit);

        grip = new Grip(gripper);
        ungrip = new UnGrip(gripper);

        encoderShooter = new Encoder(RobotMap.DIO.ENCODER_SHOOTER_POS, RobotMap.DIO.ENCODER_SHOOTER_NEG);
        motorShooter = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_MOTOR);
        limitShooter = new DigitalInput(RobotMap.DIO.SHOOTER_LIMIT);
        shooter = new Shooter(motorShooter, limitShooter, encoderShooter);

        OI oi = new OI(gripper, rail, shooter);
        moveCmd = new MoveTrain(train, () -> oi.getLeftY(), () -> oi.getRightY());

        train.setDefaultCommand(moveCmd);

    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.</p>
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods. This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
    }


    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
