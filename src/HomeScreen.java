import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    public static void main(String[] args) {
        homeScreen();
    }

    private static void homeScreen() {
        JFrame mainWindow = new JFrame("Home Screen");
        mainWindow.setLayout(new GridLayout(2,1));
        JLabel welcome = new JLabel("Welcome to the TV and Internet Subscriber Management System. Please use the options below to manage subscriber data.");
        mainWindow.add(welcome);
        JButton addSubscriber = new JButton("Add new customer");
        addSubscriber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSubscriber.subscriberWindow();
            }
        });
        mainWindow.add(addSubscriber);
        mainWindow.setBounds(0, 0, 750, 500);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
