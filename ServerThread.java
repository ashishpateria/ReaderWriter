import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket=null;
	private CacheManagerDriver server=null;
	private int ID=-1;
	private DataInputStream streamIn=null;
	private DataOutputStream streamOut=null;
	public ServerThread(CacheManagerDriver server,Socket socket) {
		this.server=server;
		this.socket=socket;
		ID=socket.getPort();
		
	}
	public void run(){
		System.out.println("Server Thread " + ID + " running.");
		while(true){
			try {
				//System.out.println(streamIn.readUTF());
				if(streamIn.readUTF().equalsIgnoreCase("reader"))
				CacheManagerDriver.NUM_OF_READERS++;
				if(streamIn.readUTF().equalsIgnoreCase("writer"))
					CacheManagerDriver.NUM_OF_WRITERS++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void open() throws IOException{
		streamIn=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	}
	public void close() throws IOException{
		if(socket!=null)socket.close();
		if(streamIn!=null)streamIn.close();
	}
	public void send(String msg)
	   {   try
	       {  streamOut.writeUTF(msg);
	          streamOut.flush();
	       }
	       catch(IOException ioe)
	       {  System.out.println(ID + " ERROR sending: " + ioe.getMessage());
	         
	       }
	   }

}
