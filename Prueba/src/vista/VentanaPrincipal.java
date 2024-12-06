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
import javax.swing.JToolBar;
import java.awt.Toolkit;

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
		setTitle("Pagina Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/iconos/WhatsApp Image 2024-11-29 at 14.20.07.jpeg")));
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
		
		JButton btnPagos = new JButton("Registro de Pagos");
		btnPagos.setBorder(null);
		btnPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPagos vpa=new VistaPagos();
				vpa.setVisible(true);
				dispose();
				
				
			}
		});
		btnPagos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPagos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPagos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/finance_receipt_dollar_calculator_payment_money_icon_142011.png")));
		btnPagos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPagos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagos.setFont(new Font("Rockwell", Font.ITALIC, 16));
		btnPagos.setContentAreaFilled(false);
		btnPagos.setBounds(0, 295, 249, 62);
		panelDesplega.add(btnPagos);
		
		JButton btnRegistro = new JButton("Registro de Clientes");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRegistro vreg=new VistaRegistro();
				vreg.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistro.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRegistro.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/4313132notesrecordstationerytakingwriting-115803_115776.png")));
		btnRegistro.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.setFont(new Font("Rockwell", Font.ITALIC, 16));
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.setBounds(0, 148, 249, 62);
		panelDesplega.add(btnRegistro);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaReportes vrep=new VistaReportes();
				vrep.setVisible(true);
				dispose();
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
		btnReportes.setBounds(0, 222, 249, 62);
		panelDesplega.add(btnReportes);
		ImageIcon ico=new ImageIcon(getClass().getResource("/iconos/WhatsApp Image 2024-11-29 at 14.40.06 (1).jpeg"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1616, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panelDesplega, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1367, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(845, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelDesplega, GroupLayout.PREFERRED_SIZE, 883, GroupLayout.PREFERRED_SIZE))
		);
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(4, 173, 255));
		toolBar.setBounds(0, 0, 1096, 45);
		panel_1.add(toolBar);
		
		JButton btnMenu = new JButton("");
		toolBar.add(btnMenu);
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
		btnMenu.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/iconos/Menu_icon_icon-icons.com_71858.png")));
		btnMenu.setContentAreaFilled(false);
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
