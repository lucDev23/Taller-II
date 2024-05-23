package capa_logica;

import  value_objects.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import excepciones.*;

public interface IFachada extends Remote {
	public void registrarAsignatura(VOAsignatura voAsig) throws CodigoYaExisteException, AsignaturasLlenasException, RemoteException;
	public VOAsignatura[] listarAsignaturas() throws AsignaturasVaciaException, RemoteException;
	public void registrarAlumno(VOAlumnoRegistrado voAlumno) throws CedulaYaExisteException, RemoteException;
	public ArrayList<VOAlumnoApellido> listarPorApellido(String apellido) throws AlumnosVaciaException, NingunoConApellidoException, RemoteException;
	public VOAlumnoRegistrado listarPorCedula(int cedula) throws AlumnosVaciaException, AlumnoNoExisteException, RemoteException;
	public void inscripcionAsignatura(String codigo, int cedula, VOInscripcionRegistrada voInsc) throws AlumnoNoExisteException, AsignaturaNoExisteException, AsignaturaYaAprobadaException, AsignaturaSinNotaFinalException, MismoAnioLectivoException, AnioInvalidoException, RemoteException;
	public void resultadoAsignatura(int cedula, int nota, int numero) throws AlumnoNoExisteException, InscripcionNoExisteException, YaTieneNotaFinalException, RemoteException;
	public double montoRecaudado(int anioLectivo, int cedula) throws AlumnoNoExisteException, AnioNoCursadoException, AlumnoSinInscripcionesException, RemoteException;
	public ArrayList<? extends VOInscripcionParcial> consultarEscolaridad(int cedula, String modoListado) throws AlumnoNoExisteException, AlumnoSinInscripcionesException, EscolaridadParcialVaciaException, RemoteException;
	public ArrayList<? extends VOEgresadoParcial> listarEgresados(String modoListado) throws AlumnosVaciaException, SinEgresadosException, RemoteException;
	public void respaldarDatos() throws RemoteException, PersistenciaException; 
	public void recuperarDatos() throws RemoteException, PersistenciaException; 
}
