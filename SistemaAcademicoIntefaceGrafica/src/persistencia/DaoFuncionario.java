package persistencia;

import java.sql.*;
import java.util.ArrayList;
import modelo.Funcionario;

public class DaoFuncionario extends DAO{
    
     private DaoEndereco daoEndereco;
    
    public DaoFuncionario() {
        daoEndereco = new DaoEndereco();
    }
    
    public ArrayList<Funcionario> carregarFuncionarios() {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        try {
            String sql = """
                         SELECT d.*, e.* FROM funcionario as d
                         left join endereco as e on d.fkEndereco = e.idEndereco""";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Funcionario d = new Funcionario();
                d.setIdFuncionario(rs.getInt("idFuncionario"));
                d.setNome(rs.getString("nome"));
                d.setCpf(rs.getString("cpf"));
                d.setEmail(rs.getString("email"));
                d.setGenero(rs.getString("genero"));
                //d.setDataNascimento(rs.getString("dataNascimento"));
                d.setCtps(rs.getString("ctps"));
                d.setSalario(rs.getDouble("salario"));
                d.setEndereco(daoEndereco.carregarEnderecoPorId(rs.getInt("fkEndereco")));
                
                listaFuncionarios.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Falha ao carregar funcionarios!\n" + e.getMessage());
        }
        return listaFuncionarios;
    }
    
    public Funcionario carregarPorId(int idFuncionario){
        Funcionario cl = null;
        try {
            String sql = "SELECT * FROM funcionario \n"
                    + "left join endereco as ed on fkEndereco = ed.idEndereco"
                    + " where funcionario.idFuncionario = " + idFuncionario;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                cl = new Funcionario();
                cl.setIdFuncionario(rs.getInt("idFuncionario"));
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));
                cl.setEmail(rs.getString("email"));
                cl.setGenero(rs.getString("genero"));
                //cl.setDataNascimento(rs.getDate("dataNascimento"));
                cl.setCtps(rs.getString("ctps"));
                cl.setSalario(rs.getDouble("salario"));
                cl.setEndereco(daoEndereco.carregarEnderecoPorId(rs.getInt("fkEndereco")));

            }
        } catch (SQLException e) {
            System.out.println("Falha ao carregar curso!\n"
                    + e.getMessage());
        }
        return cl;
    }
    
    public boolean salvar(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario"
                    + " (idFuncionario, nome, cpf, email, genero, dataNascimento, ctps, salario, fkEndereco)"
                    + " VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";

            PreparedStatement ps = criarPreparedStatement(sql);
            funcionario.setIdFuncionario(gerarProximoId("funcionario", "idFuncionario"));
            ps.setInt(1, funcionario.getIdFuncionario());
            ps.setString(2, funcionario.getNome());
            ps.setString(3, funcionario.getCpf());
            ps.setString(4, funcionario.getEmail());
            ps.setString(5, funcionario.getGenero());
            java.util.Date dataNascimento = java.sql.Date.valueOf(funcionario.getDataNascimento());
            ps.setDate(6, (Date) dataNascimento);
            ps.setString(7, funcionario.getCtps());
            ps.setDouble(8, funcionario.getSalario());

            if (funcionario.getEndereco() != null) {
                if (funcionario.getEndereco().getIdEndereco()== null || funcionario.getEndereco().getIdEndereco()== 0) {
                    daoEndereco.salvar(funcionario.getEndereco());
                }
                ps.setInt(9, funcionario.getEndereco().getIdEndereco());
            } else {
                ps.setObject(9, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            try {
                getConexao().rollback();
            } catch (SQLException ex1) {
                System.out.println("Falhar ao realizar RollBack");
            }
            System.out.println("Falha ao salvar Funcionario\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionario"
                    + "SET nome=?, cpf=?, email=?, genero=?,"
                    + "dataNascimento=?, ctps=?, salario=?,"
                    + "fkEndereco=?"
                    + " WHERE idFuncionario= " + funcionario.getIdFuncionario();

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEmail());
            ps.setString(4, funcionario.getGenero());
           // ps.setString(5, funcionario.getDataNascimento());
            ps.setString(6, funcionario.getCtps());
            ps.setDouble(7, funcionario.getSalario());
            
            if (funcionario.getEndereco() == null) {
                if (funcionario.getEndereco().getIdEndereco() == null) {
                    daoEndereco.salvar(funcionario.getEndereco());
                } else {
                    daoEndereco.atualizar(funcionario.getEndereco());
                }
                ps.setInt(8, funcionario.getEndereco().getIdEndereco());
            } else {
                ps.setObject(8, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar funcionario!\n" + e.getMessage());
            return false;
        }
    }

    public boolean remover(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM funcionario WHERE idFuncionario =" + funcionario.getIdFuncionario();

            executeSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover funcionario!\n" + e.getMessage());
            return false;
        }
    }
}
