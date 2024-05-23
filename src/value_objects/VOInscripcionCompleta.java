package value_objects;

public class VOInscripcionCompleta extends VOInscripcionParcial {
	
	private static final long serialVersionUID = 1L;
	
	private double montoBase;
	
	public VOInscripcionCompleta(int anioLectivoParam, int numeroParam, String nombreAsignaturaParam, int calificacionParam, double montoBaseParam) {
		super(anioLectivoParam, numeroParam, nombreAsignaturaParam, calificacionParam);
		montoBase = montoBaseParam; 
	}
	
	public double getMontoBase() {
		return montoBase;
	}
}
