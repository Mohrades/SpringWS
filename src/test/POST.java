package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class POST {
	 private BufferedInputStream in;
     private OutputStream out;
	 private boolean open;
	 private String ip;
	 private int port;
	 private int sleep;
     private Socket socket;

	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public POST(String ip, int port, int sleep){
	try {
		socket = new Socket(ip, port);
        out= socket.getOutputStream();
		this.sleep=sleep;
		this.ip=ip;
		this.port=port;
		if(out!=null)open=true;
	} 
        catch (UnknownHostException e) {
	} 
        catch (IOException e) {
	} 
}
	
	public void fermer(){
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
        public String executerRequetes(String requete){
        	String header="POST /SpringWS/holidayService/ HTTP/1.1\n"+
                            "Content-Length: "+requete.length()+"\n"+
                            "Content-Type: text/xml\n"+
                            "Host: "+ip+":"+port+"\n\n";
            requete=header+requete;
            
            byte data[] = requete.getBytes();
            try {
				out.write(data, 0, data.length);
				out.flush();
				
				in = new BufferedInputStream(socket.getInputStream());
	            String reponse = "";
	            byte[] lecteur = new byte[1024];
	            while (in.available() == 0){
	            	Thread.sleep(sleep);
	            }
	            Thread.sleep(10);
	            while (in.available() > 0) {
	                in.read(lecteur);
	                reponse += new String(lecteur);
	                lecteur = new byte[1024];
	                }
	            
	            return reponse;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            return "";
	}
}
