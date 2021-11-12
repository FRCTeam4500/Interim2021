package frc.robot.command;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystem.swerve.Swerve;
import frc.robot.subsystem.vision.OffsetProvider;
import frc.robot.subsystem.vision.Vision;

public class AlignWithTargetCommand extends PIDCommand {
    public AlignWithTargetCommand(double kP, double kI, double kD, OffsetProvider offset, Swerve swerve) {
        super(new PIDController(kP, kI, kD),
                offset::getXOffset, //measurement
                () -> {return 0.0;}, //setpoint/target
                (output) -> { swerve.moveRobotCentric(0, 0, output);},
                swerve
                );
        // the requires(Subsystem) method must be called for each subsystem used by the command
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }


    protected void end() {

    }


    protected void interrupted() {

    }
}
