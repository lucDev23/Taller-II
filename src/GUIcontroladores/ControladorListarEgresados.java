package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import GUIventanas.GUIListarEgresados;
import GUIventanas.GUIMensaje;
import capa_logica.IFachada;
import excepciones.AlumnosVaciaException;
import excepciones.SinEgresadosException;
import value_objects.VOEgresadoParcial;

public class ControladorListarEgresados {
	private IFachada fachada;
	private GUIListarEgresados ventana;
	
	public ControladorListarEgresados(GUIListarEgresados ventanaP) {
		try {
			ventana = ventanaP;
			
			Properties p = new Properties();
            String nomArch = "config/file.properties";
            p.load(new FileInputStream(nomArch));
            String ip = p.getProperty("serverIp");
            String port = p.getProperty("serverPort");
            int portInt = Integer.parseInt(port);
            String route = "//" + ip + ":" + port + "/fachada";		
            fachada = (IFachada) Naming.lookup(route);
			
		} catch (NotBoundException | IOException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		} 
	}
	
	public ArrayList<? extends VOEgresadoParcial> listarEgresados(String modoListado) {
		ArrayList<? extends VOEgresadoParcial> listado = null;
		try {
			listado = fachada.listarEgresados(modoListado);
		} catch (AlumnosVaciaException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (SinEgresadosException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
		return listado;
	}
}
