package excepciones;

public class AsignaturaSinNotaFinalException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AsignaturaSinNotaFinalException(String msg)
	{
		mensaje = msg;
	}
	public String getMensaje()
	{
		return mensaje;
	}	
}
