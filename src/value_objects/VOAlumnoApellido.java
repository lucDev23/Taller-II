package value_objects;

public class VOAlumnoApellido extends VOEgresadoParcial{
	
	private static final long serialVersionUID = 1L;
	
	private String tipoAlumno;
	
	public VOAlumnoApellido(int cedParam, String nombreParam, String apellidoParam, String tipoAlumnoParam) {
		super(cedParam, nombreParam, apellidoParam);
		tipoAlumno = tipoAlumnoParam;
	}
	public String getTipoAlumno() {
		return tipoAlumno;
	}
	
}
