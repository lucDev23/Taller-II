package excepciones;

public class PersistenciaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public PersistenciaException(String msg)
	{
		mensaje = msg;
	}
	public String getMensaje()
	{
		return mensaje;
	}
}