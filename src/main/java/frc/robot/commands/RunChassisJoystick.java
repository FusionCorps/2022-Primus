package frc.robot.commands;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import static frc.robot.RobotContainer.m_controller;
import static java.lang.Math.abs;

public class RunChassisJoystick extends CommandBase {

    Chassis mChassis;

    SlewRateLimiter speedLimit;


    public RunChassisJoystick(Chassis chassis) {
        mChassis = chassis;
        addRequirements(mChassis);
        speedLimit = new SlewRateLimiter(2.5);
    }

    @Override
    public void execute() {

        mChassis.driveChassis(speedLimit.calculate(-m_controller.getRawAxis(1)), m_controller.getRawAxis(4));
    }

}
