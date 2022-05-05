package views;

import java.awt.Dimension;

import javax.swing.JFrame;

import views.mainwindow.MainWindow;

// Java Framework für die GUI: Swing
public class MainFrame extends JFrame {
	public MainFrame() {
		super.setTitle("Mitarbeiter Verwaltung");
		super.setSize(new Dimension(400, 400)); // Breite & Höhe in Pixel
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Standardverhalten beim X-Button oben Rechts im Fenster
		super.setLocationRelativeTo(null); // Starte das Fenster mittig auf dem Bildschirm
		
		MainWindow mw = new MainWindow();
		super.getContentPane().add(mw);
		
		super.pack();
		
		super.setVisible(true); // Mach das Fenster sichtbar
	}
}
