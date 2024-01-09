package persistencia;

import modelo.Docente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDocente extends DAO{
    
    private DaoEndereco daoEndereco;
    
    public DaoDocente() {
        daoEndereco = new DaoEndereco();
    }
    
    public List<Docente> carregarDocentes() {
        List<Docente> listaDocentes = new ArrayList<>();
        try {
            String sql = """
                         SELECT d.*, e.* FROM docente as d
                         left join endereco as e on d.fkEndereco = e.idEndereco""";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Docente d = new Docente();
                d.setIdDocente(rs.getInt("idDocente"));
                d.setNome(rs.getString("nome"));
                d.setCpf(rs.getString("cpf"));
                d.setEmail(rs.getString("email"));
                d.setGenero(rs.getString("genero"));
                //d.setDataNascimento(rs.getString("dataNascimento"));
                d.setCtps(rs.getString("ctps"));
                d.setSalario(rs.getDouble("salario"));
                d.setEndereco(daoEndereco.carregarEnderecoPorId(rs.getInt("fkEndereco")));
                
                listaDocentes.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Falha ao carregar docentes!\n" + e.getMessage());
        }
        return listaDocentes;
    }
    
    public Docente carregarPorId(int idDocente){
        Docente cl = null;
        try {
            String sql = "SELECT * FROM docente \n"
                    + "left join endereco as ed on fkEndereco = ed.idEndereco"
                    + " where docente.idDocente = " + idDocente;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                cl = new Docente();
                cl.setIdDocente(rs.getInt("idDocente"));
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
    
    public boolean salvar(Docente docente) {
        try {
            String sql = "INSERT INTO docente"
                    + " (idDocente, nome, cpf, email, genero, dataNascimento, ctps, salario, fkEndereco)"
                    + " VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";

            PreparedStatement ps = criarPreparedStatement(sql);
            docente.setIdDocente(gerarProximoId("docente", "idDocente"));
            ps.setInt(1, docente.getIdDocente());
            ps.setString(2, docente.getNome());
            ps.setString(3, docente.getCpf());
            ps.setString(4, docente.getEmail());
            ps.setString(5, docente.getGenero());
            java.util.Date dataNascimento = java.sql.Date.valueOf(docente.getDataNascimento());
            ps.setDate(6, (Date) dataNascimento);
            ps.setString(7, docente.getCtps());
            ps.setDouble(8, docente.getSalario());

            if (docente.getEndereco() != null) {
                if (docente.getEndereco().getIdEndereco()== null || docente.getEndereco().getIdEndereco()== 0) {
                    daoEndereco.salvar(docente.getEndereco());
                }
                ps.setInt(9, docente.getEndereco().getIdEndereco());
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
            System.out.println("Falha ao salvar Docente\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Docente docente) {
        try {
            String sql = "UPDATE docente"
                    + "SET nome=?, cpf=?, email=?, genero=?,"
                    + "dataNascimento=?, ctps=?, salario=?,"
                    + "fkEndereco=?"
                    + " WHERE idDocente= " + docente.getIdDocente();

            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, docente.getNome());
            ps.setString(2, docente.getCpf());
            ps.setString(3, docente.getEmail());
            ps.setString(4, docente.getGenero());
           // ps.setString(5, docente.getDataNascimento());
            ps.setString(6, docente.getCtps());
            ps.setDouble(7, docente.getSalario());
            
            if (docente.getEndereco() == null) {
                if (docente.getEndereco().getIdEndereco() == null) {
                    daoEndereco.salvar(docente.getEndereco());
                } else {
                    daoEndereco.atualizar(docente.getEndereco());
                }
                ps.setInt(8, docente.getEndereco().getIdEndereco());
            } else {
                ps.setObject(8, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar docente!\n" + e.getMessage());
            return false;
        }
    }

    public boolean remover(Docente docente) {
        try {
            String sql = "DELETE FROM docente WHERE idDocente =" + docente.getIdDocente();

            executeSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover docente!\n" + e.getMessage());
            return false;
        }
    }
}
