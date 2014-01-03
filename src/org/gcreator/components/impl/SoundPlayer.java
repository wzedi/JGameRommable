/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import javax.sound.sampled.LineUnavailableException;
/*    */ import javax.sound.sampled.UnsupportedAudioFileException;
/*    */ import org.gcreator.threading.TerminatedThreadException;
/*    */ 
/*    */ public class SoundPlayer
/*    */ {
/*    */   public SoundPlayer(String fname)
/*    */     throws IOException, UnsupportedAudioFileException, LineUnavailableException
/*    */   {
/*    */   }
/*    */ 
/*    */   public SoundPlayer(File f)
/*    */     throws IOException, NullPointerException, UnsupportedAudioFileException, LineUnavailableException
/*    */   {
/*    */   }
/*    */ 
/*    */   public SoundPlayer(byte[] bytearray)
/*    */     throws IOException, NullPointerException, UnsupportedAudioFileException, LineUnavailableException
/*    */   {
/* 64 */     if (bytearray == null)
/* 65 */       throw new NullPointerException();
/* 66 */     ByteInputStream stream = new ByteInputStream(bytearray);
/*    */   }
/*    */ 
/*    */   public SoundPlayer(InputStream stream)
/*    */     throws IOException, NullPointerException, UnsupportedAudioFileException, LineUnavailableException
/*    */   {
/* 85 */     if (stream == null)
/* 86 */       throw new NullPointerException();
/*    */   }
/*    */ 
/*    */   public void loop()
/*    */     throws TerminatedThreadException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void play()
/*    */     throws TerminatedThreadException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void stop()
/*    */     throws TerminatedThreadException
/*    */   {
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.SoundPlayer
 * JD-Core Version:    0.6.2
 */