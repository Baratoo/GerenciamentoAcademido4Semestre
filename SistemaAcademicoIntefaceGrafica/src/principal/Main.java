package principal;

import controle.ControleLogin;
import controle.ControlePrincipal;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Aluno;
import modelo.Curso;
import modelo.Docente;
import modelo.Endereco;
import persistencia.DaoAluno;
import persistencia.DaoCurso;


public class Main {

    private static ControlePrincipal controle;
   
    public static void main(String[] args) {
       /*DaoAluno daoAluno = new DaoAluno();
       Endereco endereco = new Endereco(1, "Cascavel", "Aqui", "123");
       Docente docente = new Docente(1,"TADS", "12345", 5000,"Mateus", "08346661975", "mateus@hotmail.com", "Masculino", LocalDate.now(), endereco);
       Curso curso = new Curso(1, "TADS", 3000, 6, docente);
       Aluno aluno = new Aluno(2, "123", curso, LocalDate.now(), "ATIVO", "Pepice", "123456789", "pepice@hotmail.com", "Masculino", LocalDate.now(), endereco);
       
        System.out.println("CHEGOU AQUI");
       daoAluno.salvar(aluno, "aluno");
       DaoCurso daoCurso = new DaoCurso();
       ArrayList<Curso> cursos = new ArrayList<>();
       cursos = daoCurso.carregarCursos();
        for (Curso curso : cursos) {
            curso.exibirInformacoes();
        }*/
        controle = new ControlePrincipal();
        ControleLogin controleLogin = new ControleLogin(controle);
        
        controle.getControleLogin().abrirTelaLogin();
    }

    public static ControlePrincipal getControle() {
        return controle;
    }
    
}
