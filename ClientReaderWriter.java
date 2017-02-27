import java.net.*;
import java.io.*;
public class ClientReaderWriter {
	private Socket socket=null;
	private DataInputStream console=null;
	private DataOutputStream streamOut=null;
	
	@SuppressWarnings("deprecation")
	public ClientReaderWriter(String serverName,int serverPort) {
		
		try {
			socket=new Socket(serverName,serverPort);
			System.out.println("Connected :"+socket);
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String line="";
		while(!line.equals(".bye")){
			try {
				line=console.readLine();
				streamOut.writeUTF(line);
				streamOut.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public void start()throws IOException{
		console=new DataInputStream(System.in);
		streamOut=new DataOutputStream(socket.getOutputStream());
		
	}
	public void stop(){ 
		try{
			if (console   != null)  console.close();
	         if (streamOut != null)  streamOut.close();
	         if (socket    != null)  socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientReaderWriter reader = null;
	      if (args.length != 2)
	         System.out.println("Usage: java ChatClient host port");
	      else
	         reader = new ClientReaderWriter(args[0], Integer.parseInt(args[1]));

	}
	

}
