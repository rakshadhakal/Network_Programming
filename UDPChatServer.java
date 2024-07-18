import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UDPChatServer {
    public static void main(String [] args){
        // make a datagramsocket 
        try{
             DatagramSocket socket=new DatagramSocket(2013);
            System.out.println("Server is running at port" +socket.getLocalPort());
            while(true){
              DatagramPacket request= new DatagramPacket(new byte[1024],1024);
              socket.receive(request);
               System.out.println("Got request from client:"+request.getAddress()+":"+request.getPort());
               //get the request data
        String data =new String (request.getData(),"US-ASCII");
        System.out.println("Client" +data);

        //get content from console and send to client
        Scanner in=new Scanner(System.in);
        data =in.nextLine();
        byte[] content=data.getBytes("US-ASCII");
        in.close();
        //make datagram response
        DatagramPacket response= new DatagramPacket(content,content.length,request.getAddress(),request.getPort());
        socket.send(response);
            }
        }catch(SocketException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
