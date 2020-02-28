/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AngleForHighPort;
import frc.robot.commands.AngleForPickup;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunShooter;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // Main Joystick
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_USB);
  
  // Shooter Stops
  public final Button button7 = new JoystickButton(joystick, 7);
  public final Button button9 = new JoystickButton(joystick, 9);
  public final Button button11 = new JoystickButton(joystick, 11);
  public final Button button8 = new JoystickButton(joystick, 8);
  public final Button button2 = new JoystickButton(joystick, 2);
  public final Button trigger = new JoystickButton(joystick, 1);

  // Subsystems
  private final DriveSubsystem drivesubsystem = new DriveSubsystem();
  private final ElevatorSubsystem elevatorsubsystem = new ElevatorSubsystem();
  private final ShooterSubsystem shootersubsystem = new ShooterSubsystem();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

     //drivesubsystem.setDefaultCommand(new RunCommand(() ->
      //drivesubsystem.drive(joystick.getY(), joystick.getTwist())
    //));

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    trigger.whenHeld(new RunShooter(shootersubsystem));
    button8.whenHeld(new RunIntake(shootersubsystem));

    button7.whenHeld(new AngleForPickup(shootersubsystem));

    button11.whenHeld(new AngleForHighPort(shootersubsystem));
  }

  public void tempDrive() {
    drivesubsystem.drive(filter(joystick.getY()), filter(joystick.getTwist()));
  }

  public void elevatorDrive() {
    elevatorsubsystem.drive(filter(joystick.getThrottle()));
  }

  public void shooterDrive() {
  }

  private double filter(double value){
    if (Math.abs(value) > Constants.FILTER_THRESHOLD){
      return value;
    }
    return 0;
  }
}
