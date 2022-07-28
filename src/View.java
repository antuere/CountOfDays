
import javax.swing.*;
import java.awt.*;


public class View extends JFrame {

    JLabel result;
    JLabel nowDays;
    Controller controller;

    public View(String title, Controller controller) throws HeadlessException {
        super(title);
        this.controller = controller;
    }

    public void initView() {
            setLayout(null);
            String onStart = controller.getNowDays();
            result = new JLabel(controller.getResult(), JLabel.CENTER);
            nowDays = new JLabel(onStart);
            nowDays.setBounds(1, 0, 150, 10);
            result.setBounds(30, 20, 300, 30);
            setSize(380, 110);
            add(result);
            add(nowDays);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }
