package persistencia;

import java.sql.*;
import java.util.ArrayList;
import modelo.Pessoa;

public class DaoPessoa extends DAO{
    
   /* private DaoEndereco daoEndereco;

    public DaoPessoa() {
        daoEndereco = new DaoEndereco();
    }

    public void lerResultSet(Pessoa p, ResultSet rs){
        try{
            p.set(rs.getInt("id"+"_aluno"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));

            if (rs.getObject("id_endereco", Integer.class) != null) {
                p.getEndereco().setId(rs.getInt("id_endereco"));
                p.getEndereco().setCidade(rs.getString("cidade"));
                p.getEndereco().setRua(rs.getString("rua"));
            }
        } catch (SQLException e) {
            System.out.println("Falha ao carregar pessoas!\n" + e.getMessage());
        } 
    }
    
    public ArrayList<Pessoa> carregarPessoas() {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        try {
            String sql = """
                         SELECT * FROM aluno 
                         left join endereco as ed on fk_endereco = ed.id_endereco""";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Pessoa p = new Pessoa();
                lerResultSet(p, rs);
                listaPessoas.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Falha ao carregar pessoas!\n" + e.getMessage());
        }
        return listaPessoas;
    }

    public Pessoa carregarPorId(int idAluno) {
        Pessoa cl = null;
        try {
            String sql = "SELECT * FROM aluno \n"
                    + "left join endereco as ed on fk_endereco = ed.id_endereco"
                    + " where aluno.id = " + idAluno;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                cl = new Pessoa();
                cl.setId(rs.getInt("id_aluno"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));

                if (rs.getObject("id_endereco", Integer.class) != null) {
                    cl.getEndereco().setId(rs.getInt("id_endereco"));
                    cl.getEndereco().setCidade(rs.getString("cidade"));
                    cl.getEndereco().setRua(rs.getString("rua"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Falha ao carregar aluno!\n"
                    + e.getMessage());
        }
        return cl;
    }

    public boolean salvar(Pessoa pessoa) {
        try {
            String sql = "INSERT INTO aluno\n"
                    + " (id_aluno, nome, cpf, fk_endereco, fk_curso)\n"
                    + " VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = criarPreparedStatement(sql);
            pessoa.setId(gerarProximoId("aluno", "id_aluno"));
            ps.setInt(1, pessoa.getId());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getCpf());

            if (pessoa.getEndereco() != null) {
                if (pessoa.getEndereco().getId() == null || pessoa.getEndereco().getId() == 0) {
                    daoEndereco.salvar(pessoa.getEndereco());
                }
                ps.setInt(4, pessoa.getEndereco().getId());
            } else {
                ps.setObject(4, null);
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

    public boolean atualizar(Pessoa pessoa) {
        try {
            String sql = "UPDATE aluno\n"
                    + "SET nome=?, cpf=?, fk_endereco=?, fk_curso=? \n"
                    + " WHERE id_aluno= " + pessoa.getId();

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            
            if (pessoa.getEndereco() == null) {
                if (pessoa.getEndereco().getId() == null) {
                    daoEndereco.salvar(pessoa.getEndereco());
                } else {
                    daoEndereco.atualizar(pessoa.getEndereco());
                }
                ps.setInt(3, pessoa.getEndereco().getId());
            } else {
                ps.setObject(3, null);
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar aluno!\n" + e.getMessage());
            return false;
        }
    }

    public boolean remover(Pessoa pessoa) {
        try {
            String sql = "DELETE FROM aluno WHERE id_aluno =" + pessoa.getId();

            executeSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover aluno!\n" + e.getMessage());
            return false;
        }
    }*/
}
