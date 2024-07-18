import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;

public class SocketChannelChatServer {
    public static void main(String[] args){
        try{
            //open a server socket channel to litsen to the client request
            ServerSocketChannel serverChannel=ServerSocketChannel.open();

            //bind the channel to specific port
            int port=2000;
            SocketAddress address=new InetSocketAddress( port);
            System.out.println("Connected to the client:"+client.getRemoteAddress());
            
        }
    }
    
}
