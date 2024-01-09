package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Aluno extends Pessoa{
    protected Integer idAluno;
    protected String ra;
    protected Curso curso;
    protected LocalDate dataMatricula;
    protected String situacao;
    
    public Aluno() {
        this.curso = new Curso();
    }

    public Aluno(Integer idAluno, String ra, Curso curso, LocalDate dataMatricula, String situacao, String nome, String cpf, String email, String genero, LocalDate dataNascimento, Endereco endereco) {
        super(nome, cpf, email, genero, dataNascimento, endereco);
        this.idAluno = idAluno;
        this.ra = ra;
        this.curso = curso;
        this.dataMatricula = dataMatricula;
        this.situacao = situacao;
    }


    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getAnoMatricula(){
        return getDataMatricula().getYear();
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    @Override
    public void exibirInformacoes(){
        System.out.println(nome +  " | Cpf: " + cpf + " | RA: " + ra + " | Idade: " + /*calcularIdade() +*/ " anos | "
                            + "Curso: " + curso.getNome() + " | Ano matricula: " + getAnoMatricula() + " | Situação: " + situacao);
    }
    
    
}
