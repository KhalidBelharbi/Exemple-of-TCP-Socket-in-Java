package com.geodes.dst;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class SimpleClient {

	
	ObjectOutputStream out=null;
 	ObjectInputStream in=null;     
 	Socket connexion;    
    InetAddress adrServer;      
	
	
    public SimpleClient(String ip, int port) {    	
    	try {    		
    		adrServer =InetAddress.getByName(ip);
			connexion= new Socket(ip, port);
			out=new ObjectOutputStream(connexion.getOutputStream());
	    	in=new ObjectInputStream(connexion.getInputStream());	
	    	
			System.out.println("Well established connection with the server "+ip+":"+port);

		} catch (UnknownHostException e) {
			System.out.println("Error in the server's ip address or port "+ip+":"+port);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("*** Error *** "+e.getMessage());
		}    	
    }
	    
    public void lancer() {    	
    	Scanner lire = new Scanner(System.in);
    	while(true) {   
    		System.out.println("________________________________________________");
    		System.out.println("Enter a msg to send it to the server:");    		
    		this.envoyer_msg(lire.nextLine());    		
    	}    	
    }
    
    public void envoyer_msg(String trame){    	
    	try {
    		this.out.writeObject(trame);
    		this.out.reset();
    	} catch (IOException ex) {	System.out.println("Error: "+ex.getMessage());}	
    }
		
}
