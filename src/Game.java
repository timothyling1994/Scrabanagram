import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Game extends JFrame{
	
	String username = "Tester01", level = "Bronze";
	JPanel main, play, setting, startPanel, window;
	CardLayout cl;
	int count = 30, points = 0, numPlayers;
	Timer t;
	int roundCount = 1;
	
	public Game(){
		
		super("Scrabanagram");
		setSize(600, 500);

		window = new JPanel();
		main = new JPanel();		
		JLabel logo = new JLabel(new ImageIcon("./images/main.jpg")); 
		window.setLayout(new CardLayout());
		cl = (CardLayout)(window.getLayout());

		JButton start = new JButton(new ImageIcon("./images/start.jpg"));
		JButton settings = new JButton(new ImageIcon("./images/settings.jpg"));
		start.setBorder(BorderFactory.createEmptyBorder());
		start.setContentAreaFilled(false);
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		
		/*
		start.setRolloverEnabled(true);
		start.setRolloverIcon(new ImageIcon("./images/start.jpg"));
		settings.setRolloverEnabled(true);
		settings.setRolloverIcon(new ImageIcon("./images/start.jpg"));
		*/
		
		settings.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				  cl.show(window, "Settings");
					
				
			}
					
		});
		
		start.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				  cl.show(window, "Start");
				
			}
			
			
			
			
		});
		
		JLabel nameLabel = new JLabel(username);
		JLabel levelLabel = new JLabel(level);
		
		Font font = new Font(nameLabel.getFont().getName(), Font.PLAIN, 24);
		nameLabel.setFont(font);
		levelLabel.setFont(font);

		
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		main.add(Box.createGlue());
		main.add(logo);
		main.add(Box.createGlue());
		main.add(nameLabel);
		main.add(levelLabel);
		main.add(Box.createGlue());
		main.add(start);
		main.add(settings);
		main.add(Box.createGlue());

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        
        // *** START  ***
        JLabel startLabel = new JLabel(new ImageIcon("./images/start.jpg"));
        startPanel = new JPanel();
        JButton two = new JButton(new ImageIcon("./images/two.jpg"));
        JButton three = new JButton(new ImageIcon("./images/three.jpg"));
        two.setBorder(BorderFactory.createEmptyBorder());
		two.setContentAreaFilled(false);
		three.setBorder(BorderFactory.createEmptyBorder());
		three.setContentAreaFilled(false);
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
        startPanel.add(Box.createGlue());
        startPanel.add(startLabel);
        startPanel.add(Box.createGlue());
        startPanel.add(Box.createGlue());
        startPanel.add(two);
        startPanel.add(Box.createGlue());
        startPanel.add(three);
        startPanel.add(Box.createGlue());
        startPanel.add(Box.createGlue());
        startLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        two.setAlignmentX(Component.CENTER_ALIGNMENT);
        three.setAlignmentX(Component.CENTER_ALIGNMENT);
        startPanel.setBackground(Color.WHITE);
        
        two.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
				numPlayers = 2;
				play();
			}	
        });
        
        three.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
				numPlayers = 3;
				play();
			}	
        });	
        
        // *** GAME INTERFACE ***
       
		play = new JPanel();
		play.setBackground(Color.WHITE);
		play.setLayout(new BoxLayout(play, BoxLayout.Y_AXIS));
		
		JLabel smallLogo = new JLabel(new ImageIcon("./images/small.jpg"));
		JLabel round = new JLabel("ROUND " + roundCount);
		round.setFont(new Font(nameLabel.getFont().getName(), Font.BOLD, 36));
		JLabel word = new JLabel("Your word:");
		JTextField input = new JTextField(50);
		
		
		JLabel time = new JLabel("Timer: 30");
		t = new Timer(1000, new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				count--;
				if(count > -1)
					time.setText("Timer: " + Integer.toString(count));
				else{
					
					t.stop();
				}
				
			}
		});
		time.setFont(new Font(nameLabel.getFont().getName(), Font.PLAIN, 20));

		JPanel top = new JPanel();
		top.setLayout(null);
		top.add(smallLogo);
		top.add(time);
		smallLogo.setBounds(2, 5, 250, 100);
		time.setBounds(470, 5, 100, 100);


		play.add(top);
		
		
		
		// *** SETTINGS ***
		
		setting = new JPanel();
		setting.setBackground(Color.WHITE);
		setting.setLayout(new BoxLayout(setting, BoxLayout.Y_AXIS));
		setting.add(Box.createGlue());
		JLabel settingsLabel = new JLabel(new ImageIcon("./images/settings.jpg"));
		JLabel name = new JLabel(new ImageIcon("./images/name.jpg"));
		JLabel icons = new JLabel(new ImageIcon("./images/icon.jpg"));
		JTextField nameInput = new JTextField(username, 35);
		setting.add(settingsLabel);
		setting.add(Box.createGlue());
		setting.add(Box.createGlue());
		setting.add(icons);
		setting.add(Box.createGlue());
		setting.add(name);
		setting.add(Box.createGlue());
		setting.add(nameInput);
		setting.add(Box.createGlue());
		setting.add(Box.createGlue());
		nameInput.setMaximumSize( nameInput.getPreferredSize() );

		settingsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		icons.setAlignmentX(Component.CENTER_ALIGNMENT);
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameInput.setAlignmentX(Component.CENTER_ALIGNMENT);


		
		
		
		main.setBackground(Color.WHITE);
		window.add(main, "Main");
		window.add(play, "Play");
		window.add(setting, "Settings");
		window.add(startPanel, "Start");

		
		cl.show(window, "Main");


		add(window);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void play(){
		
		
		if(numPlayers == 2){
			
			
		}
		
		else{
			
			
		}
		
		
			
		cl.show(window, "Play");
		t.start();

		
	}
	
	
	public static void main(String [] args){
		
		Game g = new Game();
	}

}