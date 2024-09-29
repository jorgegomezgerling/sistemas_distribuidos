public class CrearMSSP {
    public static void main(String[] args) {
        String mensajeCompleto = "Hola que tal como te va que frase tan vulgar con la que me voy a presentar.";

        MSSP parte1 = new MSSP((byte) 8, (byte) 1, mensajeCompleto.substring(0, 24));
        MSSP parte2 = new MSSP((byte) 8, (byte) 2, mensajeCompleto.substring(24, 48));
        MSSP parte3 = new MSSP((byte) 8, (byte) 3, mensajeCompleto.substring(48));

        System.out.println("Parte 1: ");
        imprimirMSSP(parte1);
        System.out.println("Parte 2: ");
        imprimirMSSP(parte2);
        System.out.println("Parte 3: ");
        imprimirMSSP(parte3);
    }

    public static void imprimirMSSP(MSSP mssp) {
        System.out.println("ID: " + mssp.getIdMSN());
        System.out.println("Secuencia: " + mssp.getSec_msn());
        System.out.println("Mensaje: " + mssp.getMsn());
    }
}
