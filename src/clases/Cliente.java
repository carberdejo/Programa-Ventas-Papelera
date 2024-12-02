package clases;

public class Cliente {
	private int CodCliente;
	private String nomCliente;
	private String apeCliente;
	private String Direccion; 
	private String Telefono;
	private String DNI;
	private String Email;
	
	/*public static int AutoCod;
	
	static {
		AutoCod = 1001;
	}*/

	
	public Cliente(int codCliente, String nomCliente, String apeCliente, String direccion, String telefono, String dNI,
			String email) {
		
		/*if(CodCliente >= AutoCod) {
			AutoCod = codCliente+1;
		}else*/
		CodCliente = codCliente;
		
		this.nomCliente = nomCliente;
		this.apeCliente = apeCliente;
		Direccion = direccion;
		Telefono = telefono;
		DNI = dNI;
		Email = email;
		//AutoCod++;
		
	}
	




	public int getCodCliente() {
		return CodCliente;
	}

	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getApeCliente() {
		return apeCliente;
	}

	public void setApeCliente(String apeCliente) {
		this.apeCliente = apeCliente;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	/*public static int getAutoCod() {
		return AutoCod;
	}

	public static void setAutoCod(int autoCod) {
		AutoCod = autoCod;
	}*/

}
