package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;

public class ResultFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	
	
	public ResultFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 11, 963, 699);
		 contentPane.add(scrollPane);
		
		
		 textArea= new JTextArea();
		 scrollPane.setViewportView(textArea);
	}
	
	public void updateResultText(String newValue) {
		this.textArea.setText(newValue);
	}
}