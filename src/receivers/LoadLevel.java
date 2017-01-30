package receivers;

import java.io.IOException;

import levels.Level;

public interface LoadLevel {
	public Level load(String path) throws IOException;
}