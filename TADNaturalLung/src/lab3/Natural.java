package lab3;

public class Natural {
	
	static int max_dim=1000;
	int dim;
	int cif[];
	
	/*constructor implicit
	 * initializeaza lungimea cu 1 si numarul cu 0
	 */
	public Natural(){
		
		dim=1;
		cif = new int[dim];
		cif[0]=0;
	}
	
	/*constructor cu parametri
	 * 
	 */
	public Natural( Natural n) {
		if(this!=n)
		{
			dim = n.dim;
			cif = new int[dim];
			for(int i=0; i<dim; i++)
				cif[i]=n.cif[i];
		}
	}
	
	/*constructor dintr-un string
	 * cifrele numarului se salveaza in ordine inversa
	 */
	public Natural(String sir) {
		
		dim = (int) sir.length();
		cif = new int[dim];
		int i=0, j;
		while ( i<dim && sir.charAt(i)=='0' )
			i++;
		j = dim-1;
		while( j >= i) {
			cif[dim-1-j]=(int) (sir.charAt(j)-'0');
			j--;
		}
		dim=dim-i;
	}
	
	/*verifica daca this > n
	 * 
	 */
	public boolean isGreater(Natural n) {
		
		if(dim > n.dim)
			return true;
		if(dim< n.dim)
			return false;
		
		int i=dim-1;
		while(i>0 && cif[i]==n.cif[i])
			i--;
		
		if(cif[i] >= n.cif[i])
			return true;
		return false;
	}
	
	/*returneaza this + n
	 * 
	 */
	public Natural suma(Natural n) {
		
		Natural suma=new Natural();
		int i, transport=0, sumacifre;
		
		if(this.isGreater(n)) {
			suma.cif=new int[dim+1];
			suma.dim=dim+1;
			for(i=0; i<dim; i++) {	//daca this>=n se merge pana la dimensiunea lui this
				if(i<n.dim) {		//se aduna cifre din ambele numere
					sumacifre = cif[i] + n.cif[i] + transport;
					suma.cif[i] = sumacifre % 10 ;
					transport = sumacifre / 10;
				}
				else {				//se iau doar cifrele lui this si transportul
					sumacifre = cif[i] + transport;
					suma.cif[i] = sumacifre % 10 ;
					transport = sumacifre / 10;
				}		
			}	//end for
			
		}
		else {			//n > this
			suma.cif=new int[n.dim+1];
			suma.dim=n.dim+1;
			for(i=0; i<n.dim; i++) {
				if(i<dim) {		//se aduna cifre din ambele nr
					sumacifre = cif[i] + n.cif[i] + transport;
					suma.cif[i] = sumacifre % 10 ;
					transport = sumacifre / 10;
				}
				else {			//se continua doar cu cifrele lui n si transportul
					sumacifre = n.cif[i] + transport;
					suma.cif[i] = sumacifre % 10 ;
					transport = sumacifre / 10;
				}		
			}	//end for
			
		}
		if( transport == 1)		//daca la final mai ramane un transport
			suma.cif[dim] = 1;
		else
			suma.dim--;
		
		return suma;
	}
	
	/*accesor de tip set pt cifre
	 * 
	 */
	public void setNatural( int[] cifre) {
		
		dim=cifre.length;
		cif=new int[dim];
		int i;
		for(i=0; i<dim; i++) {
			cif[i]=cifre[i];
		}	
	}
	/*
	 * accesor de tip get pt cifre
	 */
	public int[] getNatural() {
		
		return cif;
	}
	
	/*
	 * accesor de tip get pentru dimensiune
	 */
	public int getDim() {
		
		return dim;
	}
	
	/*
	 * metoda de conversie la string pt afisari
	 */
	public String toString() {
		String str=new String();
		int i;
		for(i=dim-1;i>=0;i--)
			str=str+Integer.toString(cif[i]);
		return str;
	}
}
