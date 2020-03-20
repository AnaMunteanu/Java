package lab3;
import lab3.Vector;

public class Controller {
	
	private Vector vector;
	
	/*
	 * constructor implicit
	 */
	public Controller() {
		
		vector = new Vector();
	}
	
	/*
	 * costructor cu parametri
	 */
	public Controller ( Vector v) {
		
		vector = v;
	}
	
	/*
	 * accesor de tip get pentru vector
	 */
	public Vector getVector() {
		
		return vector;
	}
	
	/*
	 * accesor de tip set pentru vector
	 */
	public void setVector( Vector v) {
		
		vector = v;
	}
	
	/*
	 * metoda pentru determinare sumei elementelor din vector
	 */
	public Natural suma() {
		
		return vector.suma();
	}
	
	/*
	 * metoda pentru determinarea maximului din vector
	 */
	public Natural maxim() {
		
		return vector.maxim();
	}
	
	/*
	 * metoda pentru adaugarea unui natural in vector
	 */
	public void addNatural( Natural n) {
		
		vector.add(n);
	}
	
	/*
	 * returneaza conversia la string a vectorului pentru afisari
	 */
	public String toString() {
		
		return vector.toString();
	}
	
}
