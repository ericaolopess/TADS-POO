/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiverings;


import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author erica
 */
public class TestWebCam  {
    public byte bytes[] = null;
    JButton start = null;
    JButton stop = null;
    JButton capture = null;
   
    CaptureStream captureStream = null;
    boolean takeShot = false;
    
    public TestWebCam()
    {
        CaptureSystemFactory factory = DefaultCaptureSystemFactorySingleton.instance();
        CaptureSystem system;
        
        try
        {
           system = factory.createCaptureSystem();
           system.init();
           List list = system.getCaptureDeviceInfoList();
           
           int i = 0;
           
           if (i < list.size())
           {
               CaptureDeviceInfo info = (CaptureDeviceInfo) list.get(i);
               //System.out.println((new StringBilder()).append("Device ID ").append(i).append(": ").append())
               captureStream = system.openCaptureDeviceStream(info.getDeviceID());
               captureStream.setObserver(TestWebCam.this);
           }
        }
        catch (CaptureException ex)
        {
              ex.printStackTrace();      
        }
        
        
    }
    
    public void onNewImage(CaptureStream stream, Image image)
    {
        if(!takeShot)
        {
            return;
        }
        
        takeShot = false;
        JOptionPane.showMessageDialog(null,"Imagem Capturada");
        
        try
        {
            if (image == null)
            {
                bytes = null;
                return;
            }    
            
            try
            {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                JPEGImageEncoder jpeg = JPEGCoder.createJPEGEndcor(os);
                jpeg.endcode(AWTImageConverter.toBufferedImage(image));
                os.close();
                bytes = os.toByteArray();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(TestWebCam.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (Throwable t) 
            {
                Logger.getLogger(TestWebCam.class.getName()).log(Level.SEVERE, null, t);
                bytes = null;    
            }
    }        
    catch (Exception ex)
    {
        Logger.getLogger(TestWebCam.class.getName()).log(Level.SEVERE, null, ex);    
    }            
            
    public void onError(CaptureStream arg0, CaptureStream arg1)    
    {
        throw new UnsupportedOperationException("Error is Coming ");
    }
            
    
    }
    
}
