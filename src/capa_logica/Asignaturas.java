package capa_logica;

import java.io.Serializable;

import value_objects.VOAsignatura;

public class Asignaturas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected static final int MAX = 10;
	private Asignatura arregloAsignaturas [];
	private int tope;
	
	private static Asignaturas asignaturas;
	
	private Asignaturas() {
		arregloAsignaturas = new Asignatura[MAX];
		tope = 0;
	}
	
	public static Asignaturas getAsignaturas() {
		if(asignaturas == null) {
			asignaturas = new Asignaturas();
		}
		return asignaturas;
	}
	
	public int getAsignaturasTotales() {
		return tope;
	}
	
	public boolean empty() {
		return tope == 0;
	}
	
	public void insert(Asignatura asignatura) {
		arregloAsignaturas[tope] = asignatura;
		tope++;
	}
	
	public boolean member(String codigo) {
		int i = 0;
		boolean encontre = false;
		while(i < tope && !encontre) {
			encontre = arregloAsignaturas[i].getCodigo().equals(codigo);
			i++;
		}
		return encontre;
	}
	
	public Asignatura find(String codigo) {
		int i = 0;
		while(arregloAsignaturas[i].getCodigo().equals(codigo) == false) {
			i++;
		}
		return arregloAsignaturas[i];
	}
	
	public VOAsignatura[] obtenerAsignaturas() {
		VOAsignatura voa [] = new VOAsignatura[tope];
		for(int i = 0; i < tope; i++) {
			voa[i] = new VOAsignatura(arregloAsignaturas[i].getCodigo(), arregloAsignaturas[i].getNombre(), arregloAsignaturas[i].getDescripcion());
		}
		return voa;
	}
}
