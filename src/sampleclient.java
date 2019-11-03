import java.io.*;
import java.net.*;

class sampleclient
{
	public static void main(String args[]) throws Exception
	{
		//init parameters	
		int localPort = 0;
		String dest_ip = "0.0.0.0";
		int dest_port = 0;
		String message = "";
		int receiveTimeout = 5000;
		UDPApi myApi = new UDPApi();

		if (args.length < 5) {
			System.err.println("usage is sampleclient  local_port  dest_ip  dest_port  message  timeout(msec)");
			System.exit(1);
		}
		try {
			
			localPort = Integer.parseInt(args[0]);
			dest_ip = args[1];
			dest_port = Integer.parseInt(args[2]);
			message = args[3];
			receiveTimeout = Integer.parseInt(args[4]);

		} catch (NumberFormatException e) {
			System.err.println("argument must be an integer.");
			System.exit(1);
		}
	

		/*TODO*/

	}
}
