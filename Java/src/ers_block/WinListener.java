package ers_block;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinListener extends WindowAdapter
{
       public void windowClosing(WindowEvent l)
       {
           System.exit(0);
       }
}