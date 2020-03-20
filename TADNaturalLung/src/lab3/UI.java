package lab3;
import java.util.Scanner;

import lab3.Natural;
import lab3.Controller;
import java.io.*;


public class UI {

	private Controller ctrl;
	
	public UI() {
		
		ctrl = new Controller();
	}
	
	public static int CitInt(String sir) {   	//citeste un nr de tip int
		
		System.out.println(sir);
		Scanner scn = new Scanner(System.in);
		return scn.nextInt();
	}
	
	/*
	 * citeste un string de la tastatura pana la Enter
	 */
	public static String citString() throws IOException {
		
	    char c;
	    String  s = new String();
	    System.out.println("Dati un sir: ");
	    do {
	        c= (char) System.in.read();
	        s = s + c;
	    }
	    while (c != '\n');

	    return s.substring(0, s.length()-2);
	  }
	
	public static int AfisMeniu() {
		
		System.out.println("1. Citire siruri de numere de la tastatura + afisare maxim si suma pentru fiecare sir");
		System.out.println("2. Citire siruri de numere din fisier + afisare mxim si suma pentru fiecare sir");
		System.out.println("3. Rulare program (afisarea unui vector cu maximul din fiecare sir si suma acestor maxime)");
		System.out.println("0. Terminare program");
		int optiune=CitInt("Optiunea ta: ");
		return optiune;
		
		}
	
	public void run() {
		Vector rezultat = new Vector();
		int opt=AfisMeniu();
		while ( opt != 0 ) {
			if(opt==1) {
				 
				String str = new String();
				String[] sir = new String[0];
				rezultat = new Vector();
				
				try{
					 str = new String( citString() );
				 }
				 catch(IOException exc) {
					 System.out.println("Mai incearca...");
					 
				 }
				while( !str.equals("")){
					 
					 Vector vector = new Vector();
					 ctrl = new Controller(vector);
					 sir = str.split(",");
					 for( String a : sir) {
						 Natural n = new Natural( a);
						 ctrl.addNatural(n);
					 }
					 System.out.println(ctrl.toString());
					 System.out.println("Suma numerelor este: "+ ctrl.suma());
					 System.out.println("Maximul numerelor este: "+ ctrl.maxim());
					 rezultat.add(ctrl.maxim());
					 
					 
					 try{
						 str = new String( citString() );
					 }
					 catch(IOException exc) {
						 System.out.println("Mai incearca...");
						 
					 }
				 } //end while
				 	
				}
			
			else if(opt==2) {
				
				String[] sir = new String[0];
				rezultat = new Vector();
					try {
						BufferedReader file = new BufferedReader ( new FileReader ("D:\\METODE AVANSATE\\lab3\\src\\lab3\\SIRURI"));
						String str = new String();
						while ( (str = file.readLine())!=null) {
						
							Vector vector = new Vector();
							ctrl = new Controller(vector);
							sir = str.split(",");
							
							for(String a: sir) {
								Natural n = new Natural(a);
								ctrl.addNatural(n);
							}  //end for
							
							 System.out.println(ctrl.toString());
							 System.out.println("Suma numerelor este: "+ ctrl.suma());
							 System.out.println("Maximul numerelor este: "+ ctrl.maxim());
							 System.out.println();
							 rezultat.add(ctrl.maxim());
							 
							// str = file.readLine();
						}	//end while
					}
					catch(IOException e) {
						
						System.out.println("Eroare la citire...");
						e.printStackTrace();
					}
					
				
			}
			else if(opt==3){
				System.out.println(rezultat.toString());
				System.out.println("Suma maximelor este " + rezultat.suma());
				
			}
			opt=AfisMeniu();
			
		}
		System.out.println("Program terminat");
		
	}

	

}
