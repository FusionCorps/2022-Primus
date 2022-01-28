package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import static frc.robot.RobotContainer.m_controller;

public class RunChassisJoystick extends CommandBase {

    Chassis mChassis;



    public RunChassisJoystick(Chassis chassis) {
        mChassis = chassis;
        addRequirements(mChassis);
    }

    @Override
    public void execute() {
        mChassis.driveChassis(-m_controller.getRawAxis(1), m_controller.getRawAxis(4));
    }

}
