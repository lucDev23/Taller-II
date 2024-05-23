package excepciones;

public class AnioInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AnioInvalidoException(String msg)
	{
		mensaje = msg;
	}
	public String getMensaje()
	{
		return mensaje;
	}

}

