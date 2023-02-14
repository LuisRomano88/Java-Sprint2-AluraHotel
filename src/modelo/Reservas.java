package modelo;

import java.sql.Date;

public class Reservas {

	private int id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String valor;
	private String formaDePago;
	
		
	
 
	public Reservas(int id, Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor; 
		this.formaDePago = formaDePago;
	}
	
	
	public Reservas(Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor; 
		this.formaDePago = formaDePago;
	}


	public Reservas() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public String getValor() {
		return valor;
	}


	public String getFormaDePago() {
		return formaDePago;
	}


	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

 
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}


	

	



	
	
}
