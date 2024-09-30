package UDP;

//Ejercicio 1
//      Realizar un programa que permita determinar a cuales de los puertos entre el 1 al 1024 se puede establecer
  //      una conexión a : 1) - al host local 2) una maquina Linux del laboratorio. Lo de máquina linux de laboratorio me falta.

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EnviarMSSPUDP{
    public static void main(String[] args) {
        try {
            String mensajeCompleto = "Prendido a tu botella vacía, esa que antes siempre tuvo gusto a nada aaaaaa.";

            MSSP parte1 = new MSSP((byte) 8, (byte) 1, mensajeCompleto.substring(0, 24));
            MSSP parte2 = new MSSP((byte) 8, (byte) 2, mensajeCompleto.substring(24, 48));
            MSSP parte3 = new MSSP((byte) 8, (byte) 3, mensajeCompleto.substring(48));

            DatagramSocket socket = new DatagramSocket();
            InetAddress direccionDestino = InetAddress.getLocalHost(); // entiendo que debe ser lo mismo con getByName y el iP Local ( es para pruebas );
            int puertoDestino = 1000;

            enviarPaquete(socket, parte1, direccionDestino, puertoDestino);
            enviarPaquete(socket, parte2, direccionDestino, puertoDestino);
            enviarPaquete(socket, parte3, direccionDestino, puertoDestino);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void enviarPaquete(DatagramSocket socket, MSSP mssp, InetAddress direccionDestino, int puertoDestino) throws Exception{
        byte[] datos = mssp.getArrayBytes();
        DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccionDestino, puertoDestino);
        socket.send(paquete);
        System.out.println("Paquete enviado; " + mssp.getMsn());
    }
}
