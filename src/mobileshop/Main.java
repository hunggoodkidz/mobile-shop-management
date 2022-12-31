package mobileshop;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mobileshop.model.FrontEnd.GiaoDienChuan.LoginForm;
import mobileshop.model.FrontEnd.GiaoDienChuan.SplashScreen;

public class Main {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch 
        (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
        /* Create and display the form */

                
        SplashScreen screen = new SplashScreen();        
        
        screen.setVisible(true);
        try {
            for (int row = 0; row <=100; row++) {
                Thread.sleep(8);
                screen.loadingnumber.setText(Integer.toString(row)+"%");
                screen.loadingprogress.setValue(row);
                if (row == 100) {
                    
                    screen.setVisible(false);
                    new LoginForm().setVisible(true);
                }
            }
        } catch (Exception e) {
        }

    }
}
