package excepciones;

public class AsignaturaNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AsignaturaNoExisteException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
