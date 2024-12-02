package gui;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clases.ClassExtras;
import clases.Producto;
import procesos.ArregloProducto;
import javax.swing.JComboBox;


public class ManteniPro_Ingresar extends JDialog implements ActionListener {

	ArregloProducto ap = new ArregloProducto();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private JButton btnAceptar;
	private JComboBox <String>cboAcabado;
	private JButton btnCerrar;
	

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
	public ManteniPro_Ingresar() {
		
		 
		setTitle("Ingresar");
		setBounds(100, 100, 450, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 43, 126, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(222, 40, 149, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblPrecio = new JLabel("Precio :");
			lblPrecio.setBounds(10, 74, 126, 14);
			contentPanel.add(lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(222, 71, 149, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			JLabel lblStockActual = new JLabel("Stock Actual :");
			lblStockActual.setBounds(10, 106, 126, 14);
			contentPanel.add(lblStockActual);
		}
		{
			txtStockActual = new JTextField();
			txtStockActual.setBounds(222, 103, 149, 20);
			contentPanel.add(txtStockActual);
			txtStockActual.setColumns(10);
		}
		{
			JLabel lblStockMin = new JLabel("Stock Minimo :");
			lblStockMin.setBounds(10, 143, 126, 14);
			contentPanel.add(lblStockMin);
		}
		{
			txtStockMin = new JTextField();
			txtStockMin.setColumns(10);
			txtStockMin.setBounds(222, 140, 149, 20);
			contentPanel.add(txtStockMin);
		}
		{
			JLabel lblStockMax = new JLabel("Stock Maxmo :");
			lblStockMax.setBounds(10, 177, 126, 14);
			contentPanel.add(lblStockMax);
		}
		{
			txtStockMax = new JTextField();
			txtStockMax.setColumns(10);
			txtStockMax.setBounds(222, 174, 149, 20);
			contentPanel.add(txtStockMax);
		}
		{
			JLabel lblAcabado = new JLabel("Acabado :");
			lblAcabado.setBounds(10, 212, 126, 14);
			contentPanel.add(lblAcabado);
		}
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(88, 260, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(222, 260, 89, 23);
		contentPanel.add(btnCerrar);
		
		cboAcabado = new JComboBox<String>();
		cboAcabado.setModel(new DefaultComboBoxModel<String>(ClassExtras.Acabados));
		cboAcabado.setBounds(222, 208, 149, 22);
		contentPanel.add(cboAcabado);
		
		
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerStockActual() {
		return Integer.parseInt(txtStockActual.getText().trim());
	}
	int leerSmin() {
		return Integer.parseInt(txtStockMin.getText().trim());
	}
	int leerSmax() {
		return Integer.parseInt(txtStockMax.getText().trim());
	}
	String leerAcabado() {
		return cboAcabado.getSelectedItem().toString();
	}
	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		try {
			String name = leerNombre();
			try {
				double ape = leerPrecio();
				try {
					int SActual = leerStockActual();
					try {
						int Smin = leerSmin();
						String acabado = leerAcabado();
						try {
							int Smax = leerSmax();
							//System.out.println(Cliente.getAutoCod());
							Producto pro = new Producto(ap.codAutoProducto(), name, ape, SActual, Smin, Smax,acabado);
							ap.agregarProducto(pro);
							//System.out.println(Cliente.getAutoCod());
							ap.grabarProducto();
							mensaje("Cliente con codigo  "+pro.getCodProducto()+" se registro correctamente");	
							dispose();
						} catch (Exception e2) {
							mensaje("Ingrese Telefono correcto", txtStockMax);
						}
					} catch (Exception e2) {
						mensaje("Ingrese Telefono correcto", txtStockMin);
					}
				} catch (Exception e2) {
					mensaje("Ingrese DNI correcto", txtStockActual);
				}
			} catch (Exception e2) {
				mensaje("Ingrese apellido correcto", txtPrecio);
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
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
}
