package lab3;
import lab3.Natural;
import java.util.*;

public class Vector {
	
	static int max_dim=100;
	private Natural[] vect;
	private int lung;
	
	/*
	 * constructor fara parametri
	 */
	public Vector() {
		
		lung = 0;
		vect = new Natural[max_dim];
	}
	
	/*
	 * constructor vector cu un singur element
	 */
	public Vector(Natural n) {
		
		lung=1;
		vect=new Natural[1];
		vect[0]=n;
	}
	
	/*
	 * functie de adaugare a unui element in vector
	 */
	public void add(Natural n) {
		
		Natural[] aux=new Natural[lung];
		aux=vect;
		lung++;
		int i;
		vect=new Natural[lung];
		for(i=0; i<lung-1; i++)
			vect[i]=aux[i];
		vect[lung-1]=n; 
	}
	
	/*
	 * functie de determinare a maximului din vector
	 */
	public Natural maxim() {
		
		Natural max=new Natural(vect[0]);
		int i;
		for(i=1; i<lung; i++)
			if(vect[i].isGreater(max))
				max=vect[i];
		return max;
		
	}
	
	/*
	 * functie de determinare a sumei elementelor din vector
	 */
	public Natural suma() {
		
		Natural sum=new Natural();
		int i;
		for(i=0; i<lung; i++)
			sum = sum.suma(vect[i]);
		return sum;
			
		
	}
	
	/*
	 * metoda de conversie la string pentru afisari
	 */
	public String toString() {
		
		int i;
		String str = new String("Sirul este: ");
		for( i=0; i< lung; i++)
			str = str + " " + vect[i].toString();
		return str;
	}
}
