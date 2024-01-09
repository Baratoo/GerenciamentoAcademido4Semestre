package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

public class DaoAluno extends DAO {

    private DaoPessoa daoPessoa;
    private DaoEndereco daoEndereco;
    private DaoCurso daoCurso;
    
    public DaoAluno() {
        daoPessoa = new DaoPessoa();
        daoCurso = new DaoCurso();
        daoEndereco = new DaoEndereco();
    }
    
    public List<Aluno> carregarAlunos() {
        List<Aluno> listaAlunos = new ArrayList<>();
        try {
            String sql = """
                         SELECT a.*, c.*, e.* FROM aluno as a
                         left join curso as c on a.fkCurso = c.idCurso
                         left join endereco as e on a.fkEndereco = e.idEndereco""";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setEmail(rs.getString("email"));
                a.setGenero(rs.getString("genero"));
                a.setRa(rs.getString("ra"));
                a.setSituacao(rs.getString("situacao"));
                /*a.setEndereco(rs.getString("email"));
                a.setCurso(rs.getString("email"));*/
                
                listaAlunos.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Falha ao carregar alunos!\n" + e.getMessage());
        }
        return listaAlunos;
    }

    public Aluno carregarPorId(int idAluno) {
        Aluno cl = null;
        try {
            String sql = "SELECT * FROM aluno \n"
                    + "left join endereco as ed on fk_endereco = ed.id_endereco"
                    + " where aluno.idAluno = " + idAluno;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                cl = new Aluno();
                cl.setIdAluno(rs.getInt("idAluno"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));
                cl.setEmail(rs.getString("email"));
                cl.setGenero(rs.getString("genero"));
                cl.setRa(rs.getString("ra"));
                cl.setSituacao(rs.getString("situacao"));
                cl.setEndereco(daoEndereco.carregarEnderecoPorId(rs.getInt("fkEndereco")));
                cl.setCurso(daoCurso.carregarCursoPorId(rs.getInt("fkCurso")));
            }
            
        } catch (SQLException e) {
            System.out.println("Falha ao carregar aluno!\n"
                    + e.getMessage());
        }
        return cl;
    }

    public boolean salvar(Aluno aluno) {
        try {
            String sql = "INSERT INTO aluno\n"
                    + " (idAluno, nome, cpf, email, genero, dataNascimento, ra, dataMatricula, situacao,fkEndereco, fkCurso)\n"
                    + " VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = criarPreparedStatement(sql);
            aluno.setIdAluno(gerarProximoId("aluno", "idAluno"));
            ps.setInt(1, aluno.getIdAluno());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getCpf());
            ps.setString(4, aluno.getEmail());
            ps.setString(5, aluno.getGenero());
            java.util.Date dataNascimento = java.sql.Date.valueOf(aluno.getDataNascimento());
            ps.setDate(6, (Date) dataNascimento);
            ps.setString(7, aluno.getRa());
            java.util.Date dataMatricula = java.sql.Date.valueOf(aluno.getDataMatricula());
            ps.setDate(8, (Date) dataMatricula);
            ps.setString(9, aluno.getSituacao());

            if (aluno.getEndereco() != null) {
                if (aluno.getEndereco().getIdEndereco()== null || aluno.getEndereco().getIdEndereco()== 0) {
                    daoEndereco.salvar(aluno.getEndereco());
                }
                ps.setInt(10, aluno.getEndereco().getIdEndereco());
            } else {
                ps.setObject(10, null);
            }
            if (aluno.getCurso()!= null) {
                if (aluno.getCurso().getIdCurso()== null || aluno.getCurso().getIdCurso()== 0) {
                    daoCurso.salvar(aluno.getCurso());
                }
                ps.setInt(11, aluno.getCurso().getIdCurso());
            } else {
                ps.setObject(11, null);
            }
           
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            try {
                getConexao().rollback();
            } catch (SQLException ex1) {
                System.out.println("Falhar ao realizar RollBack");
            }
            System.out.println("Falha ao salvar Aluno\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Aluno aluno) {
        try {
            String sql = "UPDATE aluno"
                    + "SET nome=?, cpf=?, email=?, genero=?,"
                    + "dataNascimento=?, ra=?, dataMatricula=?, situacao=?,"
                    + "fkEndereco=?, fkCurso=?"
                    + " WHERE idAluno= " + aluno.getIdAluno();

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getEmail());
            ps.setString(4, aluno.getGenero());
           // java.util.Date dataNascimento = java.sql.Date.valueOf(aluno.getDataNascimento());
           // ps.setDate(5, (Date) dataNascimento);
            ps.setString(6, aluno.getRa());
           // java.util.Date dataMatricula = java.sql.Date.valueOf(aluno.getDataMatricula());
            //ps.setDate(7, (Date) dataMatricula);
            ps.setString(8, aluno.getSituacao());
            
            if (aluno.getEndereco() != null) {
                if (aluno.getEndereco().getIdEndereco() == null) {
                    daoEndereco.salvar(aluno.getEndereco());
                } else {
                    daoEndereco.atualizar(aluno.getEndereco());
                }
                ps.setObject(9, null);
            } else {
                ps.setInt(9, aluno.getEndereco().getIdEndereco());
            }
            
            if (aluno.getCurso() != null) {
                if (aluno.getCurso().getIdCurso() == null || aluno.getCurso().getIdCurso() == 0) {
                    daoCurso.salvar(aluno.getCurso());
                } else {
                    daoCurso.atualizar(aluno.getCurso());
                }
                ps.setObject(10, null);
            } else {
                ps.setInt(10, aluno.getCurso().getIdCurso());            
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar aluno!\n" + e.getMessage());
            return false;
        }
    }

    public boolean remover(Aluno aluno) {
        try {
            String sql = "DELETE FROM aluno WHERE idAluno =" + aluno.getIdAluno();

            executeSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover aluno!\n" + e.getMessage());
            return false;
        }
    }
}
