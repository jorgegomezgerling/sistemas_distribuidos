import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente_mensajeria {
    public static void main(String[] args) {

        // Evidentemente para este ejercicio se necesita otra máquina linux. Probar luego. Arreglado el tema de los metodos deprecados.

        Socket socket_cliente;
       // DataInputStream data_in_socket;
        //DataInputStream data_in_consola;
        String linea;
       PrintStream data_out_socket;
       // String host = "172.20.10.5";

        if (args.length < 1) {
            System.out.println("Uso: java Cliente_msg <name_server> <puerto>");
            return; // Salir si no se proporciona el puerto ni el servidor
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]); // Convertir el argumento a entero



        try {
            socket_cliente = new Socket(host, port);
            System.out.println("Conectado con éxito.");
            BufferedReader data_in_socket = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
            BufferedReader data_in_consola = new BufferedReader(new InputStreamReader(System.in));

            data_out_socket = new PrintStream(socket_cliente.getOutputStream());

            //data_in_consola = new DataInputStream(System.in);

            while(true){
                linea = data_in_consola.readLine();
                if (linea.equals(".")) break;
                data_out_socket.println(linea);
                System.out.println(data_in_socket.readLine());
            }
            socket_cliente.close();
        } catch (UnknownHostException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
