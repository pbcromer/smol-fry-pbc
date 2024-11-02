package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class FieldUtil {
    public static boolean isAllianceBlue() {
        boolean isAllianceBlue = true;

        if (DriverStation.getAlliance().isPresent()) {
            isAllianceBlue = DriverStation.getAlliance().get() == DriverStation.Alliance.Blue;
        }

        return isAllianceBlue;
    }
}