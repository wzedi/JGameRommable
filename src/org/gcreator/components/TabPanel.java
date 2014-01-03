/*     */ package org.gcreator.components;
/*     */ 
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ 
/*     */ public class TabPanel extends JPanel
/*     */ {
/*     */   public Aurwindow parent;
/*     */   public ExtendedFrame frame;
/*  23 */   public String title = "<none>";
/*     */   public Project project;
/*  25 */   public GFile file = null;
/*     */ 
/*     */   public void dispose()
/*     */   {
/*  29 */     if (!wasModified()) {
/*  30 */       this.parent.remove(this, this.frame);
/*  31 */       if (this.file != null)
/*  32 */         this.file.tabPanel = null;
/*     */     } else {
/*  34 */       Object[] options = { "Yes", "No", "Cancel" };
/*     */ 
/*  37 */       int n = JOptionPane.showOptionDialog(this.frame, "You have unsaved changes in your document.\nDo you want to save it?", "Save document?", 1, 3, null, options, options[2]);
/*     */ 
/*  46 */       if ((n == 0) && 
/*  47 */         (Save())) {
/*  48 */         this.parent.remove(this, this.frame);
/*  49 */         this.file.tabPanel = null;
/*     */       }
/*     */ 
/*  52 */       if (n == 1) {
/*  53 */         this.parent.remove(this, this.frame);
/*  54 */         if (this.file != null)
/*  55 */           this.file.tabPanel = null;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean canSave() {
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean Save() {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean Load()
/*     */   {
/*  70 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean wasModified() {
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean canFind() {
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean canReplace() {
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean Find(String str, boolean useRegex)
/*     */   {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean Replace(String match, String replace, boolean useRegex) {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean ReplaceAll(String match, String replace, boolean useRegex) {
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 100 */     return this.title;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.TabPanel
 * JD-Core Version:    0.6.2
 */