package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import GUIventanas.GUIInscripcionAsignatura;
import GUIventanas.GUIMensaje;
import capa_logica.IFachada;
import excepciones.AlumnoNoExisteException;
import excepciones.AnioInvalidoException;
import excepciones.AsignaturaNoExisteException;
import excepciones.AsignaturaSinNotaFinalException;
import excepciones.AsignaturaYaAprobadaException;
import excepciones.MismoAnioLectivoException;
import value_objects.VOInscripcionRegistrada;

public class ControladorInscripcionAsignatura {
	
	private IFachada fachada;
	private GUIInscripcionAsignatura ventana;
	
	public ControladorInscripcionAsignatura(GUIInscripcionAsignatura ventanaP) {
		try {
			ventana = ventanaP;
			
			Properties p = new Properties();
            String nomArch = "config/file.properties";
            p.load(new FileInputStream(nomArch));
            String ip = p.getProperty("serverIp");
            String port = p.getProperty("serverPort");
            String route = "//" + ip + ":" + port + "/fachada";		
            fachada = (IFachada) Naming.lookup(route);
			
		} catch (NotBoundException | IOException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		} 
	}
	
	public void inscripcionAsignatura(String codigo, int cedula, int anioLectivo, double montoBase) {
		try {
			VOInscripcionRegistrada voa = new VOInscripcionRegistrada(anioLectivo, montoBase);
			fachada.inscripcionAsignatura(codigo, cedula, voa);
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Inscripcion registrada con exito.", false);
		} catch(AlumnoNoExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(AsignaturaNoExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(AsignaturaYaAprobadaException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(AsignaturaSinNotaFinalException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(MismoAnioLectivoException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(AnioInvalidoException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
	}
}
