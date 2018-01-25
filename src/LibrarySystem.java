public class LibrarySystem {

    public static void main(String[] args) {
        JavaConnect connect = new JavaConnect();
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }
    
}
