package com.geodes.src;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Vector;


/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class Service extends Thread{

	Socket socket;
	ObjectOutputStream outS;
	ObjectInputStream inS;	
    int IDConnection;
	InetAddress InetClient;
	
	
	public Service(Socket socket, int id) {		
		this.socket = socket;
		this.IDConnection = id;			
	    try {
		outS=new ObjectOutputStream(this.socket.getOutputStream());
		inS=new ObjectInputStream(this.socket.getInputStream());      
	            
		} catch (IOException e) {System.out.println("Erreur: "+e.getMessage());}
		
	}
	
	public void run(){
			
	while(true){	
		try {
			Object oo=(Object) inS.readObject();			
			if(oo instanceof String) {				
				System.out.println("\n--- New message ---> A message received by the customer "+this.socket.getInetAddress()+":"+this.socket.getPort()+":");
				System.out.println((String)oo);				
			}
			
	} catch (ClassNotFoundException e) {
				
		break;
	} catch (IOException e) {
		System.out.println("Connection closed with the Client: ID="+this.IDConnection+"  IP="+this.socket.getInetAddress()+"  Port="+this.socket.getPort());
	break;
	}
	}
	
		 
	
	}
	
}
