import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class RecibirMSSPUDP {
    public static void main(String[] args) {
        try {
            int puerto = 1000;
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.print("Esperando mensajes MSSP en el puerto " + puerto);

            byte[] buffer = new byte[52];

            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

            String[] mensajePartes = new String[3];

            for (int i = 0; i < 3; i++){
                socket.receive(paqueteRecibido);

                byte[] datos = paqueteRecibido.getData();

                byte id = datos[0];
                byte secuencia = datos[1];

                String mensaje = new String(datos, 2, paqueteRecibido.getLength() -2);

                mensajePartes[secuencia - 1] = mensaje;

                System.out.println("Parte recibida - ID:" + id + ", Secuencia " + secuencia + " Mensaje: " + mensaje);
            }

            StringBuilder mensajeCompleto = new StringBuilder();
            for (String parte: mensajePartes){
                mensajeCompleto.append(parte);
            }
            System.out.println("Mensaje completo reconstruido: " + mensajeCompleto.toString());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
