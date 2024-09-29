package UDP;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ArmarSocketUDP {
    public static void main(String[] args) {
        try {
            int port_local = 80;
            DatagramSocket ds = new DatagramSocket(port_local);

            ds.setReceiveBufferSize(800); // debe ser seteado;
            ds.setSendBufferSize(800); // debe ser seteado;
            ds.setSoTimeout(1000); // modificar segun consgina;
            ds.connect(InetAddress.getByName("127.0.0.0"), 81);

            //mostrar los datos del socket

            System.out.println("Dir Local: " + ds.getLocalAddress());
            System.out.println("Puerto Local: " + ds.getLocalPort());
            System.out.println("Dir Remota: " + ds.getInetAddress());
            System.out.println("Puerto Remoto: " + ds.getPort());
            System.out.println("Buffer de recepción: " + ds.getReceiveBufferSize() + " bytes");
            System.out.println("Buffer de envío: " + ds.getSendBufferSize() + " bytes");
            System.out.println("Tiempo de TimeOut: " + ds.getSoTimeout() + " milisegundos");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
