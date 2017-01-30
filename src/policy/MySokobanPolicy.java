package policy;

import commands.MoveCommand;
import levels.Level;
import receivers.*;
import elements.*;

public class MySokobanPolicy {

	private Player player;
	private Level level;
	private Direction direction;
	
	public MySokobanPolicy(Level level) {
		this.level = level; 
		this.player = level.getPlayer(); 
	}
	
	public void execute(MoveCommand moveCommand) {
		this.direction = moveCommand.getMoveMaker().getDirection();
		
		if (checkIfMovePossible())
		{
			if (checkIfNeedPush())
			{
				push((Box)level.getNext(player.getPosition(), direction),direction);
				moveCommand.execute();
			}
			else 
			{
				moveCommand.execute();
			}
		}
	}
	
	private void push(Box box, Direction direction) {
				
		if (!wallCollision(box,direction))
		{
			MoveCommand pushCommand = new MoveCommand(new Move(level,box,direction));
			pushCommand.execute();
		}
		
	}
	
	private boolean checkIfMovePossible() {
		if (wallCollision(player,direction))
			return false;

		if (level.getNext(player.getPosition(),direction).getElementType() == ElementType.BOX)
			return checkIfNeedPush();
		
		return true;
	}
	
	private boolean wallCollision(Element elem, Direction direction) {
		
		if(level.getNext(elem.getPosition(), direction).getElementType() == ElementType.WALL)
		{
			return true;
		}
				
		return false;
	}
	
	private boolean checkIfNeedPush() {
		
		Element potentialBox = level.getNext(player.getPosition(),direction);
		Element potentialFloor = level.getNext(potentialBox.getPosition(),direction);
		
		if (potentialBox.getElementType() == ElementType.BOX) 
		{
			if (potentialFloor.getElementType() == ElementType.FLOOR) {
				return true;
			}
			if (potentialFloor.getElementType() == ElementType.TARGET) {
				return true;
			}
		}
		return false;
	}
	

	
}