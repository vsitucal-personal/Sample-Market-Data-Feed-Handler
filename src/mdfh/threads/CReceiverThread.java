/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdfh.threads;

import mdfh.udp.CUdpReceiver;

/**
 *
 * @author Vincent
 */
public class CReceiverThread extends Thread
{
    private String host;
    private int port;
    
    public CReceiverThread (String host, int port)
    {
        this.host = host;
        this.port = port;
    }
    
    //overriding run method in Thread
    @Override
    public void run()
    {
        try
        {
            CUdpReceiver udpReceiver = new CUdpReceiver(host,port);
            udpReceiver.onReceive();
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
