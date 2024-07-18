import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTimeClient {
    public static void main(String[] args){
        try{
            //open a socket channel
            SocketChannel channel=SocketChannel.open();
            //connect to the localhost at server port
            int port=2000;
            InetAddress addr=InetAddress.getLocalHost();
            SocketAddress address=new InetSocketAddress(addr, port);
            channel.connect(address);
            //read from the server
            ByteBuffer readBuffer=ByteBuffer.allocate(1024);
            channel.read(readBuffer);
            //convert the bytebuffer to string and display
            byte[]arr=readBuffer.array();
            String content=new String(arr,"US-ASCII");
            System.out.println("Server send the time:" +content);
        }
    }
}
