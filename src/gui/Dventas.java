package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import procesos.*;
import clases.*;
import extras.*;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Dventas extends JFrame implements ActionListener {
	
	//declarando objeto
	ArregloVenta ave = new ArregloVenta();
	ArregloCliente ac = new ArregloCliente();
	ArregloProducto ap = new ArregloProducto();
	ArregloEmpleado ae = new ArregloEmpleado();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtCodCliente;
	private JButton btnCerrar;
	private DefaultTableModel modelVent;
	private JComboBox<String> cboEmpleado;
	private JComboBox <String>cboProducto;
	private JButton btnVender;
	private JButton btnAgregar;
	private JTable tblResultado;
	private DefaultTableModel modelResult;
	private JTextField txtCodigoVent;
	private JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dventas frame = new Dventas();
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
	public Dventas() {
		setTitle("Venta");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 198, 603, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblProducto = new JLabel("Producto :");
		lblProducto.setBounds(24, 33, 63, 14);
		contentPane.add(lblProducto);
		
		cboProducto = new JComboBox<String>();
		cboProducto.setEnabled(false);
		cboProducto.setBounds(95, 29, 201, 22);
		contentPane.add(cboProducto);
		datosCodigoPro();
		
		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setBounds(24, 63, 46, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(97, 60, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setText(""+ap.obtener(leerProducto()).getPrecioProducto());
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(24, 88, 63, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setBounds(97, 85, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo Cliente :");
		lblNewLabel.setBounds(309, 30, 96, 14);
		contentPane.add(lblNewLabel);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setBounds(414, 25, 107, 20);
		contentPane.add(txtCodCliente);
		txtCodCliente.setColumns(10);
		txtCodCliente.requestFocus();
		
		JLabel lbEmpleado = new JLabel("Empleado :");
		lbEmpleado.setBounds(24, 128, 63, 14);
		contentPane.add(lbEmpleado);
		
		cboEmpleado = new JComboBox<String>();
		cboEmpleado.setEnabled(false);
		cboEmpleado.setBounds(97, 120, 208, 22);
		contentPane.add(cboEmpleado);
		datosEmpleado();
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(531, 24, 89, 23);
		contentPane.add(btnVender);
		
		btnCerrar = new JButton("");
		btnCerrar.setIcon(new ImageIcon(Dventas.class.getResource("/imagenes/cerrar-sesion.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(532, 137, 89, 41);
		contentPane.add(btnCerrar);
		
		modelVent = new DefaultTableModel();
		modelVent.addColumn("Codigo Producto");
		modelVent.addColumn("Producto");
		modelVent.addColumn("Precio Uni");
		modelVent.addColumn("Cantidad");
		modelVent.addColumn("improte");
		table.setModel(modelVent);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(531, 66, 89, 23);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(425, 382, 201, 39);
		contentPane.add(scrollPane_1);
		
		tblResultado = new JTable();
		scrollPane_1.setViewportView(tblResultado);
		
		modelResult = new DefaultTableModel();
		modelResult.addColumn("Subtotal");
		modelResult.addColumn("IGV");
		modelResult.addColumn("Total");
		tblResultado.setModel(modelResult);
		
		txtCodigoVent = new JTextField();
		txtCodigoVent.setEditable(false);
		txtCodigoVent.setColumns(10);
		txtCodigoVent.setBounds(127, 154, 86, 20);
		contentPane.add(txtCodigoVent);
		txtCodigoVent.setText(""+ave.codAutoVenta());
		
		JLabel lblCodigo = new JLabel("Codigo Venta  :");
		lblCodigo.setBounds(22, 153, 101, 23);
		contentPane.add(lblCodigo);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setEnabled(false);
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBounds(531, 97, 89, 23);
		contentPane.add(btnFinalizar);
		
	}
	void listar() {
		try {
			modelVent.setRowCount(0);
			System.out.println(ave.cantDentVent());
			for(int v = 0; v < ave.cantDentVent(); v++) {
					
				Producto pro = ap.buscarPro(ave.ObtenerD(v).getCodPro());
				//Cliente cli = ac.buscarCLi(ave.ObtenerV(v).getCodCliente());
				//Empleado em = ae.buscaE(ave.ObtenerV(v).getCodEmple());
				
				if(ave.ObtenerD(v).getCodVent() == ave.ObtenerD(ave.cantDentVent()-1).getCodVent()) {
					Object ventas[] = {
							//ave.ObtenerD(v).getCodVent(),
							//ave.buscarV(ave.ObtenerD(v).getCodVent()).getCodEmple(),
							//em != null ? em.getNomEmpleado() : "No encontrado",
							//ave.buscarV(ave.ObtenerD(v).getCodVent()).getCodCliente() ,
							//cli != null ? cli.getNomCliente() : "No encontrado",
							//cli.getApeCliente(),
							ave.ObtenerD(v).getCodPro(),
							pro != null ? pro.getNomProducto() : "No encontrado",
							ave.ObtenerD(v).getPrecioU(),
							ave.ObtenerD(v).getCantidad(),
							ave.ObtenerD(v).importe()
							//ave.buscarV(ave.ObtenerD(v).getCodVent()).getDate()			
						};
						modelVent.addRow(ventas);
				}
			}
		} catch (Exception e) {
			mensaje("Mensaje  " + e.getMessage());
		}
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigoVent.getText().trim());
	}
	int leerProducto() {
	    //return Integer.parseInt(cboProducto.getSelectedItem().toString());
		return cboProducto.getSelectedIndex();
	}
	int leercliente() {
		return Integer.parseInt(txtCodCliente.getText().trim());
	}
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().trim());
	}
	int leerEmpleado() {
		return cboEmpleado.getSelectedIndex();
	}
	int leerCodEmple() {
		return ae.Obtener(leerEmpleado()).getCodEmpleado();
	}
	void datosEmpleado() {
		try {
			cboEmpleado.removeAllItems();
			for(int i =0 ;i<ae.cantEmple();i++) {
				String texto = ae.Obtener(i).getNomEmpleado()+" "+ae.Obtener(i).getApeEmpleado();
				cboEmpleado.addItem(texto);
			}
		} catch (Exception e) {
			mensaje("Mensaje de error de empleado: " + e.getMessage());
		}
	}
	void datosCodigoPro() {
		try {
			cboProducto.removeAllItems();
			for(int i =0 ;i<ap.cantProducto();i++) {
				String texto = ""+ap.obtener(i).getNomProducto();
				cboProducto.addItem(texto);
			}
		} catch (Exception e) {
			mensaje("Mensaje de error de producto: " + e.getMessage());
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFinalizar) {
			do_btnFinalizar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
		if (e.getSource() == btnVender) {
			do_btnVender_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	protected void do_btnVender_actionPerformed(ActionEvent e) {
		vender();
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		agregar();
	}
	protected void do_btnFinalizar_actionPerformed(ActionEvent e) {
		finalizar();
	}
	void vender() {
		int cliente = leercliente();
		Cliente cli = ac.buscarCLi(cliente);
		int cod = ave.codAutoVenta();
		if(cli != null) {
			Venta ve = new Venta(cod, cliente, leerCodEmple(), Date.fechaActual());
			ave.agregarVenta(ve);
			ave.grabarVenta();
			txtCodigoVent.setText(""+cod);
			txtCodCliente.setText(""+ve.getCodCliente());
			txtCodCliente.setEditable(false);
			btnFinalizar.setEnabled(true);
			btnAgregar.setEnabled(true);
			Cajas(true);
			//System.out.println(ve.getCodEmple());
		}else 
			mensaje("cliente no encontrado");
	}
	
	void agregar() {
		
		int cantidad = leerCantidad();
		int codigo = leerCodigo();
		int produc = ap.obtener(leerProducto()).getCodProducto();
		double precio = ap.obtener(leerProducto()).getPrecioProducto();
		
		int act = ap.obtener(leerProducto()).getStockActual();
		if( act >= cantidad) {
			
		ap.obtener(leerProducto()).setStockActual(act-cantidad);
		DetalleVenta dv = new DetalleVenta(codigo, produc, cantidad, precio);
		ave.agregarDetalle(dv);
		ave.grabarDetVenta();
		
		listar();
		}else
			mensaje("Excede el stock minimo");
	}
	
	void finalizar() {
		Cajas(false);
		limpieza();
		listar();
		double sum = 0;
		for(int i = 0;i<ave.cantDentVent();i++) {
			if(ave.ObtenerD(ave.cantDentVent()-1).getCodVent() == ave.ObtenerD(i).getCodVent())
				sum += ave.ObtenerD(i).importe();
		}
		
		listarPrecios(sum);
		listar();
	}
	void listarPrecios(double num){
		try {
			double igv = num*Venta.IGV;
			modelVent.setRowCount(0);
			Object ventas[] = {
					num,igv,num+igv
				};
				modelResult.addRow(ventas);
		} catch (Exception e) {
			mensaje("Mensaje  " + e.getMessage());
		}
	}

	void Cajas(boolean conf) {
		txtCodCliente.setEditable(conf);
		txtCantidad.setEditable(conf);
		cboEmpleado.setEnabled(conf);
		cboProducto.setEnabled(conf);
	}
	void mensajeText(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s);
		txt.setText("");
		txt.requestFocus();
	}
	void limpieza() {
		txtCodigoVent.setText("");
		txtCantidad.setText("");
		txtCodCliente.setText("");
		txtCantidad.setText("");
		txtPrecio.requestFocus();
	}
	
}
