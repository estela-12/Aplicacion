package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import controlador.Conxion;
import controlador.DataPAGOS;
import controlador.DataReporte;
import modelo.Reporte;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class VistaRepo extends JFrame {

	private static final long serialVersionUID = 1L;
	//private static final Reporte Reporte = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtDescripcion;
	private JTextField txtIdR;
	private JTextField txtFechaL;
	private JTextField txtFechaC;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRepo frame = new VistaRepo();
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
	public VistaRepo() {
		setTitle("Reportes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRepo.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.20.07.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 806);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 172, 255));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(VistaRepo.class.getResource("/iconos/Menu_icon_icon-icons.com_71858.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu Primcipal");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vpr=new VentanaPrincipal();
				vpr.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registro De Clientes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRegistro vr=new VistaRegistro();
				vr.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Pagos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPagos vp=new VistaPagos();
				vp.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(624, 179, 586, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarReporte();
				cargarDatos();
				limpiar();
			}
		});
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardar.setIcon(new ImageIcon(VistaRepo.class.getResource("/iconos/savedisk_floppydisk_guardar_1543.png")));
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorder(null);
		btnGuardar.setBounds(57, 481, 76, 61);
		contentPane.add(btnGuardar);
		
		JButton btnConsultarPersona = new JButton("Consultar");
		btnConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		btnConsultarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultarPersona.setIcon(new ImageIcon(VistaRepo.class.getResource("/iconos/3709746-customer-evaluation-review-satisfaction-system_108070.png")));
		btnConsultarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarPersona.setContentAreaFilled(false);
		btnConsultarPersona.setBorder(null);
		btnConsultarPersona.setBounds(151, 491, 87, 51);
		contentPane.add(btnConsultarPersona);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarReporte();
				cargarDatos();
				limpiar();
			}
		});
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditar.setIcon(new ImageIcon(VistaRepo.class.getResource("/iconos/UserEdit_40958.png")));
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorder(null);
		btnEditar.setBounds(231, 469, 111, 73);
		contentPane.add(btnEditar);
		
		JButton btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarReporte();
			}
		});
		btnEliminarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarPersona.setIcon(new ImageIcon(VistaRepo.class.getResource("/iconos/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		btnEliminarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarPersona.setContentAreaFilled(false);
		btnEliminarPersona.setBorder(null);
		btnEliminarPersona.setBounds(345, 481, 70, 61);
		contentPane.add(btnEliminarPersona);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(195, 394, 374, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Arial", Font.ITALIC, 12));
		lblDescripcion.setBounds(40, 394, 145, 20);
		contentPane.add(lblDescripcion);
		
		JLabel lblFechaDeCorte = new JLabel("Fecha de corte de agua:");
		lblFechaDeCorte.setFont(new Font("Arial", Font.ITALIC, 12));
		lblFechaDeCorte.setBounds(40, 339, 133, 20);
		contentPane.add(lblFechaDeCorte);
		
		JLabel lblFechaDeLevantaminto = new JLabel("Fecha de Levantamiento:");
		lblFechaDeLevantaminto.setFont(new Font("Arial", Font.ITALIC, 12));
		lblFechaDeLevantaminto.setBounds(40, 292, 145, 20);
		contentPane.add(lblFechaDeLevantaminto);
		
		JLabel lblIdReporte = new JLabel("ID Reporte:");
		lblIdReporte.setFont(new Font("Arial", Font.ITALIC, 12));
		lblIdReporte.setBounds(40, 236, 126, 20);
		contentPane.add(lblIdReporte);
		
		txtIdR = new JTextField();
		txtIdR.setColumns(10);
		txtIdR.setBounds(195, 236, 374, 20);
		contentPane.add(txtIdR);
		
		txtFechaL = new JTextField();
		txtFechaL.setColumns(10);
		txtFechaL.setBounds(195, 292, 374, 20);
		contentPane.add(txtFechaL);
		
		txtFechaC = new JTextField();
		txtFechaC.setColumns(10);
		txtFechaC.setBounds(195, 339, 374, 20);
		contentPane.add(txtFechaC);
		
		JLabel lblImagenF = new JLabel("");
		lblImagenF.setBounds(0, 0, 1244, 713);
		ImageIcon icone=new ImageIcon(getClass().getResource("el.jpg"));
		ImageIcon imgi =new ImageIcon(icone.getImage().getScaledInstance(lblImagenF.getWidth(), lblImagenF.getHeight(), Image.SCALE_SMOOTH));
		lblImagenF.setIcon(imgi);
		contentPane.add(lblImagenF);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		

	}
	private void guardarReporte() {
		String id_Reporte=txtIdR.getText();
		String fechaLevantamiento=txtFechaL.getText();
		String fechaCorte=txtFechaC.getText();
		String descripsion=txtDescripcion.getText();
		try {

		}catch(NumberFormatException e) {
			return;
		}
	
	DataReporte dp= new DataReporte();
	boolean re=dp.guardar( id_Reporte,  fechaLevantamiento,  fechaCorte, descripsion);
	if(re) {
		JOptionPane.showMessageDialog(this, "Reporte registrado correctamente");
		limpiar();
	}else {
		JOptionPane.showMessageDialog(this, "No se pudo registrar el Reporte");
	}
	}

	private void editarReporte() {
		DataReporte dp= new DataReporte();
		dp.editarReporte(txtIdR.getText(), txtFechaL.getText(), txtFechaC.getText(),txtDescripcion.getText());
		guardarReporte();
		eliminarReporte();
		limpiar();

	
		}
	
	private void eliminarReporte() {
		int filas=table.getSelectedRow();
		if(filas !=-1) {
			String id=(String) table.getValueAt(filas, 0);
			DataReporte dp= new DataReporte();
			dp.eliminarReporte(id);
			cargarDatos();
			limpiar();

		}
		
	}
	private void cargarDatos() {
		modelo.setRowCount(0);
		DataReporte dp= new DataReporte();
		List<Object[]> pagos=dp.obtenerReporte();
		for(Object[] pago : pagos) {
			modelo.addRow(pago);
		}
}
	private void limpiar() {
		txtIdR.setText("");
		txtFechaL.setText("");
		txtFechaC.setText("");
		txtDescripcion.setText("");
	}
}




