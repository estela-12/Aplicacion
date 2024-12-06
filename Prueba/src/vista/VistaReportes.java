package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaReportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaReportes frame = new VistaReportes();
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
	public VistaReportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1121, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 223, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		table = new JTable();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Id Reporte");
		lblNombre.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JLabel lblApellidoMaterno = new JLabel("Fecha del levantamiento del reporte:");
		lblApellidoMaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Materno:");
		lblApellidoPaterno.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(138, 197, 255));
		
		JButton btnNewButton_3 = new JButton("Crear PDF");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setIcon(new ImageIcon(VistaReportes.class.getResource("/iconos/pdf_filetype_icon_177525.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblApellidoMaterno, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblApellidoPaterno, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(btnNewButton_3)))
							.addPreferredGap(ComponentPlacement.RELATED, -400, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)))
					.addGap(412)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(177)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblApellidoMaterno, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApellidoPaterno, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_3)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp= new VentanaPrincipal();
				vp.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(VistaReportes.class.getResource("/iconos/home-button_icon-icons.com_72700.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Registro de Clientes");
		btnNewButton_2.setContentAreaFilled(false);
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Registro Pagos");
		btnNewButton_1.setContentAreaFilled(false);
		toolBar.add(btnNewButton_1);
		contentPane.setLayout(gl_contentPane);
	}
}
