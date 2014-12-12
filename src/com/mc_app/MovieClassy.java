package com.mc_app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Font;

public class MovieClassy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieClassy frame = new MovieClassy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MovieClassy() {
		setTitle("MovieClassy v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 565);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 521, 322);
		contentPane.add(scrollPane);
		
		final JEditorPane newPlot = new JEditorPane();
		newPlot.setToolTipText("Enter the movie plot here...");
		scrollPane.setViewportView(newPlot);
		
		final JLabel result = new JLabel("");
		result.setFont(new Font("Calibri", Font.PLAIN, 13));
		result.setBounds(139, 421, 174, 14);
		contentPane.add(result);
		
		JButton btnGetGenre = new JButton("Get Genre");
		btnGetGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String newPot = newPlot.getText();

		        if(newPot.equals("")){
		            result.setText("Oops... Enter a plot!");
		        }else{
		            MC_Read.ReadCSV();
		            try {
						MC_Read.ReadPlot(newPot);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						result.setText("No input");
					}
		            MC_Read.check();
		            String s = MC_Read.print();
		            result.setText(s);
		        }
			}
		});
		btnGetGenre.setBounds(442, 378, 89, 23);
		contentPane.add(btnGetGenre);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				newPlot.setText("");
			}
		});
		btnClear.setBounds(10, 378, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblTheMovieBelongs = new JLabel("The movie belongs to:");
		lblTheMovieBelongs.setBounds(10, 421, 126, 14);
		contentPane.add(lblTheMovieBelongs);
		
		
		
		JLabel lblNewLabel = new JLabel("Enter the movie plot here...");
		lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel.setBounds(10, 23, 174, 23);
		contentPane.add(lblNewLabel);
	}
}
