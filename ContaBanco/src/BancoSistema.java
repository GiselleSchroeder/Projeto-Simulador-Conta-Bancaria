import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoSistema extends JFrame {

    private JPanel mainPanel;
    private JPanel telaCadastroCliente;
    private JPanel telaCadastroGerente;

    private Map<Integer, ContaBancaria> contas;
    private List<Gerente> gerentes;

    public BancoSistema() {
        // Configurações do JFrame
        setTitle("Sistema Bancário");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        contas = new HashMap<>();
        gerentes = new ArrayList<>();

        // Tela inicial
        JPanel telaInicial = new JPanel(new GridBagLayout());
        GridBagConstraints gbcInicial = new GridBagConstraints();
        gbcInicial.insets = new Insets(10, 10, 10, 10);

        JButton clienteButton = new JButton("Cliente");
        JButton gerenteButton = new JButton("Gerente");
        JButton diretorButton = new JButton("Diretor"); // Novo botão

        gbcInicial.gridx = 0;
        gbcInicial.gridy = 0;
        telaInicial.add(clienteButton, gbcInicial);

        gbcInicial.gridx = 1;
        telaInicial.add(gerenteButton, gbcInicial);

        gbcInicial.gridx = 2; // Posicionando o botão "Diretor"
        telaInicial.add(diretorButton, gbcInicial);

        mainPanel.add(telaInicial, "Tela Inicial");

        // Tela do Cliente
        JPanel telaCliente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(10, 10, 10, 10);

        JButton consultarContaClienteButton = new JButton("Consultar Conta");
        JButton voltarClienteButton = new JButton("Voltar");

        gbcCliente.gridx = 0;
        gbcCliente.gridy = 0;
        telaCliente.add(consultarContaClienteButton, gbcCliente);

        gbcCliente.gridx = 1;
        telaCliente.add(voltarClienteButton, gbcCliente);

        mainPanel.add(telaCliente, "Tela Cliente");

        // Tela do Gerente
        JPanel telaGerente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcGerente = new GridBagConstraints();
        gbcGerente.insets = new Insets(10, 10, 10, 10);

        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");
        JButton cadastrarContaButton = new JButton("Cadastrar Conta");
        JButton voltarGerenteButton = new JButton("Voltar");

        gbcGerente.gridx = 0;
        gbcGerente.gridy = 0;
        telaGerente.add(cadastrarClienteButton, gbcGerente);

        gbcGerente.gridx = 1;
        telaGerente.add(cadastrarContaButton, gbcGerente);

        gbcGerente.gridx = 0;
        gbcGerente.gridy = 1;
        telaGerente.add(voltarGerenteButton, gbcGerente);

        mainPanel.add(telaGerente, "Tela Gerente");

        // Tela de Cadastro de Cliente
        telaCadastroCliente = new JPanel(new GridBagLayout()); // Inicialização do painel de cadastro de cliente
        GridBagConstraints gbcCadastroCliente = new GridBagConstraints();
        gbcCadastroCliente.insets = new Insets(10, 10, 10, 10);

        JLabel nomeClienteLabel = new JLabel("Nome:");
        JTextField nomeClienteField = new JTextField(20);

        JLabel enderecoLabel = new JLabel("Endereço:");
        JTextField enderecoField = new JTextField(20);

        JLabel rgLabel = new JLabel("RG:");
        JTextField rgField = new JTextField(12);

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(11);

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField(12);

        JLabel gerenteLabel = new JLabel("Gerente:");
        JComboBox<String> gerenteComboBox = new JComboBox<>();

        for (Gerente gerente : gerentes) {
            gerenteComboBox.addItem(gerente.getNome());
        }

        JButton cadastrarClienteFinalButton = new JButton("Cadastrar");
        JButton voltarCadastroClienteButton = new JButton("Voltar");

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 0;
        telaCadastroCliente.add(nomeClienteLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(nomeClienteField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 1;
        telaCadastroCliente.add(enderecoLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(enderecoField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 2;
        telaCadastroCliente.add(rgLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(rgField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 3;
        telaCadastroCliente.add(cpfLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(cpfField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 4;
        telaCadastroCliente.add(telefoneLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(telefoneField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 5;
        telaCadastroCliente.add(gerenteLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(gerenteComboBox, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 6;
        telaCadastroCliente.add(cadastrarClienteFinalButton, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(voltarCadastroClienteButton, gbcCadastroCliente);

        mainPanel.add(telaCadastroCliente, "Tela Cadastro Cliente");

        // Tela de Cadastro de Conta
        JPanel telaCadastroConta = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCadastroConta = new GridBagConstraints();
        gbcCadastroConta.insets = new Insets(10, 10, 10, 10);

        JLabel clienteContaLabel = new JLabel("Cliente:");
        JComboBox<String> clienteContaComboBox = new JComboBox<>();

        JLabel tipoContaLabel = new JLabel("Tipo de Conta:");
        JComboBox<String> tipoContaComboBox = new JComboBox<>(new String[]{"Conta Corrente", "Poupança"});

        JLabel agenciaLabel = new JLabel("Número da Agência:");
        JTextField agenciaField = new JTextField(10);

        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        JTextField numeroContaField = new JTextField(10);

        JButton cadastrarContaFinalButton = new JButton("Cadastrar");
        JButton voltarCadastroContaButton = new JButton("Voltar");

        JLabel saldoLabel = new JLabel("Saldo:");
        JTextField saldoField = new JTextField(10);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 0;
        telaCadastroConta.add(clienteContaLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(clienteContaComboBox, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 1;
        telaCadastroConta.add(tipoContaLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(tipoContaComboBox, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 2;
        telaCadastroConta.add(agenciaLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(agenciaField, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 3;
        telaCadastroConta.add(numeroContaLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(numeroContaField, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 4;
        telaCadastroConta.add(cadastrarContaFinalButton, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(voltarCadastroContaButton, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 5;
        telaCadastroConta.add(saldoLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(saldoField, gbcCadastroConta);

        mainPanel.add(telaCadastroConta, "Tela Cadastro Conta");

        // Adicionando os ActionListeners para os botões da tela inicial
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Cliente");
            }
        });

        gerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Gerente");
            }
        });

        diretorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para o botão Diretor
            }
        });

        // Adicionando os ActionListeners para os botões da tela do cliente
        voltarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Inicial");
            }
        });

        consultarContaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para consultar conta do cliente
            }
        });

        // Adicionando os ActionListeners para os botões da tela do gerente
        voltarGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Inicial");
            }
        });

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Cadastro Cliente");
            }
        });

        cadastrarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Cadastro Conta");
            }
        });

        // Adicionando os ActionListeners para os botões da tela de cadastro de cliente
        voltarCadastroClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Gerente");
            }
        });

        cadastrarClienteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para cadastrar cliente
            }
        });

        // Adicionando os ActionListeners para os botões da tela de cadastro de conta
        voltarCadastroContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Tela Gerente");
            }
        });

        cadastrarContaFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar ação para cadastrar conta
            }
        });

        // Configurações finais do JFrame
        add(mainPanel);
        setVisible(true);
    }

    //public static void main(String[] args) {
        //SwingUtilities.invokeLater(new Runnable() {
            //@Override
            //public void run() {
               // new BancoSistema();
           // }
       // });
   // }
}
