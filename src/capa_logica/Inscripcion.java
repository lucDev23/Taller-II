package capa_logica;

import java.io.Serializable;

public class Inscripcion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private int anioLectivo;
	private double montoBase;
	private int calificacion;
	private Asignatura asignatura;
	
	public Inscripcion(int anioLectivoParam, double montoBaseParam, Asignatura asignaturaParam) {
		anioLectivo = anioLectivoParam;
		montoBase = montoBaseParam;
		calificacion = 0;
		asignatura = asignaturaParam;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getAnio() {
		return anioLectivo;
	}
	
	public double getMontoBase() {
		return montoBase;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public Asignatura getAsignatura() {
	  	return asignatura;
	}
	
	public void setNumero(int numeroParam) {
		numero = numeroParam;
	}
	
	public void setCalificacion(int calificacionParam) {
		calificacion = calificacionParam;
	}
}
 