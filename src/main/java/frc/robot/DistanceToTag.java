package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.Command;

public class DistanceToTag extends Command {
    private CommandSwerveDrivetrain m_drivetrain;
    private double m_maxrate;
    private SwerveRequest.FieldCentric m_drive;

    public DistanceToTag(CommandSwerveDrivetrain drivetrain, double maxrate, SwerveRequest.FieldCentric drive) {
        m_drivetrain = drivetrain;
        m_maxrate = maxrate;
        m_drive = drive;
    }

    @Override
    public void execute() {
        double y = LimelightHelpers.getTY("");
        double yRate = y / 36.0;
        if (Math.abs(y) < 1) {
            end(true);
        } else {
            m_drivetrain.setControl(m_drive.withVelocityX(-yRate * m_maxrate));
        }
    }
}
