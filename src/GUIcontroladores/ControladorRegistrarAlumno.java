package GUIcontroladores;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import GUIventanas.GUIMensaje;
import GUIventanas.GUIRegistrarAlumno;
import capa_logica.IFachada;
import excepciones.CedulaYaExisteException;
import value_objects.VOAlumnoRegistrado;
import value_objects.VOBecadoRegistrado;

public class ControladorRegistrarAlumno {
	private IFachada fachada;
	private GUIRegistrarAlumno ventana;
	
	public ControladorRegistrarAlumno(GUIRegistrarAlumno ventanaP) {
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
	
	public void registrarAlumno(int cedula, String nombre, String apellido, String domicilio, String telefono) {
		try {
			VOAlumnoRegistrado alumno = new VOAlumnoRegistrado(cedula, nombre, apellido, domicilio, telefono);
			fachada.registrarAlumno(alumno);
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Alumno registrado con exito.", false);
		} catch(CedulaYaExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
	}
	
	public void registrarBecado(int cedula, String nombre, String apellido, String domicilio, String telefono, double descuento, String razon) {
		try {
			VOBecadoRegistrado becado = new VOBecadoRegistrado(cedula, nombre, apellido, domicilio, telefono, descuento, razon);
			fachada.registrarAlumno(becado);
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Alumno registrado con exito.", false);
		} catch(CedulaYaExisteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), e.getMensaje(), true);
		} catch(RemoteException e) {
			GUIMensaje mensaje = new GUIMensaje(ventana.getFrame(), "Fallo al comunicarse con el servidor.", true);
		}
	}
}
