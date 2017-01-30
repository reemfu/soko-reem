package levels;

import java.io.IOException;
import java.io.InputStream;

public interface LevelLoader {
	public Level loadLevel (InputStream in) throws IOException;
}
