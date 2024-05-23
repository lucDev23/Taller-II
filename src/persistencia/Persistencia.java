package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import excepciones.PersistenciaException;
import value_objects.VOCapaLogica;

public class Persistencia {
	
	private static Persistencia persistencia;
	
	public static Persistencia getPersistencia() {
		if (persistencia == null)
			persistencia = new Persistencia();
		return persistencia;
	}
	
	public void respaldar(String nombreArchivo, VOCapaLogica voc) throws PersistenciaException {
		try {
			FileOutputStream f = new FileOutputStream(nombreArchivo);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(voc);
			o.close();
			f.close();
		} 
		catch (IOException e) {
			throw new PersistenciaException("Error al respaldar.");
		}
	}
	
	public VOCapaLogica restaurar(String nombreArchivo) throws PersistenciaException {
		VOCapaLogica voc;
		try {
			FileInputStream f = new FileInputStream(nombreArchivo);
			ObjectInputStream o = new ObjectInputStream(f);
			voc = (VOCapaLogica) o.readObject();
			o.close();
			f.close();
		} 
		catch (IOException | ClassNotFoundException e) {
			throw new PersistenciaException("Error al recuperar.");
		}
		return voc;
	}
	
	
}
