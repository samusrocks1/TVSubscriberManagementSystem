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
        mainWindow.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        JLabel welcome = new JLabel("Welcome to the TV and Internet Subscriber Management System. Please use the options below to manage subscriber data.");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        mainWindow.add(welcome, c);
        JButton addSubscriber = new JButton("Add new customer");
        addSubscriber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSubscriber.subscriberWindow();
            }
        });
        JButton viewSubscriber = new JButton("View/Edit Subscriber");
        viewSubscriber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditSubscriber.searchSubscriber();
            }
        });
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        mainWindow.add(addSubscriber, c);
        c.gridx = 1;
        mainWindow.add(viewSubscriber, c);
        mainWindow.setBounds(0, 0, 750, 500);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
