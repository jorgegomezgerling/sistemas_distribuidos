import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server_msg {
    public static void main(String[] args) {
        ServerSocket so_serv;

        PrintStream data_out_conex;

        // Verificamos que se haya pasado un argumento para el puerto
        if (args.length < 1) {
            System.out.println("Uso: java Server_msg <puerto>");
            return; // Salir si no se proporciona el puerto
        }

        int port = Integer.parseInt(args[0]); // Convertir el argumento a entero

        try {
            so_serv = new ServerSocket(port);
            System.out.println("Servidor atendiendo en el puerto " + port);
            try {
                while (true) {
                    Socket so_conex = so_serv.accept();

                    data_out_conex = new PrintStream(so_conex.getOutputStream());
                    data_out_conex.println("Se ha conectado al socket servidor");
                    so_conex.close();
                }
            } catch (UnknownHostException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}


