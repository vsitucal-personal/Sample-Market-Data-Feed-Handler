/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdfh;

import java.io.IOException;
import java.net.*;
import java.nio.*;

import mdfh.threads.CReceiverThread;
import mdfh.threads.CSenderThread;


/**
 *
 * @author Vincent
 */
public class Main
{
    
    public static void main(String[] args)
    {
        CSenderThread senderThread = new CSenderThread(args[0], "localhost", 8989);
        CReceiverThread receiverThread = new CReceiverThread("localhost", 8989);
        receiverThread.start();
        senderThread.start();
    }
    
}
