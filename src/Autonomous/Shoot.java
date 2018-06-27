package Autonomous;

import org.usfirst.frc.team6024.robot.commands.MoveWheelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
	public Shoot() {
		addSequential(new MoveWheelCommand(1000,-0.6));
	}
}

