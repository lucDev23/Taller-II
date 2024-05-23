package mainClientServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;
import javax.swing.JFrame;
import GUIventanas.GUIFrame;
import GUIventanas.GUIMensaje;


public class GUIClient {
	
	public static void main(String[] args) {
		 
        /* 	
         * CORTAMOS LA EJECUCION SI NO ESTA EL SERVIDOR CORRIENDO 
         * COMENTANDO ESTE SEGMENTE DE CODIGO SE DESPLEGARA LA INTERFAZ  GRAFICA Y SE DESPLEGARAN 12 MENSAJES DE ERROR //
         * UNO POR CADA CONTROLADOR QUE ACCEDE AL SERVIDOR 
        */
        
		try {
			Properties p = new Properties();
            String nomArch = "config/file.properties";
            p.load(new FileInputStream(nomArch));
            String ip = p.getProperty("serverIp");
            String port = p.getProperty("serverPort");
            String route = "//" + ip + ":" + port + "/fachada";		
            Naming.lookup(route);
		} catch (NotBoundException | IOException e) {
			JFrame frame = new JFrame();
			GUIMensaje mensaje = new GUIMensaje(frame, "El servidor no esta iniciado", true);
			return;
		} 
		
		GUIFrame frame = new GUIFrame();
	}
}