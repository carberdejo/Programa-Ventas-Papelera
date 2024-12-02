package gui;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clases.Cliente;
import procesos.ArregloCliente;


public class ManteniCli_Ingresar extends JDialog implements ActionListener {

ArregloCliente ac =new ArregloCliente();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JButton btnAceptar;
	//ArregloCliente ac1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManteniClli_Modi dialog = new ManteniClli_Modi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManteniCli_Ingresar() {
		// this.ac1 = ac;  // Pasar la instancia de ArregloCliente
		 
		setTitle("Ingresar");
		setBounds(100, 100, 364, 316);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(21, 43, 108, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(139, 40, 188, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(21, 74, 95, 14);
			contentPanel.add(lblApellido);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(139, 71, 188, 20);
			contentPanel.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			JLabel lblDNI = new JLabel("DNI");
			lblDNI.setBounds(21, 105, 95, 14);
			contentPanel.add(lblDNI);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBounds(139, 102, 188, 20);
			contentPanel.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(21, 136, 95, 14);
			contentPanel.add(lblTelefono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(139, 133, 188, 20);
			contentPanel.add(txtTelefono);
		}
		{
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(21, 167, 83, 14);
			contentPanel.add(lblDireccion);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(139, 164, 188, 20);
			contentPanel.add(txtDireccion);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(21, 198, 83, 14);
			contentPanel.add(lblEmail);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(139, 195, 188, 20);
			contentPanel.add(txtEmail);
		}
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(66, 243, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(204, 243, 89, 23);
		contentPanel.add(btnCerrar);
		
		
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	String leerDNI() {
		return txtDNI.getText().trim();
	}
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	String leerEmail() {
		return txtEmail.getText().trim();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		try {
			String name = leerNombre();
			try {
				String ape = leerApellido();
				try {
					String dni = leerDNI();
					try {
						String fono = leerTelefono();
						//System.out.println(Cliente.getAutoCod());
						Cliente cli = new Cliente(ac.numeroauto(), name, ape, leerDireccion(),fono, dni,leerEmail());
						ac.agregarCliente(cli);
						//System.out.println(Cliente.getAutoCod());
						ac.grabarCliente();
						
						mensaje("Cliente con codigo  "+cli.getCodCliente()+" se registro correctamente");
						dispose();
						
					} catch (Exception e2) {
						mensaje("Ingrese Telefono correcto", txtTelefono);
					}
				} catch (Exception e2) {
					mensaje("Ingrese DNI correcto", txtDNI);
				}
			} catch (Exception e2) {
				mensaje("Ingrese apellido correcto", txtApellido);
			}
		} catch (Exception e2) {
			mensaje("Ingrese nombre correcto", txtNombre);
		}
	}
	void mensaje(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s);
		txt.setText("");
		txt.requestFocus();
	}
}
