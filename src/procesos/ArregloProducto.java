package procesos;

import clases.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloProducto {
	private ArrayList<Producto>prod;

	public ArregloProducto() {
		prod = new ArrayList<Producto>();
		listadoProducto();
	}
	
	public void agregarProducto(Producto p) {
		prod.add(p);
	}
	
	public int cantProducto() {
		return prod.size();
	}
	
	public Producto obtener(int posicion) {
		return prod.get(posicion);
	}
	
	public Producto buscarPro(int cod) {
		for(int x = 0;x<cantProducto();x++) {
			if(obtener(x).getCodProducto() == cod)
				return obtener(x);
			
		}return null;
	}
	
	public void eliminarPro(Producto objP) {
		prod.remove(objP);
	}
	public void eliminartodo() {
		prod.removeAll(prod);
	}
	public void grabarProducto() {
		try {
			PrintWriter pw;
			Producto objC;
			String linea;		
			pw = new PrintWriter(new FileWriter("Productos.txt"));
			for(int i =0;i<cantProducto();i++) {
				objC = prod.get(i);
				linea = objC.getCodProducto()+";"+
						objC.getNomProducto()+";"+
						objC.getPrecioProducto()+";"+
						objC.getStockActual()+";"+
						objC.getStockMin()+";"+
						objC.getStockMax()+";"+
						objC.getAcabado();
				pw.println(linea);
				
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listadoProducto() {
		try {
			BufferedReader br;
			String linea;
			String Arreglo [];
			//declarar variables de los atributos
			int cod,sActual,sMin,sMax;
			String nom,acabado;
			double precio;
			
			br = new BufferedReader(new FileReader("Productos.txt"));
			while((linea=br.readLine())!=null) {
				Arreglo = linea.split(";");
				cod = Integer.parseInt(Arreglo[0]);
				nom = Arreglo[1];
				precio = Double.parseDouble(Arreglo[2]);
				sActual =Integer.parseInt( Arreglo[3]);
				sMin = Integer.parseInt(Arreglo[4]);
				sMax = Integer.parseInt(Arreglo[5]);
				acabado = Arreglo[6];
				
				agregarProducto(new Producto(cod, nom, precio, sActual, sMin, sMax, acabado));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int codAutoProducto() {
		if (cantProducto() == 0)
			return 100001;
		else
			return obtener(cantProducto()-1).getCodProducto() + 1;
	}
}
