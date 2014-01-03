/*     */ package org.gcreator.externproject;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipException;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import javax.swing.JFileChooser;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.components.impl.CustomFileFilter;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.ClassLoading;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Group;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.managers.ProjectTree;
/*     */ 
/*     */ public class ProjectImporter
/*     */ {
/*     */   static int type;
/*     */   static Project project;
/*     */   static String config;
/*  35 */   static Vector<String> Stringfiles = new Vector();
/*  36 */   static Vector<byte[]> Bytefiles = new Vector();
/*  37 */   static Vector<Object> objects = new Vector();
/*     */ 
/* 172 */   private static JFileChooser fc = new JFileChooser();
/*     */ 
/*     */   public static void readFile(String s, String name)
/*     */   {
/*  40 */     Stringfiles.add(s);
/*     */   }
/*     */ 
/*     */   public static void readConfig(String s, String name) {
/*  44 */     Folder f = new Folder("");
/*  45 */     String ptype = s.split(">")[3].split("<")[0];
/*  46 */     boolean run2 = false;
/*     */     try {
/*  48 */       System.out.println(ptype);
/*  49 */       project = (Project)ClassLoading.classLoader.loadClass(ptype).newInstance();
/*     */     } catch (Exception e) {
/*  51 */       System.out.println(e.toString());
/*  52 */       run2 = true;
/*     */     }
/*  54 */     if (run2)
/*     */       try {
/*  56 */         project = (Project)ClassLoading.classLoader.loadClass(ptype).newInstance();
/*     */       } catch (Exception e) {
/*  58 */         System.out.println(e.toString());
/*     */       }
/*  60 */     project.name = name;
/*  61 */     s = s.replaceAll("</content>", "");
/*  62 */     String[] ss = s.split("<file type=\"");
/*  63 */     int ii = 0;
/*  64 */     int fileno = 0;
/*  65 */     while (ii < ss.length) {
/*  66 */       String[] sss = ss[ii].replaceAll("</file>", "").split("\">");
/*  67 */       if (sss[0].equals("org.gcreator.fileclass.GFile")) {
/*  68 */         sss[1] = sss[1].replaceAll("</project>", "");
/*  69 */         String[] ssss = sss[1].split("\\.");
/*  70 */         String dir = sss[1];
/*  71 */         if (dir.indexOf("/") != -1)
/*  72 */           dir = dir.substring(0, dir.lastIndexOf("/"));
/*     */         else {
/*  74 */           dir = "/";
/*     */         }
/*  76 */         if (ssss.length > 0) {
/*     */           try {
/*  78 */             String tname = ssss[0];
/*  79 */             if (tname.indexOf("/") != -1) {
/*  80 */               tname = tname.substring(tname.lastIndexOf("/") + 1);
/*     */             }
/*  82 */             GFile file = new GFile(project.findFolder(dir), tname, ssss[1], null);
/*     */ 
/*  84 */             file.value = objects.elementAt(fileno);
/*     */ 
/* 112 */             fileno++;
/*     */           } catch (Exception e) {
/* 114 */             System.out.println(e.getMessage());
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 143 */         boolean rung = false;
/*     */         try {
/* 145 */           Group t = (Group)ClassLoading.classLoader.loadClass(sss[0]).newInstance();
/* 146 */           t.root = project;
/* 147 */           t.name = sss[1].substring(sss[1].lastIndexOf("/") + 1);
/* 148 */           project.add(t);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/* 152 */           rung = true;
/*     */         }
/* 154 */         if (rung)
/*     */           try {
/* 156 */             Group t = (Group)ClassLoading.classLoader.loadClass(sss[0]).newInstance();
/* 157 */             t.root = project;
/* 158 */             t.name = sss[1].substring(sss[1].lastIndexOf("/") + 1);
/* 159 */             project.add(t);
/*     */           }
/*     */           catch (Exception e) {
/*     */           }
/*     */       }
/* 164 */       ii++;
/*     */     }
/* 166 */     if (project != null) {
/* 167 */       ProjectTree.importFolderToTree(project, gcreator.window.top);
/*     */     }
/* 169 */     Aurwindow.setMainProject(project);
/* 170 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   public static void OpenProject(Component caller)
/*     */   {
/* 178 */     String fname = null;
/*     */     try
/*     */     {
/* 181 */       fc.showOpenDialog(caller);
/* 182 */       File file = fc.getSelectedFile();
/* 183 */       if (file == null) {
/* 184 */         return;
/*     */       }
/* 186 */       if (!file.exists())
/* 187 */         return;
/* 188 */       if (file.isDirectory())
/* 189 */         return;
/* 190 */       FileInputStream fin = new FileInputStream(file);
/* 191 */       ZipInputStream in = new ZipInputStream(fin);
/*     */ 
/* 193 */       byte[] b = new byte[1024];
/* 194 */       fname = file.getName().replaceAll("^(.*)\\.(.*)$", "$1");
/*     */       ZipEntry zipe;
/* 195 */       while ((zipe = in.getNextEntry()) != null) {
/* 196 */         System.out.println("" + zipe.getName());
/* 197 */         if (!zipe.isDirectory()) {
/* 198 */           ByteArrayOutputStream stream = new ByteArrayOutputStream();
/*     */           int len;
/* 200 */           while ((len = in.read(b)) > 0) {
/* 201 */             stream.write(b, 0, len);
/*     */           }
/* 203 */           System.out.println("after write");
/*     */ 
/* 206 */           if (zipe.getName().equals("config")) {
/* 207 */             config = stream + "";
/*     */           }
/* 212 */           else if ((zipe.getName().endsWith(".txt")) || (zipe.getName().endsWith(".egml"))) {
/* 213 */             Bytefiles.add(stream.toByteArray());
/* 214 */             Stringfiles.add(new String(stream.toByteArray()));
/* 215 */             objects.add(new String(stream.toByteArray()));
/*     */           }
/*     */           else
/*     */           {
/* 219 */             ObjectInputStream s = new ObjectInputStream(new ByteArrayInputStream(stream.toByteArray()));
/*     */             try
/*     */             {
/* 222 */               objects.add(s.readObject());
/* 223 */               s.close();
/*     */             }
/*     */             catch (Exception e) {
/* 226 */               System.out.println("Class error(projectimporter): " + e.getLocalizedMessage());
/*     */             }
/*     */ 
/* 229 */             readFile(stream + "", zipe.getName());
/*     */ 
/* 231 */             Bytefiles.add(stream.toByteArray());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (ZipException ex)
/*     */     {
/* 239 */       System.out.println(ex.toString() + ": " + ex.getMessage());
/* 240 */       Logger.getLogger(Aurwindow.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 242 */       System.out.println(ex.toString() + ": " + ex.getMessage());
/* 243 */       Logger.getLogger(Aurwindow.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 246 */     readConfig(config, fname);
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 174 */     fc.setFileFilter(new CustomFileFilter(".gcp", "G-Creator Project File"));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.externproject.ProjectImporter
 * JD-Core Version:    0.6.2
 */