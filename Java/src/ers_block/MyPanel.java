package ers_block;

import java.awt.Insets;
import java.awt.Panel;

//��дMyPanel�࣬ʹPanel���������ռ� 
@SuppressWarnings("serial")
class MyPanel extends Panel
{
     public Insets getInsets()
     {
         return new Insets(10,10,10,50);
     }
}