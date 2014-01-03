/*    */ package org.gcreator.managers;
/*    */ 
/*    */ import org.gcreator.fileclass.Folder;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.GObject;
/*    */ 
/*    */ public class FilesFinder
/*    */ {
/*    */   protected static int pos;
/*    */ 
/*    */   public static int getFileCountAt(Folder folder, String format)
/*    */   {
/* 20 */     if ((folder == null) || (format == null)) {
/* 21 */       return 0;
/*    */     }
/* 23 */     int a = folder.getChildNum();
/* 24 */     for (int i = 0; i < folder.getChildNum(); i++) {
/* 25 */       GObject o = folder.childAt(i);
/* 26 */       if ((o instanceof GFile)) {
/* 27 */         GFile f = (GFile)o;
/* 28 */         if (!f.type.equals(format))
/* 29 */           a--;
/*    */       }
/* 31 */       if ((o instanceof Folder)) {
/* 32 */         Folder f = (Folder)o;
/* 33 */         int g = f.getChildNum();
/* 34 */         g -= getFileCountAt(f, format);
/* 35 */         a -= g;
/*    */       }
/*    */     }
/* 38 */     return a;
/*    */   }
/*    */ 
/*    */   public static GFile[] getFilesAt(Folder folder, String format)
/*    */   {
/* 44 */     GFile[] files = new GFile[getFileCountAt(folder, format)];
/* 45 */     pos = 0;
/* 46 */     return _getFilesAt(files, folder, format);
/*    */   }
/*    */ 
/*    */   private static GFile[] _getFilesAt(GFile[] files, Folder folder, String format) {
/* 50 */     for (int i = 0; i < folder.getChildNum(); i++) {
/* 51 */       GObject o = folder.childAt(i);
/* 52 */       if ((o instanceof GFile)) {
/* 53 */         GFile f = (GFile)o;
/* 54 */         if (f.type.equals(format)) {
/* 55 */           files[(pos++)] = f;
/*    */         }
/*    */       }
/* 58 */       if ((o instanceof Folder)) {
/* 59 */         Folder f = (Folder)o;
/* 60 */         files = _getFilesAt(files, f, format);
/*    */       }
/*    */     }
/* 63 */     return files;
/*    */   }
/*    */ 
/*    */   public static boolean contains(Folder folder, String format) {
/* 67 */     if (getFileCountAt(folder, format) > 0)
/* 68 */       return true;
/* 69 */     return false;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.FilesFinder
 * JD-Core Version:    0.6.2
 */