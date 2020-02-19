package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    private final VictorSPX leftFMotor = new VictorSPX(Constants.LEFT_FRONT_MOTOR);
    private final VictorSPX leftBMotor = new VictorSPX(Constants.LEFT_BACK_MOTOR);
    private final VictorSPX rightFMotor = new VictorSPX(Constants.RIGHT_FRONT_MOTOR);
    private final VictorSPX rightBMotor = new VictorSPX(Constants.RIGHT_BACK_MOTOR);

    public DriveSubsystem() {

    }

    public void drive(final double forward, final double twist) {
        System.out.println("forward:" + forward + " turn:" + twist);
        leftFMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, - twist);
        leftBMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, - twist);
        rightFMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, + twist);
        rightBMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, + twist);
    }
}