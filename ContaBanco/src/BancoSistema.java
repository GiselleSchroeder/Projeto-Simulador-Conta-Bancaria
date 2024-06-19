import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BancoSistema extends JFrame {

    private JPanel mainPanel;

    private Map<Integer, ContaBancaria> contas;

    public BancoSistema() {
        // Configurações do JFrame
        setTitle("Sistema Bancário");
        setSize(600, 400); // Aumentei o tamanho da janela para melhor acomodar os campos maiores
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        contas = new HashMap<>();

        // Tela inicial
        JPanel telaInicial = new JPanel(new GridBagLayout());
        GridBagConstraints gbcInicial = new GridBagConstraints();
        gbcInicial.insets = new Insets(10, 10, 10, 10);

        JButton clienteButton = new JButton("Cliente");
        JButton gerenteButton = new JButton("Gerente");

        gbcInicial.gridx = 0;
        gbcInicial.gridy = 0;
        telaInicial.add(clienteButton, gbcInicial);

        gbcInicial.gridx = 1;
        telaInicial.add(gerenteButton, gbcInicial);

        mainPanel.add(telaInicial, "Tela Inicial");

        // Tela do Cliente
        JPanel telaCliente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(10, 10, 10, 10);

        JButton consultarContaClienteButton = new JButton("Consultar Conta"); // Botão de consultar conta para o cliente
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
        JPanel telaCadastroCliente = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCadastroCliente = new GridBagConstraints();
        gbcCadastroCliente.insets = new Insets(10, 10, 10, 10);

        JLabel nomeClienteLabel = new JLabel("Nome:");
        JTextField nomeClienteField = new JTextField(20); // Aumentei para 20 caracteres

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(11);

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField(12); // Aumentei para 12 caracteres

        JLabel cepLabel = new JLabel("CEP:");
        JTextField cepField = new JTextField(8);

        JButton cadastrarClienteFinalButton = new JButton("Cadastrar");
        JButton voltarCadastroClienteButton = new JButton("Voltar");

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 0;
        telaCadastroCliente.add(nomeClienteLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(nomeClienteField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 1;
        telaCadastroCliente.add(cpfLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(cpfField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 2;
        telaCadastroCliente.add(telefoneLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(telefoneField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 3;
        telaCadastroCliente.add(cepLabel, gbcCadastroCliente);
        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(cepField, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 0;
        gbcCadastroCliente.gridy = 4;
        telaCadastroCliente.add(cadastrarClienteFinalButton, gbcCadastroCliente);

        gbcCadastroCliente.gridx = 1;
        telaCadastroCliente.add(voltarCadastroClienteButton, gbcCadastroCliente);

        mainPanel.add(telaCadastroCliente, "Tela Cadastro Cliente");

        // Tela de Cadastro de Conta
        JPanel telaCadastroConta = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCadastroConta = new GridBagConstraints();
        gbcCadastroConta.insets = new Insets(10, 10, 10, 10);

        JLabel tipoContaLabel = new JLabel("Tipo de Conta:");
        JRadioButton contaCorrenteButton = new JRadioButton("Conta Corrente");
        JRadioButton poupancaButton = new JRadioButton("Poupança");

        ButtonGroup tipoContaGroup = new ButtonGroup();
        tipoContaGroup.add(contaCorrenteButton);
        tipoContaGroup.add(poupancaButton);

        JLabel nomeClienteContaLabel = new JLabel("Nome do Cliente:");
        JTextField nomeClienteContaField = new JTextField(20); // Aumentei para 20 caracteres

        JLabel numeroAgenciaLabel = new JLabel("Número da Agência:");
        JTextField numeroAgenciaField = new JTextField(12); // Aumentei para 12 caracteres

        JLabel numeroContaLabel = new JLabel("Número da Conta:");
        JTextField numeroContaField = new JTextField(12); // Aumentei para 12 caracteres

        JButton cadastrarContaFinalButton = new JButton("Cadastrar");
        JButton voltarCadastroContaButton = new JButton("Voltar");

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 0;
        telaCadastroConta.add(tipoContaLabel, gbcCadastroConta);

        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(contaCorrenteButton, gbcCadastroConta);

        gbcCadastroConta.gridx = 2;
        telaCadastroConta.add(poupancaButton, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 1;
        telaCadastroConta.add(nomeClienteContaLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(nomeClienteContaField, gbcCadastroConta);

        gbcCadastroConta.gridx = 0;
        gbcCadastroConta.gridy = 2;
        telaCadastroConta.add(numeroAgenciaLabel, gbcCadastroConta);
        gbcCadastroConta.gridx = 1;
        telaCadastroConta.add(numeroAgenciaField, gbcCadastroConta);

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

        mainPanel.add(telaCadastroConta, "Tela Cadastro Conta");

        // Tela de Consulta de Conta
        JPanel telaConsultaConta = new JPanel(new GridBagLayout());
        GridBagConstraints gbcConsultaConta = new GridBagConstraints();
        gbcConsultaConta.insets = new Insets(10, 10, 10, 10);

        JLabel idContaLabel = new JLabel("ID da Conta:");
        JTextField idContaField = new JTextField(10);

        JButton consultarContaFinalButton = new JButton("Consultar");
        JButton voltarConsultaContaButton = new JButton("Voltar");

        gbcConsultaConta.gridx = 0;
        gbcConsultaConta.gridy = 0;
        telaConsultaConta.add(idContaLabel, gbcConsultaConta);

        gbcConsultaConta.gridx = 1;
        telaConsultaConta.add(idContaField, gbcConsultaConta);

        gbcConsultaConta.gridx = 0;
        gbcConsultaConta.gridy = 1;
        telaConsultaConta.add(consultarContaFinalButton, gbcConsultaConta);

        gbcConsultaConta.gridx = 1;
        telaConsultaConta.add(voltarConsultaContaButton, gbcConsultaConta);

        mainPanel.add(telaConsultaConta, "Tela Consulta Conta");

        // Adicionando o painel principal ao JFrame
        add(mainPanel);

        // Ações dos botões

        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cliente");
            }
        });

        gerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Gerente");
            }
        });

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cadastro Cliente");
            }
        });

        cadastrarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cadastro Conta");
            }
        });

        voltarGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Inicial");
            }
        });

        voltarCadastroClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Gerente");
            }
        });

        voltarCadastroContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Gerente");
            }
        });

        consultarContaClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Consulta Conta");
            }
        });

        voltarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Inicial");
            }
        });

        consultarContaFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idConta = Integer.parseInt(idContaField.getText());
                    if (contas.containsKey(idConta)) {
                        ContaBancaria conta = contas.get(idConta);
                        String mensagem = "Informações da Conta:\n" +
                                "ID da Conta: " + conta.getId() + "\n" +
                                "Tipo de Conta: " + conta.getTipoConta() + "\n" +
                                "Nome do Cliente: " + conta.getNomeCliente() + "\n" +
                                "Número da Agência: " + conta.getNumeroAgencia() + "\n" +
                                "Número da Conta: " + conta.getNumeroConta();

                        JOptionPane.showMessageDialog(BancoSistema.this, mensagem, "Consulta de Conta", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(BancoSistema.this, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BancoSistema.this, "Por favor, insira um ID de conta válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        voltarConsultaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Tela Cliente");
            }
        });

        cadastrarClienteFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = nomeClienteField.getText();
                String cpf = cpfField.getText();
                String telefone = telefoneField.getText();
                String cep = cepField.getText();

                int idConta = new Random().nextInt(901) + 100; // Gera um ID de conta aleatório

                ContaBancaria conta = new ContaBancaria(idConta, "", nomeCliente, "", "");

                contas.put(idConta, conta); // Adiciona a conta ao mapa de contas

                String mensagem = "Cliente cadastrado com sucesso!\n" +
                        "Nome: " + nomeCliente + "\n" +
                        "CPF: " + cpf + "\n" +
                        "Telefone: " + telefone + "\n" +
                        "CEP: " + cep + "\n" +
                        "ID da Conta: " + idConta;

                JOptionPane.showMessageDialog(BancoSistema.this, mensagem, "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cadastrarContaFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoConta = contaCorrenteButton.isSelected() ? "Conta Corrente" : "Poupança";
                String nomeCliente = nomeClienteContaField.getText();
                String numeroAgencia = numeroAgenciaField.getText();
                String numeroConta = numeroContaField.getText();

                int idConta = new Random().nextInt(901) + 100;

                ContaBancaria conta = new ContaBancaria(idConta, tipoConta, nomeCliente, numeroAgencia, numeroConta);

                contas.put(idConta, conta); // Adiciona a conta ao mapa de contas

                String mensagem = "Conta cadastrada com sucesso!\n" +
                        "Tipo de Conta: " + tipoConta + "\n" +
                        "Nome do Cliente: " + nomeCliente + "\n" +
                        "Número da Agência: " + numeroAgencia + "\n" +
                        "Número da Conta: " + numeroConta + "\n" +
                        "ID da Conta: " + idConta;

                JOptionPane.showMessageDialog(BancoSistema.this, mensagem, "Cadastro de Conta", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BancoSistema().setVisible(true);
            }
        });
    }
}

class ContaBancaria {
    private int id;
    private String tipoConta;
    private String nomeCliente;
    private String numeroAgencia;
    private String numeroConta;

    public ContaBancaria(int id, String tipoConta, String nomeCliente, String numeroAgencia, String numeroConta) {
        this.id = id;
        this.tipoConta = tipoConta;
        this.nomeCliente = nomeCliente;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
    }

    public int getId() {
        return id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
