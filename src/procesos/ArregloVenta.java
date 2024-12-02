package procesos;

import clases.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArregloVenta {
	private ArrayList<Venta>ven;
	private ArrayList<DetalleVenta>detV;
	public ArregloVenta() {
		ven = new ArrayList<Venta>();
		detV = new ArrayList<DetalleVenta>();
		listadDetVenta();
		listadoVenta();
	}
	public void agregarVenta(Venta v) {
		ven.add(v);
	}
	public void agregarDetalle(DetalleVenta d) {
		detV.add(d);
	}
	public int cantVent() {
		return ven.size();	
	}
	public int cantDentVent() {
		return detV.size();
	}
	
	public Venta ObtenerV(int posicion) {
		return ven.get(posicion);
	}
	public DetalleVenta ObtenerD(int pos) {
		return detV.get(pos);
	}
	
	public Venta buscarV(int codV) {
		for(int i = 0;i < cantVent(); i++) 
			if(ObtenerV(i).getCodigoVenta() == codV)
				return ObtenerV(i);
		return null;
	}
	
	public void eliminarV(int posc){
		ven.remove(posc);
		detV.remove(posc);
	}
	
	public void grabarVenta() {
		try {
			PrintWriter pw;
			Venta objC;
			String linea;		
			pw = new PrintWriter(new FileWriter("Ventas.txt"));
			for(int i =0;i<cantVent();i++) {
				objC = ven.get(i);
				linea = objC.getCodigoVenta()+";"+
						objC.getCodCliente()+";"+
						objC.getCodEmple()+";"+
						objC.getDate()+";";
				pw.println(linea);				
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listadoVenta() {
		try {
			BufferedReader br;
			String linea;
			String Arreglo [];
			//declarar variables de los atributos
			int codV, codC, codE;
			String date;
			
			br = new BufferedReader(new FileReader("Ventas.txt"));
			while((linea=br.readLine())!=null) {
				Arreglo = linea.split(";");
				codV = Integer.parseInt(Arreglo[0]);
				codC = Integer.parseInt(Arreglo[1]);
				codE = Integer.parseInt(Arreglo[2]);
				date = Arreglo[3];
				
				agregarVenta(new Venta(codV, codC, codE, date));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void grabarDetVenta() {
		try {
			PrintWriter pw;
			DetalleVenta objC;
			String linea;		
			pw = new PrintWriter(new FileWriter("Detalle Ventas.txt"));
			for(int i =0;i<cantDentVent();i++) {
				objC = detV.get(i);
				linea = objC.getCodVent()+";"+
						objC.getCantidad()+";"+
						objC.getCodPro()+";"+
						objC.getPrecioU()+";";
				pw.println(linea);				
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listadDetVenta() {
		try {
			BufferedReader br;
			String linea;
			String Arreglo [];
			//declarar variables de los atributos
			int codV, cant, codP;
			Double Precio;
			
			br = new BufferedReader(new FileReader("Detalle Ventas.txt"));
			while((linea=br.readLine())!=null) {
				Arreglo = linea.split(";");
				codV = Integer.parseInt(Arreglo[0]);
				cant = Integer.parseInt(Arreglo[1]);
				codP = Integer.parseInt(Arreglo[2]);
				Precio = Double.parseDouble(Arreglo[3]);
				
				agregarDetalle(new DetalleVenta(codV, cant, codP, Precio));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int codAutoVenta() {
		if (cantVent() == 0)
			return 3001;
		else
			return ObtenerV(cantVent()-1).getCodigoVenta() + 1;
	}
		
}