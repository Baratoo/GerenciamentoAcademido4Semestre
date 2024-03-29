package modelo;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
    
    protected Integer idFuncionario;
    protected String ctps;
    protected double salario;

    public Funcionario() {
    }

    public Funcionario(String ctps, double salario, String nome, String cpf, String email, String genero, LocalDate dataNascimento, Endereco endereco) {
        super(nome, cpf, email, genero, dataNascimento, endereco);
        this.ctps = ctps;
        this.salario = salario;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    
    @Override
    public void exibirInformacoes(){
        System.out.println( nome + " | Cpf: " + cpf + " | Idade: " + calcularIdade() + " anos " +
                " | Cidade: "+ endereco.getCidade() + " | Rua : " + endereco.getRua() + " | Número: " + endereco.getNumero() + " | "
                + "Ctps: " + ctps + " |  Salario: " + salario
        );
    }
}
