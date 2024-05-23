package excepciones;

public class MismoAnioLectivoException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public MismoAnioLectivoException(String msg)
	{
		mensaje = msg;
	}
	public String getMensaje()
	{
		return mensaje;
	}

}
