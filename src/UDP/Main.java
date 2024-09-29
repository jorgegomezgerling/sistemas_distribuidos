package UDP;

import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {
        //  System.out.println("Hello world!");
        try{
            InetAddress google = InetAddress.getByName("www.infobae.com");
            System.out.println(google);
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
