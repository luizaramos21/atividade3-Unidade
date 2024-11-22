
package mluiza;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mlu {
         public static void main(String[] args) {
        Scanner teclado;
             teclado = new Scanner(System.in);

        try {
            System.out.print("Informe o nome do funcionário: ");
            String nome = teclado.nextLine();
            System.out.print("Informe a data de admissão (dd/mm/aaaa): ");
            String dataAdmissao = teclado.nextLine();
            System.out.print("Informe o valor pago por hora trabalhada: ");
            float valorHora = teclado.nextFloat();
            System.out.print("Informe o número de horas trabalhadas: ");
            float horasTrabalhadas = teclado.nextFloat();

            funcionario funcionario = new funcionario(nome, dataAdmissao, valorHora, horasTrabalhadas);

            System.out.println("\n--- Detalhes do Funcionário ---");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Tempo de Empresa: " + funcionario.calcularTempoEmpresa() + " anos");
            System.out.printf("Salário a Receber: R$ %.2f\n", funcionario.calcularSalario());
            
        } 
        catch (ParseException e) {  
            System.out.println("\n ---*AVISO*---\n Erro ao processar a data de admissão. \nCertifique-se de usar o formato dd/mm/aaaa.\n");
        } 
        catch (InputMismatchException e) { 
            System.out.println("\n ---*AVISO*---\n Erro ao processar valores numéricos. \nCertifique-se de usar números válidos.\n");
        }

        teclado.close();
    }
}