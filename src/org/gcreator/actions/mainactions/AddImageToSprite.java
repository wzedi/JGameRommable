/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.actions.components.AddImageToSpritePanel;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class AddImageToSprite extends ActionPattern
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 22 */   public static ImageIcon img = new ImageIcon(Comment.class.getResource("/org/gcreator/actions/images/Add_Image_To_Sprite.png"));
/*    */ 
/* 24 */   public String URL = ""; public String Sprite = "";
/* 25 */   public int fails_1 = 0; public int fails_2 = 0;
/*    */ 
/*    */   public void save(JComponent panel)
/*    */   {
/* 33 */     this.URL = ((AddImageToSpritePanel)panel).URL.getText();
/* 34 */     this.Sprite = ((AddImageToSpritePanel)panel).Sprite.getText();
/* 35 */     this.fails_1 = ((AddImageToSpritePanel)panel).fails1.getSelectedIndex();
/* 36 */     this.fails_2 = ((AddImageToSpritePanel)panel).fails2.getSelectedIndex();
/*    */   }
/*    */ 
/*    */   public void load(JComponent panel)
/*    */   {
/* 41 */     ((AddImageToSpritePanel)panel).URL.setText(this.URL);
/* 42 */     ((AddImageToSpritePanel)panel).Sprite.setText(this.Sprite);
/* 43 */     ((AddImageToSpritePanel)panel).fails1.setSelectedIndex(this.fails_1);
/* 44 */     ((AddImageToSpritePanel)panel).fails2.setSelectedIndex(this.fails_2);
/*    */   }
/*    */ 
/*    */   public void setStandardImage(ImageIcon img) {
/* 48 */     img = img;
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 52 */     return img;
/*    */   }
/*    */ 
/*    */   public JComponent createNewPanel(Action action, Project project) {
/* 56 */     AddImageToSpritePanel panel = new AddImageToSpritePanel();
/* 57 */     return panel;
/*    */   }
/*    */ 
/*    */   public String getStandardText(JComponent panel) {
/* 61 */     if (panel != null)
/* 62 */       save(panel);
/* 63 */     return LangSupporter.activeLang.getEntry(229);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent cmp) {
/* 67 */     if (cmp != null)
/* 68 */       save(cmp);
/* 69 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.AddImageToSprite
 * JD-Core Version:    0.6.2
 */