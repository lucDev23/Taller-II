package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import GUIventanas.GUIMensaje;
import GUIventanas.GUIMontoRecaudado;
import capa_logica.IFachada;
import excepciones.AlumnoNoExisteException;
import excepciones.AlumnoSinInscripcionesException;
import excepciones.AnioNoCursadoException;

public class ControladorMontoRecaudado {
	private IFachada fachada;
	private GUIMontoRecaudado ventana;
	
	public ControladorMontoRecaudado(GUIMontoRecaudado ventanaP) {
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
	
	public double recaudarMonto(int anioLectivo, int cedula) {
		double monto = -1;
		try {
			monto =  fachada.montoRecaudado(anioLectivo, cedula);
		} catch (AlumnoNoExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (AnioNoCursadoException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (AlumnoSinInscripcionesException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch (RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
		return monto;
	}
}

