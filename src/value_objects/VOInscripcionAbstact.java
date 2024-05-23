package value_objects;

import java.io.Serializable;

public abstract class VOInscripcionAbstact implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int anioLectivo;
	
	public VOInscripcionAbstact (int anioLectivoParam) {
		anioLectivo = anioLectivoParam;
	}
	
	public abstract int getAnio();
}
