
package modelo;

public class Disciplina implements IDescricao{
    
    protected Integer idDisciplina;
    protected String nome;
    protected Integer semestre;
    protected Integer cargaHoraria;
    protected Curso curso;

    public Disciplina() {
        curso = new Curso();
    }

    public Disciplina(String nome, Integer semestre, Integer cargaHoraria, Curso curso) {
        this.nome = nome;
        this.semestre = semestre;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    
    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", semestre=" + semestre + ", cargaHoraria=" + cargaHoraria + ", curso=" + curso + '}';
    }

    @Override
    public String getDescricao() {
        return nome;
    }
    
    
}
