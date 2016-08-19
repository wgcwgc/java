package AYIT;
import javax.swing.*;
public class GUI
{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static void main(String [] args)
		{
			JButton jbtOK = new JButton("OK");
			JButton jbtCancel = new JButton("Cancel");
			JLabel jlblName = new JLabel ("Enter your name:");
			JTextField jtfName = new JTextField("Type Name Here");
			JCheckBox jchkBold = new JCheckBox ("Bold");
			JCheckBox jchkItalic = new JCheckBox ("Italic");
			JRadioButton jrbRed = new JRadioButton ("Red");
			JRadioButton jrbYellow = new JRadioButton ("Yellow");
			JComboBox jcboColor = new JComboBox (new String [] {"Freshman","Sophomore","Junior","Senior"});

			JPanel panel = new JPanel ();

			panel.add(jbtOK);
			panel.add(jbtCancel);
			panel.add(jlblName);
			panel.add(jtfName);
			panel.add(jchkBold);
			panel.add(jchkItalic);
			panel.add(jrbRed);
			panel.add(jrbYellow);
			panel.add(jcboColor);

			JFrame frame = new JFrame ();

			frame.add(panel);
			frame.setTitle("Show GUI Components");
			frame.setSize(777,555);
			frame.setLocation(444,111);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
}
