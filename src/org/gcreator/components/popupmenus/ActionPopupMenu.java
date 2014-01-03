/*     */ package org.gcreator.components.popupmenus;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.gcreator.actions.Action;
/*     */ import org.gcreator.components.custom.MenuGenerator;
/*     */ import org.gcreator.editors.ActorEditor;
/*     */ import org.gcreator.editors.TimelineEditor;
/*     */ import org.gcreator.events.Event;
/*     */ import org.gcreator.fileclass.res.TimelineStep;
/*     */ import org.gcreator.managers.ActorEditorClipboard;
/*     */ 
/*     */ public class ActionPopupMenu extends MenuGenerator
/*     */ {
/*  25 */   private ActorEditor aedit = null;
/*  26 */   private TimelineEditor tedit = null;
/*     */   private JMenuItem delete;
/*     */   private JMenuItem cut;
/*     */   private JMenuItem copy;
/*     */   private JMenuItem paste;
/*     */   private JMenuItem editaction;
/*     */ 
/*     */   public ActionPopupMenu(ActorEditor edit)
/*     */   {
/*  32 */     this.aedit = edit;
/*  33 */     init();
/*     */   }
/*     */ 
/*     */   private void init() {
/*  37 */     Object cut = addMenuItem(252, new ImageIcon(getClass().getResource("/org/gcreator/resources/general/cut.png")));
/*  38 */     Object copy = addMenuItem(253, new ImageIcon(getClass().getResource("/org/gcreator/resources/general/copy.png")));
/*  39 */     Object paste = addMenuItem(254, new ImageIcon(getClass().getResource("/org/gcreator/resources/general/paste.png")));
/*  40 */     Object delete = addMenuItem(255, new ImageIcon(getClass().getResource("/org/gcreator/resources/general/delete.png")));
/*     */ 
/*  51 */     addActionListener(delete, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  53 */         ActionPopupMenu.this.onDelete();
/*     */       }
/*     */     });
/*  56 */     addActionListener(cut, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  58 */         ActionPopupMenu.this.onCut();
/*     */       }
/*     */     });
/*  61 */     addActionListener(copy, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  63 */         ActionPopupMenu.this.onCopy();
/*     */       }
/*     */     });
/*  66 */     addActionListener(paste, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  68 */         ActionPopupMenu.this.onPaste();
/*     */       }
/*     */     });
/*  71 */     addActionListener(this.editaction, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  73 */         ActionPopupMenu.this.onEdit();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public ActionPopupMenu(TimelineEditor edit)
/*     */   {
/*  85 */     this.tedit = edit;
/*  86 */     init();
/*     */   }
/*     */ 
/*     */   public void onEdit() {
/*  90 */     if (this.aedit != null)
/*  91 */       this.aedit.jScrollPane3.setViewportView(((Action)this.aedit.jList2.getSelectedValue()).getPanel());
/*  92 */     if (this.tedit != null)
/*  93 */       this.aedit.jScrollPane3.setViewportView(((Action)this.tedit.jList1.getSelectedValue()).getPanel());
/*     */   }
/*     */ 
/*     */   public void onCut() {
/*  97 */     if ((this.aedit != null) && 
/*  98 */       (this.aedit.jList2.getSelectedIndex() == -1))
/*     */     {
/* 100 */       System.out.println("Error you need to select an action!");
/*     */     }
/*     */ 
/* 103 */     if ((this.tedit != null) && 
/* 104 */       (this.tedit.jList1.getSelectedIndex() == -1))
/*     */     {
/* 106 */       System.out.println("Error you need to select an action!");
/*     */     }
/*     */ 
/* 109 */     int x = 0;
/* 110 */     if (this.aedit != null)
/* 111 */       x = this.aedit.jList2.getSelectedIndex();
/* 112 */     if (this.tedit != null)
/* 113 */       x = this.tedit.jList1.getSelectedIndex();
/*     */     try {
/* 115 */       Vector array = null;
/* 116 */       if (this.aedit != null)
/* 117 */         array = ((Event)this.aedit.jList1.getSelectedValue()).actions;
/* 118 */       if (this.tedit != null)
/* 119 */         array = (TimelineStep)this.tedit.jComboBox3.getSelectedItem();
/* 120 */       Action a = (Action)array.get(x);
/* 121 */       ActorEditorClipboard.copiedAction = a;
/* 122 */       array.remove(x);
/*     */     } catch (Exception e) {
/*     */     }
/* 125 */     if (this.aedit != null) {
/* 126 */       this.aedit.updateUI();
/* 127 */       this.aedit.updateActionList();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onCopy()
/*     */   {
/* 134 */     int x = 0;
/* 135 */     if (this.aedit != null)
/* 136 */       x = this.aedit.jList2.getSelectedIndex();
/* 137 */     if (this.tedit != null)
/* 138 */       x = this.tedit.jList1.getSelectedIndex();
/*     */     try {
/* 140 */       Vector array = null;
/* 141 */       if (this.aedit != null)
/* 142 */         array = ((Event)this.aedit.jList1.getSelectedValue()).actions;
/* 143 */       if (this.tedit != null)
/* 144 */         array = (TimelineStep)this.tedit.jComboBox3.getSelectedItem();
/* 145 */       Action a = (Action)array.get(x);
/* 146 */       ActorEditorClipboard.copiedAction = a.clone();
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 150 */     if (this.aedit != null) {
/* 151 */       this.aedit.updateUI();
/* 152 */       this.aedit.updateActionList();
/*     */     }
/* 154 */     if (this.tedit != null) {
/* 155 */       this.tedit.updateUI();
/* 156 */       this.tedit.updateActionList();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onPaste() {
/* 161 */     if (ActorEditorClipboard.copiedAction == null) return; try
/*     */     {
/* 163 */       Vector array = null;
/* 164 */       if (this.aedit != null)
/* 165 */         array = ((Event)this.aedit.jList1.getSelectedValue()).actions;
/* 166 */       if (this.tedit != null)
/* 167 */         array = (TimelineStep)this.tedit.jComboBox3.getSelectedItem();
/* 168 */       array.add(ActorEditorClipboard.copiedAction);
/*     */     } catch (Exception e) {
/*     */     }
/* 171 */     if (this.aedit != null) {
/* 172 */       this.aedit.updateUI();
/* 173 */       this.aedit.updateActionList();
/*     */     }
/* 175 */     if (this.tedit != null) {
/* 176 */       this.tedit.updateUI();
/* 177 */       this.tedit.updateActionList();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void onDelete() {
/* 182 */     int x = 0;
/* 183 */     if (this.aedit != null)
/* 184 */       this.aedit.jList2.getSelectedIndex();
/* 185 */     if (this.tedit != null)
/* 186 */       this.tedit.jList1.getSelectedIndex();
/*     */     try {
/* 188 */       Vector array = null;
/* 189 */       if (this.aedit != null)
/* 190 */         array = ((Event)this.aedit.jList1.getSelectedValue()).actions;
/* 191 */       if (this.tedit != null)
/* 192 */         array = (TimelineStep)this.tedit.jComboBox3.getSelectedItem();
/* 193 */       array.remove(x);
/*     */     } catch (Exception e) {
/*     */     }
/* 196 */     if (this.aedit != null) {
/* 197 */       this.aedit.updateUI();
/* 198 */       this.aedit.updateActionList();
/*     */     }
/* 200 */     if (this.tedit != null) {
/* 201 */       this.tedit.updateUI();
/* 202 */       this.tedit.updateActionList();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.ActionPopupMenu
 * JD-Core Version:    0.6.2
 */