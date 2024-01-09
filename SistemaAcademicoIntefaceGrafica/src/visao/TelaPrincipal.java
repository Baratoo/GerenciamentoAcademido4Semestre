package visao;

import controle.ControlePrincipal;

public class TelaPrincipal extends javax.swing.JFrame {

    private ControlePrincipal controlePrincipal;

    public TelaPrincipal(ControlePrincipal controlePrincipal) {
        this.controlePrincipal = controlePrincipal;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jB_Alunos = new javax.swing.JButton();
        jB_Docentes = new javax.swing.JButton();
        jB_Cursos = new javax.swing.JButton();
        jB_Docentes1 = new javax.swing.JButton();
        jB_Disciplina = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAluno = new javax.swing.JMenuItem();
        jMenuItemDocente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Acadêmico");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema Acadêmico");

        jB_Alunos.setBackground(new java.awt.Color(171, 213, 213));
        jB_Alunos.setForeground(new java.awt.Color(20, 20, 20));
        jB_Alunos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/imagens/student.png"))); // NOI18N
        jB_Alunos.setText("<html> <b>Cadastro de Alunos  </html>");
        jB_Alunos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null));
        jB_Alunos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_Alunos.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jB_Alunos.setPreferredSize(new java.awt.Dimension(150, 100));
        jB_Alunos.setRequestFocusEnabled(false);
        jB_Alunos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_Alunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AlunosActionPerformed(evt);
            }
        });

        jB_Docentes.setBackground(new java.awt.Color(171, 213, 213));
        jB_Docentes.setForeground(new java.awt.Color(20, 20, 20));
        jB_Docentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/imagens/online-learning.png"))); // NOI18N
        jB_Docentes.setText("<html>\n<b>Cadastro de Docentes\n\n</html>");
        jB_Docentes.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null));
        jB_Docentes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_Docentes.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jB_Docentes.setPreferredSize(new java.awt.Dimension(150, 100));
        jB_Docentes.setRequestFocusEnabled(false);
        jB_Docentes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_Docentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_DocentesActionPerformed(evt);
            }
        });

        jB_Cursos.setBackground(new java.awt.Color(171, 213, 213));
        jB_Cursos.setForeground(new java.awt.Color(20, 20, 20));
        jB_Cursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/imagens/curso2.png"))); // NOI18N
        jB_Cursos.setText("<html> <b>Cadastro de Cursos </html>");
        jB_Cursos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null));
        jB_Cursos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_Cursos.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jB_Cursos.setPreferredSize(new java.awt.Dimension(150, 100));
        jB_Cursos.setRequestFocusEnabled(false);
        jB_Cursos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_Cursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CursosActionPerformed(evt);
            }
        });

        jB_Docentes1.setBackground(new java.awt.Color(171, 213, 213));
        jB_Docentes1.setForeground(new java.awt.Color(20, 20, 20));
        jB_Docentes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/imagens/funcionario.png"))); // NOI18N
        jB_Docentes1.setText("<html>\n<b>Cadastro de Funcionário\n\n</html>");
        jB_Docentes1.setToolTipText("Cadastro de Funcionário");
        jB_Docentes1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null));
        jB_Docentes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_Docentes1.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jB_Docentes1.setPreferredSize(new java.awt.Dimension(150, 100));
        jB_Docentes1.setRequestFocusEnabled(false);
        jB_Docentes1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_Docentes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Docentes1ActionPerformed(evt);
            }
        });

        jB_Disciplina.setBackground(new java.awt.Color(171, 213, 213));
        jB_Disciplina.setForeground(new java.awt.Color(20, 20, 20));
        jB_Disciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/util/imagens/icons8-discipline-64.png"))); // NOI18N
        jB_Disciplina.setText("<html> <b>Cadastro de Disciplinas </html>");
        jB_Disciplina.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null));
        jB_Disciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_Disciplina.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jB_Disciplina.setPreferredSize(new java.awt.Dimension(150, 100));
        jB_Disciplina.setRequestFocusEnabled(false);
        jB_Disciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_DisciplinaActionPerformed(evt);
            }
        });

        jMenu1.setText("Cadastros");

        jMenuItemAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItemAluno.setText("Aluno");
        jMenuItemAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAluno);

        jMenuItemDocente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItemDocente.setText("Docente");
        jMenu1.add(jMenuItemDocente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");
        jMenu2.setToolTipText("");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Cursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Docentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Docentes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jB_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Docentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_Cursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_Docentes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jB_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlunoActionPerformed
        controlePrincipal.getControleAluno().abrirTelaListagem();
    }//GEN-LAST:event_jMenuItemAlunoActionPerformed

    private void jB_AlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AlunosActionPerformed
        controlePrincipal.getControleAluno().abrirTelaListagem();
    }//GEN-LAST:event_jB_AlunosActionPerformed

    private void jB_CursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CursosActionPerformed
        controlePrincipal.getControleCurso().abrirTelaListagem();
    }//GEN-LAST:event_jB_CursosActionPerformed

    private void jB_DocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_DocentesActionPerformed
        controlePrincipal.getControleDocente().abrirTelaListagem();
    }//GEN-LAST:event_jB_DocentesActionPerformed

    private void jB_Docentes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Docentes1ActionPerformed
        controlePrincipal.getControleFuncionario().abrirTelaListagem();
    }//GEN-LAST:event_jB_Docentes1ActionPerformed

    private void jB_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_DisciplinaActionPerformed
        controlePrincipal.getControleDisciplina().abrirTelaListagem();
    }//GEN-LAST:event_jB_DisciplinaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Alunos;
    private javax.swing.JButton jB_Cursos;
    private javax.swing.JButton jB_Disciplina;
    private javax.swing.JButton jB_Docentes;
    private javax.swing.JButton jB_Docentes1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAluno;
    private javax.swing.JMenuItem jMenuItemDocente;
    // End of variables declaration//GEN-END:variables
}
