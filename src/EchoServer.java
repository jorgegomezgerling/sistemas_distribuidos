import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        int port = 50000; // De acuerdo con la documentación debe ser el puerto 7;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor Echo escuchando en el puerto " + port);

            while (true) {
                // Aceptar conexión de un cliente
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept(); // Establece conexión
                    System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                    // Para leer lo que se retornará
                    BufferedReader in = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));


                    // Establezco el retorno y limpio el buffer;
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Mensaje recibido: " + inputLine);

                        out.println("Echo: " + inputLine);

                        if (inputLine.equals(".")) {
                            break;
                        }
                    }
                    clientSocket.close();
                    System.out.println("Conexión con el cliente cerrada. ");
                } catch (IOException e) {
                    System.out.println("Error al crear el servidor: " + e.getMessage());
                }
            }
        }
    }
}
