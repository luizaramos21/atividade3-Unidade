
package mluiza;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class funcionario {
     private final String nome;
    private Date dataAdmissao;
    private float valorHora;
    private float horasTrabalhadas;
    
    
     public funcionario(String nome, String dataAdmissao, float valorHora, float horasTrabalhadas) throws ParseException  {
        this.nome = nome; 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        this.dataAdmissao = sdf.parse(dataAdmissao); 
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    } 
     
    public int calcularTempoEmpresa() {
        Date dataAtual = new Date();
        long diferencaMilissegundos = dataAtual.getTime() - dataAdmissao.getTime(); 
        long diferencaAnos = diferencaMilissegundos / (1000L * 60 * 60 * 24 * 365); 
        return (int) diferencaAnos;
    }

    public float calcularSalario() {
        float salarioBase = valorHora * horasTrabalhadas; 
        int tempoEmpresa = calcularTempoEmpresa(); 
        if (tempoEmpresa >= 10) {
            return salarioBase * 1.10f;
        } else if (tempoEmpresa >= 5) {
            return salarioBase * 1.05f;
        } else {
            return salarioBase;
        }
    }

    public String getNome() {
        return nome;
    }
}
