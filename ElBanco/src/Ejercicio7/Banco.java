package Ejercicio7;

public class Banco {

	private CuentaBancaria[] cuentas;
	private int numeroCuentas;

	public Banco() {// Objeto que inicializa lo declarado anteriormente.
		this.cuentas = new CuentaBancaria[100];
	}

	public boolean abrirCuenta(CuentaBancaria c) {
		if (numeroCuentas > 100) {
			System.out.println("No se pueden crear mas cuentas");
			return false;

		}
		CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
		if (existe != null) {
			System.out.println("La cuenta introducida ya existe");// La cuenta existe, por eso retorna a falso, porque no se puede crear. 

			return false;

		}
		this.cuentas[this.numeroCuentas]=c;//Quiero meter en cuentas, en la posicion que marca numeroCuentas en "c"
		this.numeroCuentas++;
		return true;

	}
	
	public String [] listadoCuentas() {
		String [] informacionCuenta= new String[this.numeroCuentas];
		for(int i=0;i<this.numeroCuentas;i++) {
			
		}
		
		return null;
		
	}

	private CuentaBancaria buscarCuenta(String IBAN) {// private + lo que vaya a devolver + nombre del metodo+ lo que
														// recibe por parametro para poder buscarla.
		for (int i = 0; i < numeroCuentas; i++) {
			if (this.cuentas[i].getIBAN().equals(IBAN)) {
				return this.cuentas[i];
			}
		}
		return null;
	}
}