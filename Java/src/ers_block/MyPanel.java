package ers_block;

import java.awt.Insets;
import java.awt.Panel;

//重写MyPanel类，使Panel的四周留空间 
@SuppressWarnings("serial")
class MyPanel extends Panel
{
     public Insets getInsets()
     {
         return new Insets(10,10,10,50);
     }
}