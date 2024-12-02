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
import javax.swing.ImageIcon;


public class ManteniPro_Modi extends JDialog implements ActionListener {
	
	ArregloProducto ap = new ArregloProducto();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnBuscar;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JButton btnActualizar;
	 private JTextField txtPrecio;
	 private JTextField txtStockActual;
	 private JLabel lblPrecio;
	 private JLabel lblStockActual;
	 private JTextField txtStockMin;
	 private JTextField txtStockMax;
	 private JLabel lblStockMax;
	 private JLabel lblStockMin;
	 private JLabel lblAcabado;
	 private JComboBox<String> cboAcabado;
	 private JTextField txtNombre;
	 private JLabel lblNombre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManteniPro_Modi dialog = new ManteniPro_Modi();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManteniPro_Modi() {
		setTitle("Modificar");
		setBounds(100, 100, 454, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(ManteniPro_Modi.class.getResource("/imagenes/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(73, 263, 130, 23);
		contentPanel.add(btnBuscar);
		{
			lblCodigo = new JLabel("Codigo :");
			lblCodigo.setBounds(39, 28, 73, 14);
			contentPanel.add(lblCodigo);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(211, 25, 154, 20);
			contentPanel.add(txtCodigo);
		}
		{
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setIcon(new ImageIcon(ManteniPro_Modi.class.getResource("/imagenes/Actualizar.png")));
			btnActualizar.setEnabled(false);
			btnActualizar.addActionListener(this);
			btnActualizar.setBounds(276, 263, 130, 23);
			contentPanel.add(btnActualizar);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(211, 87, 154, 20);
			contentPanel.add(txtPrecio);
		}
		{
			txtStockActual = new JTextField();
			txtStockActual.setEditable(false);
			txtStockActual.setColumns(10);
			txtStockActual.setBounds(211, 118, 154, 20);
			contentPanel.add(txtStockActual);
		}
		{
			lblPrecio = new JLabel("Precio :");
			lblPrecio.setBounds(39, 90, 73, 14);
			contentPanel.add(lblPrecio);
		}
		{
			lblStockActual = new JLabel("Stock Actual :");
			lblStockActual.setBounds(39, 121, 98, 14);
			contentPanel.add(lblStockActual);
		}
		{
			txtStockMin = new JTextField();
			txtStockMin.setEditable(false);
			txtStockMin.setColumns(10);
			txtStockMin.setBounds(211, 149, 154, 20);
			contentPanel.add(txtStockMin);
		}
		{
			txtStockMax = new JTextField();
			txtStockMax.setEditable(false);
			txtStockMax.setColumns(10);
			txtStockMax.setBounds(211, 180, 154, 20);
			contentPanel.add(txtStockMax);
		}
		{
			lblStockMax = new JLabel("Stock Maxmo :");
			lblStockMax.setBounds(39, 183, 98, 14);
			contentPanel.add(lblStockMax);
		}
		{
			lblStockMin = new JLabel("Stock Minimo :");
			lblStockMin.setBounds(39, 152, 98, 14);
			contentPanel.add(lblStockMin);
		}
		{
			lblAcabado = new JLabel("Acabado :");
			lblAcabado.setBounds(39, 214, 98, 14);
			contentPanel.add(lblAcabado);
		}
		{
			cboAcabado = new JComboBox<String>();
			cboAcabado.setModel(new DefaultComboBoxModel<String>(ClassExtras.Acabados));
			cboAcabado.setEnabled(false);
			cboAcabado.setBounds(211, 211, 154, 20);
			contentPanel.add(cboAcabado);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(211, 56, 154, 20);
			contentPanel.add(txtNombre);
		}
		{
			lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(40, 59, 73, 14);
			contentPanel.add(lblNombre);
		}
		
		
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
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
			Producto pro = ap.buscarPro(leerCodigo());
			if(pro !=null) {
				editaCaja(true);
				txtNombre.setText(pro.getNomProducto());
				txtPrecio.setText(""+pro.getPrecioProducto());
				txtStockActual.setText(""+pro.getStockActual());
				txtStockMin.setText(""+pro.getStockActual());
				txtStockMax.setText(""+pro.getStockMin());
				txtStockMax.setText(""+pro.getStockMax());
				cboAcabado.setSelectedItem(pro.getAcabado());
				btnActualizar.setEnabled(true);
				
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		try {
			Producto pro = ap.buscarPro(leerCodigo());
			if(pro !=null) {
				pro.setNomProducto(leerNombre());
				pro.setPrecioProducto(leerPrecio());
				pro.setStockActual(leerStockActual());
				pro.setStockMin(leerSmin());
				pro.setStockMax(leerSmax());
				pro.setAcabado(leerAcabado());
				ap.grabarProducto();;
				mensaje("Producto actualizado correctamente");
				
				dispose();
			}else {
                mensaje("No se pudo actualizar, Producto no encontrado");
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
		txtPrecio.setEditable(caj);
		txtStockActual.setEditable(caj);
		txtStockMax.setEditable(caj);
		txtStockMin.setEditable(caj);
		cboAcabado.setEnabled(caj);
	}
}
