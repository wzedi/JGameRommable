/*     */ package net.iharder.dnd;
/*     */ 
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.dnd.DragGestureEvent;
/*     */ import java.awt.dnd.DragGestureListener;
/*     */ import java.awt.dnd.DragSource;
/*     */ import java.awt.dnd.DragSourceDragEvent;
/*     */ import java.awt.dnd.DragSourceDropEvent;
/*     */ import java.awt.dnd.DragSourceEvent;
/*     */ import java.awt.dnd.DragSourceListener;
/*     */ import java.awt.dnd.DropTarget;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import java.io.IOException;
/*     */ import java.util.Vector;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.JList;
/*     */ 
/*     */ public class DnDList extends JList
/*     */   implements DropTargetListener, DragSourceListener, DragGestureListener
/*     */ {
/*  26 */   private DropTarget dropTarget = null;
/*     */ 
/*  28 */   private DragSource dragSource = null;
/*     */ 
/*  30 */   private int sourceIndex = -1;
/*  31 */   private int dropIndex = -1;
/*     */   private Object sourceObject;
/*     */ 
/*     */   public DnDList()
/*     */   {
/*  43 */     super(new DefaultListModel());
/*  44 */     initComponents();
/*     */   }
/*     */ 
/*     */   public DnDList(DefaultListModel model)
/*     */   {
/*  58 */     super(model);
/*  59 */     initComponents();
/*     */   }
/*     */ 
/*     */   public DnDList(Object[] data)
/*     */   {
/*  73 */     this();
/*  74 */     ((DefaultListModel)getModel()).copyInto(data);
/*     */   }
/*     */ 
/*     */   public DnDList(Vector data)
/*     */   {
/*  89 */     this();
/*  90 */     ((DefaultListModel)getModel()).copyInto(data.toArray());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  97 */     this.dropTarget = new DropTarget(this, this);
/*  98 */     this.dragSource = new DragSource();
/*  99 */     this.dragSource.createDefaultDragGestureRecognizer(this, 2, this);
/*     */   }
/*     */ 
/*     */   public void dragGestureRecognized(DragGestureEvent event)
/*     */   {
/* 110 */     final Object selected = getSelectedValue();
/* 111 */     if (selected != null)
/*     */     {
/* 113 */       this.sourceIndex = getSelectedIndex();
/* 114 */       Transferable transfer = new TransferableObject(new TransferableObject.Fetcher()
/*     */       {
/*     */         public Object getObject()
/*     */         {
/* 121 */           ((DefaultListModel)DnDList.this.getModel()).remove(DnDList.this.sourceIndex);
/* 122 */           return selected;
/*     */         }
/*     */       });
/* 127 */       this.dragSource.startDrag(event, DragSource.DefaultLinkDrop, transfer, this);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dragDropEnd(DragSourceDropEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dragEnter(DragSourceDragEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dragExit(DragSourceEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dragOver(DragSourceDragEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dropActionChanged(DragSourceDragEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dragEnter(DropTargetDragEvent evt)
/*     */   {
/* 171 */     evt.acceptDrag(2);
/*     */   }
/*     */ 
/*     */   public void dragExit(DropTargetEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dragOver(DropTargetDragEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void dropActionChanged(DropTargetDragEvent evt)
/*     */   {
/* 184 */     evt.acceptDrag(2);
/*     */   }
/*     */ 
/*     */   public void drop(DropTargetDropEvent evt)
/*     */   {
/* 191 */     Transferable transferable = evt.getTransferable();
/*     */ 
/* 194 */     if (transferable.isDataFlavorSupported(TransferableObject.DATA_FLAVOR))
/*     */     {
/* 196 */       evt.acceptDrop(2);
/* 197 */       Object obj = null;
/*     */       try
/*     */       {
/* 200 */         obj = transferable.getTransferData(TransferableObject.DATA_FLAVOR);
/*     */       }
/*     */       catch (UnsupportedFlavorException e) {
/* 203 */         e.printStackTrace();
/*     */       }
/*     */       catch (IOException e) {
/* 206 */         e.printStackTrace();
/*     */       }
/*     */ 
/* 209 */       if (obj != null)
/*     */       {
/* 212 */         int dropIndex = locationToIndex(evt.getLocation());
/* 213 */         DefaultListModel model = (DefaultListModel)getModel();
/*     */ 
/* 215 */         if (dropIndex < 0) {
/* 216 */           model.addElement(obj);
/*     */         }
/* 219 */         else if ((this.sourceIndex >= 0) && (dropIndex > this.sourceIndex))
/* 220 */           model.add(dropIndex - 1, obj);
/*     */         else {
/* 222 */           model.add(dropIndex, obj);
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 229 */         evt.rejectDrop();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 234 */       evt.rejectDrop();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.DnDList
 * JD-Core Version:    0.6.2
 */