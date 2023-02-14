package modelo;

import java.util.Date;

public class Huespedes extends Usuario{


	Integer id;
	Date fecha_nacimiento;
	String nacionalidad;
	String telefono;
	int id_reserva;
	
	
	
	public Huespedes(int id, String nombre, String apellido, Date fecha_nacimiento, String nacionalidad,
			String telefono,  int id_reserva) {
		
		super(nombre, apellido);
		this.id = id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}
	
	public Huespedes(String nombre, String apellido, Date fecha_nacimiento, String nacionalidad,
			String telefono, int id_reserva) {
		super(nombre, apellido);
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}

	public Huespedes(String nombre, String apellido) {
		super(nombre, apellido);
	}


	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
}
