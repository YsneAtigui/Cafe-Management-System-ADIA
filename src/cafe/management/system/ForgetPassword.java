/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.management.system;

import javax.swing.JOptionPane;
import model.User;
import dao.UserDao;

/**
 *
 * @author yassine
 */
public class ForgetPassword extends javax.swing.JFrame {
    private String dbAnswer = null;
    private String email = null;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";

    /**
     * Creates new form ForgetPassword
     */
    public ForgetPassword() {
        initComponents();
        btnUpdate.setEnabled(false);
        btnSearch.setEnabled(false);
        txtSecurityQ.setEditable(false);
    }
    
    public void clear(){
        btnUpdate.setEnabled(false);
        btnSearch.setEnabled(false);
        txtemail.setEditable(true);
        txtemail.setText("");
        txtSecurityQ.setText("");
        txtanswer.setText("");
        txtpswd.setText("");
    } 
    
    public void validateEmail(){
        email = txtemail.getText();
        if(email.matches(emailPattern)){
            btnSearch.setEnabled(true);
            
        }
        else{
            btnSearch.setEnabled(false);
        }
    }
    
    public void validateFields(){
        String password = txtpswd.getText();
        String answer = txtanswer.getText();
        String securityQuestion = txtSecurityQ.getText();
        
        if(!password.equals("") && !securityQuestion.equals("") && !answer.equals("")){
            btnUpdate.setEnabled(true);
        }
        else{
            btnUpdate.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSecurityQ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtanswer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpswd = new javax.swing.JPasswordField();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(50, 5));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 206, 0));
        jLabel1.setText("Forget Password ?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 129, 38));

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 473, 38));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Security Question :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, 38));

        txtSecurityQ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSecurityQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSecurityQKeyReleased(evt);
            }
        });
        getContentPane().add(txtSecurityQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 473, 38));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Answer :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 129, 38));

        txtanswer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtanswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtanswerKeyReleased(evt);
            }
        });
        getContentPane().add(txtanswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 473, 38));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("New Password :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 129, 38));

        txtpswd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtpswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpswdKeyReleased(evt);
            }
        });
        getContentPane().add(txtpswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 473, 38));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, -1, 38));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 226, 38));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login2.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 111, 37));

        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignup.setText("SignUP");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 111, 37));

        btnexit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sortie.png"))); // NOI18N
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 440, 111, 37));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperflare.com_wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        email = txtemail.getText();
        User user = null ;
        user = UserDao.getSecurityQuestion(email);
        if(user == null){
            JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">INCORRECT EMAIL</b></html>","Message",JOptionPane.ERROR_MESSAGE);
        }
        else{
            btnSearch.setEnabled(false);
            txtemail.setEditable(false);
            dbAnswer = user.getAnswer();
            txtSecurityQ.setText(user.getSecurityQuestion());
            validateFields();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String answer = txtanswer.getText();
        String newPassword = txtpswd.getText();
        
        if(answer.equals(dbAnswer)){
            UserDao.update(email, newPassword);
            clear();
        }
        else{
            JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">INCORRECT ANSWER</b></html>","Message",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new SignUp().setVisible(true);
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        // TODO add your handling code here:
        validateEmail();
    }//GEN-LAST:event_txtemailKeyReleased

    private void txtSecurityQKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecurityQKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtSecurityQKeyReleased

    private void txtanswerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtanswerKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtanswerKeyReleased

    private void txtpswdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpswdKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtpswdKeyReleased

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Close Application","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtSecurityQ;
    private javax.swing.JTextField txtanswer;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpswd;
    // End of variables declaration//GEN-END:variables
}
