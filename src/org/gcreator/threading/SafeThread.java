/*    */ package org.gcreator.threading;
/*    */ 
/*    */ public class SafeThread
/*    */ {
/* 13 */   private volatile boolean _isrunning = true;
/*    */   public static final int STATE_RUNNING = 0;
/*    */   public static final int STATE_PAUSED = 1;
/*    */   public static final int STATE_STOPPED = 2;
/* 18 */   private Thread t = new Thread() {
/*    */     public void run() {
/* 20 */       while (SafeThread.this._isrunning)
/* 21 */         SafeThread.this.loop();
/*    */     }
/* 18 */   };
/*    */ 
/*    */   protected void loop()
/*    */   {
/*    */   }
/*    */ 
/*    */   public int getState()
/*    */   {
/* 27 */     if (this.t == null)
/* 28 */       return 2;
/* 29 */     return this._isrunning ? 0 : 1;
/*    */   }
/*    */   public void play() throws TerminatedThreadException {
/* 32 */     if (this.t == null)
/* 33 */       throw new TerminatedThreadException();
/* 34 */     if (!this._isrunning) {
/* 35 */       this._isrunning = true;
/* 36 */       this.t.run();
/*    */     }
/*    */   }
/*    */ 
/* 40 */   public void pause() throws TerminatedThreadException { if (this.t == null)
/* 41 */       throw new TerminatedThreadException();
/* 42 */     this._isrunning = false; }
/*    */ 
/*    */   public void stop() throws TerminatedThreadException {
/* 45 */     if (this.t == null)
/* 46 */       throw new TerminatedThreadException();
/* 47 */     this._isrunning = false;
/* 48 */     this.t = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.threading.SafeThread
 * JD-Core Version:    0.6.2
 */