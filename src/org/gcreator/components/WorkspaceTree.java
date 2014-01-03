/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.DropMode;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.JTree.DropLocation;
/*     */ import javax.swing.TransferHandler;
/*     */ import javax.swing.TransferHandler.TransferSupport;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeNode;
/*     */ import javax.swing.tree.TreePath;
/*     */ import javax.swing.tree.TreeSelectionModel;
/*     */ import org.gcreator.components.impl.WorkspaceCellRenderer;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Group;
/*     */ import org.gcreator.units.ObjectNode;
/*     */ 
/*     */ public class WorkspaceTree extends JTree
/*     */ {
/*     */   public WorkspaceTree(TreeNode root)
/*     */   {
/*  25 */     super(root);
/*  26 */     setScrollsOnExpand(true);
/*  27 */     int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  28 */     if (ver >= 6) {
/*  29 */       setDragEnabled(true);
/*  30 */       setDropMode(DropMode.ON_OR_INSERT);
/*     */     }
/*  32 */     getSelectionModel().setSelectionMode(1);
/*     */     try {
/*  34 */       if (ver >= 6)
/*     */       {
/*  37 */         setDropMode(DropMode.ON_OR_INSERT);
/*     */ 
/*  39 */         setTransferHandler(new TransferHandler()
/*     */         {
/*     */           protected Transferable createTransferable(JComponent c) {
/*  42 */             DefaultMutableTreeNode node = (DefaultMutableTreeNode)WorkspaceTree.this.getLastSelectedPathComponent();
/*  43 */             if (!(node instanceof ObjectNode))
/*  44 */               return null;
/*  45 */             ObjectNode f = (ObjectNode)node;
/*  46 */             if ((f.object instanceof GFile)) {
/*  47 */               System.out.println("" + ((GFile)f.object).name);
/*  48 */               return (GFile)f.object;
/*     */             }
/*  50 */             return null;
/*     */           }
/*     */ 
/*     */           public int getSourceActions(JComponent c)
/*     */           {
/*  55 */             return 2;
/*     */           }
/*     */ 
/*     */           public boolean canImport(TransferHandler.TransferSupport support)
/*     */           {
/*  60 */             TreePath drop = ((JTree.DropLocation)support.getDropLocation()).getPath();
/*  61 */             if (drop == null) {
/*  62 */               return false;
/*     */             }
/*  64 */             if (!(drop.getLastPathComponent() instanceof ObjectNode))
/*  65 */               return false;
/*  66 */             ObjectNode dropNode = (ObjectNode)drop.getLastPathComponent();
/*  67 */             ObjectNode dragNode = (ObjectNode)((JTree)support.getComponent()).getLastSelectedPathComponent();
/*     */ 
/*  70 */             if ((dropNode.object instanceof Group)) {
/*  71 */               if (((Group)dropNode.object).allowsFileType(((GFile)dragNode.object).type)) {
/*  72 */                 return true;
/*     */               }
/*  74 */               return false;
/*     */             }
/*     */ 
/*  79 */             return false;
/*     */           }
/*     */ 
/*     */           public boolean importData(TransferHandler.TransferSupport support) {
/*  83 */             if (!canImport(support)) {
/*  84 */               return false;
/*     */             }
/*  86 */             JTree.DropLocation drop = (JTree.DropLocation)support.getDropLocation();
/*  87 */             int dropIndex = drop.getChildIndex();
/*  88 */             ObjectNode dropNode = (ObjectNode)drop.getPath().getLastPathComponent();
/*  89 */             ObjectNode dragNode = (ObjectNode)((JTree)support.getComponent()).getLastSelectedPathComponent();
/*  90 */             if (dropIndex == -1) {
/*  91 */               dropIndex = dropNode.getChildCount();
/*     */             }
/*  93 */             if ((dropNode == dragNode.getParent()) && (dropIndex > dragNode.getParent().getIndex(dragNode))) {
/*  94 */               dropIndex--;
/*     */             }
/*  96 */             dropNode.insert(dragNode, dropIndex);
/*  97 */             WorkspaceTree.this.expandPath(new TreePath(dropNode.getPath()));
/*  98 */             WorkspaceTree.this.updateUI();
/*  99 */             return true;
/*     */           }
/*     */         });
/*     */       }
/*     */       else
/*     */       {
/* 105 */         System.out.println(ver);
/*     */       }
/*     */     } catch (Exception e) {
/* 108 */       System.out.println(e.getMessage());
/*     */     }
/* 110 */     setCellRenderer(new WorkspaceCellRenderer());
/* 111 */     expandRow(0);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.WorkspaceTree
 * JD-Core Version:    0.6.2
 */