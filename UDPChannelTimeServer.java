import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.sql.Date;

public class UDPChannelTimeServer {
    public static void main(String[] args) {
        try{
            //create a datagram channel
             DatagramChannel channel= DatagramChannel.open();
              SocketAddress server=new InetSocketAddress(2022);
              DatagramSocket socket=channel.socket();
              socket.bind(server);
              System.out.println("Server is ready at" +channel.getLocalAddress());
              //receive request from clients
              while(true){
              ByteBuffer content =ByteBuffer.allocate(1024);
              SocketAddress client= channel.receive(content);
               System.out.println("received request from client:" +client.toString()); 
               Date date=new Date(0);
               byte[] data=date.toString().getBytes("US-ASCII");
               channel.send(ByteBuffer.wrap(data),client);
              }
;        }catch(IOException e){
    e.printStackTrace();
}
        
    }
    
}
