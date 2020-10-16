package br.com.empresa.restservice.exception;

@SuppressWarnings("serial")
public class WebServiceException extends Exception {

	public WebServiceException() {
		super();
	
	}

	public WebServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public WebServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	public WebServiceException(String arg0) {
		super(arg0);
		
	}

	public WebServiceException(Throwable arg0) {
		super(arg0);
		
	}

}
