import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.Date;

public class UDPTimeServer{
    public static void main(String[] args) {
        //make datagram socket
        try{
            DatagramSocket socket = new DatagramSocket(2013);
            //receive datagram request
            System.out.println("Server running at"+socket.getLocalPort());
            while(true){
            DatagramPacket request = new DatagramPacket(new byte [1024],1024);
            socket.receive(request);
            System.out.println("Get request from client:" +request.getAddress()+":"+request.getPort());
             //prepare date
             Date date = new Date(0);
             byte[] content =date.toString().getBytes("US-ASCII");

             //make datagram response
             DatagramPacket response = new DatagramPacket(content,content.length,request.getAddress(),request.getPort());
             socket.send(response);
        }
        //send
    }catch(SocketException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }
        
    }
}