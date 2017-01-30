package receivers;

import java.io.FileInputStream;
import java.io.IOException;

import levels.Level;
import levels.MyTextLevelLoader;

public class LoadTextLevel implements LoadLevel {

	@Override
	public Level load(String path) throws IOException, IOException {
		MyTextLevelLoader loader = new MyTextLevelLoader();
		Level level = loader.loadLevel(new FileInputStream(path));
		return level;
	}		
}
