// importar las clases requeridas;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class Pru_UDP {
    public static void main(String[] args) {
        try {
            DatagramPacket paqueteUDP; // declaracion del paquete UDP
            String host = new String("127.0.0.1");

            InetAddress dir_remota = InetAddress.getByName(host);
            int port = 1000; //puerto donde se envia el datagrama

            //Datos a enviar en el datagrama
            String datos = new String("Hola, estos son los datos !!");
            byte[] buffer = datos.getBytes(); // retorna los bytes del string

            //crear el paquete UDP

            paqueteUDP = new DatagramPacket(buffer, buffer.length, dir_remota, port);

            //mostrar los datos del paquete

            System.out.println("Paquete UDP: ");
            System.out.println("Direccion Internet: " + paqueteUDP.getAddress());
            System.out.println("Datos: " + new String(paqueteUDP.getData()));
            System.out.println("Longitud: " + paqueteUDP.getLength());
            System.out.println("Offset: " + paqueteUDP.getOffset());
            System.out.println("Puerto: " + paqueteUDP.getPort());
        } // cierra el try
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
