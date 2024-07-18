import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPChannelTimeClient {
    public static void main(String[] args)
    {
        try{
            //create datagram channel
            DatagramChannel channel= DatagramChannel.open();
            SocketAddress server=new InetSocketAddress("localhost", 2022);
            //configure non blocking io(NIO)
            //channel configureblocking (true);
            System.out.println("Client address is:"+channel.getLocalAddress());
            //send request to server
            channel.send(ByteBuffer.allocate(1),server);
            //get response from the server
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            channel.receive(buffer);
            //get content and display
            String content=new String (buffer.array(),"US-ASCII");
            System.out.println("Server:" +content);
            channel.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
