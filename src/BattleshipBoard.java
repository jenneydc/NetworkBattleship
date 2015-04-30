import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BattleshipBoard
{
	//representation of a battleship board (rows of columns i.e. [x][y])
	int[][] board;
        
        // graphical representaion of the board
        BattleshipGUI gui;
	
	//keeps score for one game
	private int score;
	private String playerName;
	
	//names of ships with lengths
	Map<String, Integer> ships = new HashMap<>(5); 
	
	//constants for indicating state of a coordinate
	final static int empty = 0;
	final static int occupied = 1;
	     //already attacked
	final static int missed = 2;
	final static int damaged = 3;
	
	//orientations for placing ships
	final static int UP = -1;
	final static int DOWN = -2;
	final static int LEFT = -3;
	final static int RIGHT = -4;
	
	//constants for replying to attack
	final static String hit = "hit!";
	final static String miss = "miss!";
	
	/*
	 * sets up empty board and calls startGame() to prepare for game
	 */
	public BattleshipBoard() {
		//instantiate empty board
		board = new int[10][10];
		for(int[] row : board) {
                    Arrays.fill(row, empty);
		}
                
                //instantiate gui
                gui = new BattleshipGUI(this);
	}
	
	/*
	 * Checks if specified coordinate holds a ship 
	 * (is occupied), if so returns true. 
	 * Returns false otherwise.
	 */
	public boolean checkEnemyAttack(int row, int column){
		if(board[row][column] == occupied) {
			return true;
		}
		return false;
	};
	
	/*
	 * Tries to place ship on board. Sets appropriate indices to occupied.
	 * returns true if this is completed successfully. returns false if
	 * the edge of the board or another ship interferes with the placement.
	 * 
	 * @requires - shiplength must be [1,5]
	 * 			 - ship must fit within board params 
	 */
	public boolean addShip(int orientation, int startX, int startY, int shipLength) throws Exception{
		try{
			switch(orientation) {
				case BattleshipBoard.UP:
					for(int i=0; i<shipLength; i++) {
						//make sure the space isn't already occupied
						if(board[startX][startY+i] == occupied) {
							throw new Exception("space "+alpha(startX)+", "+(startY+i)+" is already occupied!");
						}
						board[startX][startY+i] = occupied;
					}
					break;
				
				case BattleshipBoard.DOWN:
					for(int i=0; i<shipLength; i++) {
						//make sure the space isn't already occupied
						if(board[startX][startY-i] == occupied) {
							throw new Exception("space "+alpha(startX)+", "+(startY-i)+" is already occupied!");
						}
						board[startX][startY-i] = occupied;
					}
					break;
				
				case BattleshipBoard.LEFT:
					for(int i=0; i<shipLength; i++) {
						//make sure the space isn't already occupied
						if(board[startX-i][startY] == occupied) {
							throw new Exception("space "+alpha(startX-i)+", "+startY+" is already occupied!");
						}
						board[startX-i][startY] = occupied;
					}
					break;
				
				case BattleshipBoard.RIGHT:
					for(int i=0; i<shipLength; i++) {
						//make sure the space isn't already occupied
						if(board[startX+i][startY] == occupied) {
							throw new Exception("space "+alpha(startX+i)+", "+startY+" is already occupied!");
						}
						board[startX+i][startY] = occupied;
					}
					break;
				
				default:
					throw new Exception("invlaid orientation");
			}
			return true;
		} catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			return false;
		}
	};
	
	
	/* 
	 * helper method for getting alphabetic value of an x value
	 * 
	 */
	private String alpha(int row) {
		return row > 0 && row < 10 ? String.valueOf((char)(row + 64)) : null;
	}
	
	public void setPlayerName(String newName) {
		this.playerName = newName;
	}
	
	/*
	 * For modifying score on a hit
	 */
	public void addToScore(int points) {
		score += points;
	}
}
