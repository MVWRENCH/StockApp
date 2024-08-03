/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stock;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author reynn
 */
public class LoginForm extends javax.swing.JFrame implements ActionListener {

//    public LoginForm() {
//        initComponents();
//    }
    
    private JTextField f_User;
    private JPasswordField f_Pass;
    private JButton login, batal;
    
    public LoginForm(){
        setSize(350, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        userInterface();
        setVisible(true);
    }
    
    private void userInterface(){
        JLabel judul = new JLabel("Form Login");
        judul.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(judul, "North");
        
        JPanel panComp = new JPanel();
        panComp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JLabel user = new JLabel("Username");
        user.setPreferredSize(new Dimension(110, 25));
        panComp.add(user);
        
        f_User = new JTextField();
        f_User.setPreferredSize(new Dimension(210, 25));
        panComp.add(f_User);
        
        JLabel pass = new JLabel("Password");
        pass.setPreferredSize(new Dimension(110, 25));
        panComp.add(pass);
        
        f_Pass = new JPasswordField();
        f_Pass.setPreferredSize(new Dimension(210, 25));
        panComp.add(f_Pass);
        
        getContentPane().add(panComp);
        
        JPanel panButton = new JPanel();
        panButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        login = new JButton("Login");
        panButton.add(login);
        login.addActionListener(this);
        
        batal = new JButton("Cancel");
        panButton.add(batal);
        batal.addActionListener(this);
        
        getContentPane().add(panButton, "South");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            String pass = String.valueOf(f_Pass.getPassword());
            if(f_User.getText().equals("admin") && pass.equals("admin")){
                JOptionPane.showMessageDialog(null, "Berhasil Login");
                this.setVisible(false);
                new ItemForm().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Gagal Login");
            }
        }else if(e.getSource()==batal){
            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
