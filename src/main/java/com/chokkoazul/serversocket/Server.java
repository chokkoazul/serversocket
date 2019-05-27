package com.chokkoazul.serversocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;
    int puerto=9000;
    DataOutputStream salida;
    BufferedReader entrada;


    public void iniciar(){

        try {
            serverSocket = new ServerSocket(puerto);
            socket = new Socket();
            socket = serverSocket.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensaje;
            do{
                mensaje = entrada.readLine();
                System.out.println(mensaje);

                salida = new DataOutputStream(socket.getOutputStream());
                salida.writeUTF("Adios Mundo\n");

            }
            while(!mensaje.equals("fin"));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
