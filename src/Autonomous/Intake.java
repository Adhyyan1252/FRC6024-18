package Autonomous;

import org.usfirst.frc.team6024.robot.commands.MoveWheelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Intake extends CommandGroup{
	public Intake() {
		addSequential(new MoveWheelCommand(2000, 0.5));
	}
}
