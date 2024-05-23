package excepciones;

public class CedulaYaExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public CedulaYaExisteException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
