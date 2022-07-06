package ar.com.cdt.utn.aerolineasapi.exception;

public class AirlineException extends Exception {

	private static final long serialVersionUID = 1L;
	
	protected String mensaje;

	public AirlineException(String message) {
		super(message);
	}

	public AirlineException(String message, Throwable cause) {
		super(message, cause);
	}

	public AirlineException(Throwable cause, String message) {
		super(cause);
		this.setMensaje(message);
	}
	
	public AirlineException(String message, String mensaje) {
		super(message);
		this.setMensaje(mensaje);
	}

	public AirlineException(Throwable cause) {
		super(cause);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}