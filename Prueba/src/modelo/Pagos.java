package modelo;

import java.util.Date;

public class Pagos {
	private int idPago;
	private int saldoPendiente;
	private int SaldoApagar;
	private Date fechaLimiteaPagar;
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public int getSaldoPendiente() {
		return saldoPendiente;
	}
	public void setSaldoPendiente(int saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}
	public int getSaldoApagar() {
		return SaldoApagar;
	}
	public void setSaldoApagar(int saldoApagar) {
		SaldoApagar = saldoApagar;
	}
	public Date getFechaLimiteaPagar() {
		return fechaLimiteaPagar;
	}
	public void setFechaLimiteaPagar(Date fechaLimiteaPagar) {
		this.fechaLimiteaPagar = fechaLimiteaPagar;
	}
	public Pagos(int idPago, int saldoPendiente, int saldoApagar, Date fechaLimiteaPagar) {
		super();
		this.idPago = idPago;
		this.saldoPendiente = saldoPendiente;
		SaldoApagar = saldoApagar;
		this.fechaLimiteaPagar = fechaLimiteaPagar;
	}
	public Pagos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
