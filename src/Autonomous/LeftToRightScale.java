package Autonomous;

import org.usfirst.frc.team6024.robot.commands.GoForwardCommand;
import org.usfirst.frc.team6024.robot.commands.GoToHeadingCommand;
import org.usfirst.frc.team6024.robot.commands.MoveArmCommand;
import org.usfirst.frc.team6024.robot.commands.MoveDriveCommand;
import org.usfirst.frc.team6024.robot.commands.MoveLiftCommand;
import org.usfirst.frc.team6024.robot.commands.MoveWheelCommand;
import org.usfirst.frc.team6024.robot.commands.WaitForTimeCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftToRightScale extends CommandGroup{
	
	class MoveAndLift extends CommandGroup {
		public MoveAndLift() {
			addParallel(new MoveLiftCommand(85));
			addSequential(new GoForwardCommand(205, 0.3, 0.7, 90));
			addSequential(new GoToHeadingCommand(-30));
			
			
//			addParallel(new MoveLiftCommand(88));
//			addSequential(new GoForwardCommand(275, 0.3, 0.55));
//			addSequential(new GoToHeadingCommand(-90));
		}
	}
	
	public LeftToRightScale() {
		addSequential(new InitialBlockDropCommand());
		addSequential(new GoForwardCommand(10, 0.3, 0.3));
		addSequential(new MoveArmCommand(1000, 0.4)); 
		addParallel(new MoveArmCommand(15000, 0.6));
		addParallel(new Intake());
		addSequential(new GoForwardCommand(190, 0.3, 0.8));
		addSequential(new GoToHeadingCommand(90));
		addSequential(new WaitForTimeCommand(200));
		addSequential(new MoveAndLift());
		addSequential(new MoveDriveCommand(1500, 0.3));
		addSequential(new Shoot());
		addSequential(new WaitForTimeCommand(500));
		addSequential(new GoForwardCommand(-15, 0.3, 0.3));
	}
}
