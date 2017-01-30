package commands;

import levels.Level;
import receivers.DisplayLevel;

public class DisplayCommand implements Command {

	DisplayLevel displayer = null;
	
	@Override
	public void execute() {
		displayer.display();
	}
	
	public DisplayCommand(Level level) {
		displayer = new DisplayLevel(level);
	}
}
