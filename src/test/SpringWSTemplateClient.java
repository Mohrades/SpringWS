package test;

import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;

public class SpringWSTemplateClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String MESSAGE="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header><wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:UsernameToken wsu:Id=\"UsernameToken-37\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsse:Username>Mohrades</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">ADWEG</wsse:Password><wsu:Created>2014-10-26T10:38:00Z</wsu:Created></wsse:UsernameToken></wsse:Security></soapenv:Header><soapenv:Body><HolidayRequest xmlns=\"http://mycompany.com/hr/schemas\"><Holiday><StartDate>2014-12-29</StartDate><EndDate>2015-04-01</EndDate></Holiday><Employee><Number>42</Number><FirstName>Leopold Sedar Mohamed</FirstName><LastName>EGNONSE</LastName></Employee></HolidayRequest></soapenv:Body></soapenv:Envelope>";
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setDefaultUri("http://localhost:8080/SpringWS/holidayService/");
		//webServiceTemplate.setMessageFactory(new SaajSoapMessageFactory());
		StreamSource source = new StreamSource(new StringReader(MESSAGE));
	    StreamResult result = new StreamResult(System.out);
	    webServiceTemplate.sendSourceAndReceiveToResult(source, result);
	}

}
