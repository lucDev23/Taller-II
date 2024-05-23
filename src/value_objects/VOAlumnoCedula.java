package value_objects;

public class VOAlumnoCedula extends VOAlumnoRegistrado {
	
	private static final long serialVersionUID = 1L;
	
	private int cantAsigAprobadas;
	private String tipoAlumno;

	public VOAlumnoCedula (int cedParam, String nombreParam, String apellidoParam, String domicParam, String telParam, int cantiAsigAprobadasParam, String tipoAlumnoParam) {
		super (cedParam, nombreParam, apellidoParam, domicParam, telParam);
		cantAsigAprobadas = cantiAsigAprobadasParam;
		tipoAlumno = tipoAlumnoParam;
	}

    public int getCantAprobadas() {
        return cantAsigAprobadas;
    }
    
    public String getTipoAlumno() {
    	return tipoAlumno;
    }
}
