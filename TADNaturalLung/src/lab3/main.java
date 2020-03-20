package lab3;
import lab3.*;
/*.Numar “NATURAL”. Un număr poate avea cel mult 1000 cifre. Metode:
 *    -  constructori;
 *       -  accesori;
 *          -  suma a două numere a două numere;
 *             -  compararea a două numere;
 *                -  alte metode, dacă sunt necesare. 
 * Sa se scrie un program care citeste mai multe siruri de numere naturale,
citirea oprindu-se la intalnirea unui sir vid (cu 0 elemente). Pentru
fiecare sir nevid se afiseaza suma elementelor sirului si numarul cel
mai mare din sir. La sfarsit se va tipari sirul Y format din toate numerele
maxime tiparite si suma lor. */

public class main {

	public static void main(String[] args) {
		/*Natural n=new Natural("12");
		Natural n2=new Natural("21");
		Natural n3=new Natural("11");
		Vector v=new Vector(n);
		v.add(n2);
		v.add(n3);
		System.out.println(v.maxim().toString());
		System.out.println(v.suma().toString());*/
		UI ui = new UI();
		ui.run();
		
	}

}
