package com.geodes.src;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
* Copyright - This code contains a watermark for the author
* @author Khalid Belharbi
*/
public class SimpleServer {
	
	InetAddress adr_server;
	ServerSocket serveur;
	Socket connexion=null;
	ObjectInputStream inS=null;
	ObjectOutputStream outS=null;
	public static int id = 0;
	static final int port=40409; // le choix d’in port dynamique

	
	public SimpleServer(){
	
		System.out.println("___This is the server side of client/server architecture___");
		try {
			serveur=new ServerSocket(port);
	
		
		adr_server = InetAddress.getLocalHost();
		
		System.out.println("The server : "+adr_server.getCanonicalHostName()+" is running on the port number : "+port+" ...");
	
		
		  while(true){
              try {
			connexion=serveur.accept();		
			System.out.println("- New connection with a client on the port:"+connexion.getLocalPort());
            Service serviceClient=new Service(connexion,++SimpleServer.id);    		  
            serviceClient.start();               
     	
          	} catch (IOException e) {System.out.println("Error : "+e.getMessage());
			}
              
              }

		} catch (IOException e1) {
			System.out.println("Error: "+e1.getMessage());
		}
	}	
}
