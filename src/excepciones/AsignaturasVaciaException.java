package excepciones;

public class AsignaturasVaciaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AsignaturasVaciaException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
