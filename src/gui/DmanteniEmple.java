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

import procesos.ArregloEmpleado;
import clases.Empleado;


import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DmanteniEmple extends JDialog implements ActionListener, MouseListener {
	//Declarando
	ArregloEmpleado ae = new ArregloEmpleado();

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
	public DmanteniEmple() {
		setTitle("Mantenimientos de Productos");
		setBounds(100, 100, 666, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 144, 608, 277);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(77, 24, 89, 23);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(186, 24, 89, 23);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(289, 24, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(388, 24, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(489, 24, 89, 23);
		contentPanel.add(btnListar);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(21, 84, 46, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(70, 81, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\goberdejo\\Documents\\papeleriaPrint\\img\\cerrar-sesion.png"));
		btnCerrar.setBackground(new Color(64, 191, 191));
		
		btnCerrar.setBounds(540, 81, 89, 41);
		contentPanel.add(btnCerrar);
		
		modelMCliente = new DefaultTableModel();
		modelMCliente.addColumn("código");
		modelMCliente.addColumn("nombre");
		modelMCliente.addColumn("Apellido");
		modelMCliente.addColumn("DNI");
		modelMCliente.addColumn("Telefono");
		modelMCliente.addColumn("Dirección");
		modelMCliente.addColumn("Email");
		modelMCliente.addColumn("Salario");
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
		try {
			modelMCliente.setRowCount(0);
			
			for(int x =0;x<ae.cantEmple();x++) {
				Object datosEmpleado[]= {
					ae.Obtener(x).getCodEmpleado(),
					ae.Obtener(x).getNomEmpleado(),
					ae.Obtener(x).getApeEmpleado(),
					ae.Obtener(x).getDNI(),
					ae.Obtener(x).getTelefono(),
					ae.Obtener(x).getDireccion(),
					ae.Obtener(x).getEmail(),
					ae.Obtener(x).getSalario()
					
				};
				modelMCliente.addRow(datosEmpleado);
			}
		} catch (Exception e) {
			mensaje("Mensaje de error  " + e.getMessage());
		}
		
	}
	
	void adicionar() {
		try {
			 ManteniEmple_Ingresar Ingresar = new ManteniEmple_Ingresar();
			Ingresar.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			Ingresar.setLocationRelativeTo(this);
			Ingresar.setVisible(true);
			ae.eliminartodo();		
			ae.listadoEmpleado();
			listar();
				}catch (Exception e) {
					
				}
		} 
	
	void modificar() {
		try {
			ManteniEmple_Modi  Modi=new ManteniEmple_Modi();
			Modi.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			Modi.setLocationRelativeTo(this);
			Modi.setVisible(true);
			ae.eliminartodo();		
			ae.listadoEmpleado();
			listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void consultar() {
		try {
			//Empleado em = ae.Obtener(table.getSelectedRow());
			Empleado em = ae.buscaE(leerCodigo());
			if(em != null) {
			modal("CODIGO :  " + em.getCodEmpleado() + "\n" + 
			        "NOMBRE :  " + em.getNomEmpleado() + "\n" + 	
			        "APELLIDO :  " + em.getApeEmpleado() + "\n" + 	
			        "DNI :  " + em.getDNI() + "\n" +
			        "TELEFONO :  " + em.getTelefono()+ "\n" +
			        "DIRECCION :  " + em.getDireccion()  + "\n" +
			        "EMAIL :  " + em.getEmail() + "\n" +
			        "SALARIO :  " + em.getSalario());
		}	else
			mensaje("Codigo no encontrado");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void eliminar() {
		int indice = table.getSelectedRow();
		Empleado em = ae.Obtener(indice);
		int confir = confirmar("Deseas eliminarlo");
		if(confir==0) {
			ae.EliminarE(em);
			ae.grabarEmpleado();
			listar();
			if(ae.cantEmple() > 0) {
				if(indice==table.getRowCount())
					indice--;
				table.getSelectionModel().setSelectionInterval(indice, indice);
			}
		}
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
