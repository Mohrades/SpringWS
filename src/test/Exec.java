package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		POST air;
		try {
			air = new POST(InetAddress.getLocalHost().getHostAddress(), 8080,5);
			String query="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header><wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:UsernameToken wsu:Id=\"UsernameToken-37\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsse:Username>Mohrades</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">ADWEG</wsse:Password><wsu:Created>2014-11-02T10:32:00Z</wsu:Created></wsse:UsernameToken></wsse:Security></soapenv:Header><soapenv:Body><HolidayRequest xmlns=\"http://mycompany.com/hr/schemas\"><Holiday><StartDate>2014-12-29</StartDate><EndDate>2015-04-01</EndDate></Holiday><Employee><Number>42</Number><FirstName>Leopold Sedar Mohamed</FirstName><LastName>EGNONSE</LastName></Employee></HolidayRequest></soapenv:Body></soapenv:Envelope>";
			//String query="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header><wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:UsernameToken wsu:Id=\"UsernameToken-37\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsse:Username>Bert</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest\">lp+zgc7I6jFisPCt3AjOalN0/qs=</wsse:Password><wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">c3ByaW5nd3M=</wsse:Nonce><wsu:Created>2014-09-22T21:22:10Z</wsu:Created></wsse:UsernameToken></wsse:Security></soapenv:Header><soapenv:Body><HolidayRequest xmlns=\"http://mycompany.com/hr/schemas\"><Holiday><StartDate>2014-12-29</StartDate><EndDate>2015-04-01</EndDate></Holiday><Employee><Number>42</Number><FirstName>Leopold Sedar Mohamed</FirstName><LastName>EGNONSE</LastName></Employee></HolidayRequest></soapenv:Body></soapenv:Envelope>";
			
			System.out.println(air.executerRequetes(query));
			air.fermer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
