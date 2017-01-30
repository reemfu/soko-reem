package receivers;

import java.io.IOException;

import levels.Level;

public interface SaveLevel {
	public void save(Level level, String path) throws IOException;
}