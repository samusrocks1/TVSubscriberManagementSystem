import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddSubscriber {
    static ArrayList<Subscriber> subscriber = new ArrayList<>();

    public static void subscriberWindow() {
        subscriber.addAll(FileRetrieval.readSubscriberFile());
        JFrame subWindow = new JFrame("Add new subscriber");
        JPanel subPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        subWindow.add(subPane);
        JLabel firstName = new JLabel("First Name: ");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = .25;
        c.gridwidth = 1;
        c.gridheight = 1;
        subPane.add(firstName, c);
        JTextField primaryName = new JTextField();
        c.gridx = 1;
        c.weightx = 1;
        c.gridwidth = 2;
        subPane.add(primaryName, c);
        JLabel lastName = new JLabel("Last Name: ");
        c.gridx = 3;
        c.weightx = .25;
        c.gridwidth = 1;
        subPane.add(lastName, c);
        JTextField surName = new JTextField();
        c.gridx = 4;
        c.weightx = 1;
        c.gridwidth = 2;
        subPane.add(surName, c);

        JLabel phone = new JLabel("Phone Number: ");
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = .25;
        c.gridwidth = 1;
        subPane.add(phone, c);
        JTextField phoneNum = new JTextField();
        c.gridx = 1;
        c.gridwidth = 5;
        c.weightx = 1;
        subPane.add(phoneNum, c);
        JLabel address = new JLabel("Street Address: ");
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = .25;
        c.gridwidth = 1;
        subPane.add(address, c);
        JTextField street = new JTextField();
        c.gridx = 1;
        c.gridwidth = 5;
        c.weightx = 1;
        subPane.add(street, c);
        JLabel city = new JLabel("City: ");
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = .25;
        c.gridwidth = 1;
        subPane.add(city, c);
        JTextField cityName = new JTextField();
        c.gridx = 1;
        c.weightx = 1;
        subPane.add(cityName, c);
        JLabel state = new JLabel("State: ");
        c.gridx = 2;
        c.weightx = .25;
        subPane.add(state, c);
        JTextField stateName = new JTextField();
        c.gridx = 3;
        c.weightx = 1;
        subPane.add(stateName, c);
        JLabel zip = new JLabel("Zip Code: ");
        c.gridx = 4;
        c.weightx = .25;
        subPane.add(zip, c);
        JTextField zipCode = new JTextField();
        c.gridx = 5;
        c.weightx = 1;
        subPane.add(zipCode, c);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = subscriber.size();
                subscriber.add(new Subscriber(primaryName.getText(), surName.getText(), phone.getText(), street.getText(), cityName.getText(), stateName.getText(), zipCode.getText(), subscriber.size() + 1));
                addServices(x);
                subWindow.setVisible(false);
            }
        });
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        subPane.add(submit, c);
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primaryName.setText("");
                surName.setText("");
                phoneNum.setText("");
                street.setText("");
                stateName.setText("");
                cityName.setText("");
                zipCode.setText("");
            }
        });
        c.gridx = 2;
        subPane.add(reset, c);
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subWindow.setVisible(false);
            }
        });
        c.gridx = 4;
        subPane.add(cancel, c);
        int x = 550;
        int y = 200;
        subWindow.setBounds(25, 25, x, y);
        subWindow.setVisible(true);
        subWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void addServices(int subscriberNumber) {
        JFrame services = new JFrame("Add subscriber services.");
        JPanel servicesPane = new JPanel(new GridLayout(3, 2));
        JPanel tvServices = new JPanel(new GridLayout(5, 1));
        JLabel tv = new JLabel("TV Options");
        tvServices.add(tv);
        JRadioButton noTV = new JRadioButton("No TV service");
        noTV.setActionCommand("0");
        noTV.setSelected(true);
        JRadioButton basicTV = new JRadioButton("Basic TV - $39.99");
        basicTV.setActionCommand("1");
        JRadioButton plusTV = new JRadioButton("TV Plus - $59.99");
        plusTV.setActionCommand("2");
        JRadioButton premiumTV = new JRadioButton("Premium TV - $79.99");
        premiumTV.setActionCommand("3");
        ButtonGroup tvOptions = new ButtonGroup();
        tvOptions.add(noTV);
        tvOptions.add(basicTV);
        tvOptions.add(plusTV);
        tvOptions.add(premiumTV);
        tvServices.add(noTV);
        tvServices.add(basicTV);
        tvServices.add(plusTV);
        tvServices.add(premiumTV);

        JPanel internet = new JPanel(new GridLayout(6, 1));
        JLabel internetOptions = new JLabel("Internet Options");
        JRadioButton noInternet = new JRadioButton("No internet");
        noInternet.setActionCommand("0");
        JRadioButton basicInternet = new JRadioButton("10 Mbps - $19.99");
        basicInternet.setActionCommand("1");
        JRadioButton plusInternet = new JRadioButton("100 Mbps - $29.99");
        plusInternet.setActionCommand("2");
        JRadioButton advancedInternet = new JRadioButton("500 Mbps - $49.99");
        advancedInternet.setActionCommand("3");
        JRadioButton gigabitInternet = new JRadioButton("1 Gbps - $79.99");
        gigabitInternet.setActionCommand("4");
        ButtonGroup internetSelection = new ButtonGroup();
        internetSelection.add(noInternet);
        internetSelection.add(basicInternet);
        internetSelection.add(plusInternet);
        internetSelection.add(advancedInternet);
        internetSelection.add(gigabitInternet);
        noInternet.setSelected(true);
        internet.add(internetOptions);
        internet.add(noInternet);
        internet.add(basicInternet);
        internet.add(plusInternet);
        internet.add(advancedInternet);
        internet.add(gigabitInternet);

        JPanel phone = new JPanel(new GridLayout(3, 1));
        JLabel phoneLabel = new JLabel("Phone: ");
        JRadioButton yes = new JRadioButton("Yes");
        JRadioButton no = new JRadioButton("No", true);
        ButtonGroup phoneOption = new ButtonGroup();
        phoneOption.add(yes);
        phoneOption.add(no);
        phone.add(phoneLabel);
        phone.add(no);
        phone.add(yes);

        JPanel tvPremium = new JPanel(new GridLayout(4, 1));
        JLabel premiumPkgs = new JLabel("Premium TV Packages: ");
        JCheckBox hbo = new JCheckBox("HBO - $14.99");
        JCheckBox cmax = new JCheckBox("Cinemax - $12.99");
        JCheckBox stars = new JCheckBox("Stars - $7.99");
        tvPremium.add(premiumPkgs);
        tvPremium.add(hbo);
        tvPremium.add(cmax);
        tvPremium.add(stars);

        JPanel cost = new JPanel(new GridLayout(4, 1));
        double sub = 0.00;
        double pkgDiscount = 0.00;
        double premiumDisc = 0.00;
        double finalCost = 0.00;
        JLabel subTotal = new JLabel("Subtotal: $" + String.format("%.2f", sub));
        JLabel packageDiscount = new JLabel("Discount from bundling services: $" + String.format("%.2f", pkgDiscount));
        JLabel premiumDiscount = new JLabel("Discount from premium services: $" + String.format("%.2f", premiumDisc));
        JLabel totalCost = new JLabel("Total: $" + String.format("%.2f", finalCost));
        cost.add(subTotal);
        cost.add(packageDiscount);
        cost.add(premiumDiscount);
        cost.add(totalCost);

        JPanel buttons = new JPanel();
        JButton updateCost = new JButton("Update cost");
        updateCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean tvService = false;
                boolean internetService = false;
                boolean phoneService = false;
                double discount = 0.00;
                double subtotal = 0.00;
                double total = 0.00;
                if (tvOptions.getSelection().getActionCommand().equals("0")) {

                }
                else if (tvOptions.getSelection().getActionCommand().equals("1")){
                    subtotal = subtotal + 39.99;
                    tvService = true;
                }
                else if (tvOptions.getSelection().getActionCommand().equals("2")) {
                    subtotal += 59.99;
                    tvService = true;
                }
                else if (tvOptions.getSelection().getActionCommand().equals("3")) {
                    subtotal += 79.99;
                    tvService = true;
                }
                if (internetSelection.getSelection().getActionCommand().equals("0")){

                }
                else if (internetSelection.getSelection().getActionCommand().equals("1")) {
                    subtotal += 19.99;
                    internetService = true;
                }
                else if (internetSelection.getSelection().getActionCommand().equals("2")){
                    subtotal += 29.99;
                    internetService = true;
                }
                else if (internetSelection.getSelection().getActionCommand().equals("3")) {
                    subtotal += 49.99;
                    internetService = true;
                }
                else if (internetSelection.getSelection().getActionCommand().equals("4")) {
                    subtotal += 79.99;
                    internetService = true;
                }
                if (yes.isSelected()){
                    subtotal += 14.99;
                    phoneService = true;

                }
                if (tvService && internetService && phoneService){
                    discount += 10.00;
                }
                else if (tvService && internetService){
                    discount += 5.00;
                }
                if (internetSelection.getSelection().getActionCommand().equals("4") && tvOptions.getSelection().getActionCommand().equals("3")){
                    discount += 30.00;
                }
                else if (internetSelection.getSelection().getActionCommand().equals("3") && tvOptions.getSelection().getActionCommand().equals("2")) {
                    discount += 20.00;
                }
                int premiumChannels = 0;
                double premiumdiscount = 0.00;
                boolean premiumChan = false;
                if (hbo.isSelected()) {
                    subtotal += 14.99;
                    premiumChannels ++;
                    premiumChan = true;
                }
                if (cmax.isSelected()) {
                    subtotal += 12.99;
                    premiumChannels ++;
                    premiumChan = true;
                }
                if (stars.isSelected()) {
                    subtotal += 7.99;
                    premiumChannels ++;
                    premiumChan = true;
                }
                if (premiumChannels == 3){
                    premiumdiscount = 15.00;
                }
                if (tvOptions.getSelection().getActionCommand().equals("3") && premiumChan) {
                    premiumdiscount += 5.00;
                }
                subTotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
                packageDiscount.setText("Package discount: $" + String.format("%.2f", discount));
                premiumDiscount.setText("Premium channel discount: $" + String.format("%.2f", premiumdiscount));
                total = subtotal - discount - premiumdiscount;
                totalCost.setText("Total: $" + String.format("%.2f", total));
                subscriber.get(subscriberNumber).setTotalCost(total);
                cost.repaint();
            }
        });
        buttons.add(updateCost);

        JButton addServices = new JButton("Add subscriber services");
        addServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subscriber.get(subscriberNumber).setTv(tvOptions.getSelection().getActionCommand());
                subscriber.get(subscriberNumber).setInternet(internetSelection.getSelection().getActionCommand());
                subscriber.get(subscriberNumber).setPremiumTVPackage("");
                if (yes.isSelected()) {
                    subscriber.get(subscriberNumber).setTelephone(true);
                }
                else {
                    subscriber.get(subscriberNumber).setTelephone(false);
                }
                if (hbo.isSelected()) {
                    subscriber.get(subscriberNumber).setPremiumTVPackage(subscriber.get(subscriberNumber).getPremiumTVPackage().concat("1"));
                }
                if (cmax.isSelected()){
                    subscriber.get(subscriberNumber).setPremiumTVPackage(subscriber.get(subscriberNumber).getPremiumTVPackage().concat("2"));
                }
                if (stars.isSelected()){
                    subscriber.get(subscriberNumber).setPremiumTVPackage(subscriber.get(subscriberNumber).getPremiumTVPackage().concat("3"));
                }
                FileRetrieval.saveSubscriberFile(subscriber);
                services.setVisible(false);
            }
        });
        buttons.add(addServices);

        servicesPane.add(tvServices);
        servicesPane.add(internet);
        servicesPane.add(phone);
        servicesPane.add(tvPremium);
        servicesPane.add(cost);
        servicesPane.add(buttons);
        services.add(servicesPane);
        services.setBounds(25,25, 500, 500);
        services.setVisible(true);
    }
}
