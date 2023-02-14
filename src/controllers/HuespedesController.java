package controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


import dao.HuespedesDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;
import views.RegistroHuesped;


public class HuespedesController {
	
	private HuespedesDAO huespedesDAO;
	private RegistroHuesped registroHuesped;
	private Huespedes huespedes;
	
	public HuespedesController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.huespedesDAO = new HuespedesDAO(connection);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedesDAO.guardar(huespedes);
	}
	
	public List<Huespedes> listar(Huespedes huespedes) throws SQLException {
		return this.huespedesDAO.listar();
	}
	
    public int eliminar(int id) {
        return huespedesDAO.eliminar(id);
    }
    
    public List<Huespedes> buscarHuespedPorApellido() {
    	return this.huespedesDAO.buscarHuespedPorApellido();
    }
    
    public int editar(Huespedes huespedes) {
		return this.huespedesDAO.editar(huespedes);
    	
    }

} 
  