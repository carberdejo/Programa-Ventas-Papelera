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

import clases.Empleado;
import procesos.ArregloEmpleado;


public class ManteniEmple_Ingresar extends JDialog implements ActionListener {

ArregloEmpleado ae = new ArregloEmpleado();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtSalario;
	private JButton btnAceptar;
	private JTextField txtEmail;

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
	public ManteniEmple_Ingresar() {
		 
		setTitle("Ingresar");
		setBounds(100, 100, 364, 316);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(49, 14, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(105, 11, 188, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(49, 45, 46, 14);
			contentPanel.add(lblApellido);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(105, 42, 188, 20);
			contentPanel.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			JLabel lblDNI = new JLabel("DNI");
			lblDNI.setBounds(49, 80, 46, 14);
			contentPanel.add(lblDNI);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setBounds(105, 74, 188, 20);
			contentPanel.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(49, 114, 46, 14);
			contentPanel.add(lblTelefono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(105, 105, 188, 20);
			contentPanel.add(txtTelefono);
		}
		{
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(49, 148, 46, 14);
			contentPanel.add(lblDireccion);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(105, 139, 188, 20);
			contentPanel.add(txtDireccion);
		}
		{
			JLabel lblSalario = new JLabel("Salario");
			lblSalario.setBounds(49, 207, 46, 14);
			contentPanel.add(lblSalario);
		}
		{
			txtSalario = new JTextField();
			txtSalario.setColumns(10);
			txtSalario.setBounds(105, 204, 188, 20);
			contentPanel.add(txtSalario);
		}
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(66, 243, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(204, 243, 89, 23);
		contentPanel.add(btnCerrar);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(105, 173, 188, 20);
		contentPanel.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(49, 176, 46, 14);
		contentPanel.add(lblEmail);
		
		
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
	double leerSalario() {
		return Double.parseDouble(txtSalario.getText().trim());
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
						try {
							String direc = leerDireccion();
							try {
								String email = leerEmail();
								try {
									double salar = leerSalario();
									//System.out.println(Cliente.getAutoCod());
									Empleado em = new Empleado(ae.codAutoEmpleado(), name, ape, dni, direc, fono, email, salar);
									ae.AgregarEmpleado(em);
									//System.out.println(Cliente.getAutoCod());
									ae.grabarEmpleado();
									
									mensaje("Empleado con codigo  "+em.getCodEmpleado()+" se registro correctamente");
									dispose();
								} catch (Exception e2) {
									mensaje("Ingrese SALARIO correcto", txtSalario);
								}
							} catch (Exception e2) {
								mensaje("Ingrese EMAIL correcto", txtEmail);
							}
						} catch (Exception e2) {
							mensaje("Ingrese direccion correcto", txtDireccion);
						}	
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
