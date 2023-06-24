package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class FlyWeightTest extends JFrame{
	
	JButton startDrawing;
	
	int windowWidth = 1350;
	int windowHeight = 750;
	
	Color[] shapeColor = {Color.orange, Color.black, Color.red, Color.yellow, Color.blue,
			Color.pink, Color.cyan, Color.magenta, Color.gray};
	
	public static void main(String[] args) {
		new FlyWeightTest();
	}
	
	public FlyWeightTest() {
		this.setSize(windowWidth, windowHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FlyWweight Test");
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		final JPanel drawingPanel = new JPanel();
		
		startDrawing = new JButton("Draw Stuff");
		
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		contentPane.add(startDrawing, BorderLayout.SOUTH);
		
		startDrawing.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = drawingPanel.getGraphics();
				
				long startTime = System.currentTimeMillis();
				
				for(int i=0;i<100000;i++) {
//					MyRect rect = new MyRect(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());
//					rect.draw(g);
					
					MyRect rect = new MyRect(getRandColor());
					rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
					
				}
				
				long endTime = System.currentTimeMillis();
				
				System.out.println("That took: " + (endTime - startTime));
				
			}
		});
		
		this.add(contentPane);
		this.setVisible(true);
		
	}
	
	private Color getRandColor() {
		Random rand = new Random();
		int randNum = rand.nextInt(9);
		return shapeColor[randNum];
	}
	
	private int getRandX() { return (int)(Math.random()*windowWidth); }
	
	private int getRandY() { return (int)(Math.random()*windowHeight); }
	
}





















