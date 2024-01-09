package persistencia;

import java.sql.*;
import java.util.ArrayList;
import modelo.Endereco;

public class DaoEndereco extends DAO{
    
    public ArrayList<Endereco> carregarEnderecos(){
        ArrayList<Endereco> enderecos = new ArrayList<>();
        try {
            String sql = "select * from endereco";
            ResultSet rs = consultaSQL(sql);
            while(rs.next()){
                Endereco end = new Endereco();
                end.setIdEndereco(rs.getInt("idEndereco"));
                end.setCidade(rs.getString("cidade"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getString("numero"));
                
                enderecos.add(end);
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar endereços!\n"+ ex.getMessage());
        }
        return enderecos;
    }
    
    public Endereco carregarEnderecoPorId(int idEndereco){
        Endereco end = null;
        try {
            String sql = "select * from endereco where idEndereco = "+idEndereco;
            ResultSet rs = consultaSQL(sql);
            if(rs.next()){
                end = new Endereco();
                end.setIdEndereco(rs.getInt("id_endereco"));
                end.setCidade(rs.getString("cidade"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getString("numero"));
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar endereço!\n"+ ex.getMessage());
        }
        return end;
    }
    
    public boolean salvar(Endereco end){
        try {
            String sql = """
                         INSERT INTO endereco
                         (idEndereco, cidade, rua, numero)
                         VALUES (?, ?, ?, ?);""";
            
            PreparedStatement ps = criarPreparedStatement(sql);
            end.setIdEndereco(gerarProximoId("endereco", "idEndereco"));
            ps.setInt(1, end.getIdEndereco());
            ps.setString(2, end.getCidade());
            ps.setString(3, end.getRua());
            ps.setString(4, end.getNumero());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar endereço\n" + ex.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Endereco end){
        try {
            String sql = """
                         UPDATE endereco
                         SET cidade=?, rua=?, numero=?
                         WHERE idEndereco ="""+end.getIdEndereco();
            
            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, end.getCidade());
            ps.setString(2, end.getRua());
            ps.setString(3, end.getNumero());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao editar endereço\n" + ex.getMessage());
            return false;
        }
    }
    
    public String comandoSqlRemover(Endereco end){
        return "DELETE FROM endereco WHERE idEndereco = "+end.getIdEndereco();
    }
    
    public boolean remover(Endereco end){
        try {
            executeSql(comandoSqlRemover(end));
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover endereço\n"+e.getMessage());
            return false;
        }
    }
    
}
