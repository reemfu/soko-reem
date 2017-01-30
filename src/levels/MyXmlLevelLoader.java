package levels;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyXmlLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream input) throws IOException {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream((input)));
		Level newLevel = (Level)decoder.readObject();
		decoder.close();
		return newLevel;
	}

}
