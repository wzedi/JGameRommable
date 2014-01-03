/*    */ package org.gcreator.actions;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.actions.mainactions.AddImageToSprite;
/*    */ import org.gcreator.actions.mainactions.Comment;
/*    */ import org.gcreator.actions.mainactions.EndOfABlock;
/*    */ import org.gcreator.actions.mainactions.ExecuteCode;
/*    */ import org.gcreator.actions.mainactions.IfClipboardHasContent;
/*    */ import org.gcreator.actions.mainactions.NextScene;
/*    */ import org.gcreator.actions.mainactions.PreviousScene;
/*    */ import org.gcreator.actions.mainactions.SetHSpeed;
/*    */ import org.gcreator.actions.mainactions.SetVSpeed;
/*    */ import org.gcreator.actions.mainactions.StartOfABlock;
/*    */ import org.gcreator.actions.mainactions.WarpTo;
/*    */ import org.gcreator.actions.platform.CmdAction;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class ActionContainer
/*    */ {
/* 20 */   public static Vector<ActionCategory> actionCats = new Vector();
/*    */ 
/* 22 */   static { ActionCategory main = new ActionCategory();
/* 23 */     ActionCategory move = new ActionCategory();
/* 24 */     ActionCategory scenes = new ActionCategory();
/* 25 */     ActionCategory draw2D = new ActionCategory();
/* 26 */     ActionCategory clipboard = new ActionCategory();
/* 27 */     ActionCategory platform = new ActionCategory();
/* 28 */     main.add(new StartOfABlock());
/* 29 */     main.add(new EndOfABlock());
/* 30 */     main.add(new Comment());
/* 31 */     main.add(new ExecuteCode());
/* 32 */     main.name = LangSupporter.activeLang.getEntry(199);
/* 33 */     main.icon = new ImageIcon(ActionContainer.class.getResource("/org/gcreator/actions/images/Main.png"));
/* 34 */     move.add(new SetHSpeed());
/* 35 */     move.add(new SetVSpeed());
/* 36 */     move.add(new WarpTo());
/* 37 */     move.name = LangSupporter.activeLang.getEntry(200);
/* 38 */     move.icon = new ImageIcon(ActionContainer.class.getResource("/org/gcreator/actions/images/hspeed.png"));
/* 39 */     scenes.add(new NextScene());
/* 40 */     scenes.add(new PreviousScene());
/* 41 */     scenes.name = LangSupporter.activeLang.getEntry(208);
/* 42 */     scenes.icon = new ImageIcon(ActionContainer.class.getResource("/org/gcreator/actions/images/Scene.png"));
/* 43 */     draw2D.add(new AddImageToSprite());
/* 44 */     draw2D.name = LangSupporter.activeLang.getEntry(201);
/* 45 */     draw2D.icon = new ImageIcon(ActionContainer.class.getResource("/org/gcreator/actions/images/Draw2D.png"));
/* 46 */     clipboard.name = LangSupporter.activeLang.getEntry(202);
/* 47 */     clipboard.icon = new ImageIcon(ActionContainer.class.getResource("/org/gcreator/resources/general/paste.png"));
/* 48 */     clipboard.add(new IfClipboardHasContent());
/* 49 */     platform.name = LangSupporter.activeLang.getEntry(203);
/* 50 */     platform.add(new CmdAction());
/* 51 */     actionCats.add(main);
/* 52 */     actionCats.add(move);
/* 53 */     actionCats.add(scenes);
/* 54 */     actionCats.add(draw2D);
/* 55 */     actionCats.add(clipboard);
/* 56 */     actionCats.add(platform);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.ActionContainer
 * JD-Core Version:    0.6.2
 */