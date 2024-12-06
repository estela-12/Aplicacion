 package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaPagos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdPago;
	private JTextField txtPagosPen;
	private JTextField txtSaldoAPagar;
	private JTextField txtFechaLim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPagos frame = new VistaPagos();
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
	public VistaPagos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id Pagos:");
		lblNewLabel.setBounds(41, 64, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPagosPendientes = new JLabel("Pagos Pendientes:");
		lblPagosPendientes.setBounds(41, 112, 103, 14);
		contentPane.add(lblPagosPendientes);
		
		JLabel lblSaldoAPagar = new JLabel("Saldo a pagar:");
		lblSaldoAPagar.setBounds(41, 161, 103, 14);
		contentPane.add(lblSaldoAPagar);
		
		JLabel lblFechaLimitePara = new JLabel("Fecha Limite Para Pagar:");
		lblFechaLimitePara.setBounds(41, 211, 119, 14);
		contentPane.add(lblFechaLimitePara);
		
		txtIdPago = new JTextField();
		txtIdPago.setBounds(206, 61, 167, 20);
		contentPane.add(txtIdPago);
		txtIdPago.setColumns(10);
		
		txtPagosPen = new JTextField();
		txtPagosPen.setBounds(206, 109, 167, 20);
		contentPane.add(txtPagosPen);
		txtPagosPen.setColumns(10);
		
		txtSaldoAPagar = new JTextField();
		txtSaldoAPagar.setBounds(206, 158, 167, 20);
		contentPane.add(txtSaldoAPagar);
		txtSaldoAPagar.setColumns(10);
		
		txtFechaLim = new JTextField();
		txtFechaLim.setBounds(206, 208, 167, 20);
		contentPane.add(txtFechaLim);
		txtFechaLim.setColumns(10);
		
		JButton btnNewButton = new JButton("Realizar pago");
		btnNewButton.setBounds(158, 277, 167, 23);
		contentPane.add(btnNewButton);
	}
}
