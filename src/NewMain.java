

import main.form1_home;
import com.formdev.flatlaf.FlatLightLaf;

public class NewMain {

    public static void main(String[] args) {
        
        FlatLightLaf.setup();       
       
       new form1_home().setVisible(true); 
    }
    
}
