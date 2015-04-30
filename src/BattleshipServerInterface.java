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
}
