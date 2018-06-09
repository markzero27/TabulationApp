package ServerConnection;

import Controllers.overviewController;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ServerConnection extends Thread{

    private ServerSocket serverSocket;
    private ClientThread clientThread;
    private String message = "";
    private int port;
    private HashSet<ObjectOutputStream> clients = new HashSet<>();

    @Override
    public void run() {
        port = 1989;
        System.out.println("connection started...");
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                clientThread = new ClientThread(serverSocket.accept());
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String msg) {
        for(ObjectOutputStream outputStream: clients){
            try {
                outputStream.writeObject("Server: "+msg);
                outputStream.flush();
            } catch (IOException e) {
                System.out.println("Sending failed!");
            }
        }
    }

    /*public void setMessage(final String msg){
        Platform.runLater(()->{
            overviewController.updateConnection(msg);
        });
    }*/




    public class ClientThread extends Thread{
        Socket clientSocket;
        ObjectOutputStream outputStream;
        ObjectInputStream inputStream;


        public ClientThread(Socket socket){
            clientSocket = socket;
        }

        @Override
        public void run() {
            System.out.println("client connected!");
            try{
                outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                inputStream = new ObjectInputStream(clientSocket.getInputStream());
                clients.add(outputStream);
                while (clientSocket.isConnected()){
                    try{
                        message = (String) inputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        System.out.println("sending failed");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void disConnect() {
            try{
                outputStream.close();
                inputStream.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
