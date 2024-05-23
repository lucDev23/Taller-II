package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import GUIventanas.GUIListarPorCedula;
import GUIventanas.GUIMensaje;
import capa_logica.IFachada;
import excepciones.AlumnoNoExisteException;
import excepciones.AlumnosVaciaException;
import value_objects.VOAlumnoRegistrado;

public class ControladorListarPorCedula {
	private IFachada fachada;
	private GUIListarPorCedula ventana;
	
	public ControladorListarPorCedula(GUIListarPorCedula ventanaP) {
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
	
	public VOAlumnoRegistrado listarPorCedula(int cedula) {
		VOAlumnoRegistrado alumno = null;
		try {
			alumno = fachada.listarPorCedula(cedula);
		} catch (AlumnosVaciaException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (AlumnoNoExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
		return alumno;
	}
}
