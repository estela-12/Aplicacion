package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.DataUsuarios;
import controlador.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class RegistroLog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passContraseña;
	private JButton btnMostrar;
	private JProgressBar progBarra;
	private static HashMap<String, User> users= new HashMap<>();
	 private boolean contraseñaVisi=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroLog frame = new RegistroLog();
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
	public RegistroLog() {
		setTitle("Registrate en MAHE SOLUTIONS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroLog.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.20.07.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblUsuario.setBounds(258, 64, 125, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(258, 90, 328, 20);
		contentPane.add(txtUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblContrasea.setBounds(258, 162, 125, 14);
		contentPane.add(lblContrasea);
		
		//JComboBox<String> registerRoleBox= new JComboBox<>(new String[] {"Administrador", "Usuario"});

		
		passContraseña = new JPasswordField();
		passContraseña.setBounds(258, 187, 328, 20);
		contentPane.add(passContraseña);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario=txtUsuario.getText().trim();
				String password= new String (passContraseña.getPassword()).trim();
				//String role=(String)comboRole.getSelectedItem();
				if (usuario.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo 'Usuario' no puede estar vacío.");
		            return;
		        }
		        if (password.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo 'Contraseña' no puede estar vacío.");
		            return;
		        }
				
				User user = new User(usuario, password);  

		        DataUsuarios du = new DataUsuarios();
		        
		        progBarra.setVisible(true);
		        progBarra.setIndeterminate(true);

		        SwingWorker<Void, Void> worker = new SwingWorker<>() {
		            @Override
		            protected Void doInBackground() throws Exception {
		                Thread.sleep(100);


		        
		        if (du.existeUsuario(user)) {
		            JOptionPane.showMessageDialog(null, "El usuario ya existe. Por favor, elija otro nombre de usuario.");
					
				}else {
					 boolean registrado = du.registrarUsuario(user, password);
					  VentanaPrincipal vp=new VentanaPrincipal();
		                vp.setVisible(true);
		                dispose();
					 if (registrado) {
			                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
			                
			            } else {
			                JOptionPane.showMessageDialog(null, "Hubo un problema al registrar el usuario. Intente nuevamente.");
			            }
					



				}
		        return null;
		      
			}
		            @Override
		            protected void done() {
		            	progBarra.setVisible(false);
		            }
		        };
		        worker.execute();
			}
		});
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setBackground(SystemColor.activeCaption);
		btnRegistrarse.setBounds(357, 417, 169, 23);
		contentPane.add(btnRegistrarse);
		
		btnMostrar = new JButton("");
		btnMostrar.setIcon(new ImageIcon(RegistroLog.class.getResource("/iconos/3844476-eye-see-show-view-watch_110339.png")));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarContraseña();
			}
		});
		btnMostrar.setBackground(SystemColor.window);
		btnMostrar.setBounds(584, 187, 91, 20);
		contentPane.add(btnMostrar);
		
		progBarra = new JProgressBar();
		progBarra.setBackground(SystemColor.inactiveCaption);
		progBarra.setBounds(327, 309, 229, 23);
		contentPane.add(progBarra);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 1015, 556);
		ImageIcon ico=new ImageIcon(getClass().getResource("OIP.jpg"));
		ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img);
		contentPane.add(lblImagen);
		
		
	}
	private void mostrarContraseña() {
		if(contraseñaVisi) {
			passContraseña.setEchoChar('*');
			//btnMostrar.setText("Mostrar");
		}else {
			passContraseña.setEchoChar((char) 0);
			//btnMostrar.setText("Ocultar");
			btnMostrar.setIcon(new ImageIcon(RegistroLog.class.getResource("/iconos/3844477-disable-eye-inactive-see-show-view-watch_110343.png")));
		}
		contraseñaVisi=!contraseñaVisi;
	}
	
}
