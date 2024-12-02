package vista;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Vprueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private FrmRegistros reg;
	private FrmReportes repo;
	private Soluciones solu;
	private JDesktopPane dspPrincipal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vprueba frame = new Vprueba();
					frame.setVisible(true);
					FrmRegistros reg= new FrmRegistros(frame.getDesktopPane());
					reg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vprueba() {
		setTitle("Sistema de gestion\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivos");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\ACER\\Downloads\\menu-button_icon-icons.com_72989.ico"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cargaRegistro();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reportes");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.control);
		toolBar.setFloatable(false);
		
		dspPrincipal = new JDesktopPane();
		dspPrincipal.setBackground(new Color(172, 227, 249));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(dspPrincipal, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dspPrincipal, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
		);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cargaRegistro();
			}
		});
		btnRegistro.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnRegistro);
		
		JButton btnRepotes = new JButton("Reportes");
		btnRepotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cargaReportes();
			}
		});
		btnRepotes.setBackground(SystemColor.inactiveCaption);
		toolBar.add(btnRepotes);
		
		JButton btnNewButton = new JButton("Soluciones");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cargaSoluciones();
				
			}
		});
		toolBar.add(btnNewButton);
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	
//}
	/*private void cargaRegistro() {
		if(reg==null || reg.isClosed()) {
		reg=new FrmRegistros();
		dspPrincipal.add(reg);
		//Dimension tf=reg.getSize();
		//reg.setLocation((dspPrincipal.getWidth()-tf.width)/2, (dspPrincipal.getHeight()-tf.height)/2);
		reg.show();
		}
	}
	private void cargaReportes() {
		if(repo==null || repo.isClosed()) {
		repo=new FrmReportes();
		dspPrincipal.add(repo);
		Dimension tif=repo.getSize();
		repo.setLocation((dspPrincipal.getWidth()-tif.width)/2, (dspPrincipal.getHeight()-tif.height)/2);
		repo.show();
		}
}
	private void cargaSoluciones() {
		//if(solu==null || solu.isClosed()) {
		Soluciones solu=new Soluciones();
		/*dspPrincipal.add(solu);
		Dimension tif=solu.getSize();
		solu.setLocation((dspPrincipal.getWidth()-tif.width)/2, (dspPrincipal.getHeight()-tif.height)/2);
		solu.show();*/
		/*solu.setVisible(true);
		}*/
	
}
	public JDesktopPane getDesktopPane() {
		return dspPrincipal;
		
	}
}