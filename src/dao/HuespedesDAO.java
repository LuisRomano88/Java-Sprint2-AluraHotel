package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Huespedes;
import modelo.Reservas;
import views.Busqueda;

public class HuespedesDAO {

	private Connection connection;

	public HuespedesDAO(Connection connection) {

		this.connection = connection;
	}

	public void guardar(Huespedes huespedes) {

		String sql = "INSERT INTO Huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)"
				+ "VALUES (?,?,?,?,?,?)";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, huespedes.getNombre());
			statement.setString(2, huespedes.getApellido());
			statement.setDate(3, (java.sql.Date) huespedes.getFecha_nacimiento());
			statement.setString(4, huespedes.getNacionalidad());
			statement.setString(5, huespedes.getTelefono());
			statement.setInt(6, huespedes.getId_reserva());

			statement.executeUpdate();

			try (ResultSet rs = statement.getGeneratedKeys()) {
				while (rs.next()) {
					huespedes.setId(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> listar() {

		ArrayList<Huespedes> resultadoTabla = new ArrayList<Huespedes>();

		String sql = "SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA FROM Huespedes";

		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.executeQuery();
			try (ResultSet rs = statement.executeQuery(sql)) {
				while (rs.next()) {

					resultadoTabla.add(new Huespedes(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
							rs.getDate("fecha_nacimiento"), rs.getString("nacionalidad"), rs.getString("telefono"),
							rs.getInt("id_reserva")));

				}
			} catch (SQLException e) {
				throw new RuntimeException(e);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("listar "+resultadoTabla.size());
		return resultadoTabla;

	}
	
	public List<Huespedes> buscarHuespedPorApellido() {
		
		Huespedes huespedes = new Huespedes(null, null);

		ArrayList<Huespedes> resultadoBusqueda = new ArrayList<Huespedes>();

		String sql = "SELECT * FROM Huespedes WHERE apellido = ?";
		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, sql);
			statement.executeQuery();

			try {
				ResultSet rs = statement.executeQuery(sql);

				while (rs.next()) {
					resultadoBusqueda.add(new Huespedes(rs.getInt("id"), rs.getString("nombre"),
							rs.getString("apellido"), rs.getDate("fecha_nacimiento"), rs.getString("nacionalidad"),
							rs.getString("telefono"), rs.getInt("id_reserva")));

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println(resultadoBusqueda.size());
		return resultadoBusqueda;
	}

	public int eliminar(int id) {

		String sql = "DELETE FROM Huespedes WHERE ID = ?";
		PreparedStatement statement;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();

			final int updateCount = statement.getUpdateCount();

			return updateCount;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int editar(Huespedes huespedes ) {
		
				
		String sql = "UPDATE Huespedes SET id = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, nacionalidad = ?, telefono = ?, id_reserva = ? WHERE id = ?";

		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, huespedes.getId());
			statement.setString(2, huespedes.getNombre());
			statement.setString(3, huespedes.getApellido());
			statement.setDate(4, (java.sql.Date) huespedes.getFecha_nacimiento());
			statement.setString(5, huespedes.getNacionalidad());			
			statement.setString(6, huespedes.getTelefono());
			statement.setInt(7, huespedes.getId_reserva());
			statement.execute();
			
			int updateCount = statement.getUpdateCount();

            return updateCount;           
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		 
	}


}
