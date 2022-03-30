package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class SetChassisServo extends CommandBase {

    Chassis mChassis;
    double target;

    public SetChassisServo(Chassis chassis, double angle) {
        mChassis = chassis;
        addRequirements(mChassis);
        target = angle;
    }

    @Override
    public void execute() {
        mChassis.servo.setAngle(target);
    }

}
