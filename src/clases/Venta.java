package clases;

public class Venta {
	private int codigoVenta;
	private int codCliente,codEmple;	
	private String date;
	
	private static int cantidadV;
	
	public static final double IGV;
	
	static {
		IGV = 0.18;
		cantidadV = 0;
	}

	public Venta(int codigoVenta, int codCliente, int codEmple, String date) {
		this.codigoVenta = codigoVenta;
		this.codCliente = codCliente;
		this.codEmple = codEmple;
		this.date = date;
		cantidadV++;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodEmple() {
		return codEmple;
	}

	public void setCodEmple(int codEmple) {
		this.codEmple = codEmple;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static int getCantidadV() {
		return cantidadV;
	}

	public static void setCantidadV(int cantidadV) {
		Venta.cantidadV = cantidadV;
	}
	
	
	
	
	
}
