//Ejercicio 2
  //      Realizar un programa que se conecte a un host y muestre información acerca de la conexión usando los
    //    métodos getInetAddress() y getPort().

import java.net.InetAddress;
import java.net.Socket;

public class ConexionAHost {
    public static void main(String[] args) {
        String host = "www.google.com.ar";

        try {
            Socket socket = new Socket(host, 80);
            System.out.println(" Puerto: " + 80 + " está abierto.");
            InetAddress direccion_remota = socket.getInetAddress();
            int puerto_remoto = socket.getPort();
            System.out.println("Dirección remota: " + direccion_remota);
            System.out.println("Puerto remoto: " + puerto_remoto);
            socket.close();
        } catch (Exception e) {
            //  System.out.println("Puerto " + puerto + " está cerrado.");
        }
    }
}
