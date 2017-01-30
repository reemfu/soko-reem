package commands;

import receivers.Move;

public class MoveCommand implements Command {

	private Move moveMaker = null;
	
	@Override
	public void execute() {
		moveMaker.move(); 
	}
	
	public MoveCommand(Move move) {	
		this.moveMaker = move;
	}
	
	public Move getMoveMaker () {
		return moveMaker;
	}
	
}