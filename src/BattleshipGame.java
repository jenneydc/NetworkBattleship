import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BattleshipGame
{
	
	//this client player's board for this game
            BattleshipBoard board;
	
	//names of ships with lengths
            Map<String, Integer> ships = new HashMap<String, Integer>(5);
	
	//Scanner for receiving input (will be replaced by GUI)
            private Scanner in = new Scanner(System.in);

		
	public BattleshipGame() {
		board = new BattleshipBoard();
		fillShipInfo();
		startGame();
	}
	/*
	 * Prompts user for name and adds ships to board
	 */
	public boolean startGame() {
		//Prompt player for name
		System.out.println("Player Name: ");
		board.setPlayerName(in.nextLine());
		
		//place ships on board
		Object[] info;
		for(Map.Entry<String, Integer> ship : ships.entrySet()) {
			//get placement info
			info = getPlacementInfo(ship);
			
			try {
				board.addShip((int)info[0], (int)info[1], (int)info[2], (int)info[3]);
			} catch(Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
		return true;
	}
		
	/*
	 * gets remaining info for placing the ship in the board from user;
	 * orientation, startx, startY, shipLength;
	 * and places them, in that order into an Object[] to return
	 */
	private Object[] getPlacementInfo(Map.Entry<String, Integer> ship) {
		Object[] placementInfo = new Object[4];
		String tempResults;
		
		System.out.println("Where would you like to place "+ship.getKey()+"?");
		tempResults = in.nextLine();
		placementInfo[1] = Integer.parseInt(tempResults.split(", ")[0]);
		placementInfo[2] = Integer.parseInt(tempResults.split(", ")[1]);
		
		System.out.println("Which direction should it face?"
				+ "\n -1 = UP, -2 = DOWN, -3 = LEFT, -4 = RIGHT");
		tempResults = in.nextLine();
		placementInfo[0] = Integer.parseInt(in.nextLine());
		
		placementInfo[3] = ship.getValue();
		return placementInfo;
	}
	
	/*
	 * fills in standard names and lengths of ships
	 */
	private void fillShipInfo() {
		ships.put("Patrol Boat", 2);
		ships.put("Destroyer", 3);
		ships.put("Submarine", 3);
		ships.put("Battleship", 4);
		ships.put("Aircraft Carrier", 5);
	}
	
	/*
	 * Tallies scores, declares a winner and sends data to the server
	 */
	public boolean finishGame() {
		return false;
	}
}
