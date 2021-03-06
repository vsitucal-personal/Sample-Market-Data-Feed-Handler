/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdfh.text;

import java.nio.channels.FileChannel;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.io.FileNotFoundException;

/**
 *
 * @author Vincent
 */
public class CTextFileReader
{
    private String path = "";
    
    public CTextFileReader(String path){
        this.path = path;
    }
    
    public String readFileData()
    {
        String message = "";
        
        try
        {
            RandomAccessFile textFile = new RandomAccessFile(path,"r");
            FileChannel inChannel =textFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            
            int bytesRead = inChannel.read((ByteBuffer) buf);
            while(bytesRead != -1)
            {
                buf.flip();
                
                while(buf.hasRemaining())
                {
                    message += (char)buf.get();
                }
                
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            
            textFile.close();
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
             
        return message;
    }
}
