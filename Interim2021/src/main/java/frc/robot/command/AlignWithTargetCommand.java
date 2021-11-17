package frc.robot.command;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.component.VisionComponent;
import frc.robot.subsystem.swerve.Swerve;
import frc.robot.subsystem.vision.OffsetProvider;
import frc.robot.subsystem.vision.Vision;

public class AlignWithTargetCommand extends CommandBase {

    private PIDController translationalPID;
    private PIDController rotationalPID;
    private double currentTranslation; //output from translational PID command
    private double currentRotation;
    private Swerve swerve;
    private Vision vision;

    /**
     *
     * @param kPt PID params for the translational component
     * @param kIt
     * @param kDt
     * @param kPz PID params for the rotational component
     * @param kIz
     * @param kDz
     * @param vision
     * @param swerve
     */
    public AlignWithTargetCommand(double kPt, double kIt, double kDt, double kPz, double kIz, double kDz, Vision vision, Swerve swerve) {
        translationalPID = new PIDController(kPt, kIt, kDt);
        rotationalPID = new PIDController(kPt, kIt, kDt);
        this.vision = vision;
        this.swerve = swerve;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        swerve.moveRobotCentric(
                translationalPID.calculate(vision.getHorizontalOffsetFromCrosshair(), 0),
                0,
                rotationalPID.calculate(vision.getSkew(), 0)
        );
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
