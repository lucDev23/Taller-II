package value_objects;

import java.io.Serializable;

public class VOInscripcionRegistrada extends VOInscripcionAbstact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private double montoBase;
	
	public VOInscripcionRegistrada(int anioLectivoParam, double montoBaseParam) {
		super (anioLectivoParam);
		montoBase = montoBaseParam;
		
	}
	
	public double getMontoBase() {
		return montoBase;
	}
	
	public int getAnio() {
		return anioLectivo;
	}
}
