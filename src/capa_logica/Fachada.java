 package capa_logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Properties;

import excepciones.*;
import persistencia.Persistencia;
import value_objects.*;

public class Fachada extends UnicastRemoteObject implements IFachada {
	
	private static final long serialVersionUID = 1L;
	private Asignaturas asignaturas;
	private Alumnos alumnos;
	private Monitor monitor;
	private Persistencia persistencia;
	
	private static Fachada fachada;
	
	private Fachada() throws RemoteException{
		asignaturas = Asignaturas.getAsignaturas();
		alumnos = Alumnos.getAlumnos();
		monitor = Monitor.getMonitor();
		persistencia = Persistencia.getPersistencia();
	}
	
	public static Fachada getFachada() {
		if (fachada == null)
			try {
				fachada = new Fachada();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		return fachada;
	}
	
	// REQUERIMIENTOS:
	
	public synchronized void registrarAsignatura(VOAsignatura voAsig) throws CodigoYaExisteException, AsignaturasLlenasException, RemoteException {
		
		monitor.comienzoEscritura();
		
		if (asignaturas.getAsignaturasTotales() == Asignaturas.MAX) {
			monitor.terminoEscritura();
			throw new AsignaturasLlenasException("Ya no se pueden registrar mas asignaturas.");
		}
		
		String codigo = voAsig.getCodigo();
		if (asignaturas.member(codigo)) {
			monitor.terminoEscritura();
			throw new CodigoYaExisteException("Ya existe una asignatura con ese codigo.");
		}
		
		Asignatura asignatura = new Asignatura(codigo, voAsig.getNombre(), voAsig.getDescripcion());
		asignaturas.insert(asignatura);
		monitor.terminoEscritura();
	}
	
	public synchronized VOAsignatura[] listarAsignaturas() throws AsignaturasVaciaException, RemoteException {
		
		monitor.comienzoLectura();
		
		if (asignaturas.empty()) {
			monitor.terminoLectura();
			throw new AsignaturasVaciaException("No hay asignaturas registradas en el sistema.");
		}
		
		VOAsignatura voa[] = asignaturas.obtenerAsignaturas();
		monitor.terminoLectura();
		
		return voa;
	}
	
	public synchronized void registrarAlumno(VOAlumnoRegistrado voAlumno) throws CedulaYaExisteException, RemoteException {
        
		monitor.comienzoEscritura();

		int cedula = voAlumno.getCedula();
        if (alumnos.member(cedula)) {
            monitor.terminoEscritura();
            throw new CedulaYaExisteException("Ya existe un alumno con esa cedula.");
        } 
        Alumno alumno;
        
        if (voAlumno instanceof VOBecadoRegistrado) {
        	double porcentajeDesc = ((VOBecadoRegistrado) voAlumno).getPorcentajeDesc();
        	String razonBeca = ((VOBecadoRegistrado) voAlumno).getRazonBeca();
            alumno = new Becado(voAlumno.getCedula(), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getDomicilio(), voAlumno.getTelefono(), porcentajeDesc, razonBeca);
        } else {
        	alumno = new Alumno(voAlumno.getCedula(), voAlumno.getNombre(), voAlumno.getApellido(), voAlumno.getDomicilio(), voAlumno.getTelefono());
        }
        
        alumnos.insert(alumno);
        monitor.terminoEscritura();
    }
	
	public synchronized ArrayList<VOAlumnoApellido> listarPorApellido(String apellido) throws AlumnosVaciaException, NingunoConApellidoException, RemoteException {

        monitor.comienzoLectura();

        if (alumnos.empty()) {
            monitor.terminoLectura();
            throw new AlumnosVaciaException("No hay alumnos registrados en el sistema.");
        }

        ArrayList<VOAlumnoApellido> listaApellidos = alumnos.obtenerAlumnosPorApellido(apellido);

        if (listaApellidos.isEmpty()) { 
            monitor.terminoLectura();
            throw new NingunoConApellidoException("No hay alumnos con ese apellido en el sistema.");
        }

        monitor.terminoLectura();
        return listaApellidos;
    }
	
	public synchronized VOAlumnoRegistrado listarPorCedula(int cedula) throws AlumnosVaciaException, AlumnoNoExisteException, RemoteException {

        monitor.comienzoLectura();
        
        if (alumnos.empty()) {
            monitor.terminoLectura();
            throw new AlumnosVaciaException("No hay alumnos registrados en el sistema.");
        }

        if(!alumnos.member(cedula)) {
            monitor.terminoLectura();
            throw new AlumnoNoExisteException("No existe un alumno con esa cedula.");
        }

        VOAlumnoRegistrado voc = alumnos.obtenerAlumnoPorCedula(cedula);
        monitor.terminoLectura();
        return voc;
    }
	
	public synchronized void inscripcionAsignatura(String codigo, int cedula, VOInscripcionRegistrada voInsc) throws AlumnoNoExisteException, AsignaturaNoExisteException, 
	AsignaturaYaAprobadaException, AsignaturaSinNotaFinalException, MismoAnioLectivoException, AnioInvalidoException, RemoteException {
		
		monitor.comienzoEscritura();
		
		if (!alumnos.member(cedula)) {
			monitor.terminoEscritura();
			throw new AlumnoNoExisteException("No existe un alumno con esa cedula.");
		}
		
		if (!asignaturas.member(codigo)) {
			monitor.terminoEscritura();
			throw new AsignaturaNoExisteException("No existe una asignatura con ese codigo.");
		}
		
		Inscripciones inscripciones = alumnos.find(cedula).getInscripciones();
		
		if (inscripciones.yaAprobada(codigo)) {
			monitor.terminoEscritura();
			throw new AsignaturaYaAprobadaException("El alumno ya aprobo esa asignatura.");
		}
		
		if (inscripciones.inscripcionSinCalificacion(codigo)) {
			monitor.terminoEscritura();
			throw new AsignaturaSinNotaFinalException("El alumno ya esta cursando esa materia.");
		}
		
		int anioLectivo = voInsc.getAnio();
		if (inscripciones.asignaturaMismoAnio(codigo, anioLectivo)) {
			monitor.terminoEscritura();
			throw new MismoAnioLectivoException("Asignatura ya cursada en ese año.");
		}
		
		if (!inscripciones.anioValido(anioLectivo)) {
			monitor.terminoEscritura();
			throw new AnioInvalidoException("El año ingresado es anterior al de la ultima inscripcion.");
		}
		
		Inscripcion inscripcion = new Inscripcion(anioLectivo, voInsc.getMontoBase(), asignaturas.find(codigo));
		inscripciones.insert(inscripcion);
		monitor.terminoEscritura();
	}
	
	public synchronized void resultadoAsignatura(int cedula, int nota, int numero) throws AlumnoNoExisteException, InscripcionNoExisteException, YaTieneNotaFinalException, RemoteException {
        
		monitor.comienzoEscritura();

        if (!alumnos.member(cedula)) {
        	monitor.terminoEscritura();
			throw new AlumnoNoExisteException("No existe un alumno con esa cedula.");
        }
        
        Inscripciones inscripciones = alumnos.find(cedula).getInscripciones();
        			
        if (!inscripciones.member(numero)){
            monitor.terminoEscritura();
            throw new InscripcionNoExisteException("No existe una inscripcion con ese numero.");
        }
        
        Inscripcion inscripcion = inscripciones.find(numero);
        if (inscripcion.getCalificacion() != 0) {
            monitor.terminoEscritura();
            throw new YaTieneNotaFinalException("La inscripcion ya tiene nota final.");
        }
        
        inscripcion.setCalificacion(nota);
        if (nota >= 6) alumnos.find(cedula).aumentarAprobadas();
     
        monitor.terminoEscritura();
    }
	
	public synchronized double montoRecaudado(int anioLectivo, int cedula) throws AlumnoNoExisteException, AnioNoCursadoException, AlumnoSinInscripcionesException, RemoteException {
		
		monitor.comienzoLectura();
		
		if (!alumnos.member(cedula)) {
			monitor.terminoLectura();
			throw new AlumnoNoExisteException("No existe un alumno con esa cedula.");
		}
		
		Alumno alumno = alumnos.find(cedula);
		Inscripciones inscripciones = alumno.getInscripciones();
		
		if (inscripciones.empty()) {
			monitor.terminoLectura();
			throw new AlumnoSinInscripcionesException("El alumno no tiene inscripciones.");
		}
		
		if (!inscripciones.anioCursado(anioLectivo)) {
			monitor.terminoLectura();
			throw new AnioNoCursadoException("El almuno no curso ninguna materia en ese año.");
		}
		
		double montoTotal = inscripciones.calcularMontoTotal(anioLectivo);
		
		if (alumno instanceof Becado) {
			double descuento = montoTotal * (((Becado) alumno).getPorcentajeDesc() / 100);
			montoTotal -= descuento;
		}
		
		monitor.terminoLectura();
		return montoTotal;
	}
	
	public synchronized ArrayList<? extends VOInscripcionParcial> consultarEscolaridad(int cedula, String modoListado) throws AlumnoNoExisteException, AlumnoSinInscripcionesException, EscolaridadParcialVaciaException, RemoteException {

        monitor.comienzoLectura();

        if(!alumnos.member(cedula)) {
            monitor.terminoLectura();
            throw new AlumnoNoExisteException("No existe un alumno con esa cedula.");
        }
        
        if(alumnos.find(cedula).getInscripciones().empty()) {
            monitor.terminoLectura();
            throw new AlumnoSinInscripcionesException("El alumno no tiene inscripciones.");
        }

        ArrayList<? extends VOInscripcionParcial> listaInscripciones;
        if(modoListado.equals("parcial"))
            listaInscripciones = alumnos.find(cedula).getInscripciones().obtenerInscripcionesParciales();
        else
            listaInscripciones = alumnos.find(cedula).getInscripciones().obtenerInscripcionesCompletas();

        if(listaInscripciones.isEmpty()) {
        	monitor.terminoLectura();
        	throw new EscolaridadParcialVaciaException("El alumno no tiene nota final en ninguna de las asignaturas.");
        }
        
        monitor.terminoLectura();
        return listaInscripciones;
    }
	
	
	public synchronized ArrayList<? extends VOEgresadoParcial> listarEgresados(String modoListado) throws AlumnosVaciaException, SinEgresadosException, RemoteException {
		
		monitor.comienzoLectura();
		
		if (alumnos.empty()) {
			monitor.terminoLectura();
			throw new AlumnosVaciaException("No hay alumnos registrados en el sistema.");
		}
		
		ArrayList<? extends VOEgresadoParcial> voe;
		if (modoListado.equals("parcial")) {
			voe = alumnos.obtenerAlumnosEgresadosParcial(asignaturas.getAsignaturasTotales());
		} else {
			voe = alumnos.obtenerAlumnosEgresadosCompleto(asignaturas.getAsignaturasTotales());
		}
		
		if (voe.isEmpty()) {
			monitor.terminoLectura();
			throw new SinEgresadosException("No hay alumnos egresados.");
		}
		
		monitor.terminoLectura();
		return voe;
	}
	
	public synchronized void respaldarDatos() throws RemoteException, PersistenciaException{

        monitor.comienzoLectura();

        VOCapaLogica voc = new VOCapaLogica(asignaturas, alumnos); 
        Properties p = new Properties();
        String file = "config/file.properties";
        
        try {
            p.load(new FileInputStream(file));
            String fileName = p.getProperty("fileName");
            
            persistencia.respaldar(fileName, voc);
            
            monitor.terminoLectura();
        } catch(PersistenciaException e) {
        	monitor.terminoEscritura();
        	throw new PersistenciaException("Error al recuperar.");
        } catch(IOException e) {
        	monitor.terminoEscritura();
        	throw new PersistenciaException("Error al recuperar.");
        }
    }

	public synchronized void recuperarDatos() throws RemoteException, PersistenciaException {

	    monitor.comienzoEscritura();
	
	    VOCapaLogica voc; 
        Properties p = new Properties();
        String file = "config/file.properties";
	    
        try {
        	p.load(new FileInputStream(file));
        	String fileName = p.getProperty("fileName");
        	
        	voc = persistencia.restaurar(fileName);
        	if(voc != null) {
        		alumnos = voc.getAlumnos();
        	    asignaturas = voc.getAsignaturas();
        	}
	    monitor.terminoEscritura();
        } catch(PersistenciaException e) {
        	monitor.terminoEscritura();
        	throw new PersistenciaException("Error al recuperar.");
        } catch(IOException e) {
        	monitor.terminoEscritura();
        	throw new PersistenciaException("Error al recuperar.");
        }
	}
}
