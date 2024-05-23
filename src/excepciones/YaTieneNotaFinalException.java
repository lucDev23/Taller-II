package excepciones;

public class YaTieneNotaFinalException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public YaTieneNotaFinalException(String msj)
	{
		mensaje = msj;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}
}
