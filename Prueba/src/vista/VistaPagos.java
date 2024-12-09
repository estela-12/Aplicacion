 package vista;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.DataPAGOS;
import modelo.Pagos;
import modelo.Reporte;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaPagos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdPago;
	private JTextField txtPagosPen;
	private JTextField txtSaldoAPagar;
	private JTextField txtFechaLim;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnGuardar, btnEditar, btnEliminar, btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPagos frame = new VistaPagos();
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
	public VistaPagos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPagos.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.20.07.jpeg")));
		setTitle("Pagos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 725);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 172, 255));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(VistaPagos.class.getResource("/iconos/Menu_icon_icon-icons.com_71858.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu Pricipal");
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
				VistaRegistro vre= new VistaRegistro();
				vre.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Reportes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRepo vrep=new VistaRepo();
				vrep.setVisible(true);
				dispose();
				}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id Pagos:");
		lblNewLabel.setBounds(26, 195, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPagosPendientes = new JLabel("Pagos Pendientes:");
		lblPagosPendientes.setBounds(26, 243, 103, 14);
		contentPane.add(lblPagosPendientes);
		
		JLabel lblSaldoAPagar = new JLabel("Saldo a pagar:");
		lblSaldoAPagar.setBounds(26, 292, 103, 14);
		contentPane.add(lblSaldoAPagar);
		
		JLabel lblFechaLimitePara = new JLabel("Fecha Limite Para Pagar:");
		lblFechaLimitePara.setBounds(26, 342, 119, 14);
		contentPane.add(lblFechaLimitePara);
		
		txtIdPago = new JTextField();
		txtIdPago.setBounds(191, 192, 167, 20);
		contentPane.add(txtIdPago);
		txtIdPago.setColumns(10);
		
		txtPagosPen = new JTextField();
		txtPagosPen.setBounds(191, 240, 167, 20);
		contentPane.add(txtPagosPen);
		txtPagosPen.setColumns(10);
		
		txtSaldoAPagar = new JTextField();
		txtSaldoAPagar.setBounds(191, 289, 167, 20);
		contentPane.add(txtSaldoAPagar);
		txtSaldoAPagar.setColumns(10);
		
		txtFechaLim = new JTextField();
		txtFechaLim.setText("año/mes/dia");
		txtFechaLim.setBounds(191, 339, 167, 20);
		contentPane.add(txtFechaLim);
		txtFechaLim.setColumns(10);
		
		modelo= new DefaultTableModel(new String[] {"Id Pago", "Pagos Pendientes","Saldo a Pagar", "Fecha Limite"}, 0);
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filas=table.getSelectedRow();
				if(filas != -1) {
					txtIdPago.setText(table.getValueAt(filas, 0).toString());
					txtPagosPen.setText(table.getValueAt(filas, 1).toString());
					txtSaldoAPagar.setText(table.getValueAt(filas, 2).toString());
					txtFechaLim.setText(table.getValueAt(filas, 3).toString());
				}
			}
		});
		table.setBackground(new Color(226, 242, 254));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(518, 137, 848, 484);
		contentPane.add(scrollPane);
		cargarDatos();
		
		
		scrollPane.setViewportView(table);
		
		JButton btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPago();
				cargarDatos();

				
			}
		});
		btnEliminarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarPersona.setIcon(new ImageIcon(VistaPagos.class.getResource("/iconos/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		btnEliminarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarPersona.setContentAreaFilled(false);
		btnEliminarPersona.setBorder(null);
		btnEliminarPersona.setBounds(320, 513, 70, 61);
		contentPane.add(btnEliminarPersona);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPago();
				cargarDatos();

			}
		});
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditar.setIcon(new ImageIcon(VistaPagos.class.getResource("/iconos/UserEdit_40958.png")));
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorder(null);
		btnEditar.setBounds(206, 501, 111, 73);
		contentPane.add(btnEditar);
		
		JButton btnConsultarPersona = new JButton("Consultar");
		btnConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		btnConsultarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultarPersona.setIcon(new ImageIcon(VistaPagos.class.getResource("/iconos/3709746-customer-evaluation-review-satisfaction-system_108070.png")));
		btnConsultarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarPersona.setContentAreaFilled(false);
		btnConsultarPersona.setBorder(null);
		btnConsultarPersona.setBounds(126, 523, 87, 51);
		contentPane.add(btnConsultarPersona);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPago();
				cargarDatos();
			
			}
		});
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardar.setIcon(new ImageIcon(VistaPagos.class.getResource("/iconos/savedisk_floppydisk_guardar_1543.png")));
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorder(null);
		btnGuardar.setBounds(32, 513, 76, 61);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 0, 1602, 825);
		ImageIcon icon=new ImageIcon(getClass().getResource("agua.jpg"));
		ImageIcon imgi =new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_1.setIcon(imgi);
		contentPane.add(lblNewLabel_1);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
	private void guardarPago() {
		String idPago=txtIdPago.getText();
		int pagosPendientes;
		double saldoAPagar;
		String fechaLimite=txtFechaLim.getText();
		try {
			
		
		pagosPendientes=Integer.parseInt(txtPagosPen.getText());
		saldoAPagar=Double.parseDouble(txtSaldoAPagar.getText());
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Pagos pendietes y saldo a pagar deben ser numeros");
			return;
		}
	
	DataPAGOS dp= new DataPAGOS();
	boolean re=dp.guardar( idPago,  pagosPendientes,  saldoAPagar, fechaLimite);
	if(re) {
		JOptionPane.showMessageDialog(this, "Pago registrado correctamente");
		limpiar();
	}else {
		JOptionPane.showMessageDialog(this, "No se pudo registrar el pago");
	}
	}
	private void cargarDatos() {
		modelo.setRowCount(0);
		DataPAGOS dp=new DataPAGOS();
		List<Object[]> pagos=dp.obtenerPagos();
		for(Object[] pago : pagos) {
			modelo.addRow(pago);
		}
}
	private void limpiar() {
		txtIdPago.setText("");
		txtPagosPen.setText("");
		txtSaldoAPagar.setText("");
		txtFechaLim.setText("");
	}
	private void editarPago() {
		DataPAGOS dpa=new DataPAGOS();
		dpa.editarPago(txtIdPago.getText(), Integer.parseInt(txtPagosPen.getText()), Double.parseDouble(txtSaldoAPagar.getText()), txtFechaLim.getText());
		limpiar();

	
		}
	
	private void eliminarPago() {
		int filas=table.getSelectedRow();
		if(filas !=-1) {
			String id=(String) table.getValueAt(filas, 0);
			DataPAGOS dpa=new DataPAGOS();
			dpa.eliminarPago(id);
			cargarDatos();
			limpiar();

		}
		
	}

}
