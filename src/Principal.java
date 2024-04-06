import model.CartaoDeCredito;
import model.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitor.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra: ");
            String descricao = leitor.next();

            System.out.println("Digite o valor da compra: ");
            double valor = leitor.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada) {
                System.out.println("Compra Realizada com sucesso!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitor.nextInt();
            }else{
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
            System.out.println("***************");
            System.out.println("COMPRAS REALIZADAS: \n");

            Collections.sort(cartao.getCompras());
            for (Compra c: cartao.getCompras()) {
                System.out.println(c.getDescricao() + " - " + c.getValor());
            }
            System.out.println("\n***************");
            System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
        }
    }
}