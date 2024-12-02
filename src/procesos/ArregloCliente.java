package procesos;
import clases.Cliente;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArregloCliente {
private ArrayList<Cliente>cli;
	
	public ArregloCliente(){
		cli = new ArrayList<Cliente>();
		listadoCliente();
	}
	public void agregarCliente(Cliente c) {
		cli.add(c);
	}
	
	public int cantClientes() {
		return cli.size();
	}
	
	public Cliente obtener(int posicion) {
		return cli.get(posicion);
	}
	
	public Cliente buscarCLi(int cod) {
		for(int x =0;x<cantClientes();x++)
			if(obtener(x).getCodCliente() == cod)
				return obtener(x);
		return null;
	}
	
	public void eliminar(Cliente obj) {
		cli.remove(obj);
	}
	public void eliminartodo() {
		cli.removeAll(cli);
	}
	
	public void grabarCliente() {
		try {
			PrintWriter pw;
			Cliente objC;
			String linea;		
			pw = new PrintWriter(new FileWriter("Clientes.txt"));
			for(int i =0;i<cantClientes();i++) {
				objC = cli.get(i);
				linea = objC.getCodCliente()+";"+
						objC.getNomCliente()+";"+
						objC.getApeCliente()+";"+
						objC.getDNI()+";"+
						objC.getTelefono()+";"+
						objC.getDireccion()+";"+
						objC.getEmail();
				pw.println(linea);
				
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listadoCliente() {
		try {
			BufferedReader br;
			String linea;
			String Arreglo [];
			//declarar variables de los atributos
			int cod;
			String nom,ape,dni,tele,dir,email;
			
			br = new BufferedReader(new FileReader("Clientes.txt"));
			while((linea=br.readLine())!=null) {
				Arreglo = linea.split(";");
				cod = Integer.parseInt(Arreglo[0]);
				nom = Arreglo[1];
				ape = Arreglo[2];
				dni = Arreglo[3];
				tele = Arreglo[4];
				dir = Arreglo[5];
				email = Arreglo[6];
				
				agregarCliente(new Cliente(cod, nom, ape, dir, tele, dni, email));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Adicional haha :D
	
	
	public int numeroauto() {
		if (cantClientes() == 0)
			return 1001;
		else
			return obtener(cantClientes()-1).getCodCliente() + 1;
	}

}
