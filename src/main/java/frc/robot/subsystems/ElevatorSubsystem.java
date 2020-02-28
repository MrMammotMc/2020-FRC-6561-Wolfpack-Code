package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.Spark;

public class ElevatorSubsystem extends SubsystemBase {

private final Spark elevatorMotor = new Spark(Constants.ELEVATOR);

public ElevatorSubsystem() {
    
    }

    public void drive(final double throttle) {
        System.out.println("throttle:" + throttle);
        elevatorMotor.set( + throttle);
    }
}