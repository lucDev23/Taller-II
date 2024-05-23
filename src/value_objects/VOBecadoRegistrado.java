package value_objects;

public class VOBecadoRegistrado extends VOAlumnoRegistrado {
	
	private static final long serialVersionUID = 1L;
	
	private double porcentajeDescuento;
	private String razonBeca;
	
	public VOBecadoRegistrado(int cedulaParam, String nombreParam, String apellidoParam, String domicilioParam, String telefonoParam, double porcentajeDescParam, String razonBecaParam) {
		super(cedulaParam, nombreParam, apellidoParam, domicilioParam, telefonoParam);
		porcentajeDescuento = porcentajeDescParam;
		razonBeca = razonBecaParam;
				
	}
	
	public double getPorcentajeDesc () {
		return porcentajeDescuento;
	}
	
	public String getRazonBeca () {
		return razonBeca;
	}
}
