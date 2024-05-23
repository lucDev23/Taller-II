package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import GUIventanas.GUIMensaje;
import GUIventanas.GUIMenuOpciones;
import capa_logica.IFachada;
import excepciones.PersistenciaException;

public class ControladorRecuperar {
	private IFachada fachada;
	GUIMenuOpciones ventana;
	
	public ControladorRecuperar(GUIMenuOpciones ventanaP) {
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
	
	public void recuperar () {
		try {
			fachada.recuperarDatos();
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Recuperacion exitosa.", false);
		} catch (RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		} catch (PersistenciaException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} 
	}
}
