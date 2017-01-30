package commands;

import java.io.IOException;
import java.util.HashMap;

import levels.Level;
import receivers.*;

public class LoadCommand implements Command {

	private HashMap<String,LoadLevel> levelLoaderFactory = new HashMap<String,LoadLevel>();
	private String type = null;
	private String path = null;
	private Level level = null;
	
	@Override
	public void execute() throws IOException {
		if (!(type.equals("txt") || type.equals("obj") || type.equals("xml")))
		{
			System.out.println("invalid file name");
			return;
		}
		
		level = levelLoaderFactory.get(type).load(path);
		System.out.println("load completed!");
	}
	
	public LoadCommand(String path) {
		this.path = path;
		this.type = path.substring(path.lastIndexOf('.')+1);
		levelLoaderFactory.put("txt",new LoadTextLevel());
		levelLoaderFactory.put("obj",new LoadObjectLevel());
		levelLoaderFactory.put("xml",new LoadXmlLevel());
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setPath(String path){
		this.path = path;
	}
}