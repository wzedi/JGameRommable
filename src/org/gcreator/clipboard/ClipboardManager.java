/*    */ package org.gcreator.clipboard;
/*    */ 
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.datatransfer.Clipboard;
/*    */ import java.awt.datatransfer.ClipboardOwner;
/*    */ import java.awt.datatransfer.DataFlavor;
/*    */ import java.awt.datatransfer.StringSelection;
/*    */ import java.awt.datatransfer.Transferable;
/*    */ import java.awt.datatransfer.UnsupportedFlavorException;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class ClipboardManager
/*    */   implements ClipboardOwner
/*    */ {
/*    */   public void lostOwnership(Clipboard aClipboard, Transferable aContents)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void setClipboardContents(String aString)
/*    */   {
/* 22 */     StringSelection stringSelection = new StringSelection(aString);
/* 23 */     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
/* 24 */     clipboard.setContents(stringSelection, this);
/*    */   }
/*    */ 
/*    */   public String getClipboardContents() {
/* 28 */     String result = "";
/* 29 */     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
/*    */ 
/* 31 */     Transferable contents = clipboard.getContents(null);
/* 32 */     boolean hasTransferableText = (contents != null) && (contents.isDataFlavorSupported(DataFlavor.stringFlavor));
/* 33 */     if (hasTransferableText) {
/*    */       try {
/* 35 */         result = (String)contents.getTransferData(DataFlavor.stringFlavor);
/*    */       }
/*    */       catch (UnsupportedFlavorException ex) {
/* 38 */         System.out.println(ex);
/* 39 */         ex.printStackTrace();
/*    */       } catch (IOException ex) {
/* 41 */         System.out.println(ex);
/* 42 */         ex.printStackTrace();
/*    */       }
/*    */     }
/* 45 */     return result;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.clipboard.ClipboardManager
 * JD-Core Version:    0.6.2
 */