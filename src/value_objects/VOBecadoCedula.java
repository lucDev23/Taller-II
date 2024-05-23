package value_objects;

public class VOBecadoCedula extends VOBecadoRegistrado {
	
	private static final long serialVersionUID = 1L;
	
	private int cantAprobadas;
	private String tipoAlumno;
	
	public VOBecadoCedula (int cedParam, String nombreParam, String apellidoParam, String domicParam, String telParam, double porcentajeDescParam, String razonBecaParam, int cantAsigAprobadasParam, String tipoAlumnoParam) {
		super(cedParam, nombreParam, apellidoParam, domicParam, telParam, porcentajeDescParam, razonBecaParam);
		cantAprobadas = cantAsigAprobadasParam;
		tipoAlumno = tipoAlumnoParam;
	}
	
	public int getCantAprobadas() {
		return cantAprobadas;
	}
	
	public String getTipoAlumno() {
		return tipoAlumno;
	}
}
