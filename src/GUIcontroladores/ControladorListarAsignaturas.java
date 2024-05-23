package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import GUIventanas.GUIListarAsignaturas;
import GUIventanas.GUIMensaje;
import capa_logica.IFachada;
import excepciones.AsignaturasVaciaException;
import value_objects.VOAsignatura;

public class ControladorListarAsignaturas {
	private IFachada fachada;
	private GUIListarAsignaturas ventana;
	
	public ControladorListarAsignaturas(GUIListarAsignaturas ventanaP) {
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
	
	public VOAsignatura[] listarAsignaturas() {
		VOAsignatura[] listado = null;
		try {
			listado = fachada.listarAsignaturas();
		} catch (AsignaturasVaciaException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
		return listado;
	}
}
