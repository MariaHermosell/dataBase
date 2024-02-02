package Ejercicio7;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
	
	private double tipoInteresDescubierto;
	private double maximoDescubiertoPermitido;
	private double comisionFijaDescubierto;
	
	public CuentaCorrienteEmpresa(Persona titular, double saldo, String iBAN, String listaEntidades,
			double tipoInteresDescubierto, double maximoDescubiertoPermitido, double comisionFijaDescubierto) {
		super(titular, saldo, iBAN, listaEntidades);
		this.tipoInteresDescubierto = tipoInteresDescubierto;
		this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
		this.comisionFijaDescubierto = comisionFijaDescubierto;
	}
	

	public double getTipoInteresDescubierto() {
		return tipoInteresDescubierto;
	}


	public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
		this.tipoInteresDescubierto = tipoInteresDescubierto;
	}


	public double getMaximoDescubiertoPermitido() {
		return maximoDescubiertoPermitido;
	}


	public void setMaximoDescubiertoPermitido(double maximoDescubiertoPermitido) {
		this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
	}


	public double getComisionFijaDescubierto() {
		return comisionFijaDescubierto;
	}


	public void setComisionFijaDescubierto(double comisionFijaMantenimiento) {
		this.comisionFijaDescubierto = comisionFijaMantenimiento;
	}


	@Override
	public String devolverInfoString() {
		
		return super.devolverInfoString()+ "El tipo de interes por descubierto es: "+ this.getTipoInteresDescubierto()+"Maximo descubierto permitido: "+ this.getMaximoDescubiertoPermitido()+"La comision fija por descubierto : "+this.getComisionFijaDescubierto();
	}
	
	

}
