package procesos;

import clases.Empleado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloEmpleado {
	private ArrayList<Empleado>emp;
	
	public ArregloEmpleado() {
		emp = new ArrayList<Empleado>();
		//emp.add(new Empleado(4001, "Nicole", "Silva Montero", "Av. José Larco 812, Miraflores","922111019","01298734","NicoleSilv00@gmail.com",102.3));
		//emp.add(new Empleado(4002, "Aaron", "Flores Cervantes", "Av. Pardo 600, Miraflores", "324556799", "00129312", "Worker129@gmail.com",1212));
		//emp.add(new Empleado(4003, "Valeria", "Vargas Romero", "Av. Universitaria 2000, San Miguel", "091274998", "98334340", "Fallingstar00001@gmail.com",122));
		//emp.add(new Empleado(4004, "Laura", "Fernandez Gomez", "Av. San Luis 1000, San Borja", "992022130", "6098010", "FuturePromise@gmail.com",1212));
		//emp.add(new Empleado(4005, "Ricardo ", "Ruiz Soto", "Calle José Galvez 150, Barranco", "332400958", "11293300", "Ricardo1029@gmail.com",122));
		listadoEmpleado();
	}
	public void AgregarEmpleado(Empleado e) {
			 emp.add(e);
		}
	
	public int cantEmple() {
		return emp.size();
	}
	
	public Empleado Obtener(int Posicion) {
		return emp.get(Posicion);
	}
	
	public void EliminarE(Empleado obj) {
		emp.remove(obj);
	}
	
	public void eliminartodo() {
		emp.removeAll(emp);
	}
	public Empleado buscaE(int cod){
		for(int i=0;i<cantEmple();i++) 
			if(Obtener(i).getCodEmpleado() == cod)
				return Obtener(i);
			return null;
	}
	
	public void grabarEmpleado() {
		try {
			PrintWriter pw;
			Empleado objE;
			String linea;		
			pw = new PrintWriter(new FileWriter("Empleados.txt"));
			for(int i =0;i<cantEmple();i++) {
				objE = emp.get(i);
				linea = objE.getCodEmpleado()+";"+
						objE.getNomEmpleado()+";"+
						objE.getApeEmpleado()+";"+
						objE.getDNI()+";"+
						objE.getTelefono()+";"+
						objE.getDireccion()+";"+
						objE.getEmail()+";"+
						objE.getSalario();
						
				pw.println(linea);
				
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void listadoEmpleado() {
		try {
			BufferedReader br;
			String linea;
			String Arreglo [];
			//declarar variables de los atributos
			int cod;
			String nom,ape,dni,tele,dir,email;
			double salar;
			
			br = new BufferedReader(new FileReader("Empleados.txt"));
			while((linea=br.readLine())!=null) {
				Arreglo = linea.split(";");
				cod = Integer.parseInt(Arreglo[0]);
				nom = Arreglo[1];
				ape = Arreglo[2];
				dni = Arreglo[3];
				tele = Arreglo[4];
				dir = Arreglo[5];
				email = Arreglo[6];
				salar = Double.parseDouble(Arreglo[7]);
				
				AgregarEmpleado(new Empleado(cod, nom, ape, dni, dir, tele, email, salar));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int codAutoEmpleado() {
		if (cantEmple() == 0)
			return 4001;
		else
			return Obtener(cantEmple()-1).getCodEmpleado() + 1;
	}
	
}
