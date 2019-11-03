import java.io.*;
import java.net.*;

class sampleserver
{
	public static void main(String args[]) throws Exception
	{
		//init parameters	
		int localPort = 0;
		UDPApi myApi = new UDPApi();
		
		if (args.length < 1) {
			System.err.println("usage is sampleserver <local_port>");
			System.exit(1);
		}
		try {
			localPort = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.err.println("argument " + args[0] + " must be an integer.");
			System.exit(1);
		}


		/*TODO*/	
		
	}
}

