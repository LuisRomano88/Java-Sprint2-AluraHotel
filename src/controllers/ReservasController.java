package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Huespedes;
import modelo.Reservas;



public class ReservasController {
	
	private ReservaDAO reservaDAO;
	
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
	
	public void guardar(Reservas reservas) {
		this.reservaDAO.guardar(reservas);
	}
	
	public List<Reservas> listarReservas(Reservas reservas) throws SQLException {
		return this.reservaDAO.listarReservas();
	}
	
    public int eliminar(int id) {
        return reservaDAO.eliminar(id);
    }
	
	

}
 