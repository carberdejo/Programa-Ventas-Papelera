package clases;
//import clases.Venta;

public class DetalleVenta {
	private int codVent,codPro,cantidad;
	private double precioU;
	
	public DetalleVenta(int codVent, int codPro, int cantidad, double precioU) {
		this.codVent = codVent;
		this.codPro = codPro;
		this.cantidad = cantidad;
		this.precioU = precioU;
	}
	
	public int getCodVent() {
		return codVent;
	}


	public void setCodVent(int codVent) {
		this.codVent = codVent;
	}


	public int getCodPro() {
		return codPro;
	}


	public void setCodPro(int codPro) {
		this.codPro = codPro;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioU() {
		return precioU;
	}


	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}
	
	
	//metodos de operacion

	public  double importe() {
		return precioU*cantidad;
	}
	public double importeIGV() {
		return importe()*Venta.IGV;
	}
	public double importeTotal() {
		return importe()+importeIGV();
	}
	
}
