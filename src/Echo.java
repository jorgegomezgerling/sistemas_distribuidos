import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Echo {
    public static void main(String[] args) {

        // Evidentemente para este ejercicio se necesita otra máquina linux. Probar luego. Arreglado el tema de los metodos deprecados.

        Socket so_echo;
       // DataInputStream data_in_socket;
    //    DataInputStream data_in_consola;
        String linea;
        PrintStream data_out_socket;
        String host = "localhost";

        try {
            so_echo = new Socket(host, 7);
            BufferedReader data_in_socket = new BufferedReader(new InputStreamReader(so_echo.getInputStream()));
            BufferedReader data_in_consola = new BufferedReader(new InputStreamReader(System.in));

            data_out_socket = new PrintStream(so_echo.getOutputStream());

           // data_in_consola = new DataInputStream(System.in);

            while(true){
                linea = data_in_consola.readLine();
                if (linea.equals(".")) break;
                data_out_socket.println(linea);
                System.out.println(data_in_socket.readLine());
            }
            so_echo.close();
        } catch (UnknownHostException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
