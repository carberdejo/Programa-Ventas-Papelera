package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;

//import java.awt.FlowLayout;

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
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import procesos.ArregloCliente;
import clases.Cliente;


import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DmanteniCliente extends JDialog implements ActionListener, MouseListener {
	//Declarando
	private ArregloCliente ac = new ArregloCliente();

    

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCodigo;
	private JButton btnCerrar;
	private DefaultTableModel modelMCliente;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnListar;

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
	public DmanteniCliente() {
		setTitle("Mantenimientos de Productos");
		setBounds(100, 100, 666, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 134, 607, 287);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(35, 21, 89, 23);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(152, 21, 89, 23);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(265, 21, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(384, 21, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(504, 21, 89, 23);
		contentPanel.add(btnListar);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(21, 80, 46, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(77, 77, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DmanteniCliente.class.getResource("/imagenes/cerrar-sesion.png")));
		
		btnCerrar.setBounds(539, 69, 89, 41);
		contentPanel.add(btnCerrar);
		
		modelMCliente = new DefaultTableModel();
		modelMCliente.addColumn("código");
		modelMCliente.addColumn("nombre");
		modelMCliente.addColumn("Apellido");
		modelMCliente.addColumn("DNI");
		modelMCliente.addColumn("Telefono");
		modelMCliente.addColumn("Dirección");
		modelMCliente.addColumn("Email");
		table.setModel(modelMCliente);
		
		
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
	
	void listar() {
		modelMCliente.setRowCount(0);
		
		for(int x =0;x<ac.cantClientes();x++) {
			Object datosCliente[]= {
				ac.obtener(x).getCodCliente(),
				ac.obtener(x).getNomCliente(),
				ac.obtener(x).getApeCliente(),
				ac.obtener(x).getDNI(),
				ac.obtener(x).getTelefono(),
				ac.obtener(x).getDireccion(),
				ac.obtener(x).getEmail(),
			};
			modelMCliente.addRow(datosCliente);
		}
	}
	
	void adicionar() {
		try {
			
			 ManteniCli_Ingresar Ingresar = new ManteniCli_Ingresar();
			Ingresar.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			Ingresar.setLocationRelativeTo(this);
			Ingresar.setVisible(true);
				ac.eliminartodo();
				
				ac.listadoCliente();
				listar();
		} catch (Exception e) {
			mensaje("Mensaje de error de empleado: " + e.getMessage());
		}
		
		} 
		
	
	void consultar() {
		try {
			//Cliente cli = ac.obtener(table.getSelectedRow());
			Cliente cli = ac.buscarCLi(leerCodigo());
			if(cli != null) {
			modal("CODIGO :  " + cli.getCodCliente() + "\n" + 
			        "NOMBRE :  " + cli.getNomCliente() + "\n" + 	
			        "DNI :  " + cli.getDNI() + "\n" +
			        "PESO :  " + cli.getTelefono() + " kg " + "\n" +
			        "ESTATURA :  " + cli.getDireccion() + " mts" + "\n" +
			        "ESTADO CIVIL :  " + cli.getEmail());
			}else
				mensaje("codigo no encontrado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*try {
			Cliente cli = ac.buscarCLi(leerCodigo());
			if(cli != null) {
				txtNombre.setText(cli.getNomCliente());
				txtApellido.setText(cli.getApeCliente());
				txtDNI.setText(cli.getDNI());
				txtTelefono.setText(cli.getTelefono());
				txtDireccion.setText(cli.getDireccion());
				txtEmail.setText(cli.getEmail());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
	
	void eliminar() {
		int indice = table.getSelectedRow();
		Cliente cli = ac.obtener(indice);
		int confir = confirmar("Deseas eliminarlo");
		if(confir==0) {
			ac.eliminar(cli);
			ac.grabarCliente();
			listar();
			if(ac.cantClientes() > 0) {
				if(indice==table.getRowCount())
					indice--;
				table.getSelectionModel().setSelectionInterval(indice, indice);
			}
		}
	}
	
	void modificar() {
		ManteniClli_Modi  Modi=new ManteniClli_Modi();
		Modi.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		Modi.setLocationRelativeTo(this);
		Modi.setVisible(true);
		ac.eliminartodo();
		ac.listadoCliente();
		listar();
	}
	
	
	
	
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		adicionar();
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		modificar();
	}
	protected void do_btnConsultar_actionPerformed(ActionEvent e) {
		consultar() ;
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		eliminar();
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		listar();
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
	
}
