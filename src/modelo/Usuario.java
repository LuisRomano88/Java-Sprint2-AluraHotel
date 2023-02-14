package modelo;

public class Usuario {

	int id;
	String nombre;
	String apellido;
	//byte tipoUsuario;
	
	
	
	
	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		//this.tipoUsuario = tipoUsuario;
	}
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/*
	public byte getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(byte tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}*/
	
	
	
	
}
