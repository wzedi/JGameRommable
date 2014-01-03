/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JComponent;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.actions.components.YesOrNoIfPanel;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class IfClipboardHasContent extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 22 */   public boolean not = false;
/*    */ 
/* 24 */   public static ImageIcon img = null;
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 32 */     this.not = ((YesOrNoIfPanel)panel).NotCheckbox.isSelected();
/*    */   }
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 37 */     ((YesOrNoIfPanel)panel).NotCheckbox.setSelected(this.not);
/*    */   }
/*    */ 
/*    */   public void setStandardImage(ImageIcon img) {
/* 41 */     img = img;
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 45 */     return img;
/*    */   }
/*    */ 
/*    */   public JComponent createNewPanel(Action action, Project project) {
/* 49 */     YesOrNoIfPanel panel = new YesOrNoIfPanel();
/* 50 */     return panel;
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel) {
/* 54 */     if (panel != null)
/* 55 */       save(panel);
/* 56 */     if ((panel == null) || (!(panel instanceof YesOrNoIfPanel)) || (!((YesOrNoIfPanel)panel).NotCheckbox.isSelected()))
/* 57 */       return LangSupporter.activeLang.getEntry(230);
/* 58 */     return LangSupporter.activeLang.getEntry(231);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel) {
/* 62 */     save(panel);
/* 63 */     if ((panel == null) || (!(panel instanceof YesOrNoIfPanel)) || (!((YesOrNoIfPanel)panel).NotCheckbox.isSelected()))
/* 64 */       return "if(clipboard_has_text())\n";
/* 65 */     return "if(!clipboard_has_text())\n";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.IfClipboardHasContent
 * JD-Core Version:    0.6.2
 */