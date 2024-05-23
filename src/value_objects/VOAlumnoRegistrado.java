package value_objects;

public class VOAlumnoRegistrado extends VOEgresadoParcial {
	
	private static final long serialVersionUID = 1L;
	
	private String domicilio;
	private String telefono;
	
	public VOAlumnoRegistrado(int cedParam, String nombreParam, String apellidoParam, String domicParam, String telParam) {
		super (cedParam, nombreParam, apellidoParam);
		domicilio = domicParam;
		telefono = telParam;
	}
	
	public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public int getCantAprobadas() {
        return -1;
    }
    
    public String getTipoAlumno() {
    	return "-1";
    }
}
