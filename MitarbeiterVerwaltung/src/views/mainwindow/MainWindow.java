package views.mainwindow;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import helpers.FileHandler;
import models.Mitarbeiter;

public class MainWindow extends JPanel {
	private JButton btnAdd;
    private JButton btnDel;
    private JButton btnLogin;
    private JLabel lbName;
    private JTextField tfName;
    private JLabel lbAge;
    private JTextField tfAge;
    private JLabel lbEmail;
    private JTextField tfEmail;
    private JLabel lbPassword;
    private JPasswordField tfPassword;
    private JList<String> listEmployees;
    
    // Meine ArrayList für die Serialisierung / Deserialsierung in JSON
    ArrayList<Mitarbeiter> listEmployeesItems = new ArrayList<Mitarbeiter>();
    
    // Meine Model (Liste) für die JList Komponente. 
    // Beinhaltet die Elemente, die angezeigt werden sollen als String
    DefaultListModel<String> listModel = new DefaultListModel<String>();
    
    // Die JSON Datei, wo unsere Mitarbeiter gespeichert werden
    String mitarbeiterJsonFile = "mitarbeiter.json";
	
	public MainWindow() {
        // Beim Programmstart
        try {
        	// Lese die mitarbeiter.json Datei aus und erwarte ein Array mit Mitarbeiter Objekten
        	Mitarbeiter[] employeesFromJson = FileHandler.readJson(mitarbeiterJsonFile, Mitarbeiter[].class);
        	// Sollte etwas gültiges ausgelesen werden können...
        	if(employeesFromJson != null) {
        		// ... iteriere durch das Array mit Mitarbeiter Objekten
        		for(int i = 0; i < employeesFromJson.length; i++) {
        			// und füge jedes einzelnde Element in unsere ArrayList
        			this.listEmployeesItems.add(employeesFromJson[i]);
        			// und befülle das Model für die JList, damit es weiß, welche Elemente es anzeigen soll
        			this.listModel.addElement(employeesFromJson[i].getName() + " (" + employeesFromJson[i].getAlter() + ")");
        		}
        	}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        
        this.btnAdd = new JButton ("Hinzufügen");
        this.btnDel = new JButton ("Löschen");
        this.btnLogin = new JButton ("Login");
        this.lbName = new JLabel ("Name");
        this.tfName = new JTextField (1);
        this.lbAge = new JLabel ("Alter");
        this.tfAge = new JTextField (1);
        this.lbEmail = new JLabel ("Email");
        this.tfEmail = new JTextField (1);
        this.lbPassword = new JLabel ("Kennwort");
        this.tfPassword = new JPasswordField (1);
        this.listEmployees = new JList<String>(listModel);

        super.setPreferredSize (new Dimension (306, 429));
        super.setLayout (null);

        super.add(btnAdd);
        super.add(btnDel);
        super.add(btnLogin);
        super.add(lbName);
        super.add(tfName);
        super.add(lbAge);
        super.add(tfAge);
        super.add(lbEmail);
        super.add(tfEmail);
        super.add(lbPassword);
        super.add(tfPassword);
        super.add(listEmployees);

        this.btnAdd.setBounds (5, 395, 100, 30);
        this.btnDel.setBounds (110, 395, 95, 30);
        this.btnLogin.setBounds (210, 395, 90, 30);
        this.lbName.setBounds (5, 285, 50, 20);
        this.tfName.setBounds (5, 305, 210, 25);
        this.lbAge.setBounds (230, 285, 40, 20);
        this.tfAge.setBounds (220, 305, 80, 25);
        this.lbEmail.setBounds (5, 335, 100, 25);
        this.tfEmail.setBounds (5, 360, 165, 25);
        this.lbPassword.setBounds (175, 335, 100, 25);
        this.tfPassword.setBounds (175, 360, 125, 25);
        this.listEmployees.setBounds (5, 5, 295, 280);
        
        this.btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Erstelle neuen Mitarbeiter anhand der GUI-TextFelder
				Mitarbeiter neuerMitarbeiter = new Mitarbeiter(
						tfName.getText(), 
						Integer.parseInt(tfAge.getText()), 
						tfEmail.getText(), 
						String.valueOf(tfPassword.getPassword())
					);
				
				// Füge diesen in unsere ArrayList für die JSON Serialsierung/Deserialisierung 
				// als Mitarbeiter Objekt hinzu, sowie in das Model für die JList als String
				MainWindow.this.listEmployeesItems.add(neuerMitarbeiter);
				MainWindow.this.listModel.addElement(neuerMitarbeiter.getName() + " (" + neuerMitarbeiter.getAlter() + ")");
				
				// Schreibe die neuen Daten in die json-Datei (Serialisierung)
				FileHandler.writeJson(mitarbeiterJsonFile, listEmployeesItems.toArray());
			}
        });
        
        this.btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Sollte in der JList ein Element ausgewählt sein, bekommen wir seine Position
				// Diese Position ist die selbe, wie in unserem Array mit Mitarbeiter Objekten
				if(listEmployees.getSelectedIndex() > -1) {
					// Lösche den Mitarbeiter aus unserem Array
					MainWindow.this.listEmployeesItems.remove(listEmployees.getSelectedIndex());
					// Entferne den Listen-Eintrag von der JList Komponente
					MainWindow.this.listModel.removeElementAt(listEmployees.getSelectedIndex());
					// Schreibe neue Daten wieder in die json-Datei
					FileHandler.writeJson(mitarbeiterJsonFile, listEmployeesItems.toArray());
				}
			}
        });
	}
}
