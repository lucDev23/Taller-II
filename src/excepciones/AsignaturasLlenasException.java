package excepciones;

public class AsignaturasLlenasException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AsignaturasLlenasException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
