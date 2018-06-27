package Autonomous;

import org.usfirst.frc.team6024.robot.commands.GoForwardCommand;
import org.usfirst.frc.team6024.robot.commands.GoToHeadingCommand;
import org.usfirst.frc.team6024.robot.commands.MoveArmCommand;
import org.usfirst.frc.team6024.robot.commands.MoveLiftCommand;
import org.usfirst.frc.team6024.robot.commands.MoveWheelCommand;
import org.usfirst.frc.team6024.robot.commands.WaitForTimeCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightScale extends CommandGroup{
	
	class MoveAndLift extends CommandGroup {
		public MoveAndLift() {
			addParallel(new MoveLiftCommand(85));
			addSequential(new GoForwardCommand(245, 0.3, 0.55));
			addSequential(new GoToHeadingCommand(-45));
			
//			addParallel(new MoveLiftCommand(88));
//			addSequential(new GoForwardCommand(275, 0.3, 0.55));
//			addSequential(new GoToHeadingCommand(-90));
		}
	}
	
	public RightScale() {
		addSequential(new InitialBlockDropCommand());
		addSequential(new GoForwardCommand(10, 0.3, 0.3));
		addSequential(new MoveArmCommand(1000, 0.4)); 
		addParallel(new MoveArmCommand(15000, 0.4));
		addParallel(new Intake());
		addSequential(new MoveAndLift());
		addSequential(new GoForwardCommand(15, 0.4, 0.4));
		addSequential(new Shoot());
		addSequential(new WaitForTimeCommand(500));
		addSequential(new GoForwardCommand(-15, 0.3, 0.3));
	}
}
