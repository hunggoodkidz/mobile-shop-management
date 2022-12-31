package mobileshop.model.FrontEnd.MyButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FileButton extends JButton {

    public FileButton() {
        this.setIcon(new ImageIcon(this.getClass().getResource("/mobileshop/images/icons8_opened_folder_20px.png")));
    }
}
