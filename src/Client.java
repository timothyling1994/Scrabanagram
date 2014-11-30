import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
 
public class Client extends JFrame implements Runnable{
       
        private static final long serialVersionUID = 1L;
        
        private PrintWriter pw;
        private BufferedReader br;

        public Client(String hostname, int port) {
                super("Player");
                setSize(350, 150);
                setLocation(500, 500);
                setupGUI();
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                try {
                        Socket s = new Socket(hostname, port);
                        this.pw = new PrintWriter(s.getOutputStream());
                        this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        new Thread(this).start();
                }
                catch (IOException ioe) {
                       
                }
        }
 
      
        public void run() {
                try {
                        while (true) {
                                String line = br.readLine();
                                if (line.equals("Ready")) {
       
                                        //Instantiate GUI and other player variable
                                	
                                	
                                }
                                else{
                                        String incomingWord = line;
                                        //Provide the incomind word to player to be unscrambled
                                        
                                        
                                        //here the player unscrambles the word
                                        
                                        //Check if word exists
                                        
                                        //make variable 'points' and add to points according to words created
                                       
                                        
                                        
                                }
                        }
                }
                catch (IOException ioe) {
                }
               
        }
       
        private void setupGUI() {
        	
        	//GUI code here
                
        }
 
        public static void main(String [] args) {
                
                new Client("127.0.0.1", 2500);
        }
}
