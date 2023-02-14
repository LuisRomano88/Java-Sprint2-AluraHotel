package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controllers.HuespedesController;
import controllers.ReservasController;
import dao.HuespedesDAO;
import modelo.Huespedes;
import modelo.Reservas;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.Scrollbar;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	public JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private JTable tbBuscarHuespedes;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private DefaultTableModel modeloBusquedaHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	HuespedesController huespedesController;
	ReservasController reservasController;
	ReservasView reservasView;
	RegistroHuesped registroHuesped;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {

		this.huespedesController = new HuespedesController();
		this.reservasController = new ReservasController();
		this.registroHuesped = new RegistroHuesped();
		this.reservasView = new ReservasView();
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		



		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 20));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(237, 51, 59));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		JScrollPane scrollTablaReservas = new JScrollPane();
		tbReservas = new JTable();
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 14));
		tbReservas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Check In", "Check Out", "Valor", "Numero de Reserva" }));
		modelo = (DefaultTableModel) tbReservas.getModel();
		scrollTablaReservas.setViewportView(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scrollTablaReservas);

		JScrollPane scrollTablaHuespedes = new JScrollPane();
		tbHuespedes = new JTable();
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 14));
		tbHuespedes.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nombre", "Apellido",
				"Fecha de Nacimiento", "Nacionalidad", "Teléfono", "Id Reserva" }));
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		scrollTablaHuespedes.setViewportView(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scrollTablaHuespedes);

		panel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("Tab: " + panel.getSelectedIndex());
				if (panel.getSelectedIndex() == 0) {
					try {
						cargarTablaReservas();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (panel.getSelectedIndex() == 1) {
					try {

						cargarTablaHuespedes();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String txt = txtBuscar.getText();
					System.out.println(txt);
					limpiarTabla(modeloBusquedaHuesped);
					buscarHuespedPorApellido();
			}
		});
		
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JButton btnEditar = new JButton();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (panel.getSelectedIndex() == 0) {
					
					editarReserva();

				} else if (panel.getSelectedIndex() == 1) {
					
					editarHuesped();
					
				}
			}
		});

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JButton btnEliminar = new JButton();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.getSelectedIndex() == 0) {
					eliminarReserva();

				} else if (panel.getSelectedIndex() == 1) {
					eliminarHuesped();
				}
			}
		});
	}
	

	private void cargarTablaHuespedes() throws SQLException {

		List<Huespedes> huespedes = this.huespedesController.listar(null);
		huespedes.forEach(huesped -> modeloH.addRow(new Object[] { huesped.getId(), huesped.getNombre(),
				huesped.getApellido(), huesped.getFecha_nacimiento(), huesped.getNacionalidad(), huesped.getTelefono(),
				huesped.getId_reserva() }));
	}

	private void cargarTablaReservas() throws SQLException {

		List<Reservas> reservas = this.reservasController.listarReservas(null);
		reservas.forEach(reserv -> modelo.addRow(new Object[] {
				reserv.getId(), reserv.getFechaEntrada(), reserv.getFechaSalida(), reserv.getValor(),
				reserv.getFormaDePago() }));
	}

	private void eliminarReserva() {

		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());

					var filasModificadas = this.reservasController.eliminar(id);

					modelo.removeRow(tbReservas.getSelectedRow());

					JOptionPane.showMessageDialog(this,
							String.format("Reserva eliminada con éxito!", filasModificadas));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	private void eliminarHuesped() {

		Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

					var filasModificadas = this.huespedesController.eliminar(id);

					modeloH.removeRow(tbHuespedes.getSelectedRow());

					JOptionPane.showMessageDialog(this,
							String.format("Huesped eliminado con éxito!", filasModificadas));
				},
				() -> JOptionPane.showMessageDialog(this, "Por favor, selecionar un huesped"));
	}
	
	
	
	private void buscarHuespedPorApellido() {
				
		List<Huespedes> huespedes = this.huespedesController.buscarHuespedPorApellido();
		huespedes.forEach(huesped -> modeloBusquedaHuesped.addRow(new Object[] { 
				huesped.getId(), 
				huesped.getNombre(),
				huesped.getApellido(), 
				huesped.getFecha_nacimiento(), 
				huesped.getNacionalidad(), 
				huesped.getTelefono(),
				huesped.getId_reserva() }));
		
	}
	
	private void limpiarTabla(DefaultTableModel modeloH){
		modeloH.setRowCount(0);
	}
	
	
	private void editarHuesped() {
		int fila = tbHuespedes.getSelectedRow();
		String nombre = tbHuespedes.getValueAt(fila, 1).toString();
		String apellido = tbHuespedes.getValueAt(fila, 2).toString();
		String nacimiento = tbHuespedes.getValueAt(fila, 3).toString();
		java.sql.Date fechaSql = java.sql.Date.valueOf(nacimiento);
		String nacionalidad = tbHuespedes.getValueAt(fila, 4).toString();
		String telefono = tbHuespedes.getValueAt(fila, 5).toString();
		Integer id_reserva = Integer.valueOf(tbHuespedes.getValueAt(fila, 6).toString());

		Huespedes huespedes = new Huespedes(nombre, apellido, fechaSql, nacionalidad, telefono, id_reserva);
		huespedes.setNombre(nombre);
		huespedes.setApellido(apellido);
		huespedes.setFecha_nacimiento(fechaSql);
		huespedes.setNacionalidad(nacionalidad);
		huespedes.setTelefono(telefono);
		huespedes.setId_reserva(id_reserva);
		
		JOptionPane.showMessageDialog(null, "Huesped modificado con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		;
		
		
	}	
	
	
private void editarReserva() {
	try {
		int fila = tbReservas.getSelectedRow();
		
		String fechaEntrada = tbReservas.getValueAt(fila, 1).toString();
		java.sql.Date fechaEntradaSql = java.sql.Date.valueOf(fechaEntrada);

		String fechaSalida = tbReservas.getValueAt(fila, 2).toString();
		java.sql.Date fechaSalidaSql = java.sql.Date.valueOf(fechaSalida);

		String valor = tbReservas.getValueAt(fila, 3).toString();

		String formaDePago = tbReservas.getValueAt(fila, 4).toString();

		Reservas reservaEditado = new Reservas();
		reservaEditado.setFechaEntrada(fechaEntradaSql);
		reservaEditado.setFechaSalida(fechaSalidaSql);
		reservaEditado.setValor(valor);
		reservaEditado.setFormaDePago(formaDePago);

		JOptionPane.showMessageDialog(null, "Reserva modificada con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		cargarTablaReservas();

	} catch (SQLException e1) {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
	}
}	

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
	
	
