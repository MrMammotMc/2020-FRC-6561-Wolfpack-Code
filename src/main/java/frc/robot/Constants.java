/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // USB Devices
    public static final int JOYSTICK_USB = 0;

    // CAN Devices
    public static final int LEFT_FRONT_MOTOR = 1;
    public static final int LEFT_BACK_MOTOR = 3;
    public static final int RIGHT_FRONT_MOTOR = 2;
    public static final int RIGHT_BACK_MOTOR = 4;

    // PWM Devices
    public static final int SHOOTER = 1;
    public static final int SHOOTER_ANGLE = 2;
    public static final int ELEVATOR = 3;
    public static final int TRIGGER = 4;

    /**
     * This value is used to filter out the joystick signal, before passing it 
     * to the drive command.
     */
    public static final double FILTER_THRESHOLD = 0.25;

}
