package view;

import javax.swing.*;
import service.VendaService;
import dao.VendaDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class TelaVendas extends JFrame {
    private JTextField campoProduto;
    private JTextField campoQuantidade;
    private JTextArea areaResumoVenda;
    private JButton botaoAdicionar;
    private JButton botaoFinalizar;
    private VendaService vendaService;

    public TelaVendas() {
        vendaService = new VendaService(new VendaDAO());
        configurarJanela();
        inicializarComponentes();
        configurarEventos();
    }

    private void configurarJanela() {
        setTitle("Tela de Vendas - PeqSystem");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        JPanel painelSuperior = new JPanel(new GridLayout(2, 2, 5, 5));
        campoProduto = new JTextField();
        campoQuantidade = new JTextField();
        painelSuperior.add(new JLabel("Produto:"));
        painelSuperior.add(campoProduto);
        painelSuperior.add(new JLabel("Quantidade:"));
        painelSuperior.add(campoQuantidade);

        areaResumoVenda = new JTextArea();
        areaResumoVenda.setEditable(false);
        JScrollPane scrollResumo = new JScrollPane(areaResumoVenda);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botaoAdicionar = new JButton("Adicionar");
        botaoFinalizar = new JButton("Finalizar");
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoFinalizar);

        add(painelSuperior, BorderLayout.NORTH);
        add(scrollResumo, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {
        botaoAdicionar.addActionListener(e -> {
            if (vendaService.adicionarVenda(campoProduto.getText().trim(), campoQuantidade.getText().trim())) {
                areaResumoVenda.setText(vendaService.gerarResumo());
                limparCampos();
            } else {
                exibirMensagem("Dados inválidos ou campos vazios.");
            }
        });

        botaoFinalizar.addActionListener(e -> {
            if (areaResumoVenda.getText().isEmpty()) {
                exibirMensagem("Nenhum produto adicionado.");
            } else {
                exibirMensagem("Venda finalizada:\n" + areaResumoVenda.getText());
                areaResumoVenda.setText("");
            }
        });
    }

    private void limparCampos() {
        campoProduto.setText("");
        campoQuantidade.setText("");
        campoProduto.requestFocus();
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaVendas().setVisible(true));
    }
}