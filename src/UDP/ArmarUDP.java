package UDP;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class ArmarUDP {
    public static void main(String[] args) {
        // Verificar si se pasaron los argumentos correctos
        if (args.length < 3) {
            System.out.println("Uso: java ArmarUDP <IP destino> <puerto destino> <mensaje>");
            return;
        }

        try {
            // Obtener los parámetros desde la consola
            String host = args[0];
            int port = Integer.parseInt(args[1]);
            String mensaje = args[2];

            // Crear los datos del paquete
            byte[] buffer = mensaje.getBytes();
            InetAddress direccion_remota = InetAddress.getByName(host);

            // Crear el paquete UDP con los datos, la dirección y el puerto de destino
            DatagramPacket paqueteUDP = new DatagramPacket(buffer, buffer.length, direccion_remota, port);

            // Mostrar los datos del datagrama
            System.out.println("Paquete UDP:");
            System.out.println("Host (Dirección IP): " + paqueteUDP.getAddress());
            System.out.println("Puerto destino: " + paqueteUDP.getPort());
            System.out.println("Datos: " + new String(paqueteUDP.getData()));
            System.out.println("Longitud: " + paqueteUDP.getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
