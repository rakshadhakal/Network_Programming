import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class SocketChannelTimeServer{
    public static void main(String[] args) {
    try{
        //open a server socket channel to listen to the client request
        ServerSocketChannel serverchannel=ServerSocketChannel.open();

        //bind the channe to a spcific port
        int port=2000;
        SocketAddress address=new InetSocketAddress( port);
        serverchannel.bind(address);
        while(true){
        //accept the incoming client request
        SocketChannel client=serverchannel.accept();
        client.read(ByteBuffer.allocate(1));
        Date date= new Date();
        byte[] array=date.toString().getBytes("US-ASCII");
        System.out.println("Client content" +client);
        ByteBuffer content=ByteBuffer.wrap(array);
        client.write(content);

    }catch(IOException e){
        e.printStackTrace();
    }
        
    }
}