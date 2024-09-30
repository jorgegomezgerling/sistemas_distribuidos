import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

// falta probar con maquina linux, es cuestion de cambiar el host.

public class Daytime {
    public static void main(String[] args) {

        Socket so_daytime;
       // DataInputStream data_daytime;
        String host = "time.nist.gov";
        String[] prueba = null;

        try{
            so_daytime = new Socket(host, 13);
           // data_daytime = new DataInputStream(so_daytime.getInputStream());

            BufferedReader InputStream = new BufferedReader(new InputStreamReader(so_daytime.getInputStream()));

            System.out.println("Conectado a: " + so_daytime.getInetAddress());
            System.out.println("port: " + so_daytime.getPort());

            String line;
            while ((line = InputStream.readLine()) != null) {
                if (!line.isEmpty()){
                    //System.out.println("Día y hora: " + line);
                    prueba = line.split(" ");
                }
            }
         //   System.out.println(prueba.getClass());

            // Por cuestiones de null point;

            if (prueba != null){
                System.out.println("Día: " + prueba[1]);
                System.out.println("Hora: " + prueba[2]);
            }


            so_daytime.close();
        } catch (UnknownHostException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }


}

