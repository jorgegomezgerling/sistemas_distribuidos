import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.*;

public class DayTimeServer {
    public static void main(String[] args) {
        int port = 5000; // Puerto encima de 1024 porque salta error.
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor Daytime escuchando en el puerto " + port);

            while (true) {
                // Aceptar conexión de un cliente
                Socket clientSocket = null;
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = now.format(formatter);
//                    System.out.println(formattedDate);

       //             System.out.println(localDate);
       //             System.out.println(localTime);


                    // Enviar la fecha y hora al cliente
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // Envío automático
                    out.println(formattedDate);

                    System.out.println("Fecha y hora enviadas al cliente.");

                } catch (IOException e) {
                    System.out.println("Error al manejar el cliente: " + e.getMessage());
                } finally {
                    // Asegurarse de cerrar el socket del cliente
                    if (clientSocket != null && !clientSocket.isClosed()) {
                        try {
                            clientSocket.close();
                            System.out.println("Conexión con el cliente cerrada.");
                        } catch (IOException e) {
                            System.out.println("Error al cerrar el socket del cliente: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear el servidor: " + e.getMessage());
        }
    }
}
