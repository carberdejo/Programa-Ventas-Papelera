package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import clases.*;
import procesos.*;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.Color;


public class Dreportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelReport;
	private DefaultTableModel modelReport2;
	private DefaultTableModel modelReport3;
	private DefaultTableModel modelReport4;
	private JComboBox<String> cboReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dreportes dialog = new Dreportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dreportes() {
		setTitle("Reportes");
		setBounds(100, 100, 666, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		 cboReporte = new JComboBox<>();
	        cboReporte.setModel(new DefaultComboBoxModel<>(new String[] {
	            "Listado general de ventas", 
	            "productos cuyo stock se encuentra por debajo del stock mínimo", 
	            "productos por unidades vendidas acumuladas mostrando por cada producto", 
	            "productos por importe total"
	        }));
	        cboReporte.setBounds(138, 61, 375, 31);
	        contentPanel.add(cboReporte);
	        cboReporte.setSelectedIndex(0); 
	        cboReporte.addActionListener(e -> Listar());
	      
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 122, 604, 291);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		modelReport = new DefaultTableModel();
		table.setModel(modelReport);
		
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(Dreportes.class.getResource("/imagenes/cerrar-sesion.png")));
		btnCerrar.setBounds(535, 23, 89, 41);
		contentPanel.add(btnCerrar);
		
		
		
		  System.out.println("Dialog initialized"); // Debug statement
		   	SwingUtilities.invokeLater(new Runnable() {
		   	    @Override
		   	    public void run() {
		   	        Listar(); // Call to populate the table
		   	    }
		   	});
	        System.out.println("listar() called"); // Debug statement
	     
		
		class MyReportClass {
		    private JComboBox<String> cboReporte;
		    private DefaultTableModel modelReport;
		    
		    public MyReportClass() {
		        // Initialize combo box and model
		        cboReporte = new JComboBox<>();
		        modelReport = new DefaultTableModel();
		        cboReporte.addItem("Listado general de ventas");
		        cboReporte.addItem("productos cuyo stock se encuentra por debajo del stock mínimo");
		        cboReporte.addItem("productos por unidades vendidas acumuladas mostrando por cada producto");
		        cboReporte.addItem("productos por unidades vendidas acumuladas mostrando por cada producto");
		        cboReporte.addItem("productos por importe total");
		    }
		}
		
	
}
    private void updateTableData(int index) {
        modelReport.setRowCount(0);
    }    
	ArregloCliente ac=new ArregloCliente();
	ArregloEmpleado ae=new ArregloEmpleado();
	ArregloProducto ap=new ArregloProducto();
	ArregloVenta av = new ArregloVenta();
	private JButton btnCerrar;

	//  M�todos tipo void (sin par�metros)

   	void Listar() {
   		/*Listado general de ventas mostrando en cada caso: código de venta,
   		 *  código de cliente, código de producto, fecha, importe subtotal, importe del 
   		 *  IGV e importe total.*/
   		
   		modelReport.setRowCount(0);
   		modelReport.setColumnCount(0);
   		int Index = cboReporte.getSelectedIndex();
   
   		if(Index == 0) {
   			
   		try {
   			modelReport.addColumn("código Venta");
   			modelReport.addColumn("código Cliente");
   			modelReport.addColumn("código Producto");
   			modelReport.addColumn("Fecha");
   			modelReport.addColumn("Sub Total");
   			modelReport.addColumn("IGV");
   			modelReport.addColumn("Importe Total");
   			for (int x = 0; x<av.cantDentVent(); x++) {
   				Object GenVentas[] = {
   						av.buscarV(av.ObtenerD(x).getCodVent()).getCodigoVenta(),
   						av.buscarV(av.ObtenerD(x).getCodVent()).getCodCliente(),
   						av.ObtenerD(x).getCodPro(),
   						av.buscarV(av.ObtenerD(x).getCodVent()).getDate(),				
   						av.ObtenerD(x).importe(),				
   						av.ObtenerD(x).importeIGV(),				
   						av.ObtenerD(x).importeTotal(),								
   				};
   				modelReport.addRow(GenVentas);
   				table.revalidate();
   			}
		} catch (Exception e) {
			mensaje("Mensaje  " + e.getMessage());
		}
		}else if (Index == 1) {
			modelReport.addColumn("código Producto");
			modelReport.addColumn("Nombre Producto");
			modelReport.addColumn("Stock Actual");
			modelReport.addColumn("Stock Minimo");
   		for (int x = 0; x<ap.cantProducto(); x++) {
   			if(ap.obtener(x).getStockActual()<ap.obtener(x).getStockMin()) {
			Object ProductoStock[] = {
					ap.obtener(x).getCodProducto(),
					ap.obtener(x).getNomProducto(),
					ap.obtener(x).getStockActual(),
					ap.obtener(x).getStockMin(),
			};
			modelReport.addRow(ProductoStock);
			table.revalidate();
	};
   		}	
   		}
   		else if (Index == 2) {
   			modelReport.addColumn("código Producto");
			modelReport.addColumn("Nombre Producto");
			modelReport.addColumn("Cant Uni Vendidas");
			//modelReport.addColumn("Cantidad Productos");
   			for (int x = 0; x<ap.cantProducto(); x++) {
   				Object ProductoUVendidas[]= {
   						ap.obtener(x).getCodProducto(),
   						ap.obtener(x).getNomProducto(),
   						CantidadPro(x),
   						//ap.obtener(x).getCantidadPro(),
   				};
   				modelReport.addRow(ProductoUVendidas);
   				table.revalidate();
   			}
   		}
   		//Listado de productos por importe total acumulado
   		//mostrando por cada producto: código del producto, 
   		//nombre del producto e importe total acumulado entre todas las ventas.
   		else if (Index == 3) {
   			modelReport.addColumn("código Producto");
			modelReport.addColumn("Nombre Producto");
			modelReport.addColumn("Imp total acumulado");
   			for (int x = 0; x<ap.cantProducto(); x++) {
   				Object ProductoUVendidas[]= {
   						ap.obtener(x).getCodProducto(),
   						ap.obtener(x).getNomProducto(),
   						ImportePro(x)
   				};
   				modelReport.addRow(ProductoUVendidas);
   				table.revalidate();
   			}
   		}
   			else if  (cboReporte == null) {
   	            System.out.println("cboReporte is null!");
   	            return;
   	            }
   	}
   	double ImportePro(int e) {
   		double importe = 0;
   		for (int x = 0; x<av.cantDentVent(); x++) 
   			if(av.ObtenerD(x).getCodPro() == ap.obtener(e).getCodProducto()) 
   				importe += av.ObtenerD(x).importe() ;
   		return importe;
   		
   	}
	int CantidadPro(int e) {
   		int cantidad = 0;
   		for (int x = 0; x<av.cantDentVent(); x++) 
   			if(av.ObtenerD(x).getCodPro() == ap.obtener(e).getCodProducto()) 
   				cantidad += av.ObtenerD(x).getCantidad() ;
   		return cantidad;
   		
   	}
    private class ComboBoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = cboReporte.getSelectedIndex();
            updateTableData(selectedIndex); // Update table based on selected index
        }
    }
   	
   
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}	
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(e);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
	}
   	}



