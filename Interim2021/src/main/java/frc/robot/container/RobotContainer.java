package frc.robot.container;

import edu.wpi.first.wpilibj.command.Command;

public interface RobotContainer {

    default Command getAutonomousCommand(){
        return null;
    }

    default void teleopInit(){

    }
}
