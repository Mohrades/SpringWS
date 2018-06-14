package intercepteurs;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

public class MySoapActionInterceptor1 implements EndpointInterceptor{

	@Override
	public void afterCompletion(MessageContext arg0, Object arg1, Exception arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(MessageContext arg0, Object arg1)throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean handleRequest(MessageContext arg0, Object arg1)throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean handleResponse(MessageContext arg0, Object arg1)throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}