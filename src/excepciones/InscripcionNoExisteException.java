package excepciones;

public class InscripcionNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public InscripcionNoExisteException(String msg)
	{
		mensaje = msg;
	}
	public String getMensaje()
	{
		return mensaje;
	}

}
