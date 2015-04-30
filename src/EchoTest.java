import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class EchoTest {
	//socket connection
	static Socket socket;
	private static final String endLine = ";";
	
	public static void main(String args[]) throws IOException {
			//try to set up connection to server
			socket = new Socket(args[0], Integer.parseInt(args[1]));
			PrintWriter writer = 
					new PrintWriter(socket.getOutputStream(), true);
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Scanner in = new Scanner(System.in);
			
			String line;
			while((line = in.nextLine()) != "" && line != "exit") {
				//send message
				writer.println(line);
				
				//receive message
				while((line = reader.readLine()) != null && 
						!line.equals(endLine)) {
					System.out.println(line);
				}
			}
			//close
			socket.close();
	}
}
