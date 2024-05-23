package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import GUIventanas.GUIListarPorApellido;
import GUIventanas.GUIMensaje;
import capa_logica.IFachada;
import excepciones.AlumnosVaciaException;
import excepciones.NingunoConApellidoException;
import value_objects.VOAlumnoApellido;

public class ControladorListarPorApellido {
	private IFachada fachada;
	private GUIListarPorApellido ventana;
	
	public ControladorListarPorApellido(GUIListarPorApellido ventanaP) {
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
	
	public ArrayList<VOAlumnoApellido> listarPorApellido(String apellido) {
		ArrayList<VOAlumnoApellido> listado = null;
		try {
			listado = fachada.listarPorApellido(apellido);
		} catch (AlumnosVaciaException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (NingunoConApellidoException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
		return listado;
	}
}
