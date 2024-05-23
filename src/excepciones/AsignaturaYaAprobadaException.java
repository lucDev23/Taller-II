package excepciones;

public class AsignaturaYaAprobadaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AsignaturaYaAprobadaException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
