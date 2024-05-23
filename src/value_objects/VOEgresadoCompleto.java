package value_objects;

public class VOEgresadoCompleto extends VOEgresadoParcial {
	
	private static final long serialVersionUID = 1L;
	
	private double promedioTotal;
	private double promedioAprobado;

	public VOEgresadoCompleto(int cedulaParam, String nombreParam, String apellidoParam, double promedioTotalParam, double promedioAprobadoParam) {
		super(cedulaParam, nombreParam, apellidoParam);
		promedioTotal = promedioTotalParam;
		promedioAprobado = promedioAprobadoParam;
	}
	
	public double getPromedioTotal() {
		return promedioTotal;
	}
	
	public double getPromedioAprobado() {
		return promedioAprobado;
	}
}
