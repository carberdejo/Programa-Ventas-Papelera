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
import javax.swing.ImageIcon;


public class ManteniEmple_Modi extends JDialog implements ActionListener {
	
	ArregloEmpleado ae = new ArregloEmpleado();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JButton btnBuscar;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JButton btnActualizar;
	private JTextField txtSalario;
	private JLabel lblSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManteniEmple_Modi dialog = new ManteniEmple_Modi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManteniEmple_Modi() {
		setTitle("Modificar");
		setBounds(100, 100, 364, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 43, 80, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(136, 40, 188, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setBounds(10, 74, 80, 14);
			contentPanel.add(lblApellido);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setEditable(false);
			txtApellido.setBounds(136, 71, 188, 20);
			contentPanel.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			JLabel lblDNI = new JLabel("DNI:");
			lblDNI.setBounds(10, 105, 80, 14);
			contentPanel.add(lblDNI);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setEditable(false);
			txtDNI.setBounds(136, 102, 188, 20);
			contentPanel.add(txtDNI);
			txtDNI.setColumns(10);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 136, 80, 14);
			contentPanel.add(lblTelefono);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(136, 133, 188, 20);
			contentPanel.add(txtTelefono);
		}
		{
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(10, 167, 80, 14);
			contentPanel.add(lblDireccion);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(136, 164, 188, 20);
			contentPanel.add(txtDireccion);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(10, 198, 80, 14);
			contentPanel.add(lblEmail);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setEditable(false);
			txtEmail.setColumns(10);
			txtEmail.setBounds(136, 195, 188, 20);
			contentPanel.add(txtEmail);
		}
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(ManteniEmple_Modi.class.getResource("/imagenes/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(42, 269, 111, 23);
		contentPanel.add(btnBuscar);
		{
			lblCodigo = new JLabel("Codigo :");
			lblCodigo.setBounds(10, 15, 80, 14);
			contentPanel.add(lblCodigo);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(136, 12, 188, 20);
			contentPanel.add(txtCodigo);
			txtCodigo.requestFocus();
		}
		{
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setIcon(new ImageIcon(ManteniEmple_Modi.class.getResource("/imagenes/Actualizar.png")));
			btnActualizar.setEnabled(false);
			btnActualizar.addActionListener(this);
			btnActualizar.setBounds(207, 269, 117, 23);
			contentPanel.add(btnActualizar);
		}
		{
			txtSalario = new JTextField();
			txtSalario.setEditable(false);
			txtSalario.setColumns(10);
			txtSalario.setBounds(136, 226, 188, 20);
			contentPanel.add(txtSalario);
		}
		{
			lblSalario = new JLabel("Salario:");
			lblSalario.setBounds(10, 229, 80, 14);
			contentPanel.add(lblSalario);
		}
		
		
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		try {
			
			Empleado em = ae.buscaE(leerCodigo());
			mensaje("si");
			if(em !=null) {
				editaCaja(true);
				txtNombre.setText(em.getNomEmpleado());
				txtApellido.setText(em.getApeEmpleado());
				txtDNI.setText(em.getDNI());
				txtTelefono.setText(em.getTelefono());
				txtDireccion.setText(em.getDireccion());
				txtEmail.setText(em.getEmail());
				txtSalario.setText(""+em.getSalario());
				btnActualizar.setEnabled(true);
				
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		try {
			Empleado em = ae.buscaE(leerCodigo());
			if(em !=null) {
				em.setNomEmpleado(leerNombre());
				em.setApeEmpleado(leerApellido());
				em.setDNI(leerDNI());
				em.setTelefono(leerTelefono());
				em.setDireccion(leerDireccion());
				em.setEmail(leerEmail());
				em.setSalario(leerSalario());
				
				ae.grabarEmpleado();
				mensaje("Cliente actualizado correctamente");
				
				dispose();
			}else {
                mensaje("No se pudo actualizar, cliente no encontrado");
            }
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void editaCaja(boolean caj ) {
		txtNombre.setEditable(caj);
		txtApellido.setEditable(caj);
		txtDNI.setEditable(caj);
		txtTelefono.setEditable(caj);
		txtDireccion.setEditable(caj);
		txtEmail.setEditable(caj);
		txtSalario.setEditable(caj);
	}
}
