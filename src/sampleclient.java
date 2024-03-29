import java.io.*;
import java.net.*;

class sampleclient
{
	public static void main(String args[]) throws Exception
	{
		//init parameters	
		int localPort = 8888;
		//String dest_ip = "127.0.0.1";
		String dest_ip = "192.168.43.22";
		int dest_port = 8889;
		String message = "coucou";
		int receiveTimeout = 5000;
		UDPApi myApi = new UDPApi();
		
		
		System.out.println("CLIENT UDP");
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
		
		try {
			System.out.println("try to open on port " + Integer.toString(localPort));
			myApi.open(localPort); //open a socket with localPort
		}
		catch(Exception e)
		{
			System.err.println("failled to open socket");
		}
		System.out.println("port openned on " + Integer.toString(localPort));
		
		boolean retry = true;
		int retryTimeout = 1;
		
		while(retry)
		{
			try{
				System.out.println("try " + Integer.toString(retryTimeout)+ " to send on ip " +dest_ip +" port " +Integer.toString(localPort));
				myApi.send(message, dest_ip, dest_port); // try to send data to dest_ip with dest_port
			}
			catch(Exception e){
				System.err.println("failled to send message n� " + Integer.toString(retryTimeout));
			}
			//loop to check ack
			if(myApi.receive(receiveTimeout)) {
				System.out.print("ack ok");
				retry = false;
			}
			else System.err.println("ack timeout"); 
			
			retryTimeout++;
			
			if(retryTimeout == 4) retry = false;
		}
		
		try {
			myApi.close(); // close socket
			System.out.print("socket closed");
			
		}
		catch(Exception e)
		{
			System.err.println("failled to close, blyat"); 
		}
		

	}
}
