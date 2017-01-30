package receivers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import levels.Level;

public class SaveToObject implements SaveLevel {

	@Override
	public void save(Level level, String path) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		out.writeObject(level);
		out.close();
	}
}