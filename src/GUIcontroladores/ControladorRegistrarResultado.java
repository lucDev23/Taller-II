package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import GUIventanas.GUIMensaje;
import GUIventanas.GUIRegistrarResultado;
import capa_logica.IFachada;
import excepciones.AlumnoNoExisteException;
import excepciones.InscripcionNoExisteException;
import excepciones.YaTieneNotaFinalException;

public class ControladorRegistrarResultado {
	
	private IFachada fachada;
	private GUIRegistrarResultado ventana;
	
	public ControladorRegistrarResultado(GUIRegistrarResultado ventanaP) {
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
 
	public void registrarResultado (int cedula, int calificacion, int numeroInscripcion) {
		try {
			fachada.resultadoAsignatura(cedula, calificacion, numeroInscripcion);
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Resultado registrado con exito.", false);
		} catch(AlumnoNoExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);	
		} catch(InscripcionNoExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(YaTieneNotaFinalException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
	}
}

