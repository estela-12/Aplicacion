package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import controlador.DataRegistro;
import modelo.Registro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VistaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla1;
	private JTextField txtBuscar;
	private TableRowSorter trsfiltro;
	private String filtro;
	private JTextField txtNombre;
	private JTextField txtApellidoP;
	private JTextField txtApellidoM;
	private JTextField txtDireccion;
	private JTextField txtCurp;
	private JTextField txtNumeroT;
	private JTextField txtCorreoE;
	private JTextField txtIdCliente;
	private ButtonGroup bg=new ButtonGroup();
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JDateChooser dcCalendario;
	private JCheckBox chckbxActivo ;
	private DefaultTableModel modelo;
	private TableRowSorter<DefaultTableModel> sorter;
	private JScrollPane scrollPane ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistro frame = new VistaRegistro();
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
	public VistaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1472, 1029);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(4, 173, 255));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/Menu_icon_icon-icons.com_71858.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu Principal");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp=new VentanaPrincipal();
				vp.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reportes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaReportes vrep=new VistaReportes();
				vrep.setVisible(true);
				dispose();
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registro Pagos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPagos vpa=new VistaPagos();
				vpa.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 247, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(688, 248, 1091, 423);
		scrollPane.setBackground(new Color(153, 204, 255));
		
		tabla1 = new JTable();
		scrollPane.setViewportView(tabla1);
		tabla1.setBackground(new Color(153, 204, 255));
		modelo=new DefaultTableModel();
		Object [] titulos= {"Nombre", "Apellido Paterno", "Apellido Materno", "Sexo", "Fecha Nacimiento", "Direccion", "CURP", "Numero Telefonico","Correo"};
		modelo.setColumnIdentifiers(titulos);
		tabla1= new JTable(modelo);
		scrollPane.setViewportView(tabla1);
		
		sorter=new TableRowSorter<>(modelo);
		tabla1.setRowSorter(sorter);
		
		JButton btnConsultarPersona = new JButton("Consultar");
		btnConsultarPersona.setBounds(284, 678, 87, 233);
		btnConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataRegistro dr=new DataRegistro();
				Registro regi=dr.consultarRegistro(Integer.parseInt(txtIdCliente.getText()));
				txtNombre.setText(regi.getNombre());
				txtApellidoP.setText(regi.getApellidoP());
				txtApellidoM.setText(regi.getApellidoM());
				rdbtnMujer.setSelected(regi.getSexo());
				rdbtnHombre.setSelected(regi.getSexo());
				dcCalendario.setDate(regi.getFechaDeNacimiento());
				txtCurp.setText(regi.getCurp());
				txtNumeroT.setText(String.valueOf(regi.getNumeroTelefonico()));
				txtCorreoE.setText(regi.getCorreoElectronico());
				txtDireccion.setText(regi.getDireccion());
				chckbxActivo.setSelected(regi.getActivo());
			}
		});
		btnConsultarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarPersona.setContentAreaFilled(false);
		btnConsultarPersona.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/3709746-customer-evaluation-review-satisfaction-system_108070.png")));
		btnConsultarPersona.setBorder(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(389, 844, 111, 67);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/UserEdit_40958.png")));
		btnEditar.setBorder(null);
		
		JButton btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setBounds(506, 860, 70, 51);
		btnEliminarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarPersona.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		btnEliminarPersona.setContentAreaFilled(false);
		btnEliminarPersona.setBorder(null);
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(125, 860, 76, 51);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataRegistro dr=new DataRegistro();
				Registro regi=new Registro();
				regi.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
				regi.setNombre(txtNombre.getText());
				regi.setApellidoP(txtApellidoP.getText());
				regi.setApellidoM(txtApellidoM.getText());
				regi.setSexo(rdbtnMujer.isSelected());
				regi.setSexo(rdbtnHombre.isSelected());
				regi.setFechaDeNacimiento(dcCalendario.getDate());
				regi.setCurp(txtCurp.getText());
				regi.setNumeroTelefonico(Integer.parseInt(txtNumeroT.getText()));
				regi.setCorreoElectronico(txtCorreoE.getText());
				regi.setDireccion(txtDireccion.getText());
				regi.setActivo(chckbxActivo.isSelected());
				dr.guardar(regi);
			}
		});
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/savedisk_floppydisk_guardar_1543.png")));
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorder(null);
		
		txtBuscar = new JTextField();
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro=txtBuscar.getText().trim();
				if(filtro.isEmpty()) {
					sorter.setRowFilter(null);
				}else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
				}
				
			}
		});
		txtBuscar.setBounds(716, 146, 660, 20);
		txtBuscar.addKeyListener(new KeyAdapter() {
			
		});
	
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setColumns(10);
		ImageIcon icon= new ImageIcon(getClass().getResource("OIP.jpg"));
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(1402, 140, 111, 32);
		lblBuscar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/glassmagnifiermagnifyingsearchsearchingweb_123111.png")));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(68, 285, 83, 14);
		lblNombre.setFont(new Font("Arial", Font.ITALIC, 12));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(238, 282, 438, 20);
		txtNombre.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setBounds(238, 333, 438, 20);
		txtApellidoP.setColumns(10);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setBounds(238, 390, 444, 20);
		txtApellidoM.setColumns(10);
		
	     dcCalendario = new JDateChooser();
	     dcCalendario.setBounds(238, 447, 438, 20);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(238, 494, 444, 20);
		txtDireccion.setColumns(10);
		
		txtCurp = new JTextField();
		txtCurp.setBounds(238, 550, 444, 20);
		txtCurp.setColumns(10);
		
		txtNumeroT = new JTextField();
		txtNumeroT.setBounds(238, 597, 444, 20);
		txtNumeroT.setColumns(10);
		
		txtCorreoE = new JTextField();
		txtCorreoE.setBounds(238, 652, 444, 20);
		txtCorreoE.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(68, 652, 166, 20);
		lblCorreoElectronico.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblNmeroDeTelefono = new JLabel("Número de telefono:");
		lblNmeroDeTelefono.setBounds(68, 597, 166, 20);
		lblNmeroDeTelefono.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblCurp = new JLabel("CURP:");
		lblCurp.setBounds(68, 550, 166, 20);
		lblCurp.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(68, 494, 166, 20);
		lblDireccin.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(68, 447, 166, 20);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Materno:");
		lblApellidoPaterno.setBounds(68, 390, 166, 20);
		lblApellidoPaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Paterno:");
		lblApellidoMaterno.setBounds(68, 333, 166, 20);
		lblApellidoMaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblImagen = new JLabel("Sexo:");
		lblImagen.setBounds(91, 692, 60, 14);
		
	    rdbtnHombre = new JRadioButton("Hombre");
	    rdbtnHombre.setBounds(219, 697, 63, 23);
		
	    rdbtnMujer = new JRadioButton("Mujer");
	    rdbtnMujer.setBounds(413, 697, 63, 23);
		
		bg.add(rdbtnMujer);
		bg.add(rdbtnHombre);
		
		JLabel lblNewLabel = new JLabel("Id cliente:");
		lblNewLabel.setBounds(68, 249, 48, 14);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(238, 244, 438, 20);
		txtIdCliente.setColumns(10);
		
	    chckbxActivo = new JCheckBox("Activo");
	    chckbxActivo.setBounds(82, 738, 119, 23);
		contentPane.setLayout(null);
		contentPane.add(rdbtnHombre);
		contentPane.add(btnGuardar);
		contentPane.add(rdbtnMujer);
		contentPane.add(lblImagen);
		contentPane.add(btnConsultarPersona);
		contentPane.add(btnEditar);
		contentPane.add(btnEliminarPersona);
		contentPane.add(lblApellidoMaterno);
		contentPane.add(txtApellidoP);
		contentPane.add(lblApellidoPaterno);
		contentPane.add(txtApellidoM);
		contentPane.add(lblFechaDeNacimiento);
		contentPane.add(dcCalendario);
		contentPane.add(lblDireccin);
		contentPane.add(txtDireccion);
		contentPane.add(lblCurp);
		contentPane.add(txtCurp);
		contentPane.add(lblNmeroDeTelefono);
		contentPane.add(txtNumeroT);
		contentPane.add(lblCorreoElectronico);
		contentPane.add(txtCorreoE);
		contentPane.add(lblNombre);
		contentPane.add(lblNewLabel);
		contentPane.add(txtIdCliente);
		contentPane.add(txtNombre);
		contentPane.add(scrollPane);
		contentPane.add(txtBuscar);
		contentPane.add(lblBuscar);
		contentPane.add(chckbxActivo);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\salvar111.png"));
		btnNewButton.setBounds(193, 725, 89, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\consulta1.png"));
		btnNewButton_1.setBounds(359, 738, 111, 78);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\actualizar-datos1.png"));
		btnNewButton_2.setBounds(515, 738, 89, 78);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\error.png"));
		btnNewButton_3.setBounds(652, 738, 76, 78);
		contentPane.add(btnNewButton_3);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	
	}
}
