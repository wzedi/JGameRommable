/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public class ByteInputStream extends InputStream
/*    */ {
/*    */   private byte[] res;
/* 15 */   private int pos = 0;
/* 16 */   private int markpos = 0;
/* 17 */   private int markinvalid = 0;
/*    */ 
/*    */   public ByteInputStream(byte[] bytearray) {
/* 20 */     this.res = bytearray;
/*    */   }
/*    */ 
/*    */   public int read() throws IOException {
/* 24 */     if (this.res == null)
/* 25 */       throw new IOException("Null buffer");
/* 26 */     if (this.pos + 1 >= this.res.length)
/* 27 */       return -1;
/* 28 */     return this.res[(this.pos++)];
/*    */   }
/*    */ 
/*    */   public void skip(int len) throws IOException {
/* 32 */     if (this.res == null)
/* 33 */       throw new IOException("Null buffer");
/* 34 */     if (len <= 0)
/* 35 */       return;
/* 36 */     this.pos += len;
/* 37 */     if (this.pos >= this.res.length)
/* 38 */       throw new IOException("Buffer end");
/*    */   }
/*    */ 
/*    */   public void close() {
/* 42 */     this.res = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ByteInputStream
 * JD-Core Version:    0.6.2
 */