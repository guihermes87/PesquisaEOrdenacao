import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa uma linha do arquivo telephony_sessions.txt.
 * Formato da linha: <telefone>;{json com os dados da sessão}
 */
public class SessaoTelefonia implements Serializable {

    private static final long serialVersionUID = 1L;

    private String telefone;      // chave antes do ';'
    private String sessionId;
    private String imsi;
    private String imei;
    private String mcc;
    private String mnc;
    private int cellId;
    private int lac;
    private String bearer;        // 3G, 5G, LTE, WCDMA
    private String startTime;     // ISO-8601 (ex.: 2025-11-05T05:56:01Z)
    private String endTime;
    private int durationS;
    private String ipAddr;
    private String sipCallId;
    private String codec;         // AMR-WB, G711, G729, OPUS
    private long bytesUp;
    private long bytesDown;
    private double lat;
    private double lon;
    private String encryption;    // AES, SRTP

    public SessaoTelefonia() { }

    /** Converte uma linha do txt em objeto (parser simples, sem bibliotecas externas). */
    public static SessaoTelefonia fromLinha(String linha) {
        int sep = linha.indexOf(';');
        if (sep < 0) throw new IllegalArgumentException("Linha inválida: " + linha);
        String json = linha.substring(sep + 1);

        SessaoTelefonia s = new SessaoTelefonia();
        s.setTelefone(linha.substring(0, sep).trim());
        s.setSessionId(texto(json, "session_id"));
        s.setImsi(texto(json, "imsi"));
        s.setImei(texto(json, "imei"));
        s.setMcc(texto(json, "mcc"));
        s.setMnc(texto(json, "mnc"));
        s.setCellId(Integer.parseInt(numero(json, "cell_id")));
        s.setLac(Integer.parseInt(numero(json, "lac")));
        s.setBearer(texto(json, "bearer"));
        s.setStartTime(texto(json, "start_time"));
        s.setEndTime(texto(json, "end_time"));
        s.setDurationS(Integer.parseInt(numero(json, "duration_s")));
        s.setIpAddr(texto(json, "ip_addr"));
        s.setSipCallId(texto(json, "sip_call_id"));
        s.setCodec(texto(json, "codec"));
        s.setBytesUp(Long.parseLong(numero(json, "bytes_up")));
        s.setBytesDown(Long.parseLong(numero(json, "bytes_down")));
        s.setLat(Double.parseDouble(numero(json, "lat")));
        s.setLon(Double.parseDouble(numero(json, "lon")));
        s.setEncryption(texto(json, "encryption"));
        return s;
    }

    private static String texto(String json, String campo) {
        Matcher m = Pattern.compile("\"" + campo + "\"\\s*:\\s*\"([^\"]*)\"").matcher(json);
        return m.find() ? m.group(1) : null;
    }

    private static String numero(String json, String campo) {
        Matcher m = Pattern.compile("\"" + campo + "\"\\s*:\\s*(-?[0-9.]+)").matcher(json);
        if (!m.find()) throw new IllegalArgumentException("Campo ausente: " + campo);
        return m.group(1);
    }

    // ---------------- Getters e Setters ----------------

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public String getImsi() { return imsi; }
    public void setImsi(String imsi) { this.imsi = imsi; }

    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }

    public String getMcc() { return mcc; }
    public void setMcc(String mcc) { this.mcc = mcc; }

    public String getMnc() { return mnc; }
    public void setMnc(String mnc) { this.mnc = mnc; }

    public int getCellId() { return cellId; }
    public void setCellId(int cellId) { this.cellId = cellId; }

    public int getLac() { return lac; }
    public void setLac(int lac) { this.lac = lac; }

    public String getBearer() { return bearer; }
    public void setBearer(String bearer) { this.bearer = bearer; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public int getDurationS() { return durationS; }
    public void setDurationS(int durationS) { this.durationS = durationS; }

    public String getIpAddr() { return ipAddr; }
    public void setIpAddr(String ipAddr) { this.ipAddr = ipAddr; }

    public String getSipCallId() { return sipCallId; }
    public void setSipCallId(String sipCallId) { this.sipCallId = sipCallId; }

    public String getCodec() { return codec; }
    public void setCodec(String codec) { this.codec = codec; }

    public long getBytesUp() { return bytesUp; }
    public void setBytesUp(long bytesUp) { this.bytesUp = bytesUp; }

    public long getBytesDown() { return bytesDown; }
    public void setBytesDown(long bytesDown) { this.bytesDown = bytesDown; }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }

    public double getLon() { return lon; }
    public void setLon(double lon) { this.lon = lon; }

    public String getEncryption() { return encryption; }
    public void setEncryption(String encryption) { this.encryption = encryption; }

    // ------- equals e hashCode: identidade = telefone -------

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.telefone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final SessaoTelefonia other = (SessaoTelefonia) obj;
        return Objects.equals(this.telefone, other.telefone);
    }

    @Override
    public String toString() {
        return "SessaoTelefonia{telefone=" + telefone + ", sessionId=" + sessionId +
               ", imsi=" + imsi + ", imei=" + imei + ", mcc=" + mcc + ", mnc=" + mnc +
               ", cellId=" + cellId + ", lac=" + lac + ", bearer=" + bearer +
               ", startTime=" + startTime + ", endTime=" + endTime + ", durationS=" + durationS +
               ", ipAddr=" + ipAddr + ", sipCallId=" + sipCallId + ", codec=" + codec +
               ", bytesUp=" + bytesUp + ", bytesDown=" + bytesDown +
               ", lat=" + lat + ", lon=" + lon + ", encryption=" + encryption + "}";
    }
}
