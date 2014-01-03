/*     */ package net.iharder.dnd;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import javax.swing.event.EventListenerList;
/*     */ 
/*     */ public class FileDropBean
/*     */   implements Serializable
/*     */ {
/*  25 */   private EventListenerList listenerList = new EventListenerList();
/*     */ 
/*     */   public void addFileDropTarget(Component comp)
/*     */   {
/*  44 */     FileDrop.Listener listener = new FileDrop.Listener() {
/*     */       public void filesDropped(File[] files) {
/*  46 */         FileDropBean.this.fireFileDropHappened(files);
/*     */       }
/*     */     };
/*  49 */     boolean recursive = true;
/*  50 */     new FileDrop(comp, recursive, listener);
/*     */   }
/*     */ 
/*     */   public boolean removeFileDropTarget(Component comp)
/*     */   {
/*  61 */     return FileDrop.remove(comp);
/*     */   }
/*     */ 
/*     */   public void addFileDropListener(FileDropListener listener)
/*     */   {
/*  72 */     this.listenerList.add(FileDropListener.class, listener);
/*     */   }
/*     */ 
/*     */   public void removeFileDropListener(FileDropListener listener)
/*     */   {
/*  84 */     this.listenerList.remove(FileDropListener.class, listener);
/*     */   }
/*     */ 
/*     */   protected void fireFileDropHappened(File[] files)
/*     */   {
/*  97 */     FileDropEvent evt = new FileDropEvent(files, this);
/*     */ 
/* 100 */     Object[] listeners = this.listenerList.getListenerList();
/*     */ 
/* 104 */     for (int i = listeners.length - 2; i >= 0; i -= 2)
/* 105 */       if (listeners[i] == FileDropListener.class)
/* 106 */         ((FileDropListener)listeners[(i + 1)]).filesDropped(evt);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.FileDropBean
 * JD-Core Version:    0.6.2
 */