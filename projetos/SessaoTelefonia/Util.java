import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Util {

    public static boolean CarregarArquivoEmHash(String nomearquivo, HashMap<String, SessaoTelefonia> tabela) {
        try {
            FileReader procurador = new FileReader(nomearquivo);
            BufferedReader leitor = new BufferedReader(procurador);
            String linha;

            do {
                linha = leitor.readLine();
                if (linha != null && !linha.isBlank()) {
                    SessaoTelefonia s = MontarSessao(linha);
                    tabela.put(s.getTelefone(), s);   // chave = telefone
                }
            } while (linha != null);

            leitor.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /** Quebra a linha e preenche o objeto usando os setters. */
    public static SessaoTelefonia MontarSessao(String linha) {
        SessaoTelefonia s = new SessaoTelefonia();

        // 1) separa telefone do resto:  5549...;{...}
        String[] partes = linha.split(";", 2);
        s.setTelefone(partes[0].trim());

        // 2) tira as chaves { } e quebra nos campos
        String dados = partes[1].trim();
        dados = dados.substring(1, dados.length() - 1);
        String[] campos = dados.split(", ");

        // 3) cada campo é  "nome": valor
        for (String campo : campos) {
            String[] chaveValor = campo.split(": ", 2);
            String nome  = chaveValor[0].replace("\"", "").trim();
            String valor = chaveValor[1].replace("\"", "").trim();

            switch (nome) {
                case "session_id":  s.setSessionId(valor); break;
                case "imsi":        s.setImsi(valor); break;
                case "imei":        s.setImei(valor); break;
                case "mcc":         s.setMcc(valor); break;
                case "mnc":         s.setMnc(valor); break;
                case "cell_id":     s.setCellId(Integer.parseInt(valor)); break;
                case "lac":         s.setLac(Integer.parseInt(valor)); break;
                case "bearer":      s.setBearer(valor); break;
                case "start_time":  s.setStartTime(valor); break;
                case "end_time":    s.setEndTime(valor); break;
                case "duration_s":  s.setDurationS(Integer.parseInt(valor)); break;
                case "ip_addr":     s.setIpAddr(valor); break;
                case "sip_call_id": s.setSipCallId(valor); break;
                case "codec":       s.setCodec(valor); break;
                case "bytes_up":    s.setBytesUp(Long.parseLong(valor)); break;
                case "bytes_down":  s.setBytesDown(Long.parseLong(valor)); break;
                case "lat":         s.setLat(Double.parseDouble(valor)); break;
                case "lon":         s.setLon(Double.parseDouble(valor)); break;
                case "encryption":  s.setEncryption(valor); break;
            }
        }
        return s;
    }

    /** Busca pelo telefone e mostra os dados com os getters. */
    public static void BuscarPorTelefone(String telefone, HashMap<String, SessaoTelefonia> tabela) {
        SessaoTelefonia s = tabela.get(telefone.trim());

        if (s == null) {
            System.out.println("Telefone " + telefone + " não encontrado.");
            return;
        }
        System.out.println("Telefone:     " + s.getTelefone());
        System.out.println("Sessão:       " + s.getSessionId());
        System.out.println("IMSI:         " + s.getImsi());
        System.out.println("IMEI:         " + s.getImei());
        System.out.println("MCC/MNC:      " + s.getMcc() + "/" + s.getMnc());
        System.out.println("Cell ID/LAC:  " + s.getCellId() + "/" + s.getLac());
        System.out.println("Rede:         " + s.getBearer());
        System.out.println("Início:       " + s.getStartTime());
        System.out.println("Fim:          " + s.getEndTime());
        System.out.println("Duração (s):  " + s.getDurationS());
        System.out.println("IP:           " + s.getIpAddr());
        System.out.println("SIP Call ID:  " + s.getSipCallId());
        System.out.println("Codec:        " + s.getCodec());
        System.out.println("Bytes up:     " + s.getBytesUp());
        System.out.println("Bytes down:   " + s.getBytesDown());
        System.out.println("Lat/Lon:      " + s.getLat() + ", " + s.getLon());
        System.out.println("Criptografia: " + s.getEncryption());
    }
}
