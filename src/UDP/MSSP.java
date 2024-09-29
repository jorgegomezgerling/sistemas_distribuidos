package UDP;

public class MSSP {
    private byte id_msn;
    private byte sec_msn;
    private String msn;

    public MSSP(byte id_mensaje, byte secuencia, String mensaje){
        this.id_msn = id_mensaje;
        this.sec_msn = secuencia;
        this.msn = mensaje;
    }

    public byte getIdMSN(){
        return id_msn;
    }

    public byte getSec_msn(){
        return sec_msn;
    }

    public String getMsn(){
        return msn;
    }

    public void setId_msn(byte msn){
        this.id_msn = msn;
    }

    public void setSec_msn(byte sec_msn){
        this.sec_msn = sec_msn;
    }

    public void setMsn(String msn){
        this.msn = msn;
    }

    public byte[] getArrayBytes(){
        byte[] protocolo = new byte[52];
        byte[] msnBytes = msn.getBytes();

        protocolo[0] = id_msn;
        protocolo[1] = sec_msn;

        for (int i = 0; i < msnBytes.length && i < 50; i++){
            protocolo[i + 2] = msnBytes[i];
        }

        return protocolo;
    }
}

