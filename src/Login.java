import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;

    public Login() {
        super("Library System");
        initComponents();
        con=JavaConnect.ConnecrDb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        signin = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library System");

        username.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        username.setText("Username");

        password.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        password.setText("Password");

        signin.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        signin.setText("Sign in");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });

        signup.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        signup.setText("Sign up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Eras Demi ITC", 1, 20)); // NOI18N
        jLabel3.setText("WELLCOME TO LIBRARY SYSTEM ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(signin)
                                    .addGap(18, 18, 18)
                                    .addComponent(signup))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(password)
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                        .addComponent(jPasswordField1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signup)
                    .addComponent(signin))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(419, 267));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        setVisible(false);
        signup sp=new signup();
        sp.setVisible(true);
    }//GEN-LAST:event_signupActionPerformed

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        String sql="select * from Account where Username=? and Password=?";
        try{
        pst=con.prepareStatement(sql);
        pst.setString(1,jTextField1.getText());
        pst.setString(2,jPasswordField1.getText());
        rs=pst.executeQuery();
        if(rs.next()){
            rs.close();
            pst.close();
            
            setVisible(false);
            Loading lo=new Loading();
            lo.setVisible(true);   
        }else
        JOptionPane.showMessageDialog(null,"Incorrct Useename or Password.");              
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }finally{
            try{
        rs.close();
        pst.close();
        }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_signinActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel password;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
