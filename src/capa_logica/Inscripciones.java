package capa_logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import value_objects.VOInscripcionCompleta;
import value_objects.VOInscripcionParcial;

public class Inscripciones implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Inscripcion> inscripciones;
	
	public Inscripciones() {
		inscripciones = new ArrayList<Inscripcion>();
	}
	
	public boolean empty() {
		return inscripciones.isEmpty();
	}
	
	public boolean member(int clave) {
		return inscripciones.size() >= clave && clave > 0;
	}
	
	public void insert(Inscripcion inscripcion) {
		inscripcion.setNumero(inscripciones.size() + 1);
		inscripciones.add(inscripcion);
	}
	
	public Inscripcion find(int clave) {
		return inscripciones.get(clave - 1);
	}
	
	
	public ArrayList<VOInscripcionCompleta> obtenerInscripcionesCompletas() {
		ArrayList<VOInscripcionCompleta> lista = new ArrayList<VOInscripcionCompleta>();
		Iterator<Inscripcion> iterador = inscripciones.iterator();
		
		while(iterador.hasNext()) {
			Inscripcion i = iterador.next();

			VOInscripcionCompleta voi = new VOInscripcionCompleta(i.getAnio(), i.getNumero(), i.getAsignatura().getNombre(), i.getCalificacion(), i.getMontoBase());
			
			lista.add(voi);
		}
		
		return lista;
	}
	
	public ArrayList<VOInscripcionParcial> obtenerInscripcionesParciales() {
		ArrayList<VOInscripcionParcial> lista = new ArrayList<VOInscripcionParcial>();
		Iterator<Inscripcion> iterador = inscripciones.iterator();
		
		while(iterador.hasNext()) {
			Inscripcion i = iterador.next();
			if (i.getCalificacion() != 0) {
				VOInscripcionParcial voi = new VOInscripcionParcial(i.getAnio(), i.getNumero(), i.getAsignatura().getNombre(), i.getCalificacion());
				lista.add(voi);
			}
		}
		
		return lista;
	}
	
	public double promedioTotal () {
		Iterator<Inscripcion> iterador = inscripciones.iterator();
		int cont = 0;
		double promedio = 0.0;
		
		while(iterador.hasNext()) {
			Inscripcion i = iterador.next();
			promedio = promedio + i.getCalificacion();
			cont++;
		}
		return promedio / cont;
	}
	
	public double promedioAprobadas () {
		Iterator<Inscripcion> iterador = inscripciones.iterator();
		int cont = 0;
		double promedio = 0.0;
		
		while(iterador.hasNext()) {
			Inscripcion i = iterador.next();
			if (i.getCalificacion() > 5) { 
				promedio = promedio + i.getCalificacion();
				cont++;
			}
		}
		return promedio / cont;
	}
	
	public boolean yaAprobada(String codigo) {
		Iterator<Inscripcion> iterador = inscripciones.iterator();
		boolean aprobada = false;
		
		while(iterador.hasNext() && !aprobada) {
			Inscripcion i = iterador.next();
			if (i.getAsignatura().getCodigo().equals(codigo) && i.getCalificacion() > 5) { 
				aprobada = true;
			}
		}
		
		return aprobada;
	}
	
	public boolean inscripcionSinCalificacion(String codigo) {
        Iterator<Inscripcion> iterador = inscripciones.iterator();
        boolean sinCalificacion = false;
        
        while(iterador.hasNext() && !sinCalificacion) {
            Inscripcion i = iterador.next();
            if(i.getAsignatura().getCodigo().equals(codigo)) {
                if(i.getCalificacion() == 0) {
                    sinCalificacion = true;
                }
            }
        }
        return sinCalificacion;
    }
	
	public boolean asignaturaMismoAnio (String codigo, int anio) {
        Iterator<Inscripcion> iterador = inscripciones.iterator();
        boolean existeMismaAsigEnAnio = false;

        while(iterador.hasNext() && !existeMismaAsigEnAnio) {
            Inscripcion i = iterador.next();
            String codigoEnInscripcionAsig = i.getAsignatura().getCodigo();

            if (codigoEnInscripcionAsig.equals(codigo)) {
                if (i.getAnio() == anio)
                    existeMismaAsigEnAnio = true;
            }
        }
        
        return existeMismaAsigEnAnio;
    }
	
	public boolean anioValido(int anio) {
		if (inscripciones.isEmpty()) return true;
		int pos = inscripciones.size() - 1;
		return inscripciones.get(pos).getAnio() <= anio;
	}
	
	public double calcularMontoTotal(int anioLectivo) {
		Iterator<Inscripcion> iterador = inscripciones.iterator();
        double suma = 0.0;

        while(iterador.hasNext()) {
            Inscripcion i = iterador.next();
            if (i.getAnio() == anioLectivo) suma += i.getMontoBase() * 9;
        }
        
        return suma;
	}
	
	public boolean anioCursado(int anio) {
		int pos = inscripciones.size() - 1;
		if (inscripciones.get(pos).getAnio() < anio) return false;
		
		Iterator<Inscripcion> iterador = inscripciones.iterator();
		boolean curso = false;
		
		while(!curso && iterador.hasNext()) {
			Inscripcion i = iterador.next();
			if (i.getAnio() == anio) curso = true;
		}
		
		return curso;
	}
}
