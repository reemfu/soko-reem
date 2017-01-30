package levels;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import elements.*;
import receivers.Direction;

public class Level implements Serializable {

	private ArrayList<ArrayList<Element>> board;
	private ArrayList<Point> solutionPoints = new ArrayList<Point>();
	private Player player = null;
	
	public Level(ArrayList<ArrayList<Element>> board) {
		try 
		{			
			this.board = board;
			Point tempPlayerPosition = getPlayer().getPosition();
			this.setPlayer(new Player(tempPlayerPosition));
			finalSolPosition();	
		}
		catch (Exception ex) {
			System.out.println(ex); 
		}
	}
	
	// Finding all TARGETs coordinates
	public void finalSolPosition() {
		for(int i = 0; i < board.size(); i++) 
			for(int j = 0; j < board.get(i).size(); j++) {
				Element el = board.get(i).get(j);
				if (el.getElementType() == ElementType.TARGET) {
					solutionPoints.add(el.getPosition()); 
					}
			}
	}
	
	public Player getPlayer()
	{
		if (player != null)
		{
			return player;
		}
		for (int i = 0; i < board.size(); i++)
		{
			for (int j = 0; j < board.get(i).size(); j++)
			{
				if (board.get(i).get(j).getElementType() == ElementType.PLAYER)
					return ((Player)board.get(i).get(j));
			}
		}
		return null;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public final ArrayList<ArrayList<Element>> getBoard() {
		return board;
	}
	
	public void setBoard(ArrayList<ArrayList<Element>> board) {
		this.board = board;
	}
	
	public List<Point> getSolutionCoordinates() {
		return solutionPoints;
	}
	
	public void setSolutionCoordinates(ArrayList<Point> solutionCoordinates) {
		this.solutionPoints = solutionCoordinates;
	}
	
	public Element getElement(Point position) {
		return board.get((int)position.getX()).get((int)position.getY());
	}
	
	public Element getNext(Point position, Direction direction) {
				
		int x = (int)position.getX();
		int y = (int)position.getY();
		
		switch (direction) {
			case UP:	return 	board.get(x-1).get(y);	
			case DOWN:	return 	board.get(x+1).get(y);				
			case LEFT:	return 	board.get(x).get(y-1);			
			case RIGHT:	return 	board.get(x).get(y+1);
			default:	return null;
		} 
	}
	
}