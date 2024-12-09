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
import java.awt.Color;

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
		setBounds(100, 100, 1031, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblUsuario.setBounds(478, 233, 125, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(478, 259, 328, 20);
		contentPane.add(txtUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Rockwell", Font.ITALIC, 14));
		lblContrasea.setBounds(478, 331, 125, 14);
		contentPane.add(lblContrasea);
		
		//JComboBox<String> registerRoleBox= new JComboBox<>(new String[] {"Administrador", "Usuario"});

		
		passContraseña = new JPasswordField();
		passContraseña.setBounds(478, 356, 328, 20);
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
		btnRegistrarse.setBounds(577, 586, 169, 23);
		contentPane.add(btnRegistrarse);
		
		btnMostrar = new JButton("");
		btnMostrar.setIcon(new ImageIcon(RegistroLog.class.getResource("/iconos/3844476-eye-see-show-view-watch_110339.png")));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarContraseña();
			}
		});
		btnMostrar.setBackground(SystemColor.window);
		btnMostrar.setBounds(804, 356, 91, 20);
		contentPane.add(btnMostrar);
		
		progBarra = new JProgressBar();
		progBarra.setBackground(new Color(0, 128, 64));
		progBarra.setBounds(547, 478, 229, 23);
		contentPane.add(progBarra);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lo=new Login();
				lo.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(SystemColor.activeCaption);
		btnRegresar.setBounds(577, 637, 169, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(382, 0, 633, 692);
		ImageIcon ico=new ImageIcon(getClass().getResource("OIP.jpg"));
		ImageIcon img =new ImageIcon(ico.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img);
		contentPane.add(lblImagen);
		

		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 382, 692);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon(RegistroLog.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.40.06 (1).jpeg")));
		lblNewLabel.setBounds(10, 138, 362, 326);
		ImageIcon icon=new ImageIcon(getClass().getResource("/iconos/WhatsApp Image 2024-11-29 at 14.40.06 (1).jpeg"));
		ImageIcon imgi =new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(imgi);
		panel.add(lblNewLabel);
		
		
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
