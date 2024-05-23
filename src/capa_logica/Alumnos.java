package capa_logica;

import java.io.Serializable;
import java.util.*;

import value_objects.VOAlumnoCedula;
import value_objects.VOAlumnoRegistrado;
import value_objects.VOBecadoCedula;
import value_objects.VOEgresadoCompleto;
import value_objects.VOEgresadoParcial;
import value_objects.VOAlumnoApellido;

public class Alumnos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TreeMap<Integer, Alumno> arbolAlumnos;
	
	private static Alumnos alumnos;
	
	private Alumnos() {
		arbolAlumnos = new TreeMap<Integer, Alumno>();
	}
	
	public static Alumnos getAlumnos() {
		if(alumnos == null) {
			alumnos = new Alumnos();
		}
		return alumnos;
	}
	
	public boolean empty() {
		return arbolAlumnos.size() == 0;
	}
	
	public boolean member(int cedula) {
		return arbolAlumnos.containsKey(cedula);
	}
	
	public void insert(Alumno alumno) {
		int cedula = alumno.getCedula();
		arbolAlumnos.put(cedula, alumno);
	}
	
	public Alumno find (int cedula) {
		return arbolAlumnos.get(cedula);
	}
	
	public ArrayList<VOAlumnoApellido> obtenerAlumnosPorApellido(String prefijo) {
		ArrayList<VOAlumnoApellido> lista =new ArrayList<VOAlumnoApellido>();
		Iterator<Alumno> iterador = arbolAlumnos.values().iterator();
		
		while (iterador.hasNext())
		{
			Alumno alumno = iterador.next();
			
			if (alumno.getApellido().startsWith(prefijo)) {
				VOAlumnoApellido voa= new VOAlumnoApellido(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.tipoAlumno());
				lista.add(voa);
			}
		
		}
		
		return lista;
	}
	
	public VOAlumnoRegistrado obtenerAlumnoPorCedula(int cedula) {
		
		Alumno alumno = find(cedula);
		VOAlumnoRegistrado voa;
		if (alumno instanceof Becado)
			voa = new VOBecadoCedula(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getDomicilio(), alumno.getTelefono(), ((Becado)alumno).getPorcentajeDesc(), ((Becado)alumno).getRazonBeca(), alumno.getCantAsigAprobadas(), ((Becado)alumno).tipoAlumno());
		else
			voa = new VOAlumnoCedula(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getDomicilio(), alumno.getTelefono(), alumno.getCantAsigAprobadas(), alumno.tipoAlumno());
		
		return voa;
	}
	
	public ArrayList<VOEgresadoParcial> obtenerAlumnosEgresadosParcial(int cantAsig) {
		
		ArrayList<VOEgresadoParcial> lista = new ArrayList<VOEgresadoParcial>();
		Iterator<Alumno> iterador = arbolAlumnos.values().iterator();
		
		while (iterador.hasNext())
		{
			Alumno alumno = iterador.next();
			
			if (alumno.alumnoEgresado(cantAsig)) {
				VOEgresadoParcial voe = new VOEgresadoParcial(alumno.getCedula(), alumno.getNombre(), alumno.getApellido());
				lista.add(voe);
			}
		
		}
		
		return lista;
	}
	
	public ArrayList<VOEgresadoCompleto> obtenerAlumnosEgresadosCompleto(int cantAsig) {
		
		ArrayList<VOEgresadoCompleto> lista = new ArrayList<VOEgresadoCompleto>();
		Iterator<Alumno> iterador = arbolAlumnos.values().iterator();
		
		while (iterador.hasNext())
		{
			Alumno alumno = iterador.next();
			
			if (alumno.alumnoEgresado(cantAsig)) {
				VOEgresadoCompleto voe= new VOEgresadoCompleto(alumno.getCedula(), alumno.getNombre(), alumno.getApellido(), alumno.getInscripciones().promedioTotal(), alumno.getInscripciones().promedioAprobadas());
				lista.add(voe);
			}
		
		}
		
		return lista;
	}
}