/*     */ package org.gcreator.externproject;
/*     */ 
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;

/*     */ import org.gcreator.core.utilities;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.fileclass.Project;
/*     */ 
/*     */ 
/*     */ public class ProjectExporter
/*     */ {
/*     */   private static int a;
/*     */ 
/*     */   public static boolean export(Project project, String filename)
/*     */   {
/*  30 */     String config = getConfigFile(project);
/*     */ 
/*  32 */     ZipOutputStream out = null;
/*     */     try {
/*  34 */       out = new ZipOutputStream(new FileOutputStream(filename));
/*     */     } catch (Exception e) {
/*  36 */       System.out.println("ProjectExport: " + e.getLocalizedMessage());
/*  37 */       return false;
/*     */     }
/*  39 */     out.setLevel(9);
/*     */     try
/*     */     {
/*  44 */       out.putNextEntry(new ZipEntry("config"));
/*  45 */       for (int i = 0; i < config.length(); i++) {
/*  46 */         out.write(config.charAt(i));
/*     */       }
/*  48 */       out.closeEntry();
/*     */     }
/*     */     catch (Exception e) {
/*  51 */       System.out.println("ProjectExport: " + e.getLocalizedMessage());
/*     */     }
/*  53 */     a = 1;
/*  54 */     putFolder(project, "", out);
/*     */     try {
/*  56 */       out.close();
/*     */     }
/*     */     catch (Exception e) {
/*  59 */       System.out.println("ProjectExport: " + e.getLocalizedMessage());
/*     */     }
/*  61 */     utilities.addStringMessage("Saved");
/*  62 */     return false;
/*     */   }
/*     */ 
/*     */   public static void putFolder(Folder folder, String prefix, ZipOutputStream out)
/*     */   {
/*  71 */     for (int i = 0; i < folder.getChildArrayNum(); i++)
/*     */     {
/*     */       GObject childNode;
/*  72 */       if ((childNode = folder.childAt(i)) != null)
/*  73 */         if ((childNode instanceof GFile))
/*     */           try {
/*  75 */             out.putNextEntry(new ZipEntry("src/_" + a++ + "." + ((GFile)childNode).type));
/*  76 */             ((GFile)childNode).writeToBuffer(out);
/*  77 */             out.closeEntry();
/*     */           }
/*     */           catch (IOException e) {
/*  80 */             System.out.println("ProjectExport: " + e.getLocalizedMessage());
/*     */           }
/*  82 */         else if ((childNode instanceof Folder))
/*  83 */           putFolder((Folder)childNode, prefix + childNode.name + "/", out);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String getConfigFile(Project project)
/*     */   {
/*  90 */     String config = "<?xml version=\"1.0\"?>\n";
/*  91 */     config = config + "<project>";
/*  92 */     config = config + "<type>" + project.getClass().getName() + "</type>";
/*  93 */     config = config + "<content>";
/*  94 */     config = config + getContent("", project);
/*  95 */     config = config + "</content>";
/*  96 */     config = config + "</project>";
/*  97 */     return config;
/*     */   }
/*     */ 
/*     */   public static String getContent(String prefix, Folder folder) {
/* 101 */     String content = "";
/*     */ 
/* 103 */     for (int i = 0; i < folder.getChildArrayNum(); i++)
/*     */     {
/*     */       GObject childNode;
/* 104 */       if ((childNode = folder.childAt(i)) != null) {
/* 105 */         content = content + "<file type=\"" + childNode.getClass().getName() + "\">" + prefix + childNode.name;
/* 106 */         if ((childNode instanceof GFile)) {
/* 107 */           content = content + "." + ((GFile)childNode).type;
/*     */         }
/* 109 */         content = content + "</file>";
/* 110 */         if ((childNode instanceof Folder)) {
/* 111 */           content = content + getContent(new StringBuilder().append(prefix).append(childNode.name).append("/").toString(), (Folder)childNode);
/*     */         }
/*     */       }
/*     */     }
/* 115 */     return content;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.externproject.ProjectExporter
 * JD-Core Version:    0.6.2
 */