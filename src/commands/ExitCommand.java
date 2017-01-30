package commands;

public class ExitCommand implements Command {

	private boolean exit = true;
		
	@Override
	public void execute() {
	}
	
	public boolean getExit() {
		return exit;
	}
}
