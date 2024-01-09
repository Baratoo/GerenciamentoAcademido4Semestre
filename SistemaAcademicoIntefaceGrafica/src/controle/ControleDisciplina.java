
package controle;

import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Disciplina;
import persistencia.DaoDisciplina;
import visao.TelaCadastroDisciplina;


public class ControleDisciplina extends ControleCadastroGenerico<Disciplina>{
    
    private ControleCurso controleCurso;  
    private DaoDisciplina daoDisciplina = new DaoDisciplina();
    
    public ControleDisciplina(ControleCurso controleCurso) {
        super(Disciplina.class);
        this.controleCurso = controleCurso;
        setTelaCadastro(new TelaCadastroDisciplina(this));
    }
    
    public ControleCurso getControleCurso(){
        return controleCurso;
    }
    
    public HashMap<String, Object> gerarVetorDados(Disciplina disc){
        HashMap<String, Object> dados = new HashMap<>();        
        dados.put("nome", disc.getNome());
        dados.put("semestre", disc.getSemestre());
        dados.put("cargaHoraria", disc.getCargaHoraria());
        dados.put("curso", disc.getCurso());
        
        return dados;
    }
    
    public void setarDadosObjeto(Disciplina disciplina, HashMap<String, Object> dados){
        if(disciplina == null){
            JOptionPane.showMessageDialog(null, "Falha ao Setar Dados!", "Falha ao Setar Dados", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        disciplina.setNome((String) dados.getOrDefault("nome", ""));
        disciplina.setSemestre((int) dados.getOrDefault("semestre", 0));
        disciplina.setCargaHoraria((int) dados.getOrDefault("cargaHoraria", 0));
        disciplina.setCurso((Curso) dados.getOrDefault("curso", null));
    }
    
    public Disciplina getDisciplinaSelecionada(int index) {
        if (index >= 0 && index < registros.size()) {
            return (Disciplina) registros.get(index);
        }
        return null;
    }

    @Override
    public void abrirTelaCadastroParaEdicao(int index) {
        registroSelecionado = getDisciplinaSelecionada(index);
        if (registroSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Falha ao Editar \nRegistro não encontrado!", "Falha ao Editar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        telaCadastro.setarDadosTela(gerarVetorDados((Disciplina) registroSelecionado));
        telaCadastro.setEditarDados(true);
        telaCadastro.setVisible(true);
    }

    @Override
    public void editar(HashMap dados) {
        if(registroSelecionado != null){
            setarDadosObjeto((Disciplina) registroSelecionado, dados);
        }
    }

    @Override
    public void salvar(HashMap dados) {
        Disciplina disc = new Disciplina();
        setarDadosObjeto(disc, dados);
        daoDisciplina.salvar(disc);
    }

    @Override
    public void carregarEntidades() {
        registros = daoDisciplina.carregarDisciplinas();
    }
    
}
