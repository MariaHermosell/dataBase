package Ejercicio7;

public class CuentaBancaria  implements Imprimible{
	
	private Persona titular;
	private double saldo;
	private String IBAN;
	public CuentaBancaria(Persona titular, double saldo, String iBAN) {
		
		this.titular = titular;
		this.saldo = saldo;
		IBAN = iBAN;
		
		
		
		
	}
	public Persona getTitular() {
		return titular;
	}
	public void setTitular(Persona titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	@Override
	public String devolverInfoString() {
		
		return "titular: "+this.titular.devolverInfoString()+"saldo: "+this.saldo+"IBAN: "+ this.IBAN;
	}

	
}
