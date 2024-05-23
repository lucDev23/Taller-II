package excepciones;

public class NingunoConApellidoException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public NingunoConApellidoException(String msg) {
		mensaje = msg;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
