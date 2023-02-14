                                                                                                                         package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Huespedes;
import modelo.Reservas;
import views.ReservasView;



public class ReservaDAO {
	 
	private Connection connection;
	
//ReservasView reservasView = new ReservasView();
	//String valorReserva = reservasView.valorReserva();
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(Reservas reservas) {
		String sql = "INSERT INTO Reservas (fechaEntrada, fechaSalida, valor, formaDePago)"
				+ "VALUES (?,?,?,?)";
		
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			statement.setDate(1, reservas.getFechaEntrada());
			statement.setDate(2, reservas.getFechaSalida());
			statement.setString(3, reservas.getValor());
			statement.setString(4, reservas.getFormaDePago());
			
			statement.executeUpdate();
			
			try(ResultSet rs = statement.getGeneratedKeys()){
				while (rs.next()) {
					reservas.setId(rs.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
	}
	}	
	
	public List<Reservas> listarReservas(){
		
		ArrayList<Reservas> resultadoReservas = new ArrayList<Reservas>();
			
		String sql = "SELECT * FROM Reservas";
		
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.executeQuery();
			try (ResultSet rs = statement.executeQuery(sql)) {
				while (rs.next()) {

					resultadoReservas.add(new Reservas(
							rs.getInt("id"),
							rs.getDate("fechaEntrada"),
							rs.getDate("fechaSalida"),
							rs.getString("valor"),
							rs.getString("formaDePago")));
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return resultadoReservas;
		
	}
	
	public int eliminar(int id) {

		String sql = "DELETE FROM Reservas WHERE ID = ?";
		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();

			int updateCount = statement.getUpdateCount();

			return updateCount;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int editarReserva(Reservas reservas) throws SQLException {
		
		int resultado = 0;
		
		String sql = "UPDATE Reservas SET fechaEntrada = ?, fechaSalida = ?, valor = ?, formaDePago = ?, WHERE id = ?";

		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setDate(1, reservas.getFechaEntrada());
			statement.setDate(2, reservas.getFechaSalida());
			statement.setString(4, reservas.getValor());			
			statement.setString(5, reservas.getFormaDePago());
			statement.execute();

			final ResultSet resultSet = statement.getGeneratedKeys();		    
            
            while (resultSet.next()) {
                resultado = resultSet.getInt(1);                
                System.out.println(String.format("Fue editado el huesped con id: " +resultado));
            }
            
		
		} catch (Exception e) {
			return resultado;
			
		} 
		
		return resultado;
	}
	
	
}
