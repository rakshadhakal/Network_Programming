import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPChatClient {
    public static void main(String[]args) {
        try{
        //prepare socket
        DatagramSocket socket = new DatagramSocket(0);
         System.out.println("The client is running at" +socket.getLocalPort());
        //prepare content
        Scanner in = new Scanner(System.in);
        while(true){
            String content=in.nextLine();
            byte[] data =content.getBytes("US-ASCII");
            //PREPARE REQUEST
            InetAddress server=InetAddress.getByName("localhost");
            DatagramPacket request=new DatagramPacket(data, data.length, server, 2013);
            //send request
            socket.send(request);
            //receive response
            DatagramPacket response=new DatagramPacket(new byte[1024],1024);
            socket.receive(response);
            //get content from response
            content=new String(response.getData(),"US-ASCII");
            //Display the content
            System.out.println("Received from server:" +content);
        }
        }catch(SocketException e){
            e.printStackTrace();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
