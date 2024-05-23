package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import GUIventanas.GUIMensaje;
import GUIventanas.GUIRegistrarAsignatura;
import capa_logica.IFachada;
import excepciones.AsignaturasLlenasException;
import excepciones.CodigoYaExisteException;
import value_objects.VOAsignatura;

public class ControladorRegistrarAsignatura {
	private IFachada fachada;
	private GUIRegistrarAsignatura ventana;
	
	public ControladorRegistrarAsignatura(GUIRegistrarAsignatura ventanaP) {
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
	
	public void registrarAsignatura(String codigo, String nombre, String descripcion) {
		try {
			VOAsignatura voa = new VOAsignatura(codigo, nombre, descripcion);
			fachada.registrarAsignatura(voa);
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Asignatura registrada con exito.", false);
		} catch(CodigoYaExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(AsignaturasLlenasException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
	}
}
