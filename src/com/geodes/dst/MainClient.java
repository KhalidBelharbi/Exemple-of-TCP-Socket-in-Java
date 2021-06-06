package com.geodes.dst;

import java.util.Scanner;
/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class MainClient {

	
	
	public static void main(String [] args ) {	
		
		System.out.println("_______________This is the exemple of client side__________");
		System.out.print("Enter the IP address of the server:");		
		Scanner reader = new Scanner(System.in); 
		String ip = reader.nextLine();
		System.out.print("Enter the service port in "+ip+":");
		int port = reader.nextInt();	
		System.out.println();
		SimpleClient client =  new SimpleClient(ip, port);	
		client.lancer();
	}
	
	
	
	
	
}
