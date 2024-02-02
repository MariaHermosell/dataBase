package Ejercicio7;

public class CuentaAhorro extends CuentaBancaria {
	

	

	private double tipoInteresAnual;

	public CuentaAhorro(Persona titular, double saldo, String iBAN, double tipoInteresAnual) {
		super(titular, saldo, iBAN);
		this.tipoInteresAnual = tipoInteresAnual;
	}

	public double getTipoInteresAnual() {
		return tipoInteresAnual;
	}

	public void setTipoInteresAnual(double tipoInteresAnual) {
		this.tipoInteresAnual = tipoInteresAnual;
	}

	@Override
	public String devolverInfoString() {
		
		return super.devolverInfoString()+"Tipo de interes anual: "+this.getTipoInteresAnual();
	}
	
	
	
	
	
	
	

}
