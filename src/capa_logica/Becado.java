package capa_logica;

public class Becado extends Alumno {
	
	private static final long serialVersionUID = 1L;
	
	private double porcentajeDesc;
	private String razonBeca;

	public Becado (int cedParam, String nomParam, String apeParam, String domicParam, String telParam, double porcentajeDescParam, String razonBecaParam) {
		super (cedParam, nomParam, apeParam, domicParam, telParam);
		porcentajeDesc = porcentajeDescParam;
		razonBeca = razonBecaParam;
	}
	
	public double getPorcentajeDesc () {
		return porcentajeDesc;
	}
	
	public String getRazonBeca () {
		return razonBeca;
	}
	
	public String tipoAlumno () {
		return "becado";
	}
}