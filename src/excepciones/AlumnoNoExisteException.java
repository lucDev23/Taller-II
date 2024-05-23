package excepciones;

public class AlumnoNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AlumnoNoExisteException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
