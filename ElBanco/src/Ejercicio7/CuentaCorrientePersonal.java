package Ejercicio7;

public class CuentaCorrientePersonal extends CuentaCorriente{
	
	private double comisionMantenimiento;

	public CuentaCorrientePersonal(Persona titular, double saldo, String iBAN, String listaEntidades,
			double comisionMantenimiento) {
		super(titular, saldo, iBAN, listaEntidades);
		this.comisionMantenimiento = comisionMantenimiento;
	}

	public double getComisionMantenimiento() {
		return comisionMantenimiento;
	}

	public void setComisionMantenimiento(double comisionMantenimiento) {
		this.comisionMantenimiento = comisionMantenimiento;
	}

	@Override
	public String devolverInfoString() {
		
		return super.devolverInfoString()+"La comision de mantenimiento es: "+this.getComisionMantenimiento();
	}
	
	

}
