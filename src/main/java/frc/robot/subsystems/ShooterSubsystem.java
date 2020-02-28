package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    final Spark shooterMotor = new Spark(Constants.SHOOTER);

    final Spark shooterAngleMotor = new Spark(Constants.SHOOTER_ANGLE);

    final Spark triggerMotor = new Spark(Constants.TRIGGER);

    public ShooterSubsystem() {
        

    }

    public void feeder() {
        triggerMotor.set(0.4);
        System.out.println("feeder invoked");
    }

    public void intake() {
        shooterMotor.set(0.4);
        System.out.println("intake invoked");
    }

    public void shoot() {
        shooterMotor.set( - 0.85);
        System.out.println("shoot invoked");
    }

    public void stop() {
        shooterMotor.set(0);
        System.out.println("stop invoked");
    }

    public void stopAim() {
        shooterAngleMotor.set(0);
        System.out.println("stop aim invoked");
    }

    public void angleForHighPort() {
        shooterAngleMotor.set( - 0.3);
        System.out.println("angleForHighPort invoked");
    }


    public void angleForPickup() {
        shooterAngleMotor.set(0.3);
        System.out.println("angleForPickup invoked");
    }
}
