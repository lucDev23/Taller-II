package mainClientServer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import capa_logica.Fachada;


public class Server {
	
    public static void main(String[] args)
    {
        try
        {
            Properties p = new Properties();
            String nomArch = "config/file.properties";
            p.load(new FileInputStream(nomArch));
            String ip = p.getProperty("serverIp");
            String port = p.getProperty("serverPort");
            int portInt = Integer.parseInt(port);

            LocateRegistry.createRegistry(portInt);
    
            Fachada fachada = Fachada.getFachada();
            String route = "//" + ip + ":" + port + "/fachada";
       
            System.out.println("Before upload");
            Naming.rebind(route, fachada);
            System.out.println("After upload");
        }
        catch(MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        catch(RemoteException e) {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


