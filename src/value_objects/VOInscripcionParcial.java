package value_objects;

public class VOInscripcionParcial extends VOInscripcionAbstact{
	
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private String nombreAsignatura;
	private int calificacion;
	
	public VOInscripcionParcial(int anioLectivoParam, int numeroParam, String nombreAsignaturaParam, int calificacionParam) {
		super(anioLectivoParam);
		numero = numeroParam;
		nombreAsignatura = nombreAsignaturaParam;
		anioLectivo = anioLectivoParam;
		calificacion = calificacionParam;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getAsignatura() {
		return nombreAsignatura;
	}
	
	public int getAnio() {
		return anioLectivo;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
}
