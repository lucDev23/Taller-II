package excepciones;

public class CodigoYaExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public CodigoYaExisteException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}