/*     */ package net.iharder.dnd;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.dnd.DropTarget;
/*     */ import java.awt.dnd.DropTargetContext;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import java.awt.event.HierarchyEvent;
/*     */ import java.awt.event.HierarchyListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Reader;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TooManyListenersException;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.border.Border;
/*     */ 
/*     */ public class FileDrop
/*     */ {
/*     */   private transient Border normalBorder;
/*     */   private transient DropTargetListener dropListener;
/*     */   private static Boolean supportsDnD;
/*  63 */   private static Color defaultBorderColor = new Color(0.0F, 0.0F, 1.0F, 0.25F);
/*     */ 
/* 444 */   private static String ZERO_CHAR_STRING = "";
/*     */ 
/*     */   public FileDrop(Component c, Listener listener)
/*     */   {
/*  78 */     this(null, c, BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), true, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(Component c, boolean recursive, Listener listener)
/*     */   {
/* 102 */     this(null, c, BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), recursive, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(PrintStream out, Component c, Listener listener)
/*     */   {
/* 127 */     this(out, c, BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), false, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(PrintStream out, Component c, boolean recursive, Listener listener)
/*     */   {
/* 158 */     this(out, c, BorderFactory.createMatteBorder(2, 2, 2, 2, defaultBorderColor), recursive, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(Component c, Border dragBorder, Listener listener)
/*     */   {
/* 180 */     this(null, c, dragBorder, false, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(Component c, Border dragBorder, boolean recursive, Listener listener)
/*     */   {
/* 207 */     this(null, c, dragBorder, recursive, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(PrintStream out, Component c, Border dragBorder, Listener listener)
/*     */   {
/* 235 */     this(out, c, dragBorder, false, listener);
/*     */   }
/*     */ 
/*     */   public FileDrop(final PrintStream out, final Component c, final Border dragBorder, boolean recursive, final Listener listener)
/*     */   {
/* 269 */     if (supportsDnD())
/*     */     {
/* 271 */       this.dropListener = new DropTargetListener() {
/*     */         public void dragEnter(DropTargetDragEvent evt) {
/* 273 */           FileDrop.log(out, "FileDrop: dragEnter event.");
/*     */ 
/* 276 */           if (FileDrop.this.isDragOk(out, evt))
/*     */           {
/* 279 */             if ((c instanceof JComponent)) {
/* 280 */               JComponent jc = (JComponent)c;
/* 281 */               FileDrop.this.normalBorder = jc.getBorder();
/* 282 */               FileDrop.log(out, "FileDrop: normal border saved.");
/* 283 */               jc.setBorder(dragBorder);
/* 284 */               FileDrop.log(out, "FileDrop: drag border set.");
/*     */             }
/*     */ 
/* 289 */             evt.acceptDrag(1);
/* 290 */             FileDrop.log(out, "FileDrop: event accepted.");
/*     */           }
/*     */           else
/*     */           {
/* 294 */             evt.rejectDrag();
/* 295 */             FileDrop.log(out, "FileDrop: event rejected.");
/*     */           }
/*     */         }
/*     */ 
/*     */         public void dragOver(DropTargetDragEvent evt)
/*     */         {
/*     */         }
/*     */ 
/*     */         public void drop(DropTargetDropEvent evt)
/*     */         {
/* 305 */           FileDrop.log(out, "FileDrop: drop event.");
/*     */           try
/*     */           {
/* 308 */             Transferable tr = evt.getTransferable();
/*     */ 
/* 311 */             if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
/*     */             {
/* 315 */               evt.acceptDrop(1);
/* 316 */               FileDrop.log(out, "FileDrop: file list accepted.");
/*     */ 
/* 319 */               List fileList = (List)tr.getTransferData(DataFlavor.javaFileListFlavor);
/*     */ 
/* 321 */               Iterator iterator = fileList.iterator();
/*     */ 
/* 324 */               File[] filesTemp = new File[fileList.size()];
/* 325 */               fileList.toArray(filesTemp);
/* 326 */               File[] files = filesTemp;
/*     */ 
/* 329 */               if (listener != null) {
/* 330 */                 listener.filesDropped(files);
/*     */               }
/*     */ 
/* 333 */               evt.getDropTargetContext().dropComplete(true);
/* 334 */               FileDrop.log(out, "FileDrop: drop complete.");
/*     */             }
/*     */             else
/*     */             {
/* 340 */               DataFlavor[] flavors = tr.getTransferDataFlavors();
/* 341 */               boolean handled = false;
/* 342 */               for (int zz = 0; zz < flavors.length; zz++) {
/* 343 */                 if (flavors[zz].isRepresentationClassReader())
/*     */                 {
/* 346 */                   evt.acceptDrop(1);
/* 347 */                   FileDrop.log(out, "FileDrop: reader accepted.");
/*     */ 
/* 349 */                   Reader reader = flavors[zz].getReaderForText(tr);
/*     */ 
/* 351 */                   BufferedReader br = new BufferedReader(reader);
/*     */ 
/* 353 */                   if (listener != null) {
/* 354 */                     listener.filesDropped(FileDrop.createFileArray(br, out));
/*     */                   }
/*     */ 
/* 357 */                   evt.getDropTargetContext().dropComplete(true);
/* 358 */                   FileDrop.log(out, "FileDrop: drop complete.");
/* 359 */                   handled = true;
/* 360 */                   break;
/*     */                 }
/*     */               }
/* 363 */               if (!handled) {
/* 364 */                 FileDrop.log(out, "FileDrop: not a file list or reader - abort.");
/* 365 */                 evt.rejectDrop();
/*     */               }
/*     */             }
/*     */           }
/*     */           catch (IOException io)
/*     */           {
/*     */             JComponent jc;
/* 371 */             FileDrop.log(out, "FileDrop: IOException - abort:");
/* 372 */             io.printStackTrace(out);
/* 373 */             evt.rejectDrop();
/*     */           }
/*     */           catch (UnsupportedFlavorException ufe)
/*     */           {
/*     */             JComponent jc;
/* 376 */             FileDrop.log(out, "FileDrop: UnsupportedFlavorException - abort:");
/* 377 */             ufe.printStackTrace(out);
/* 378 */             evt.rejectDrop();
/*     */           }
/*     */           finally
/*     */           {
/*     */             JComponent jc;
/* 383 */             if ((c instanceof JComponent)) {
/* 384 */               jc = (JComponent)c;
/* 385 */               jc.setBorder(FileDrop.this.normalBorder);
/* 386 */               FileDrop.log(out, "FileDrop: normal border restored.");
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*     */         public void dragExit(DropTargetEvent evt) {
/* 392 */           FileDrop.log(out, "FileDrop: dragExit event.");
/*     */ 
/* 394 */           if ((c instanceof JComponent)) {
/* 395 */             JComponent jc = (JComponent)c;
/* 396 */             jc.setBorder(FileDrop.this.normalBorder);
/* 397 */             FileDrop.log(out, "FileDrop: normal border restored.");
/*     */           }
/*     */         }
/*     */ 
/*     */         public void dropActionChanged(DropTargetDragEvent evt) {
/* 402 */           FileDrop.log(out, "FileDrop: dropActionChanged event.");
/*     */ 
/* 404 */           if (FileDrop.this.isDragOk(out, evt))
/*     */           {
/* 406 */             evt.acceptDrag(1);
/* 407 */             FileDrop.log(out, "FileDrop: event accepted.");
/*     */           }
/*     */           else {
/* 410 */             evt.rejectDrag();
/* 411 */             FileDrop.log(out, "FileDrop: event rejected.");
/*     */           }
/*     */         }
/*     */       };
/* 417 */       makeDropTarget(out, c, recursive);
/*     */     }
/*     */     else {
/* 420 */       log(out, "FileDrop: Drag and drop is not supported with this JVM");
/*     */     }
/*     */   }
/*     */ 
/*     */   private static boolean supportsDnD()
/*     */   {
/* 427 */     if (supportsDnD == null)
/*     */     {
/* 429 */       boolean support = false;
/*     */       try {
/* 431 */         Class arbitraryDndClass = Class.forName("java.awt.dnd.DnDConstants");
/* 432 */         support = true;
/*     */       }
/*     */       catch (Exception e) {
/* 435 */         support = false;
/*     */       }
/* 437 */       supportsDnD = new Boolean(support);
/*     */     }
/* 439 */     return supportsDnD.booleanValue();
/*     */   }
/*     */ 
/*     */   private static File[] createFileArray(BufferedReader bReader, PrintStream out)
/*     */   {
/*     */     try
/*     */     {
/* 448 */       List list = new ArrayList();
/* 449 */       String line = null;
/* 450 */       while ((line = bReader.readLine()) != null) {
/*     */         try
/*     */         {
/* 453 */           if (!ZERO_CHAR_STRING.equals(line))
/*     */           {
/* 455 */             File file = new File(new URI(line));
/* 456 */             list.add(file);
/*     */           }
/*     */         } catch (URISyntaxException ex) { log(out, "FileDrop: URISyntaxException"); }
/*     */ 
/*     */       }
/*     */ 
/* 462 */       return (File[])list.toArray(new File[list.size()]);
/*     */     } catch (IOException ex) {
/* 464 */       log(out, "FileDrop: IOException");
/*     */     }
/* 466 */     return new File[0];
/*     */   }
/*     */ 
/*     */   private void makeDropTarget(final PrintStream out, final Component c, boolean recursive)
/*     */   {
/* 474 */     DropTarget dt = new DropTarget();
/*     */     try {
/* 476 */       dt.addDropTargetListener(this.dropListener);
/*     */     }
/*     */     catch (TooManyListenersException e) {
/* 479 */       e.printStackTrace();
/* 480 */       log(out, "FileDrop: Drop will not work due to previous error. Do you have another listener attached?");
/*     */     }
/*     */ 
/* 484 */     c.addHierarchyListener(new HierarchyListener() {
/*     */       public void hierarchyChanged(HierarchyEvent evt) {
/* 486 */         FileDrop.log(out, "FileDrop: Hierarchy changed.");
/* 487 */         Component parent = c.getParent();
/* 488 */         if (parent == null) {
/* 489 */           c.setDropTarget(null);
/* 490 */           FileDrop.log(out, "FileDrop: Drop target cleared from component.");
/*     */         }
/*     */         else {
/* 493 */           new DropTarget(c, FileDrop.this.dropListener);
/* 494 */           FileDrop.log(out, "FileDrop: Drop target added to component.");
/*     */         }
/*     */       }
/*     */     });
/* 498 */     if (c.getParent() != null) {
/* 499 */       new DropTarget(c, this.dropListener);
/*     */     }
/* 501 */     if ((recursive) && ((c instanceof Container)))
/*     */     {
/* 504 */       Container cont = (Container)c;
/*     */ 
/* 507 */       Component[] comps = cont.getComponents();
/*     */ 
/* 510 */       for (int i = 0; i < comps.length; i++)
/* 511 */         makeDropTarget(out, comps[i], recursive);
/*     */     }
/*     */   }
/*     */ 
/*     */   private boolean isDragOk(PrintStream out, DropTargetDragEvent evt)
/*     */   {
/* 519 */     boolean ok = false;
/*     */ 
/* 522 */     DataFlavor[] flavors = evt.getCurrentDataFlavors();
/*     */ 
/* 525 */     int i = 0;
/* 526 */     while ((!ok) && (i < flavors.length))
/*     */     {
/* 530 */       DataFlavor curFlavor = flavors[i];
/* 531 */       if ((curFlavor.equals(DataFlavor.javaFileListFlavor)) || (curFlavor.isRepresentationClassReader()))
/*     */       {
/* 533 */         ok = true;
/*     */       }
/*     */ 
/* 536 */       i++;
/*     */     }
/*     */ 
/* 540 */     if (out != null) {
/* 541 */       if (flavors.length == 0)
/* 542 */         log(out, "FileDrop: no data flavors.");
/* 543 */       for (i = 0; i < flavors.length; i++) {
/* 544 */         log(out, flavors[i].toString());
/*     */       }
/*     */     }
/* 547 */     return ok;
/*     */   }
/*     */ 
/*     */   private static void log(PrintStream out, String message)
/*     */   {
/* 554 */     if (out != null)
/* 555 */       out.println(message);
/*     */   }
/*     */ 
/*     */   public static boolean remove(Component c)
/*     */   {
/* 572 */     return remove(null, c, true);
/*     */   }
/*     */ 
/*     */   public static boolean remove(PrintStream out, Component c, boolean recursive)
/*     */   {
/* 589 */     if (supportsDnD()) {
/* 590 */       log(out, "FileDrop: Removing drag-and-drop hooks.");
/* 591 */       c.setDropTarget(null);
/* 592 */       if ((recursive) && ((c instanceof Container))) {
/* 593 */         Component[] comps = ((Container)c).getComponents();
/* 594 */         for (int i = 0; i < comps.length; i++)
/* 595 */           remove(out, comps[i], recursive);
/* 596 */         return true;
/*     */       }
/* 598 */       return false;
/*     */     }
/* 600 */     return false;
/*     */   }
/*     */ 
/*     */   public static abstract interface Listener
/*     */   {
/*     */     public abstract void filesDropped(File[] paramArrayOfFile);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.FileDrop
 * JD-Core Version:    0.6.2
 */