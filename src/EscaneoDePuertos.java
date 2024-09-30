//import java.net.Socket;

import java.net.Socket;

public class EscaneoDePuertos {
    public static void main(String[] args) {

        String host = "127.0.0.1";
        int puerto_Inicio = 1;
        int puerto_Fin = 10000; // al 1024 todos los puertos están cerrados.

        for(int puerto = puerto_Inicio; puerto <= puerto_Fin; puerto++){
            try {
                Socket socket = new Socket(host, puerto);
                System.out.println(" Puerto: " + puerto + "está abierto.");
                socket.close();
            } catch (Exception e) {
              //  System.out.println("Puerto " + puerto + " está cerrado.");
            }
        }

        System.out.println("Escaneo completado.");
    }
}

