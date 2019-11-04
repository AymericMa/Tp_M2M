import java.io.*;
import java.net.*;

class sampleserver
{
	public static void main(String args[]) throws Exception
	{
		//init parameters	
		int localPort = 8889;
		UDPApi myApi = new UDPApi();
		
		
		System.out.println("SERVER UDP");
		
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
		
		try {
			System.out.println("try to open on port " + Integer.toString(localPort));
			myApi.open(localPort); //open a socket with localPort
		}
		catch(Exception e)
		{
			System.err.println("failled to open socket");
		}
		System.out.println("port openned on " + Integer.toString(localPort));


		try {
			if(myApi.receive(10000)) {
				System.out.println(myApi.getReceivedMessage());
				myApi.send("ack", myApi.Source_ip, myApi.Source_port); // reply to client to ack
			}
			else System.out.println("no message");
		}
		catch(Exception e)
		{
			System.err.println("failled to receice message");
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

