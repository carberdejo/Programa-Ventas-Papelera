package clases;

public class Producto {
	private int CodProducto;
	private String NomProducto;
	private double PrecioProducto;
	private int StockActual;
	private int StockMin;
	private int StockMax;
	private String Acabado;
	
	
	public Producto(int codProducto, String nomProducto,double precioProducto, int stockActual, int stockMin,
			int stockMax, String acabado) {
		
		CodProducto = codProducto;
		PrecioProducto = precioProducto;
		NomProducto = nomProducto;
		StockActual = stockActual;
		StockMin = stockMin;
		StockMax = stockMax;
		Acabado = acabado;
					
	}

	

public int getCodProducto() {
		return CodProducto;
	}



	public void setCodProducto(int codProducto) {
		CodProducto = codProducto;
	}



	public String getNomProducto() {
		return NomProducto;
	}



	public void setNomProducto(String nomProducto) {
		NomProducto = nomProducto;
	}



	public double getPrecioProducto() {
		return PrecioProducto;
	}



	public void setPrecioProducto(double precioProducto) {
		PrecioProducto = precioProducto;
	}



	public int getStockActual() {
		return StockActual;
	}



	public void setStockActual(int stockActual) {
		StockActual = stockActual;
	}



	public int getStockMin() {
		return StockMin;
	}



	public void setStockMin(int stockMin) {
		StockMin = stockMin;
	}



	public int getStockMax() {
		return StockMax;
	}



	public void setStockMax(int stockMax) {
		StockMax = stockMax;
	}



	public String getAcabado() {
		return Acabado;
	}



	public void setAcabado(String acabado) {
		Acabado = acabado;
	}

}
