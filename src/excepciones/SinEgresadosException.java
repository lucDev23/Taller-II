package excepciones;

public class SinEgresadosException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public SinEgresadosException(String msj)
	{
		mensaje = msj;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}
}

