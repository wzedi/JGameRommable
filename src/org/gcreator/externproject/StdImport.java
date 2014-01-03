/*    */ package org.gcreator.externproject;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ import java.util.Iterator;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.imageio.ImageReader;
/*    */ import javax.imageio.stream.FileImageInputStream;
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.components.WorkspaceTree;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ import org.gcreator.fileclass.Folder;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.units.ObjectNode;
/*    */ 
/*    */ public class StdImport
/*    */ {
/*    */   public static void importImage(Folder folder, File path)
/*    */     throws IOException
/*    */   {
/* 27 */     importImage(folder, path.getAbsolutePath());
/*    */   }
/*    */   public static void importImage(Folder folder, URL path) throws IOException {
/* 30 */     importImage(folder, path.getFile());
/*    */   }
/*    */   public static void importImage(Folder folder, URI path) throws IOException {
/* 33 */     importImage(folder, path.getPath() + path.getQuery());
/*    */   }
/*    */   public static void importImage(Folder folder, String path) throws IOException {
/* 36 */     Folder f = gcreator.window.getCurrentFolder();
/* 37 */     String t = path.replaceAll(".*\\.", "");
/* 38 */     if (!f.allowsFileType(t)) {
/* 39 */       System.out.println(t);
/* 40 */       f = f.magicAddition(t);
/* 41 */       if (f == null) {
/* 42 */         return;
/*    */       }
/*    */     }
/* 45 */     File _file = new File(path);
/* 46 */     GFile file = new GFile(f, _file.getName().substring(0, _file.getName().lastIndexOf(".")), "", null);
/* 47 */     file.type = path.substring(path.lastIndexOf(".") + 1);
/* 48 */     System.out.println(path);
/* 49 */     if (file.type.toLowerCase().equals("gif")) {
/* 50 */       System.out.println("GIF!");
/*    */ 
/* 52 */       ImageReader reader = (ImageReader)ImageIO.getImageReadersByFormatName("gif").next();
/*    */ 
/* 56 */       reader.setInput(new FileImageInputStream(_file));
/* 57 */       System.out.println("No: " + reader.getNumImages(true));
/* 58 */       BufferedImage[] b = new BufferedImage[reader.getNumImages(true)];
/*    */ 
/* 60 */       for (int i = 0; i < reader.getNumImages(true); i++) {
/* 61 */         b[i] = reader.read(i);
/*    */       }
/* 63 */       file.value = new ImageIcon(b[0]);
/*    */     }
/*    */     else {
/* 66 */       System.out.println("Type:" + file.type.toLowerCase());
/* 67 */       file.value = new ImageIcon(ImageIO.read(_file));
/*    */     }
/*    */ 
/* 70 */     System.out.println("will add");
/* 71 */     f.add(file);
/* 72 */     ObjectNode node = new ObjectNode(file);
/* 73 */     f.node.add(node);
/* 74 */     Aurwindow.workspace.updateUI();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.externproject.StdImport
 * JD-Core Version:    0.6.2
 */