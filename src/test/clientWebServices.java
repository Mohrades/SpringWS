import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MoovFLY2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String soapXml =   // jEdit: = buffer.getText(0,buffer.getLength())
		String soapXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Header/><S:Body><ns2:getArriverProvenanceJour xmlns:ns2=\"http://aero.com/\"><arg0>ABJ</arg0><arg1>4</arg1></ns2:getArriverProvenanceJour></S:Body></S:Envelope>";
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection)(new URL("http://10.20.4.121:8080/AEROWEB/INFOSAERO")).openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Set the necessary header fields
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conn.setRequestProperty("SOAPAction", "");
		conn.setRequestProperty("Content-Type", "text/xml");
		
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		conn.setDoOutput(true);
		// Send the request

		java.io.OutputStreamWriter wr = null;
		try {
			wr = new java.io.OutputStreamWriter(conn.getOutputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			wr.write(soapXml);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wr.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Read the response
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String line="";
		String each;
		try {
			while ((each = rd.readLine()) != null) {
				line=line+each;
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(line); /*jEdit: print(line); */ 
	}

}
