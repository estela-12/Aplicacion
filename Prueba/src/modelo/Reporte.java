package modelo;

import java.sql.Date;

public class Reporte {
	
	private int idReporte;
	private Date fechaDelLevantamientoDelReporte;
	private Date fechaDelCorteDeAgua;
	private String direccion;
	private int numeroTelefonico;
	private String descripcionDelReporte;
	
	
	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	public Date getFechaDelLevantamientoDelReporte() {
		return fechaDelLevantamientoDelReporte;
	}
	public void setFechaDelLevantamientoDelReporte(Date fechaDelLevantamientoDelReporte) {
		this.fechaDelLevantamientoDelReporte = fechaDelLevantamientoDelReporte;
	}
	public Date getFechaDelCorteDeAgua() {
		return fechaDelCorteDeAgua;
	}
	public void setFechaDelCorteDeAgua(Date fechaDelCorteDeAgua) {
		this.fechaDelCorteDeAgua = fechaDelCorteDeAgua;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(int numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	public String getDescripcionDelReporte() {
		return descripcionDelReporte;
	}
	public void setDescripcionDelReporte(String descripcionDelReporte) {
		this.descripcionDelReporte = descripcionDelReporte;
	}
	public Reporte(int idReporte, Date fechaDelLevantamientoDelReporte, Date fechaDelCorteDeAgua, String direccion,
			int numeroTelefonico, String descripcionDelReporte) {
		super();
		this.idReporte = idReporte;
		this.fechaDelLevantamientoDelReporte = fechaDelLevantamientoDelReporte;
		this.fechaDelCorteDeAgua = fechaDelCorteDeAgua;
		this.direccion = direccion;
		this.numeroTelefonico = numeroTelefonico;
		this.descripcionDelReporte = descripcionDelReporte;
	}
	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
