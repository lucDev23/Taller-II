package excepciones;

public class AlumnoSinInscripcionesException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AlumnoSinInscripcionesException(String msj)
	{
		mensaje = msj;
	}
	
	public String getMensaje()
	{
		return mensaje;
	}
}
