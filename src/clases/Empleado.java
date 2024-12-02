package clases;

public class Empleado {
	private int CodEmpleado;
	private String NomEmpleado,
				   ApeEmpleado,
				   DNI,
				   Direccion, 
				   Telefono,
				   Email;
	private double Salario;
	
	/*private static int AutoCodEm;
	
	static {
		AutoCodEm = 4001;
	}*/

	public Empleado(int codEmpleado, String nomEmpleado, String apeEmpleado, String dNI, String direccion,
			String telefono, String email, double salario) {
		
		CodEmpleado = codEmpleado;
		NomEmpleado = nomEmpleado;
		ApeEmpleado = apeEmpleado;
		DNI = dNI;
		Direccion = direccion;
		Telefono = telefono;
		Email = email;
		Salario = salario;
		
		//AutoCodEm++;
	}

	public int getCodEmpleado() {
		return CodEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		CodEmpleado = codEmpleado;
	}

	public String getNomEmpleado() {
		return NomEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		NomEmpleado = nomEmpleado;
	}

	public String getApeEmpleado() {
		return ApeEmpleado;
	}

	public void setApeEmpleado(String apeEmpleado) {
		ApeEmpleado = apeEmpleado;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		Salario = salario;
	}

	/*public static int getAutoCodEm() {
		return AutoCodEm;
	}

	public static void setAutoCodEm(int autoCodEm) {
		AutoCodEm = autoCodEm;
	}*/
	

	
}
