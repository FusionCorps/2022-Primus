package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless;
import static frc.robot.Constants.Chassis.*;

public class Chassis extends SubsystemBase {

    CANSparkMax rf_motor;
    CANSparkMax rb_motor;
    CANSparkMax lf_motor;
    CANSparkMax lb_motor;

    MotorControllerGroup left_motors;
    MotorControllerGroup right_motors;

    DifferentialDrive diff_drive;

    public Chassis() {
        rf_motor = new CANSparkMax(RF_MOTOR_ID, kBrushless);
        rb_motor = new CANSparkMax(RB_MOTOR_ID, kBrushless);
        lf_motor = new CANSparkMax(LF_MOTOR_ID, kBrushless);
        lb_motor = new CANSparkMax(LB_MOTOR_ID, kBrushless);

        rf_motor.setInverted(true);
        lf_motor.setInverted(true);

        left_motors = new MotorControllerGroup(lf_motor, lb_motor);
        right_motors = new MotorControllerGroup(rf_motor, rb_motor);

        diff_drive = new DifferentialDrive(left_motors, right_motors);

    }

    public void driveChassis(double fwd, double rot) {
        diff_drive.curvatureDrive(fwd, rot, true);
    }



}
