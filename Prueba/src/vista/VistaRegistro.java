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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JTable tabla;
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
	private JComboBox<String> comboBoxS;
	//private ButtonGroup bg=new ButtonGroup();
	private JDateChooser dcCalendario;
	private DefaultTableModel modelo;
	private TableRowSorter<DefaultTableModel> sorter;
	private JScrollPane scrollPane ;
	private JTable tabla1;
	

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRegistro.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.20.07.jpeg")));
		setTitle("Registro Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1616, 1025);
		
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
		scrollPane.setBounds(630, 102, 929, 423);
		scrollPane.setBackground(new Color(153, 204, 255));
		
		//tabla1 = new JTable();
		//scrollPane.setViewportView(tabla1);
		//tabla1.setBackground(new Color(153, 204, 255));
		
		//Object [] titulos= ;
		//Object [] row=new Object[0];
		
		//modelo.setColumnIdentifiers();
		//tabla1.setModel(modelo);
		
		sorter=new TableRowSorter<>(modelo);
		
		JButton btnConsultarPersona = new JButton("Consultar");
		btnConsultarPersona.setBounds(161, 603, 87, 51);
		btnConsultarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
		
			}
		});
		btnConsultarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarPersona.setContentAreaFilled(false);
		btnConsultarPersona.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/3709746-customer-evaluation-review-satisfaction-system_108070.png")));
		btnConsultarPersona.setBorder(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPersona();
				cargarDatos();
			}
		});
		btnEditar.setBounds(241, 581, 111, 73);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/UserEdit_40958.png")));
		btnEditar.setBorder(null);
		
		JButton btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPersona();
				cargarDatos();
			}
		});
		btnEliminarPersona.setBounds(355, 593, 70, 61);
		btnEliminarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarPersona.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		btnEliminarPersona.setContentAreaFilled(false);
		btnEliminarPersona.setBorder(null);
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(67, 593, 76, 61);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPersona();
				cargarDatos();
				limpiarCampos();
				
				


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
				
				
			}
		});
		txtBuscar.setBounds(723, 45, 660, 20);
		txtBuscar.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String filtro=txtBuscar.getText().trim();
				
				
					//sorter.setRowFilter(null);
				
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
				
				
			}
		});
	
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setColumns(10);
		//ImageIcon icon= new ImageIcon(getClass().getResource("OIP.jpg"));
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(1409, 39, 111, 32);
		lblBuscar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/glassmagnifiermagnifyingsearchsearchingweb_123111.png")));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 139, 83, 14);
		lblNombre.setFont(new Font("Arial", Font.ITALIC, 12));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(180, 136, 438, 20);
		txtNombre.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setBounds(180, 187, 438, 20);
		txtApellidoP.setColumns(10);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setBounds(180, 244, 444, 20);
		txtApellidoM.setColumns(10);
		
	     dcCalendario = new JDateChooser();
	     dcCalendario.setBounds(180, 301, 438, 20);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(180, 348, 444, 20);
		txtDireccion.setColumns(10);
		
		txtCurp = new JTextField();
		txtCurp.setBounds(180, 404, 444, 20);
		txtCurp.setColumns(10);
		
		txtNumeroT = new JTextField();
		txtNumeroT.setBounds(180, 451, 444, 20);
		txtNumeroT.setColumns(10);
		
		txtCorreoE = new JTextField();
		txtCorreoE.setBounds(180, 506, 444, 20);
		txtCorreoE.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(10, 506, 166, 20);
		lblCorreoElectronico.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblNmeroDeTelefono = new JLabel("Número de telefono:");
		lblNmeroDeTelefono.setBounds(10, 451, 166, 20);
		lblNmeroDeTelefono.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblCurp = new JLabel("CURP:");
		lblCurp.setBounds(10, 404, 166, 20);
		lblCurp.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(10, 348, 166, 20);
		lblDireccin.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(10, 301, 166, 20);
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Materno:");
		lblApellidoPaterno.setBounds(10, 244, 166, 20);
		lblApellidoPaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Paterno:");
		lblApellidoMaterno.setBounds(10, 187, 166, 20);
		lblApellidoMaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblImagen = new JLabel("Sexo:");
		lblImagen.setBounds(33, 546, 60, 14);
		
		JLabel lblNewLabel = new JLabel("Id cliente:");
		lblNewLabel.setBounds(10, 103, 48, 14);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(180, 98, 438, 20);
		txtIdCliente.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(btnGuardar);
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
		contentPane.add(txtBuscar);
		contentPane.add(lblBuscar);
		
		comboBoxS = new JComboBox<>(new String[] {"Masculino", "Femenino"});
		comboBoxS.setBounds(180, 542, 245, 22);
		contentPane.add(comboBoxS);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		//ImageIcon icone=new ImageIcon(getClass().getResource(""));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(645, 101, 921, 533);
		contentPane.add(scrollPane_1);
		
		modelo=new DefaultTableModel(new String[] {"Id","Nombre", "Apellido Paterno", "Apellido Materno", "Sexo", "Fecha Nacimiento", "Direccion", "CURP", "Numero Telefonico","Correo"}, 0);

		tabla1 = new JTable(modelo);
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filas=tabla1.getSelectedRow();
				if(filas != -1) {
					txtIdCliente.setText(tabla1.getValueAt(filas, 0).toString());
					txtNombre.setText(tabla1.getValueAt(filas, 1).toString());
					txtApellidoP.setText(tabla1.getValueAt(filas, 2).toString());
					txtApellidoM.setText(tabla1.getValueAt(filas, 3).toString());
					comboBoxS.setSelectedItem(tabla1.getValueAt(filas, 4).toString());
                    dcCalendario.setDate(java.sql.Date.valueOf(tabla1.getValueAt(filas, 5).toString()));
                    txtDireccion.setText(tabla1.getValueAt(filas, 6).toString());
                    txtCurp.setText(tabla1.getValueAt(filas, 7).toString());
                    txtNumeroT.setText(tabla1.getValueAt(filas, 8).toString());
                    txtCorreoE.setText(tabla1.getValueAt(filas, 9).toString());
				}
			
			}
		});
		
		scrollPane_1.setViewportView(tabla1);
		cargarDatos();
		
		JLabel lblImagen1 = new JLabel("");
		lblImagen1.setBounds(0, 0, 1600, 827);
		ImageIcon icon=new ImageIcon(getClass().getResource("RegiFondo.jpg"));
		ImageIcon imgi =new ImageIcon(icon.getImage().getScaledInstance(lblImagen1.getWidth(), lblImagen1.getHeight(), Image.SCALE_SMOOTH));
		lblImagen1.setIcon(imgi);
		contentPane.add(lblImagen1);
		
		
	
	
	}	  		  		          		          		   

	private void limpiarCampos() {
		txtIdCliente.setText("");
		txtNombre.setText("");
		txtApellidoP.setText("");
		txtApellidoM.setText("");
	    dcCalendario.setDate(null);
		txtCurp.setText("");
		txtNumeroT.setText("");
		txtCorreoE.setText("");
		txtDireccion.setText("");
		
		
		
		

		
	}
	private void cargarDatos() {
		modelo.setRowCount(0);
		DataRegistro dre=new DataRegistro();
		List<Object[]> personas= dre.obtenerPersonas();
		for(Object[] persona : personas) {
			modelo.addRow(persona);
		}
	
	}
	
	private void guardarPersona() {
        DataRegistro re = new DataRegistro();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(dcCalendario.getDate());
        re.guardar(txtIdCliente.getText(), txtNombre.getText(), txtApellidoP.getText(), txtApellidoM.getText(), 
        		comboBoxS.getSelectedItem().toString(), fecha, txtDireccion.getText(), txtCurp.getText(), 
            txtNumeroT.getText(), txtCorreoE.getText());
    }

    private void editarPersona() {
    	DataRegistro re = new DataRegistro();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(dcCalendario.getDate());
        re.editarPersona(txtIdCliente.getText(), txtNombre.getText(), txtApellidoP.getText(), txtApellidoM.getText(), 
        		comboBoxS.getSelectedItem().toString(), fecha, txtDireccion.getText(), txtCurp.getText(), 
            txtNumeroT.getText(), txtCorreoE.getText());
    }

    private void eliminarPersona() {
    	DataRegistro re = new DataRegistro();
        re.eliminarPersona(txtIdCliente.getText());
    }
}
