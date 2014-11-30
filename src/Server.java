import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
	private Vector<ThreadClass> players = new Vector<ThreadClass>();
    public Server(int port) {
         
            try{
                    ServerSocket ss = new ServerSocket(port);
                    while (true) {
                           
                       
                          
                            Socket s = ss.accept();
                           
                            
                            
                            ThreadClass tt = new ThreadClass(s, this);
                           
                            
                            players.add(tt);
                            if (players.size() >=2) {
                                    sendReady();
                            }
                            new Thread(tt).start();
                    }
            }
            catch(IOException ioe) {
                    return;
            }
    }
    public void sendReady() {
        for (ThreadClass player : players) {
                player.sendReadyMessage();
        }
}

public void removeThreadClass(ThreadClass tt) {
        players.remove(tt);
}

public void dealWord(String word, ThreadClass tt) {
        for (ThreadClass player : players) {
                if (player.equals(tt)) {
                        player.sendWord(word);
                }
        }      


}

public static void main(String [] args) {
       
        new Server(2500);
        System.out.println("Server Connected at Port. Launch Client Class twice to start game!");
}
}


   

