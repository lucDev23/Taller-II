package excepciones;

public class AlumnosVaciaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public AlumnosVaciaException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
