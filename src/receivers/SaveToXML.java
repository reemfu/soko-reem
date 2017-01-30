package receivers;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import levels.Level;

public class SaveToXML implements SaveLevel{
	@Override
	public void save(Level level, String path) throws IOException {
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
		encoder.writeObject(level);
		encoder.close();	
	}
}
