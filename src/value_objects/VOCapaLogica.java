package value_objects;

import java.io.Serializable;

import capa_logica.Alumnos;
import capa_logica.Asignaturas;

public class VOCapaLogica implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Asignaturas asignaturas;
	private Alumnos alumnos;
	
	public VOCapaLogica(Asignaturas asignaturasParam, Alumnos alumnosParam) {
		asignaturas = asignaturasParam;
		alumnos = alumnosParam;
	}
	
	public Asignaturas getAsignaturas() {
		return asignaturas;
	}
	
	public Alumnos getAlumnos() {
		return alumnos;
	}
}
