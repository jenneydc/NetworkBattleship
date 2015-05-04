import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class BattleshipServerInterface
{
	//socket connection
		private static Socket socket;
		private PrintWriter writer;
		private BufferedReader reader;
		
		private static final String endLine = ";";
		
		public BattleshipServerInterface() throws IOException {
				//try to set up connection to server
				socket = new Socket("ceclnx01.csi.miamioh.edu", 2015);
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
                
                /*
                 * sends name and other info to server for future identification
                 */
                public void preliminaries(String name) {
                    
                }
                
                /*
                 * sends attack to server, 
                 * returns BattleshipBoard.hit for hit, 
                 *     or BattleshipBoard.miss for miss.
                 * modifies oppboard.board, playBoard.board and .score appropriately
                 */
                public String attack(int x, int y, String playerName) {
                    return "nada";
                }
                
                /*
                 * receives attack from the server,
                 * sends back BattleshipBoard.hit for a hit, 
                 *      or BattleshipBoard.miss for a miss
                 * modifies oppboard.board, playBoard.board and .score appropriately
                 */
                public void receiveAttack(int x, int y){
                    
                }
                
                public void closeInterface() {
                    try {
                        socket.close();
                    }catch(IOException ex) {
                        ex.printStackTrace();
                    }
                }
}
