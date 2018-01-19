import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server
{
 
    private static Socket socket;
 
    public static void main(String[] args)
    {
    	int port = 25000;
        ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			 while(true) {
		        	try{
		        	Socket sock = serverSocket.accept();
		        	new SocketThread(sock).start();
		        	}
		        	catch(Exception e) {
		        		e.printStackTrace();
		        	}
		        }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
    }
}

class SocketThread extends Thread {
	 Socket socket;

	  public SocketThread(Socket csocket) {
	    this.socket = csocket;
	  }

	  public void run() {
		  try
	        {
	 
	            
	            System.out.println("Server Started and listening to the port 25000");
	 
	            //Server is running always. This is done using this while(true) loop
	                //Reading the message from the client
	                
	                InputStream is = socket.getInputStream();
	                InputStreamReader isr = new InputStreamReader(is);
	                BufferedReader br = new BufferedReader(isr);
	                String number = br.readLine();
	                System.out.println("Message received from client is "+number);
	 
	                //Multiplying the number by 2 and forming the return message
	                String returnMessage;
	                try
	                {
	                    //int numberInIntFormat = Integer.parseInt(number);
	                    Calci c=new Calci();
	                	float returnValue = c.infix(number);
	                    returnMessage = String.valueOf(returnValue) + "\n";
	                }
	                catch(NumberFormatException e)
	                {
	                    //Input was not a number. Sending proper message back to client.
	                    returnMessage = "Please send a proper number\n";
	                }
	 
	                //Sending the response back to the client.
	                OutputStream os = socket.getOutputStream();
	                OutputStreamWriter osw = new OutputStreamWriter(os);
	                BufferedWriter bw = new BufferedWriter(osw);
	                bw.write(returnMessage);
	                System.out.println("Message sent to the client is "+returnMessage);
	                bw.flush();
	    
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                socket.close();
	            }
	            catch(Exception e){}
	        }
	    }
}
