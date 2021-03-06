/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdfh.threads;

import mdfh.udp.CUdpSender;
/**
 *
 * @author Vincent
 */
public class CSenderThread extends Thread
{
    private String path ="";
    private String host;
    private int port;
    
    public CSenderThread (String path, String host, int port)
    {
        this.path = path;
        this.host = host;
        this.port = port;
    }
    
    //overriding run method in Thread
    @Override
    public void run()
    {
        try
        {
            CUdpSender udpSender = new CUdpSender(path,host,port);
            udpSender.sendMessage();
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
