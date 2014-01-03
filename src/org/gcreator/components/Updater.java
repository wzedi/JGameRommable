/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.core.utilities;
/*     */ 
/*     */ public class Updater
/*     */ {
/*     */   public static void update()
/*     */   {
/*  36 */     URL url = null;
/*  37 */     URLConnection urlConn = null;
/*  38 */     InputStreamReader inStream = null;
/*  39 */     BufferedReader buff = null;
/*     */     try
/*     */     {
/*  43 */       url = new URL("http://www.g-creator.org/update/update.xml");
/*  44 */       urlConn = url.openConnection();
/*  45 */       inStream = new InputStreamReader(urlConn.getInputStream());
/*     */ 
/*  47 */       buff = new BufferedReader(inStream);
/*     */       while (true)
/*     */       {
/*  51 */         String nextLine = buff.readLine();
/*  52 */         if (nextLine == null) break;
/*  53 */         String version = "";
/*  54 */         if (nextLine.contains("<version>"))
/*     */         {
/*  56 */           String v = nextLine.replaceAll("<version>", "").replaceAll("</version>", "");
/*  57 */           double d = Double.parseDouble(v);
/*     */ 
/*  59 */           if (d > Double.parseDouble("1.01"))
/*     */           {
/*  61 */             int update = JOptionPane.showConfirmDialog(null, "A G-Creator update is available. Are you sure you want to update? ");
/*  62 */             if ((update == 1) || (update == 2))
/*  63 */               return;
/*     */           }
/*     */           else {
/*  66 */             return;
/*     */           }
/*     */         }
/*  68 */         if (nextLine.contains("<zip>"))
/*     */         {
/*  70 */           String v = nextLine.replaceAll("<zip>", "").replaceAll("</zip>", "");
/*  71 */           download(v, "g-creator.zip");
/*  72 */           unzip("g-creator.zip");
/*  73 */           System.out.println("unzipped");
/*  74 */           JOptionPane.showMessageDialog(gcreator.window, "Finished updating G-Creator");
/*     */         }
/*     */ 
/*  77 */         utilities.addStringMessage(nextLine);
/*  78 */         System.out.println(nextLine);
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (MalformedURLException e)
/*     */     {
/*  85 */       System.out.println("Please check the URL:" + e.toString());
/*     */     }
/*     */     catch (IOException e1) {
/*  88 */       System.out.println("Can't read  from the Internet: " + e1.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void unzip(String zipfile)
/*     */   {
/*     */     try
/*     */     {
/*  96 */       ZipFile zipFile = new ZipFile(zipfile);
/*  97 */       for (Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) {
/*  98 */         ZipEntry entry = (ZipEntry)entries.nextElement();
/*  99 */         if (entry.isDirectory())
/*     */         {
/* 101 */           new File(entry.getName()).mkdirs();
/*     */         }
/*     */         else {
/* 104 */           copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(entry.getName())));
/*     */         }
/*     */       }
/* 107 */       zipFile.close();
/*     */     }
/*     */     catch (IOException ioe) {
/* 110 */       ioe.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static final void copyInputStream(InputStream in, OutputStream out)
/*     */     throws IOException
/*     */   {
/* 117 */     byte[] buffer = new byte[1024];
/*     */     int len;
/* 119 */     while ((len = in.read(buffer)) >= 0) {
/* 120 */       out.write(buffer, 0, len);
/*     */     }
/* 122 */     in.close();
/* 123 */     out.close();
/*     */   }
/*     */ 
/*     */   public static void download(String address, String localFileName) {
/*     */     try {
/* 128 */       OutputStream out = null;
/* 129 */       InputStream in = null;
/* 130 */       URLConnection conn = null;
/*     */ 
/* 132 */       URL url = new URL(address);
/* 133 */       out = new BufferedOutputStream(new FileOutputStream(localFileName));
/* 134 */       conn = url.openConnection();
/* 135 */       in = conn.getInputStream();
/* 136 */       byte[] buffer = new byte[1024];
/*     */       int numRead;
/* 139 */       for (int numWritten = 0; (numRead = in.read(buffer)) != -1; numWritten += numRead) {
/* 140 */         out.write(buffer, 0, numRead);
/*     */       }
/*     */ 
/* 145 */       System.out.println("Downloaded zip");
/*     */ 
/* 147 */       if (in != null) {
/* 148 */         in.close();
/*     */       }
/* 150 */       if (out != null) {
/* 151 */         out.close();
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 156 */       System.out.println("" + ex.getLocalizedMessage());
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.Updater
 * JD-Core Version:    0.6.2
 */