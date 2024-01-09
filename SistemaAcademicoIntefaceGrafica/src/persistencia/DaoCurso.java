package persistencia;

import java.sql.*;
import java.util.ArrayList;
import modelo.Curso;
import modelo.Docente;

public class DaoCurso extends DAO{
    
    private DaoDocente daoDocente;
    
    public DaoCurso (){
        daoDocente = new DaoDocente();
    }
    
    public int alunosCurso(Integer fk_curso){
        try{
            String sql = "select count(id_aluno) as quantidade from aluno "
                    + "inner join curso on curso.id_curso = aluno.fk_curso "
                    + "where fk_curso = "+fk_curso;
            ResultSet rs = consultaSQL(sql);
            rs.next();
            int resultado = rs.getInt("quantidade");
            return resultado;
        }catch(SQLException ex) {
            System.out.println("Falha ao carregar cursos!\n"+ ex.getMessage());
        }
        return 0;
    }
    
    public ArrayList<Curso> carregarCursos(){
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            String sql = "select * from curso";
            ResultSet rs = consultaSQL(sql);
            while(rs.next()){
                Curso cur = new Curso();
                cur.setIdCurso(rs.getInt("idCurso"));
                cur.setNome(rs.getString("nome"));
                cur.setCargaHoraria(rs.getInt("cargaHoraria"));
                cur.setQtdSemestres(rs.getInt("qtdSemestres"));
                cur.setCoordenador(daoDocente.carregarPorId(rs.getInt("fkDocente")));
                
                cursos.add(cur);
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar cursos!\n"+ ex.getMessage());
        }
        return cursos;
    }
    
    public Curso carregarCursoPorId(int idCurso){
        Curso cur = null;
        try {
            String sql = "select * from curso where idCurso = "+idCurso;
            ResultSet rs = consultaSQL(sql);
            if(rs.next()){
                cur = new Curso();
                cur.setIdCurso(rs.getInt("idCurso"));
                cur.setNome(rs.getString("nome"));
                cur.setCargaHoraria(rs.getInt("cargaHoraria"));
                cur.setQtdSemestres(rs.getInt("qtdSemestres"));
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar curso!\n"+ ex.getMessage());
        }
        return cur;
    }
    
    public boolean salvar(Curso cur){
        try {
            String sql = """
                         INSERT INTO curso
                         (idCurso, nome, cargaHoraria, qtdSemestres, fkDocente)
                         VALUES (?, ?, ?, ?, ?);""";
            
            PreparedStatement ps = criarPreparedStatement(sql);
            cur.setIdCurso(gerarProximoId("curso", "idCurso"));
            ps.setInt(1, cur.getIdCurso());
            ps.setString(2, cur.getNome());
            ps.setInt(3, cur.getCargaHoraria());
            ps.setInt(4, cur.getQtdSemestres());
            if (cur.getCoordenador() != null) {
                if (cur.getCoordenador().getIdDocente()== null || cur.getCoordenador().getIdDocente()== 0) {
                    ps.setObject(5, null);
                }
                ps.setInt(5, cur.getCoordenador().getIdDocente());
            } else {
                ps.setObject(5, null);
            }
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar curso\n" + ex.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Curso cur){
        try {
            String sql = """
                         UPDATE curso
                         SET nome=?, cargaHoraria=?, qtdSemestres=?, fkDocente=?
                         WHERE idCurso ="""+cur.getIdCurso();
            
            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, cur.getNome());
            ps.setInt(2, cur.getCargaHoraria());
            ps.setInt(3, cur.getQtdSemestres());
            ps.setInt(4, cur.getCoordenador().getIdDocente());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao editar curso\n" + ex.getMessage());
            return false;
        }
    }
    
    public String comandoSqlRemover(Curso cur){
        return "DELETE FROM curso WHERE idCurso = "+cur.getIdCurso();
    }
    
    public boolean remover(Curso cur){
        try {
            executeSql(comandoSqlRemover(cur));
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover curso\n"+e.getMessage());
            return false;
        }
    }
    
    
}
