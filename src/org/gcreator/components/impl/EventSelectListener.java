package org.gcreator.components.impl;

public abstract interface EventSelectListener
{
  public static final int CREATE = 1000;
  public static final int DESTROY = 2000;
  public static final int BEGINSTEP = 3001;
  public static final int STEP = 3002;
  public static final int ENDSTEP = 3003;
  public static final int DRAW = 4005;
  public static final int MOUSELEFTCLICKED = 5006;
  public static final int MOUSELEFTPRESSED = 5007;
  public static final int MOUSELEFTRELEASED = 5008;
  public static final int GLOBALMOUSELEFTCLICKED = 5009;
  public static final int GLOBALMOUSELEFTPRESSED = 5010;
  public static final int GLOBALMOUSELEFTRELEASED = 5011;
  public static final int MOUSERIGHTCLICKED = 5012;
  public static final int MOUSERIGHTPRESSED = 5013;
  public static final int MOUSERIGHTRELEASED = 5014;
  public static final int GLOBALMOUSERIGHTCLICKED = 5015;
  public static final int GLOBALMOUSERIGHTPRESSED = 5016;
  public static final int GLOBALMOUSERIGHTRELEASED = 5017;
  public static final int MOUSEOVER = 5018;
  public static final int MOUSEOUT = 5019;
  public static final int ALARM = 5020;
  public static final int Keyboard = 6000;
  public static final int Collision = 7000;
  public static final int Keypress = 8000;
  public static final int Keyrelease = 9000;
  public static final int Other = 10000;

  public abstract void eventSelected(int paramInt);

  public abstract void eventSelected(int paramInt, String paramString);
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.EventSelectListener
 * JD-Core Version:    0.6.2
 */