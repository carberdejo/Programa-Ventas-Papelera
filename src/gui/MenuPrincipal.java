package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnuReportes;
	private JMenuItem mntReporteVenta;
	private JMenuItem mntVentaFactura;
	private JMenuItem mntAlmaProduc;
	private JMenuItem mntProductos;

	private JMenuItem mntSalir;
	private JMenuItem mntEmpleados_1;
	private JMenuItem mntCliente;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 546);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		menuBar.setForeground(new Color(148, 0, 211));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/Archivo.png")));
		mnArchivo.setForeground(Color.BLUE);
		menuBar.add(mnArchivo);
		
		mntSalir = new JMenuItem("Salir");
		mntSalir.addActionListener(this);
		mnArchivo.add(mntSalir);
		
		JMenu mnuMantenimiento = new JMenu("Mantenimiento");
		mnuMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/Mantenimiento.png")));
		mnuMantenimiento.setForeground(Color.BLUE);
		menuBar.add(mnuMantenimiento);
		
		mntProductos = new JMenuItem("Productos");
		mntProductos.addActionListener(this);
		
		mntCliente = new JMenuItem("Cliente");
		mntCliente.addActionListener(this);
		mnuMantenimiento.add(mntCliente);
		mnuMantenimiento.add(mntProductos);
		
		mntEmpleados_1 = new JMenuItem("Empleados");
		mntEmpleados_1.addActionListener(this);
		mnuMantenimiento.add(mntEmpleados_1);
		
		JMenu mnuVentas = new JMenu("Ventas");
		mnuVentas.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/Venta1.png")));
		mnuVentas.setForeground(new Color(0, 0, 255));
		menuBar.add(mnuVentas);
		
		mntVentaFactura = new JMenuItem("Factura");
		mntVentaFactura.addActionListener(this);
		mnuVentas.add(mntVentaFactura);
		
		JMenu mnuAlmacen = new JMenu("Almacen");
		mnuAlmacen.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/Almacen.png")));
		mnuAlmacen.setForeground(Color.BLUE);
		menuBar.add(mnuAlmacen);
		
		mntAlmaProduc = new JMenuItem("Productos");
		mntAlmaProduc.addActionListener(this);
		mnuAlmacen.add(mntAlmaProduc);
		
		mnuReportes = new JMenu("Reportes");
		mnuReportes.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/reportes.png")));
		mnuReportes.setForeground(Color.BLUE);
		menuBar.add(mnuReportes);
		
		mntReporteVenta = new JMenuItem("Reportes de ventas");
		mntReporteVenta.addActionListener(this);
		mnuReportes.add(mntReporteVenta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/1.jpg")));
		lblNewLabel.setBounds(0, 0, 842, 486);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntCliente) {
			do_mntCliente_actionPerformed(e);
		}
		if (e.getSource() == mntEmpleados_1) {
			do_mntEmpleados_actionPerformed(e);
		}
		if (e.getSource() == mntSalir) {
			do_mntSalir_actionPerformed(e);
		}
		if (e.getSource() == mntProductos) {
			do_mntProductos_actionPerformed(e);
		}
		if (e.getSource() == mntAlmaProduc) {
			do_mntAlmaProduc_actionPerformed(e);
		}
		if (e.getSource() == mntVentaFactura) {
			do_mntVentaFactura_actionPerformed(e);
		}
		if (e.getSource() == mntReporteVenta) {
			do_mntReporteVenta_actionPerformed(e);
		}
	}
	protected void do_mntReporteVenta_actionPerformed(ActionEvent e) {
		Dreportes  ReportesPA=new Dreportes();
		ReportesPA.setLocationRelativeTo(this);
		ReportesPA.setVisible(true); 
	}
	protected void do_mntVentaFactura_actionPerformed(ActionEvent e) {
		Dventas  Vent=new Dventas();
		Vent.setLocationRelativeTo(this);
		Vent.setVisible(true); 
	}
	protected void do_mntAlmaProduc_actionPerformed(ActionEvent e) {
		Dalmacen  Alma=new Dalmacen();
		Alma.setLocationRelativeTo(this);
		Alma.setVisible(true);
	}
	
	protected void do_mntProductos_actionPerformed(ActionEvent e) {
		DmanteniProducto ManiProduc=new DmanteniProducto();
		ManiProduc.setLocationRelativeTo(this);
		ManiProduc.setVisible(true);
	}
	protected void do_mntSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_mntEmpleados_actionPerformed(ActionEvent e) {
		DmanteniEmple ManiEmple=new DmanteniEmple();
		ManiEmple.setLocationRelativeTo(this);
		ManiEmple.setVisible(true);
	}
	protected void do_mntCliente_actionPerformed(ActionEvent e) {
		DmanteniCliente ManiCliente=new DmanteniCliente();
		ManiCliente.setLocationRelativeTo(this);
		ManiCliente.setVisible(true);
	}
}
