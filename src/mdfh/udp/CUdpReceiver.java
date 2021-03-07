/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdfh.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 *
 * @author Vincent
 */
public class CUdpReceiver
{
    private String host;
    private int port;
    
    public CUdpReceiver (String host, int port)
    {
        this.host = host;
        this.port = port;
    }
    
    public void onReceive()
    {
        try
        {
            DatagramChannel server = DatagramChannel.open();
            InetSocketAddress address = new InetSocketAddress(host,port);
            server.bind(address);
            System.out.println("Server Started: " + address);
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            
            //receive buffer from client.
            SocketAddress remoteAdd = server.receive(buffer);
            
            //change mode of buffer
            buffer.flip();
            int limits = buffer.limit();
            byte bytes[] = new byte[limits];
            buffer.get(bytes, 0, limits);
            String msg = new String(bytes);
            System.out.println("Client at " + remoteAdd + " sent:");
            System.out.println(msg);
            server.send(buffer,remoteAdd);
            
            server.close();
        } 
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
