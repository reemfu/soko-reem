package receivers;

import java.util.ArrayList;

import elements.*;
import levels.*;

public class DisplayLevel {
	
	Level level = null;
	
	public DisplayLevel(Level level) {
		this.level = level;
	}
	
	public void display() {
		for (ArrayList<Element> a : level.getBoard())
		{
			for (Element el : a)
				System.out.print(el.getObjChar());
			System.out.println();
		}
	}

}
