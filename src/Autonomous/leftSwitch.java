package Autonomous;

import org.usfirst.frc.team6024.robot.commands.GoForwardCommand;
import org.usfirst.frc.team6024.robot.commands.GoToHeadingCommand;
import org.usfirst.frc.team6024.robot.commands.MoveArmCommand;
import org.usfirst.frc.team6024.robot.commands.MoveDriveCommand;
import org.usfirst.frc.team6024.robot.commands.MoveLiftCommand;
import org.usfirst.frc.team6024.robot.commands.MoveWheelCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class leftSwitch extends CommandGroup{
	
	class MoveAndLift extends CommandGroup{
		public MoveAndLift() {
			addParallel(new MoveLiftCommand(50));
			addSequential(new GoForwardCommand(128, 0.3, 0.7));
			addSequential(new GoToHeadingCommand(90));
			addSequential(new MoveDriveCommand(1000, 0.3));
		}
	}
	
	public leftSwitch() {
		addSequential(new InitialBlockDropCommand());
		addSequential(new GoForwardCommand(10, 0.3, 0.3));
		addSequential(new MoveArmCommand(1000, 0.4)); 
		addParallel(new Intake());
		addParallel(new MoveArmCommand(10000, 0.4));
		addSequential(new MoveAndLift());
		addSequential(new Shoot());
	}
}
