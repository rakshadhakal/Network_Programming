import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPTimeClient {
    public static void main(String[] args) {
        try{
           //prepare socket 
           DatagramSocket socket= new DatagramSocket(0);
           System.out.println("The client is running at" +socket.getLocalPort());
           //prepare request
           InetAddress server= InetAddress.getByName("localhost");
           DatagramPacket request = new DatagramPacket(new byte[1], 1, server, 2013);
           //send request
           socket.send(request);
           //receive response
           DatagramPacket response =new DatagramPacket(new byte[1024], 1024);
           socket.receive(response);
           //get content from response
           String content=new String(response.getData(),"US-ASCII");
           //Display the content
           System.out.println("Received from server :" +content);
           //close the socket
           socket.close();
        }catch(SocketException e){
            e.printStackTrace();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
