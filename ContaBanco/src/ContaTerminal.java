import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int numeroConta;
        String numeroAgencia;
        String nomeCliente;
        double saldo;

            System.out.println("Por favor digite o número da CONTA: (Exemplo: 1234).");
                numeroConta  = scanner.nextInt();
                    scanner.nextLine();
            
            System.out.println("Por favor digite o número da AGÊNCIA: (Exemplo: 123-4).");
                numeroAgencia= scanner.nextLine();
                
            System.out.println("Por favor digite o SEU NOME: (Exemplo: João da Silva.)");
                nomeCliente = scanner.nextLine();
             
            System.out.println("Por favor digite o SEU SALDO: (Exemplo 1000).");
                saldo = scanner.nextDouble();

                System.out.println("======================================================================");

                System.out.println("Olá! " + nomeCliente + " Obrigado por criar uma conta no nosso banco!");
                System.out.println();
                System.out.println("O NUMERO DA AGÊNCIA é: " + numeroAgencia);
                System.out.println("O NUMERO DA CONTA é: " + numeroConta);
                System.out.println("O SALDO é: R$" + saldo);
                System.out.println("======================================================================");

                scanner.close();

    }
}