package excepciones;

public class EscolaridadParcialVaciaException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public EscolaridadParcialVaciaException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}