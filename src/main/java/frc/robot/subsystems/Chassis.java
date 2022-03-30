package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Servo;
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

    public Servo servo;

    MotorControllerGroup left_motors;
    MotorControllerGroup right_motors;

    DifferentialDrive diff_drive;

    public Chassis() {

        servo = new Servo(0);

        rf_motor = new CANSparkMax(RF_MOTOR_ID, kBrushless);
        rb_motor = new CANSparkMax(RB_MOTOR_ID, kBrushless);
        lf_motor = new CANSparkMax(LF_MOTOR_ID, kBrushless);
        lb_motor = new CANSparkMax(LB_MOTOR_ID, kBrushless);

        rf_motor.restoreFactoryDefaults();
        rb_motor.restoreFactoryDefaults();
        lf_motor.restoreFactoryDefaults();
        lb_motor.restoreFactoryDefaults();

        rf_motor.setInverted(true);
        lf_motor.setInverted(true);

        rb_motor.setInverted(false);
        lb_motor.setInverted(false);

//        rb_motor.follow(rf_motor, true);
//        lb_motor.follow(lf_motor, true);

        rf_motor.setIdleMode(CANSparkMax.IdleMode.kCoast);
        rb_motor.setIdleMode(CANSparkMax.IdleMode.kCoast);
        lf_motor.setIdleMode(CANSparkMax.IdleMode.kCoast);
        lb_motor.setIdleMode(CANSparkMax.IdleMode.kCoast);

        left_motors = new MotorControllerGroup(lf_motor, lb_motor);
        right_motors = new MotorControllerGroup(rf_motor, rb_motor);



        diff_drive = new DifferentialDrive(lf_motor, rf_motor);

    }

    public void driveChassis(double fwd, double rot) {
        diff_drive.curvatureDrive(fwd, rot, false);
        diff_drive.feed();
        System.out.println(rb_motor.getBusVoltage());
    }



}
