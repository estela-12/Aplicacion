package modelo;

import java.util.Date;

public class Registro {
	
	
	private int idCliente;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String sexo; // Cambiado a String para representar "Hombre" o "Mujer"
    private Date fechaDeNacimiento; // Usar java.util.Date
    private String curp;
    private int numeroTelefonico;
    private String correoElectronico;
    private String direccion;
    private boolean activo;

    // Getters y Setters
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public int getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(int numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	// Constructor vacío
	public Registro() {
		super();
	}
	
	// Constructor con todos los campos
	public Registro(int idCliente, String nombre, String apellidoP, String apellidoM, String sexo,
			Date fechaDeNacimiento, String curp, int numeroTelefonico, String correoElectronico, 
			String direccion, boolean activo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.sexo = sexo;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.curp = curp;
		this.numeroTelefonico = numeroTelefonico;
		this.correoElectronico = correoElectronico;
		this.direccion = direccion;
		this.activo = activo;
	}
}