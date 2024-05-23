package excepciones;

public class AnioNoCursadoException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AnioNoCursadoException(String msj)
	{
		mensaje = msj;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}
}