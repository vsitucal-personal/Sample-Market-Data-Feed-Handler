/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdfh.udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import mdfh.text.CTextFileReader;
/**
 *
 * @author Vincent
 */
public class CUdpSender
{
    private String out = "";
    private String path = "";
    private String host;
    private int port;
    
    public CUdpSender(String path, String host, int port)
    {
        this.path = path;
        this.host = host;
        this.port = port;
    }
    
    public void sendMessage()
    {
        try
        {
            CTextFileReader textFileReader = new CTextFileReader(path);

            DatagramChannel client = null;
            client = DatagramChannel.open();

            client.bind(null);

            String message = textFileReader.readFileData();
            
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            InetSocketAddress serverAddress = new InetSocketAddress(host,port);
            
            client.send(buffer, serverAddress);
            buffer.clear();
            client.receive(buffer);
            buffer.flip();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        
        
    }
}
