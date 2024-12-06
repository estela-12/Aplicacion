package controlador;

public class User {
	private String usuario;
	private String contraseña;

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;

	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	

	

}
