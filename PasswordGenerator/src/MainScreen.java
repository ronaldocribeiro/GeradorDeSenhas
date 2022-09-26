import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame{
    private JPanel panel;
    private JTextField num;
    private JTextField slet;
    private JTextField clet;
    private JTextField scar;
    private JTextField pasger;
    private JButton Generate;

    public MainScreen(){
        setContentPane(panel);
        setTitle("Password Generator by Ronaldo Ribeiro");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n, sm, cl, sc;
                JTextField[] aux = {num, slet, clet, scar};
                for(JTextField aux1 : aux){
                    if(aux1.getText().equals("")){
                        aux1.setText("0");
                    }
                }
                n = Integer.parseInt(num.getText());
                sm = Integer.parseInt(slet.getText());
                cl = Integer.parseInt(clet.getText());
                sc = Integer.parseInt(scar.getText());
                GeneratePass generator = new GeneratePass();
                pasger.setText(generator.GeneratePass(n,sm,cl,sc));
            }
        });
    }

    public static void main(String[] args) {
        MainScreen myFrame = new MainScreen();
    }
}
