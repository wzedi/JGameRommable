/*     */ package net.iharder.dnd;
/*     */ 
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class TransferableObject
/*     */   implements Transferable
/*     */ {
/*     */   public static final String MIME_TYPE = "application/x-net.iharder.dnd.TransferableObject";
/*  75 */   public static final DataFlavor DATA_FLAVOR = new DataFlavor(TransferableObject.class, "application/x-net.iharder.dnd.TransferableObject");
/*     */   private Fetcher fetcher;
/*     */   private Object data;
/*     */   private DataFlavor customFlavor;
/*     */ 
/*     */   public TransferableObject(Object data)
/*     */   {
/*  97 */     this.data = data;
/*  98 */     this.customFlavor = new DataFlavor(data.getClass(), "application/x-net.iharder.dnd.TransferableObject");
/*     */   }
/*     */ 
/*     */   public TransferableObject(Fetcher fetcher)
/*     */   {
/* 114 */     this.fetcher = fetcher;
/*     */   }
/*     */ 
/*     */   public TransferableObject(Class dataClass, Fetcher fetcher)
/*     */   {
/* 133 */     this.fetcher = fetcher;
/* 134 */     this.customFlavor = new DataFlavor(dataClass, "application/x-net.iharder.dnd.TransferableObject");
/*     */   }
/*     */ 
/*     */   public DataFlavor getCustomDataFlavor()
/*     */   {
/* 146 */     return this.customFlavor;
/*     */   }
/*     */ 
/*     */   public DataFlavor[] getTransferDataFlavors()
/*     */   {
/* 165 */     if (this.customFlavor != null) {
/* 166 */       return new DataFlavor[] { this.customFlavor, DATA_FLAVOR, DataFlavor.stringFlavor };
/*     */     }
/*     */ 
/* 172 */     return new DataFlavor[] { DATA_FLAVOR, DataFlavor.stringFlavor };
/*     */   }
/*     */ 
/*     */   public Object getTransferData(DataFlavor flavor)
/*     */     throws UnsupportedFlavorException, IOException
/*     */   {
/* 195 */     if (flavor.equals(DATA_FLAVOR)) {
/* 196 */       return this.fetcher == null ? this.data : this.fetcher.getObject();
/*     */     }
/*     */ 
/* 199 */     if (flavor.equals(DataFlavor.stringFlavor)) {
/* 200 */       return this.fetcher == null ? this.data.toString() : this.fetcher.getObject().toString();
/*     */     }
/*     */ 
/* 203 */     throw new UnsupportedFlavorException(flavor);
/*     */   }
/*     */ 
/*     */   public boolean isDataFlavorSupported(DataFlavor flavor)
/*     */   {
/* 220 */     if (flavor.equals(DATA_FLAVOR)) {
/* 221 */       return true;
/*     */     }
/*     */ 
/* 224 */     if (flavor.equals(DataFlavor.stringFlavor)) {
/* 225 */       return true;
/*     */     }
/*     */ 
/* 228 */     return false;
/*     */   }
/*     */ 
/*     */   public static abstract interface Fetcher
/*     */   {
/*     */     public abstract Object getObject();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.TransferableObject
 * JD-Core Version:    0.6.2
 */