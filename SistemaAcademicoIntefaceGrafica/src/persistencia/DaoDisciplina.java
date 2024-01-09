package persistencia;

import java.sql.*;
import java.util.ArrayList;
import modelo.Disciplina;

public class DaoDisciplina extends DAO{
    
    private DaoCurso daoCurso;
    
    public DaoDisciplina (){
        daoCurso = new DaoCurso();
    }
    
    public ArrayList<String> disciplinasCurso(Integer fk_curso){
        try{
            String sql = "SELECT disciplina.nome FROM disciplina\n" 
                    +"inner join curso on curso.id_curso = disciplina.fk_curso "
                    +"where fk_curso = "+fk_curso;
            ResultSet rs = consultaSQL(sql);
            ArrayList<String> nomeDisciplinas = new ArrayList();
            while(rs.next()){    
                nomeDisciplinas.add(rs.getString("nome"));
            }
            return nomeDisciplinas;
        }catch (SQLException ex){
            System.out.println("Falha ao carregar cursos!\n"+ ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Disciplina> carregarDisciplinas(){
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        try {
            String sql = "select * from disciplina";
            ResultSet rs = consultaSQL(sql);
            while(rs.next()){
                Disciplina dis = new Disciplina();
                dis.setIdDisciplina(rs.getInt("idDisciplina"));
                dis.setNome(rs.getString("nome"));
                dis.setSemestre(rs.getInt("semestre"));
                dis.setCargaHoraria(rs.getInt("cargaHoraria"));
                dis.setCurso(daoCurso.carregarCursoPorId(rs.getInt("fkCurso")));
                
                disciplinas.add(dis);
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar disciplinas!\n"+ ex.getMessage());
        }
        return disciplinas;
    }
    
    public Disciplina carregarDisciplinaPorId(int idDisciplina){
        Disciplina dis = null;
        try {
            String sql = "select * from disciplina where idDisciplina = "+idDisciplina;
            ResultSet rs = consultaSQL(sql);
            if(rs.next()){
                dis = new Disciplina();
                dis.setIdDisciplina(rs.getInt("idDisciplina"));
                dis.setNome(rs.getString("nome"));
                dis.setSemestre(rs.getInt("semestre"));
                dis.setCargaHoraria(rs.getInt("cargaHoraria"));
                dis.setCurso(daoCurso.carregarCursoPorId(rs.getInt("fkCurso")));
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar disciplina!\n"+ ex.getMessage());
        }
        return dis;
    }
    
    public boolean salvar(Disciplina dis){
        try {
            String sql = """
                         INSERT INTO disciplina
                         (idDisciplina, nome, semestre, cargaHoraria, fkCurso)
                         VALUES (?, ?, ?, ?, ?);""";
            
            PreparedStatement ps = criarPreparedStatement(sql);
            dis.setIdDisciplina(gerarProximoId("disciplina", "idDisciplina"));
            ps.setInt(1, dis.getIdDisciplina());
            ps.setString(2, dis.getNome());
            ps.setInt(3, dis.getSemestre());
            ps.setInt(4, dis.getCargaHoraria());
            
            if (dis.getCurso() != null) {
                if (dis.getCurso().getIdCurso() == null || dis.getCurso().getIdCurso() == 0) {
                    daoCurso.salvar(dis.getCurso());
                }
                ps.setInt(5, dis.getCurso().getIdCurso());
            } else {
                ps.setObject(5, null);
            }
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar disciplina\n" + ex.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Disciplina dis){
        try {
            String sql = """
                         UPDATE disciplina
                         SET nome=?,  semestre=?, cargaHoraria=?, fk_curso=? 
                         WHERE idDisciplina ="""+dis.getIdDisciplina();
            
            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, dis.getNome());
            ps.setInt(2, dis.getCargaHoraria());
            ps.setInt(3, dis.getSemestre());
            
            if (dis.getCurso() == null) {
                if (dis.getCurso().getIdCurso() == null) {
                    daoCurso.salvar(dis.getCurso());
                } else {
                    daoCurso.atualizar(dis.getCurso());
                }
                ps.setInt(4, dis.getCurso().getIdCurso());
            } else {
                ps.setObject(4, null);
            }
                        
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao editar disciplina\n" + ex.getMessage());
            return false;
        }
    }
    
    public String comandoSqlRemover(Disciplina dis){
        return "DELETE FROM disciplina WHERE idDisciplina = "+dis.getIdDisciplina();
    }
    
    public boolean remover(Disciplina dis){
        try {
            executeSql(comandoSqlRemover(dis));
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover disciplina\n"+e.getMessage());
            return false;
        }
    }
}
