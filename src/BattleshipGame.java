import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class BattleshipGame
{
	
	//this client player's board for this game
            BattleshipBoard board;
        //opponent's board for this game
            BattleshipBoard oppBoard;
            
        //gui for this game
            BattleshipGUI gui;
	
	//names of ships with lengths
            Map<String, Integer> ships = new HashMap<String, Integer>(5);

        //flag to show when the game is finished, 
        //    that is someone lost all their ships
            boolean done = false;
		
	public BattleshipGame() {
		board = new BattleshipBoard();
                oppBoard = new BattleshipBoard();
		fillShipInfo();
		startGame();
                takeAttacks();
                finishGame();
	}
	/*
	 * Prompts user for name and adds ships to board
	 */
	public boolean startGame() {
                //start gui
                gui = new BattleshipGUI(board, oppBoard);
            
		//Prompt player for name
		board.setPlayerName(JOptionPane.showInputDialog("Player Name: "));
                
		//place ships on board
		Object[] info;
		for(Map.Entry<String, Integer> ship : ships.entrySet()) {
                    while(true) {
                        try {
                            //get placement info
                            info = getPlacementInfo(ship);
			
                            board.addShip((int)info[0], (int)info[1], (int)info[2], (int)info[3]);
                            gui.repaint();
			} catch(Exception ex) {
                            JOptionPane.showInternalConfirmDialog(gui, ex.getMessage());
                            continue;
			}
                        break;
                    }
		}
		return true;
	}
		
	/*
	 * gets remaining info for placing the ship in the board from user;
	 * orientation, startx, startY, shipLength;
	 * and places them, in that order into an Object[] to return
	 */
	private Object[] getPlacementInfo(Map.Entry<String, Integer> ship) throws Exception {
		Object[] placementInfo = new Object[4];
		String tempResults;
		
		tempResults = JOptionPane.showInputDialog(
                        "Where would you like to place "+ship.getKey()+"? (A1-J10)");
		placementInfo[1] = intValue(tempResults.charAt(0));
                if(tempResults.length() > 2) {
                    placementInfo[2] = Integer.parseInt(tempResults.charAt(1)+"") * 10;
                } else {
                    placementInfo[2] = Integer.parseInt(tempResults.charAt(1)+"");
                }
		
		tempResults = JOptionPane.showInputDialog(
                        "Which direction should it face?"
                        + "\n -1 = UP, -2 = DOWN, -3 = LEFT, -4 = RIGHT");
                if(tempResults != null) {
                    placementInfo[0] = Integer.parseInt(tempResults);
                } else {
                    throw new Exception("empty orientation!");
                }
		
		placementInfo[3] = ship.getValue();
                
                for(Object elt : placementInfo) {
                    System.out.println(elt);
                }
                
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
	 * helper method for getting alphabetic value of an x value
	 * 
	 */
	public static String alpha(int row) {
		return row > 0 && row < 10 ? String.valueOf((char)(row + 64)) : null;
	}
        
        /* 
	 * helper method for getting alphabetic value of an x value
	 * 
	 */
	public static int intValue(char letter) {
		return letter >= 'A' && letter <= 'J' ? letter - 64 : null;
	}
        
        public void printOppBoard() {
            for(int[] row : oppBoard.board) {
                for(int elt : row) {
                    System.out.print(elt+", ");
                }
                System.out.println();
            }
        }
        
        public void printBoard() {
            for(int[] row : board.board) {
                for(int elt : row) {
                    System.out.print(elt+", ");
                }
                System.out.println();
            }
        }
	
        /*
         * gives and receives attacks, in the form of guesses "\W\D"
         */
        private boolean takeAttacks() {
            while(!done) {
                
            }
            return true;
        }
        
	/*
	 * Tallies scores, declares a winner and sends data to the server
	 */
	public boolean finishGame() {
		return false;
	}
}
