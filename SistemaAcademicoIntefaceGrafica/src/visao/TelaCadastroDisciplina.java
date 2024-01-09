package visao;

import controle.ControleCurso;
import controle.ControleDisciplina;
import controle.ControlePrincipal;
import controle.IControleCadastro;
import java.util.HashMap;
import modelo.Curso;
import util.DialogBoxUtils;

public class TelaCadastroDisciplina extends TelaCadastro {

    private ControlePrincipal controlePrincipal;
    private ControleCurso controleCurso;

    public TelaCadastroDisciplina(IControleCadastro controle) {
        super(controle);
        initComponents();
        setLocationRelativeTo(null);
        inicializarComponentesTela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jT_Disciplina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jS_Semestre = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jS_CargaHoraria = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jC_Curso = new javax.swing.JComboBox<>();
        jB_Salvar = new javax.swing.JButton();
        jB_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Disciplina");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Disciplina");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 18));

        jT_Disciplina.setActionCommand("<Not Set>");
        jT_Disciplina.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jT_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_DisciplinaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Semestre");
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 18));

        jS_Semestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Carga Horária");
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 18));

        jS_CargaHoraria.setModel(new javax.swing.SpinnerNumberModel(200, 40, 1000, 10));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Curso");
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 18));

        jC_Curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Curso", " " }));
        jC_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_CursoActionPerformed(evt);
            }
        });

        jB_Salvar.setBackground(java.awt.SystemColor.activeCaption);
        jB_Salvar.setText("Salvar");
        jB_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalvarActionPerformed(evt);
            }
        });

        jB_Cancelar.setBackground(java.awt.SystemColor.controlHighlight);
        jB_Cancelar.setText("Cancelar");
        jB_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jS_Semestre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jS_CargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jT_Disciplina)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jB_Cancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jB_Salvar)))))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jC_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jT_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jS_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jS_CargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jC_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Salvar)
                    .addComponent(jB_Cancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jC_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_CursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jC_CursoActionPerformed

    private void jB_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalvarActionPerformed

        if (!editarDados) {
            controle.salvar(getDadosTela());
        } else {
            controle.editar(getDadosTela());
        }
        controle.atualizarTabelaTelaListagem();
        setVisible(false);
    }//GEN-LAST:event_jB_SalvarActionPerformed

    private void jB_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jB_CancelarActionPerformed

    private void jT_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_DisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_DisciplinaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Cancelar;
    private javax.swing.JButton jB_Salvar;
    private javax.swing.JComboBox<String> jC_Curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jS_CargaHoraria;
    private javax.swing.JSpinner jS_Semestre;
    private javax.swing.JTextField jT_Disciplina;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setarDadosTela(HashMap<String, Object> dados) {
        if (dados == null || dados.isEmpty()) {
            DialogBoxUtils.exibirMensagemDeErro("Erro", "Erro ao setar dados na tela");
        }

        jT_Disciplina.setText((String) dados.getOrDefault("nome", ""));
        jS_Semestre.setValue(dados.getOrDefault("semestre", 0));
        jS_CargaHoraria.setValue(dados.getOrDefault("cargaHoraria", 0));
        if (dados.get("curso") != null) {
            jC_Curso.setSelectedItem(((Curso) dados.get("curso")).getNome());
        }
    }

    @Override
    public HashMap<String, Object> getDadosTela() {
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("nome", jT_Disciplina.getText());
        dados.put("semestre", jS_Semestre.getValue());
        dados.put("cargaHoraria", jS_CargaHoraria.getValue());
        int indexCurso = jC_Curso.getSelectedIndex();
        if (indexCurso >= 0) {
            dados.put("curso", ((ControleDisciplina) controle).getControleCurso().getCursoSelecionado(indexCurso));
        } else {
            dados.put("curso", null);
        }
        return dados;
    }

    @Override
    public void inicializarComponentesTela() {
        jT_Disciplina.setText("");
        jS_CargaHoraria.setValue(200);
        jS_Semestre.setValue(12);
        ControleDisciplina controleCurso = (ControleDisciplina) controle;
        jC_Curso.removeAllItems();
        for (String nomeCurso : controleCurso.getControleCurso().getNomesCursos()) {
            jC_Curso.addItem(nomeCurso);
        }
        jC_Curso.setSelectedIndex(0);
    }
}
