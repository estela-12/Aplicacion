package vista;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import desplazable.Desface;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Desface desplazable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		desplazable=new Desface();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(113, 184, 255));
		panel_1.setLayout(null);
		
		JPanel panelDesplega = new JPanel();
		panelDesplega.setBackground(new Color(185, 220, 255));
		panelDesplega.setLayout(null);
		
		JButton btnMenu = new JButton("");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(panelDesplega.getX()==0) {
				desplazable.desplazarIzquierda(panelDesplega, panelDesplega.getX(), -250, 10, 5);
			
			}else if(panelDesplega.getX()==-250){
				desplazable.desplazarDerecha(panelDesplega, panelDesplega.getX(), 0, 10, 5);
				
			}
			}
			
		});
		btnMenu.setBorder(null);
		btnMenu.setHorizontalAlignment(SwingConstants.LEFT);
		btnMenu.setBounds(10, 0, 127, 45);
		panel_1.add(btnMenu);
		btnMenu.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/Menu_icon_icon-icons.com_71858.png")));
		btnMenu.setContentAreaFilled(false);
		

		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("Rockwell", Font.ITALIC, 16));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/home_icon-icons.com_73532.png")));
		btnNewButton_1.setBounds(0, 146, 249, 62);
		panelDesplega.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Registro de Pagos");
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/finance_receipt_dollar_calculator_payment_money_icon_142011.png")));
		btnNewButton_1_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setFont(new Font("Rockwell", Font.ITALIC, 16));
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBounds(0, 210, 249, 62);
		panelDesplega.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Registro de Clientes");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/4313132notesrecordstationerytakingwriting-115803_115776.png")));
		btnNewButton_1_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_2.setFont(new Font("Rockwell", Font.ITALIC, 16));
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBounds(0, 280, 249, 62);
		panelDesplega.add(btnNewButton_1_2);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReportes.setBorder(null);
		btnReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReportes.setVerticalAlignment(SwingConstants.BOTTOM);
		btnReportes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/shoppaymentorderbuy-27_icon-icons.com_73879.png")));
		btnReportes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnReportes.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportes.setFont(new Font("Rockwell", Font.ITALIC, 16));
		btnReportes.setContentAreaFilled(false);
		btnReportes.setBounds(0, 343, 249, 62);
		panelDesplega.add(btnReportes);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panelDesplega, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1367, Short.MAX_VALUE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1616, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(899, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(panelDesplega, GroupLayout.PREFERRED_SIZE, 908, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 878, GroupLayout.PREFERRED_SIZE)
		);
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);		
	}
}
