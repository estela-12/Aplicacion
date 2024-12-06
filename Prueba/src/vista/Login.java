package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.DataUsuarios;
import controlador.User;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passContraseña;
	private JButton btnMostrar;
	private static HashMap<String, User> users= new HashMap<>();
	private boolean contraseñaVisi=false;
	private JProgressBar progressBar;
	// private JComboBox<String> comboRol;
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Inicia seción");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.20.07.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 224, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblUsuario.setBounds(435, 175, 125, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblContrasea.setBounds(435, 273, 125, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(435, 201, 328, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passContraseña = new JPasswordField();
		passContraseña.setBounds(435, 298, 328, 20);
		contentPane.add(passContraseña);
		
		//JComboBox<String> registerRoleBox= new JComboBox<>(new String[] {"Administrador", "Usuario"});
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario= txtUsuario.getText().trim();
				String contraseña= new String (passContraseña.getPassword()).trim();
				  User user = new User(usuario, contraseña); 
			        DataUsuarios du = new DataUsuarios();
			        
			        progressBar.setVisible(true);
			        progressBar.setIndeterminate(true);

			        SwingWorker<Void, Void> worker = new SwingWorker<>() {
			            @Override
			            protected Void doInBackground() throws Exception {
			                Thread.sleep(100);

			        if (du.validarUsuario(user)) {
				
				
				
				
					//String role= du.obtenerRol(user);
					/*if("Administrador".equals(role)) {
						JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
					}else if("Usuario".equals(role)) {
						JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
					}*/
					txtUsuario.setText("");
					passContraseña.setText("");
					
					 VentanaPrincipal vp=new VentanaPrincipal();
		                vp.setVisible(true);
		                dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
					
				}
			
			            return null;
					      
					}
				            @Override
				            protected void done() {
				            	progressBar.setVisible(false);
				            }
				        };
				        worker.execute();
					}
		});
		btnIngresar.setBackground(SystemColor.activeCaption);
		btnIngresar.setBounds(530, 447, 169, 23);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegistroLog rl=new RegistroLog();
			rl.setVisible(true);
			dispose();
			}
		});
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setBackground(SystemColor.activeCaption);
		btnRegistrarse.setBounds(530, 495, 169, 23);
		contentPane.add(btnRegistrarse);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 358, 621);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Login.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.40.06 (1).jpeg")));
		lblImagen.setBounds(10, 128, 308, 275);
		ImageIcon ico=new ImageIcon(getClass().getResource("/iconos/WhatsApp Image 2024-11-29 at 14.40.06 (1).jpeg"));
		ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img);
		panel.add(lblImagen);
		
		JLabel lblMensaje2 = new JLabel("");
		lblMensaje2.setBounds(435, 348, 328, 14);
		contentPane.add(lblMensaje2);
		
		btnMostrar = new JButton("");
		btnMostrar.setIcon(new ImageIcon(Login.class.getResource("/iconos/3844476-eye-see-show-view-watch_110339.png")));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarContraseña();
			}
		});
		btnMostrar.setBackground(SystemColor.window);
		btnMostrar.setBounds(761, 298, 57, 20);
		contentPane.add(btnMostrar);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(0, 128, 128));
		progressBar.setBounds(508, 385, 206, 14);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(361, 0, 501, 621);
		ImageIcon icon=new ImageIcon(getClass().getResource("OIP.jpg"));
		ImageIcon imge =new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imge);
		contentPane.add(lblNewLabel);
		

		
		
	}
	private void mostrarContraseña() {
		if(contraseñaVisi) {
			passContraseña.setEchoChar('*');
			//btnMostrar.setText("");
		}else {
			passContraseña.setEchoChar((char) 0);
			//btnMostrar.setText("Ocultar");
			btnMostrar.setIcon(new ImageIcon(RegistroLog.class.getResource("/iconos/3844477-disable-eye-inactive-see-show-view-watch_110343.png")));
		}
		contraseñaVisi=!contraseñaVisi;
	}
}
