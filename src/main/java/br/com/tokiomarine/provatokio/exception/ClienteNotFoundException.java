package br.com.tokiomarine.provatokio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "NOT FOUND")
public class ClienteNotFoundException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9197744808355845957L;
	
	public ClienteNotFoundException(final String message) {
		super(message);
	}

}
