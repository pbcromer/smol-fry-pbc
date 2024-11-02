package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.Command;

public class RotateToTag extends Command {
    private CommandSwerveDrivetrain m_drivetrain;
    private double m_maxrate;
    private SwerveRequest.FieldCentric m_drive;

    public RotateToTag(CommandSwerveDrivetrain drivetrain, double maxrate, SwerveRequest.FieldCentric drive) {
        m_drivetrain = drivetrain;
        m_maxrate = maxrate;
        m_drive = drive;
    }

    @Override
    public void execute() {
        double x = LimelightHelpers.getTX("");
        double xRate = x / 36.0;
        if (Math.abs(x) < 1) {
            end(true);
        } else {
            m_drivetrain.setControl(m_drive.withRotationalRate(-xRate * m_maxrate));
        }
        // m_drivetrain.setControl(m_drive.withRotationalRate(-m_maxrate));
        // System.out.println("tx:" +  x);
    }
}
