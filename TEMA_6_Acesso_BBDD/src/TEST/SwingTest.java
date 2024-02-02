package TEST;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class SwingTest {
	



private static JLabel label = new JLabel("--");
private static JButton btnlimpia = new JButton("Limpia");
private static JButton btnescribe = new JButton("Escribe");
public static void acciones(ActionEvent e) {
Object obj=e.getSource();
if (obj == btnlimpia){
label.setText("");
}
if (obj == btnescribe){
label.setText("Hola Mundo");
}
}
public static void main(String[] args) {
try {
UIManager.setLookAndFeel(
UIManager.getCrossPlatformLookAndFeelClassName());
} catch (Exception e) { }
JFrame frame = new JFrame("Controlando eventos");
btnlimpia.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
acciones(e);
}
});
btnescribe.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
acciones(e);
}
});
frame.getContentPane().add(label);
frame.getContentPane().add(btnlimpia);
frame.getContentPane().add(btnescribe);
frame.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});
frame.setLayout(new GridLayout(0,1));
frame.pack();
frame.setVisible(true);
}
}
	


