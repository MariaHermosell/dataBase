package Ejercicio7;

public class Persona implements Imprimible{

	private String nombre;
	private String Apellido;
	private String DNI;
	public Persona(String nombre, String apellido, String dNI) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	@Override
	public String devolverInfoString() {
		
		return "Nombre: "+ this.getNombre()+"Apellidos: "+ this.getApellido()+"DNI: "+this.getDNI();
	}
	
	
}

