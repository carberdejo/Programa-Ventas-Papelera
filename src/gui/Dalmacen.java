package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;

import clases.Producto;
import procesos.ArregloProducto;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Dalmacen extends JDialog implements ActionListener {

	ArregloProducto ap = new ArregloProducto();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodPro;
	private JTable table;
	private JTextField txtNuevoStock;
	private JButton btnCerrar;
	private JTextField txtStockMin;
	private JTextField txtStockkMax;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private DefaultTableModel modelMProducto;
	private JTextField txtStockActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dalmacen dialog = new Dalmacen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dalmacen() {
		setBounds(100, 100, 666, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 177, 603, 230);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JLabel lblcodPro = new JLabel("Codigo de Producto:");
			lblcodPro.setBounds(10, 24, 121, 14);
			contentPanel.add(lblcodPro);
		}
		{
			txtcodPro = new JTextField();
			txtcodPro.setBounds(141, 21, 86, 20);
			contentPanel.add(txtcodPro);
			txtcodPro.setColumns(10);
		}
		{
			btnAgregar = new JButton("Agregar");
			btnAgregar.setIcon(new ImageIcon(Dalmacen.class.getResource("/imagenes/Agregar.png")));
			btnAgregar.addActionListener(this);
			btnAgregar.setBounds(512, 30, 112, 33);
			contentPanel.add(btnAgregar);
		}
		{
			JLabel lblNuevoSotck = new JLabel("Ingresar Stock :");
			lblNuevoSotck.setBounds(10, 49, 110, 14);
			contentPanel.add(lblNuevoSotck);
		}
		{
			txtNuevoStock = new JTextField();
			txtNuevoStock.setEditable(false);
			txtNuevoStock.setBounds(141, 46, 86, 20);
			contentPanel.add(txtNuevoStock);
			txtNuevoStock.setColumns(10);
		}
		{
			btnCerrar = new JButton("");
			btnCerrar.setIcon(new ImageIcon(Dalmacen.class.getResource("/imagenes/cerrar-sesion.png")));
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(535, 102, 89, 41);
			contentPanel.add(btnCerrar);
		}
		
		txtStockMin = new JTextField();
		txtStockMin.setEditable(false);
		txtStockMin.setColumns(10);
		txtStockMin.setBounds(141, 123, 86, 23);
		contentPanel.add(txtStockMin);
		
		JLabel lblStockMin = new JLabel("Stock Minimo :");
		lblStockMin.setBounds(10, 127, 104, 14);
		contentPanel.add(lblStockMin);
		
		txtStockkMax = new JTextField();
		txtStockkMax.setEditable(false);
		txtStockkMax.setColumns(10);
		txtStockkMax.setBounds(141, 99, 86, 20);
		contentPanel.add(txtStockkMax);
		
		JLabel lblStockMAx = new JLabel("Stock Maximo :");
		lblStockMAx.setBounds(10, 102, 110, 14);
		contentPanel.add(lblStockMAx);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(Dalmacen.class.getResource("/imagenes/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(357, 30, 112, 33);
		contentPanel.add(btnBuscar);
		
		modelMProducto = new DefaultTableModel();
		modelMProducto.addColumn("código");
		modelMProducto.addColumn("nombre");
		modelMProducto.addColumn("Precio");
		modelMProducto.addColumn("Stock Actual");
		modelMProducto.addColumn("Stock Min");
		modelMProducto.addColumn("Stock Max");
		modelMProducto.addColumn("Acabado");
		table.setModel(modelMProducto);
		
		JLabel lblStockActual = new JLabel("Stock Actual :");
		lblStockActual.setBounds(10, 77, 110, 14);
		contentPanel.add(lblStockActual);
		
		txtStockActual = new JTextField();
		txtStockActual.setEditable(false);
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(141, 74, 86, 20);
		contentPanel.add(txtStockActual);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		agregar();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		buscar();
	}
	
	void listar() {
		modelMProducto.setRowCount(0);
		
		for(int x =0;x<ap.cantProducto();x++) {
			Object datosProducto[]= {
				ap.obtener(x).getCodProducto(),
				ap.obtener(x).getNomProducto(),
				ap.obtener(x).getPrecioProducto(),
				ap.obtener(x).getStockActual(),
				ap.obtener(x).getStockMin(),
				ap.obtener(x).getStockMax(),
				ap.obtener(x).getAcabado()
				//TextAcabado(ap.obtener(x).getAcabado()),
			};
			modelMProducto.addRow(datosProducto);
		}
	}
	
	void buscar() {
		Producto pro = ap.buscarPro(leerCodigo());
		if(pro != null) {
			txtStockMin.setText(""+pro.getStockMin());
			txtStockkMax.setText(""+pro.getStockMax());
			txtStockActual.setText(""+pro.getStockActual());
			txtNuevoStock.setEditable(true);
			txtNuevoStock.requestFocus();
		}else
			mensaje("Codigo de producto incorrecto");
	}
	void agregar() {
		Producto pro = ap.buscarPro(leerCodigo());
		if(pro != null) {
			int nuevo = leercantidad();
			int sActual = pro.getStockActual();
			int maximo = pro.getStockMax();
				if(sActual + nuevo <= maximo) {
					pro.setStockActual(pro.getStockActual()+nuevo);
					mensaje("stock aumentado");
					listar();
				}else
					mensaje("no se puede agregar stock");
		}
	}
	
	int leerCodigo() {
		return Integer.parseInt(txtcodPro.getText().trim());
	}
	int leercantidad() {
		return Integer.parseInt(txtNuevoStock.getText().trim());
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
}
