package exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;
@SuppressWarnings("serial")
@SoapFault(faultCode = FaultCode.SERVER)
public class MyBusinessException extends Exception {

    public MyBusinessException(String message) {
        super(message);
    }
    
}