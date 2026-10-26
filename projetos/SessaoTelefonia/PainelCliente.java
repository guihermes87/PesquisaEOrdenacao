import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/** Painel do cliente: digita o telefone e recebe os dados da sessão do servidor. */
public class PainelCliente extends JFrame {

    private final JTextField campoHost = new JTextField("localhost", 10);
    private final JTextField campoPorta = new JTextField("5000", 5);
    private final JTextField campoTelefone = new JTextField(15);
    private final JButton btnConsultar = new JButton("Consultar");
    private final JLabel status = new JLabel(" ");

    private final DefaultTableModel modelo = new DefaultTableModel(new String[]{"Campo", "Valor"}, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };

    public PainelCliente() {
        super("Painel Cliente - Consulta de Sessão");

        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(new JLabel("Servidor:"));  topo.add(campoHost);
        topo.add(new JLabel("Porta:"));     topo.add(campoPorta);
        topo.add(new JLabel("Telefone:"));  topo.add(campoTelefone);
        topo.add(btnConsultar);

        btnConsultar.addActionListener(e -> consultar());
        campoTelefone.addActionListener(e -> consultar());   // ENTER também consulta

        JTable tabela = new JTable(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(380);

        add(topo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        setSize(720, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void consultar() {
        String telefone = campoTelefone.getText().replaceAll("\\D", "");  // só dígitos
        if (telefone.isEmpty()) {
            status.setText("Digite um telefone.");
            return;
        }
        String host = campoHost.getText().trim();
        int porta = Integer.parseInt(campoPorta.getText().trim());
        btnConsultar.setEnabled(false);
        status.setText("Consultando...");

        new SwingWorker<SessaoTelefonia, Void>() {
            @Override protected SessaoTelefonia doInBackground() throws Exception {
                return ServidorSessoes.consultarRemoto(host, porta, telefone);
            }
            @Override protected void done() {
                btnConsultar.setEnabled(true);
                modelo.setRowCount(0);
                try {
                    SessaoTelefonia s = get();
                    if (s == null) {
                        status.setText("Telefone " + telefone + " não encontrado.");
                    } else {
                        mostrar(s);
                        status.setText("Sessão encontrada.");
                    }
                } catch (Exception ex) {
                    status.setText("Erro de conexão: " + ex.getCause().getMessage());
                }
            }
        }.execute();
    }

    private void mostrar(SessaoTelefonia s) {
        Object[][] linhas = {
            {"Telefone", s.getTelefone()}, {"Session ID", s.getSessionId()},
            {"IMSI", s.getImsi()}, {"IMEI", s.getImei()},
            {"MCC / MNC", s.getMcc() + " / " + s.getMnc()},
            {"Cell ID / LAC", s.getCellId() + " / " + s.getLac()},
            {"Bearer", s.getBearer()},
            {"Início", s.getStartTime()}, {"Fim", s.getEndTime()},
            {"Duração (s)", s.getDurationS()}, {"IP", s.getIpAddr()},
            {"SIP Call ID", s.getSipCallId()}, {"Codec", s.getCodec()},
            {"Bytes up", s.getBytesUp()}, {"Bytes down", s.getBytesDown()},
            {"Latitude / Longitude", s.getLat() + ", " + s.getLon()},
            {"Criptografia", s.getEncryption()}
        };
        for (Object[] l : linhas) modelo.addRow(l);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PainelCliente().setVisible(true));
    }
}
