import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClass implements Runnable{
	
	private static final long serialVersionUID = 1L;
    private Socket s;
    private Server serverClassInstance;
    private PrintWriter pw;
   
    public ThreadClass(Socket s, Server serverClassInstance) {
            this.s = s;
            this.serverClassInstance = serverClassInstance;
           
            try{
                    //Establish an output stream for the game.
                    this.pw = new PrintWriter(s.getOutputStream());
            }
            catch (IOException ioe) {
            }
    }
    
    public void sendReadyMessage() {
        pw.println("Ready");
        pw.flush();
}
    public void sendWord(String word)
    {
    	pw.println(word);
    	pw.flush();
    }

public void run() {
        try{
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                        String word = br.readLine();

                        serverClassInstance.dealWord(word, this);
                }
        }
        catch(IOException ioe) {
          
                serverClassInstance.removeThreadClass(this);
        }
}
	
	

}
