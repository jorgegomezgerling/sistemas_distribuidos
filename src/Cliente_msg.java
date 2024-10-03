import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente_msg {
    public static void main(String[] args) {
        Socket cliente_so;
        String host = "172.20.10.5"; // dependiendo el IP de la maquina en un momento dado.

        // Verificamos que se haya pasado un argumento para el puerto
        if (args.length < 1) {
            System.out.println("Uso: java Cliente_msg <puerto>");
            return; // Salir si no se proporciona el puerto
        }

        int port = Integer.parseInt(args[0]); // Convertir el argumento a entero

        try {
            cliente_so = new Socket(host, port);
            // data_daytime = new DataInputStream(so_daytime.getInputStream());

           // BufferedReader InputStream = new BufferedReader(new InputStreamReader(cliente_so.getInputStream()));

            System.out.println("Conectado a: " + cliente_so.getInetAddress());
            System.out.println("port: " + cliente_so.getPort());

        } catch (UnknownHostException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
