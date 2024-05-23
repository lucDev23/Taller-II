package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;


import GUIventanas.GUIListarEscolaridad;
import GUIventanas.GUIMensaje;
import capa_logica.IFachada;
import excepciones.AlumnoNoExisteException;
import excepciones.AlumnoSinInscripcionesException;
import excepciones.EscolaridadParcialVaciaException;
import value_objects.VOInscripcionParcial;

public class ControladorListarEscolaridad {
	private IFachada fachada;
	private GUIListarEscolaridad ventana;
	
	public ControladorListarEscolaridad (GUIListarEscolaridad ventanaP) {
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
		//, , 
		public ArrayList<? extends VOInscripcionParcial> listarEscolaridad(int cedula, String modoListado) {
			ArrayList<? extends VOInscripcionParcial> listado = null;
			try {
				listado = fachada.consultarEscolaridad(cedula, modoListado);
			} catch (AlumnoNoExisteException e) {
				GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
			} catch (AlumnoSinInscripcionesException e) {
				GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
			} catch (EscolaridadParcialVaciaException e) {
				GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
			} catch (RemoteException e) {
				GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
			} return listado;
		}
}
