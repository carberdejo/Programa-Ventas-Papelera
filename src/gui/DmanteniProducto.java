package gui;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import procesos.ArregloProducto;
import clases.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DmanteniProducto extends JDialog implements ActionListener, MouseListener {
	
	ArregloProducto ap = new ArregloProducto();

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCodigo;
	private JButton btnCerrar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnListar;
	private DefaultTableModel modelMProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DmanteniProducto dialog = new DmanteniProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DmanteniProducto() {
		setTitle("Mantenimientos de Productos");
		setBounds(100, 100, 666, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 175, 603, 227);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(67, 27, 89, 23);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(176, 27, 89, 23);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(279, 27, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(378, 27, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(479, 27, 89, 23);
		contentPanel.add(btnListar);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(22, 87, 46, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(78, 84, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnCerrar = new JButton("");
		btnCerrar.setIcon(new ImageIcon(DmanteniProducto.class.getResource("/imagenes/cerrar-sesion.png")));
		
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(536, 75, 89, 41);
		contentPanel.add(btnCerrar);
		
		modelMProducto = new DefaultTableModel();
		modelMProducto.addColumn("código");
		modelMProducto.addColumn("nombre");
		modelMProducto.addColumn("Precio");
		modelMProducto.addColumn("Stock Actual");
		modelMProducto.addColumn("Stock Min");
		modelMProducto.addColumn("Stock Max");
		modelMProducto.addColumn("Acabado");
		table.setModel(modelMProducto);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		adicionar();
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		modificar();
	}
	protected void do_btnConsultar_actionPerformed(ActionEvent e) {
		consultar();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		eliminar();
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		listar();
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
	
	void consultar() {
		try {
			//Producto pro = ap.obtener(table.getSelectedRow());
			Producto pro = ap.buscarPro(leerCodigo());
			if(pro != null) {
			modal("CODIGO :  " + pro.getCodProducto() + "\n" + 
			        "NOMBRE :  " + pro.getNomProducto() + "\n" + 	
			        "PRECIO :  " + pro.getPrecioProducto() + "\n" +
			        "STOCK ACTUAL :  " + pro.getStockActual() + "unidades " + "\n" +
			        "STOCK MINIMO :  " + pro.getStockMin() + " unidades" + "\n" +
			        "STOCK MAXIMO :  " + pro.getStockMax()+" unidades");
			}else
				mensaje("Codigo no encontrado");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void adicionar() {
		try {
			
			 ManteniPro_Ingresar Ingresar = new ManteniPro_Ingresar();
			Ingresar.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			Ingresar.setLocationRelativeTo(this);
			Ingresar.setVisible(true);
				ap.eliminartodo();
				ap.listadoProducto();
				listar();
		} catch (Exception e) {
			mensaje("Mensaje de error : " + e.getMessage());
		}
	}
	void modificar() {
		try {
			ManteniPro_Modi Modificar = new ManteniPro_Modi();
			Modificar.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			Modificar.setLocationRelativeTo(this);
			Modificar.setVisible(true);
				ap.eliminartodo();
				ap.listadoProducto();
				listar();
		} catch (Exception e) {
			mensaje("Mensaje de error : " + e.getMessage());
		}
	}
	void eliminar() {
		int indice = table.getSelectedRow();
		Producto pro = ap.obtener(indice);
		int confir = confirmar("Deseas eliminarlo");
		if(confir==0) {
			ap.eliminarPro(pro);
			ap.grabarProducto();
			listar();
			if(ap.cantProducto() > 0) {
				if(indice==table.getRowCount())
					indice--;
				table.getSelectionModel().setSelectionInterval(indice, indice);
			}
		}
	}
	
	void modal(String s) {
		JOptionPane.showMessageDialog(this, s, "Persona", 1);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Persona", 0, 0, null);
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int indi = table.rowAtPoint(e.getPoint());
		txtCodigo.setText(table.getValueAt(indi, 0).toString());
	}
}
