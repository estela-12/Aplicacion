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
	private JTextField tctCurp;
	private JTextField txtNumeroT;
	private JTextField txtCorreoE;
	private JTextField txtIdCliente;
	private ButtonGroup bg=new ButtonGroup();
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JDateChooser dcCalendario;
	private JCheckBox chckbxActivo ;

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 247, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(153, 204, 255));
		
		tabla1 = new JTable();
		scrollPane.setViewportView(tabla1);
		tabla1.setBackground(new Color(153, 204, 255));
		
		JButton btnConsultarPersona = new JButton("Consultar");
		btnConsultarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConsultarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConsultarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnConsultarPersona.setContentAreaFilled(false);
		btnConsultarPersona.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/3709746-customer-evaluation-review-satisfaction-system_108070.png")));
		btnConsultarPersona.setBorder(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setContentAreaFilled(false);
		btnEditar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEditar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/UserEdit_40958.png")));
		btnEditar.setBorder(null);
		
		JButton btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminarPersona.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminarPersona.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarPersona.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		btnEliminarPersona.setContentAreaFilled(false);
		btnEliminarPersona.setBorder(null);
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarRegistro();
			}
		});
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/savedisk_floppydisk_guardar_1543.png")));
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorder(null);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				trsfiltro= new TableRowSorter(tabla1.getModel());
				tabla1.setRowSorter(trsfiltro);
			}
			public void filtro() {
				filtro =txtBuscar.getText();
				trsfiltro.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(), 0));
			}
		});
		txtBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscar.setColumns(10);
		ImageIcon icon= new ImageIcon(getClass().getResource("OIP.jpg"));
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setIcon(new ImageIcon(VistaRegistro.class.getResource("/iconos/glassmagnifiermagnifyingsearchsearchingweb_123111.png")));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.ITALIC, 12));
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setColumns(10);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setColumns(10);
		
	     dcCalendario = new JDateChooser();
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		tctCurp = new JTextField();
		tctCurp.setColumns(10);
		
		txtNumeroT = new JTextField();
		txtNumeroT.setColumns(10);
		
		txtCorreoE = new JTextField();
		txtCorreoE.setColumns(10);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblNmeroDeTelefono = new JLabel("Número de telefono:");
		lblNmeroDeTelefono.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblCurp = new JLabel("CURP:");
		lblCurp.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Materno:");
		lblApellidoPaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Paterno:");
		lblApellidoMaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblImagen = new JLabel("Sexo:");
		
	    rdbtnHombre = new JRadioButton("Hombre");
		
	    rdbtnMujer = new JRadioButton("Mujer");
		
		bg.add(rdbtnMujer);
		bg.add(rdbtnHombre);
		
		JLabel lblNewLabel = new JLabel("Id cliente:");
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		
	    chckbxActivo = new JCheckBox("Activo");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(rdbtnHombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(57)
									.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(23)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnMujer, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblImagen))))
							.addGap(10)
							.addComponent(btnConsultarPersona, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminarPersona, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblApellidoMaterno, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtApellidoP, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblApellidoPaterno, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtApellidoM, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(dcCalendario, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDireccin, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCurp, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(tctCurp, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNmeroDeTelefono, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtNumeroT, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCorreoElectronico, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(txtCorreoE, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
									.addGap(87)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtIdCliente)
										.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(711)
					.addComponent(txtBuscar, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(lblBuscar)
					.addGap(80))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxActivo)
					.addContainerGap(1442, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNombre))
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidoMaterno, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApellidoP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidoPaterno, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApellidoM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechaDeNacimiento, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(dcCalendario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDireccin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCurp, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(tctCurp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNmeroDeTelefono, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNumeroT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCorreoElectronico, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCorreoE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBuscar)
								.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(76)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(7)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnConsultarPersona, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
									.addComponent(btnEditar)
									.addComponent(btnEliminarPersona))
								.addComponent(btnGuardar))
							.addGap(260))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(lblImagen)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnHombre)
								.addComponent(rdbtnMujer))
							.addGap(35)
							.addComponent(chckbxActivo)
							.addGap(366))))
		);
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
	public void guardarRegistro() {
		DataRegistro dr=new DataRegistro();
		Registro regi=new Registro();
		regi.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
		regi.setNombre(txtNombre.getText());
		regi.setApellidoP(txtApellidoP.getText());
		regi.setApellidoM(txtApellidoM.getText());
		regi.setSexo(rdbtnMujer.isSelected());
		regi.setSexo(rdbtnHombre.isSelected());
		regi.setFechaDeNacimiento(dcCalendario.getDate());
		regi.setCurp(tctCurp.getText());
		regi.setNumeroTelefonico(Integer.parseInt(txtNumeroT.getText()));
		regi.setCorreoElectronico(txtCorreoE.getText());
		regi.setDireccion(txtDireccion.getText());
		regi.setActivo(chckbxActivo.isSelected());
		dr.guardar(regi);
	}
}
