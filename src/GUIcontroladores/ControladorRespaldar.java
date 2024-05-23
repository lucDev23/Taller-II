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

public class ControladorRespaldar {
	private IFachada fachada;
	GUIMenuOpciones ventana;
	
	public ControladorRespaldar(GUIMenuOpciones ventanaP) {
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
	
	public void respaldar () {
		try {
			fachada.respaldarDatos();
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Respaldo exitoso.", false);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMessage(), true);
		}
	}
}
