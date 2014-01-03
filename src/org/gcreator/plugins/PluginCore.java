/*    */ package org.gcreator.plugins;
/*    */ 
/*    */ import org.gcreator.exceptions.InvalidSignalException;
/*    */ 
/*    */ public abstract class PluginCore
/*    */ {
/*    */   public void onLoad()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void onLAFDefined()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void onSplashStart()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void onMainWindowStart()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void onSplashDispose()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void onMainWindowDispose()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Object sendSignal(PluginCore caller, Object signal)
/*    */     throws InvalidSignalException
/*    */   {
/* 28 */     return onSignalReceived(caller, signal);
/*    */   }
/*    */   protected Object onSignalReceived(PluginCore caller, Object signal) throws InvalidSignalException {
/* 31 */     return null;
/*    */   }
/*    */   public String getID() {
/* 34 */     return null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.PluginCore
 * JD-Core Version:    0.6.2
 */