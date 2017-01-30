package receivers;

import java.io.FileInputStream;
import java.io.IOException;

import levels.Level;
import levels.MyXmlLevelLoader;

public class LoadXmlLevel implements LoadLevel{

	@Override
	public Level load(String path) throws IOException, IOException {
		MyXmlLevelLoader loader = new MyXmlLevelLoader();
		FileInputStream in = new FileInputStream(path);
		Level level = loader.loadLevel(in);
		in.close();
		return level;
	}
}
