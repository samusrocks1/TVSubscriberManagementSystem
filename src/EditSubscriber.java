import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditSubscriber {
    private static ArrayList<Subscriber> subscribers = new ArrayList<>();

    public static void searchSubscriber() {
        subscribers.clear();
        subscribers.addAll(FileRetrieval.readSubscriberFile());
        JFrame searchWindow = new JFrame("Search for subscriber");
        searchWindow.setBounds(25, 25, 400, 600);
        searchWindow.setLayout(new BorderLayout());
        JPanel searchPanel = new JPanel();
        searchWindow.add(searchPanel, BorderLayout.NORTH);
        JLabel searchDescription = new JLabel("Name:");
        searchPanel.add(searchDescription);
        JTextField name = new JTextField(17);
        searchPanel.add(name);
        JButton search = new JButton("Search");
        searchPanel.add(search);
        searchWindow.setVisible(true);
        JPanel results = new JPanel(new GridLayout(subscribers.size(), 2));
        searchWindow.add(results, BorderLayout.CENTER);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = name.getText();
                results.removeAll();
                ArrayList<Subscriber> searchResults = new ArrayList<>();
                for (int x = 0; x < subscribers.size(); x++){
                    if (subscribers.get(x).getFirstName().equalsIgnoreCase(searchName) || subscribers.get(x).getLastName().equalsIgnoreCase(searchName)) {
                        searchResults.add(subscribers.get(x));
                    }
                }
                for (int x = 0; x < searchResults.size(); x++) {
                    JLabel name = new JLabel(searchResults.get(x).getFirstName() + " " + searchResults.get(x).getLastName() + ", ID: " + Integer.toString(searchResults.get(x).getSubscriberID()));
                    results.add(name);
                    JButton view = new JButton("View Subscriber Details");
                    int finalX = searchResults.get(x).getSubscriberID()-1;
                    view.addActionListener(e1 -> viewSubscriber(finalX));
                    results.add(view);
                }
                results.revalidate();
                results.repaint();
            }
        });
    }

    private static void viewSubscriber(int subNumber) {
        JFrame viewSubscriber = new JFrame("Subscriber number: " + subscribers.get(subNumber).getSubscriberID());
        JPanel subPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        viewSubscriber.add(subPane);
        JLabel firstName = new JLabel("First Name: ");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = .25;
        c.gridwidth = 1;
        c.gridheight = 1;
        subPane.add(firstName, c);
        JTextField primaryName = new JTextField(subscribers.get(subNumber).getFirstName());
        primaryName.setEnabled(false);
        c.gridx = 1;
        c.weightx = 1;
        c.gridwidth = 2;
        subPane.add(primaryName, c);
        JLabel lastName = new JLabel("Last Name: ");
        c.gridx = 3;
        c.weightx = .25;
        c.gridwidth = 1;
        subPane.add(lastName, c);
        JTextField surName = new JTextField(subscribers.get(subNumber).getLastName());
        surName.setEnabled(false);
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
        JTextField phoneNum = new JTextField(subscribers.get(subNumber).getPhoneNumber());
        phoneNum.setEnabled(false);
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
        JTextField street = new JTextField(subscribers.get(subNumber).getAddress());
        street.setEnabled(false);
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
        JTextField cityName = new JTextField(subscribers.get(subNumber).getCity());
        cityName.setEnabled(false);
        c.gridx = 1;
        c.weightx = 1;
        subPane.add(cityName, c);
        JLabel state = new JLabel("State: ");
        c.gridx = 2;
        c.weightx = .25;
        subPane.add(state, c);
        JTextField stateName = new JTextField(subscribers.get(subNumber).getState());
        stateName.setEnabled(false);
        c.gridx = 3;
        c.weightx = 1;
        subPane.add(stateName, c);
        JLabel zip = new JLabel("Zip Code: ");
        c.gridx = 4;
        c.weightx = .25;
        subPane.add(zip, c);
        JTextField zipCode = new JTextField(subscribers.get(subNumber).getZipCode());
        zipCode.setEnabled(false);
        c.gridx = 5;
        c.weightx = 1;
        subPane.add(zipCode, c);
        JButton editSubscriber = new JButton("Edit subscriber");
        JButton saveSubscriber = new JButton("Save changes");
        saveSubscriber.setEnabled(false);
        editSubscriber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primaryName.setEnabled(true);
                surName.setEnabled(true);
                phoneNum.setEnabled(true);
                street.setEnabled(true);
                cityName.setEnabled(true);
                stateName.setEnabled(true);
                zipCode.setEnabled(true);
                saveSubscriber.setEnabled(true);
            }
        });
        c.gridx = 0;
        c.gridy = 4;
        subPane.add(editSubscriber, c);
        saveSubscriber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subscribers.get(subNumber).setFirstName(primaryName.getText());
                subscribers.get(subNumber).setLastName(surName.getText());
                subscribers.get(subNumber).setPhoneNumber(phoneNum.getText());
                subscribers.get(subNumber).setAddress(street.getText());
                subscribers.get(subNumber).setCity(cityName.getText());
                subscribers.get(subNumber).setState(stateName.getText());
                subscribers.get(subNumber).setZipCode(zipCode.getText());
                JOptionPane.showMessageDialog(null, "Subscriber information saved successfully");
                viewSubscriber.setVisible(false);
            }
        });
        c.gridx = 1;
        subPane.add(saveSubscriber, c);
        JButton editSubServices = new JButton("Edit Services");
        editSubServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editServices(subNumber);
            }
        });
        c.gridx = 2;
        subPane.add(editSubServices, c);
        viewSubscriber.setBounds(400,25, 550, 200);
        viewSubscriber.setVisible(true);
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileRetrieval.saveSubscriberFile(subscribers);
            }
        });
    }

    public static void editServices(int subscriberNumber) {
        JFrame services = new JFrame("Subscriber number: " + subscriberNumber + 1 + " services.");
        JPanel servicesPane = new JPanel(new GridLayout(3, 2));
        JPanel tvServices = new JPanel(new GridLayout(5, 1));
        JLabel tv = new JLabel("TV Options");
        tvServices.add(tv);
        JRadioButton noTV = new JRadioButton("No TV service");
        noTV.setActionCommand("0");
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
        System.out.println(subscribers.get(subscriberNumber).getTv());
        if (subscribers.get(subscriberNumber).getTv().equals("0")) {
            noTV.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getTv().equals("1")){
            basicTV.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getTv().equals("2")){
            plusTV.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getTv().equals("3")){
            premiumTV.setSelected(true);
        }

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
        internet.add(internetOptions);
        internet.add(noInternet);
        internet.add(basicInternet);
        internet.add(plusInternet);
        internet.add(advancedInternet);
        internet.add(gigabitInternet);
        if (subscribers.get(subscriberNumber).getInternet().equals("0")){
            noInternet.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getInternet().equals("1")){
            basicInternet.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getInternet().equals("2")){
            plusInternet.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getInternet().equals("3")){
            advancedInternet.setSelected(true);
        }
        else if (subscribers.get(subscriberNumber).getInternet().equals("4")){
            gigabitInternet.setSelected(true);
        }

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
        if (subscribers.get(subscriberNumber).isTelephone()){
            yes.setSelected(true);
        }

        JPanel tvPremium = new JPanel(new GridLayout(4, 1));
        JLabel premiumPkgs = new JLabel("Premium TV Packages: ");
        JCheckBox hbo = new JCheckBox("HBO - $14.99");
        JCheckBox cmax = new JCheckBox("Cinemax - $12.99");
        JCheckBox stars = new JCheckBox("Stars - $7.99");
        tvPremium.add(premiumPkgs);
        tvPremium.add(hbo);
        tvPremium.add(cmax);
        tvPremium.add(stars);
        for (int x = 0; x < subscribers.get(subscriberNumber).getPremiumTVPackage().length(); x ++){
            char premium = subscribers.get(subscriberNumber).getPremiumTVPackage().charAt(x);
            if (premium == '1'){
                hbo.setSelected(true);
            }
            else if (premium == '2'){
                cmax.setSelected(true);
            }
            else if (premium == '3'){
                stars.setSelected(true);
            }
        }

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
                subscribers.get(subscriberNumber).setTotalCost(total);
                cost.repaint();
            }
        });
        buttons.add(updateCost);

        JButton addServices = new JButton("Edit subscriber services");
        addServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subscribers.get(subscriberNumber).setTv(tvOptions.getSelection().getActionCommand());
                subscribers.get(subscriberNumber).setInternet(internetSelection.getSelection().getActionCommand());
                subscribers.get(subscriberNumber).setPremiumTVPackage("");
                if (yes.isSelected()) {
                    subscribers.get(subscriberNumber).setTelephone(true);
                }
                else {
                    subscribers.get(subscriberNumber).setTelephone(false);
                }
                if (hbo.isSelected()) {
                    subscribers.get(subscriberNumber).setPremiumTVPackage(subscribers.get(subscriberNumber).getPremiumTVPackage().concat("1"));
                }
                if (cmax.isSelected()){
                    subscribers.get(subscriberNumber).setPremiumTVPackage(subscribers.get(subscriberNumber).getPremiumTVPackage().concat("2"));
                }
                if (stars.isSelected()){
                    subscribers.get(subscriberNumber).setPremiumTVPackage(subscribers.get(subscriberNumber).getPremiumTVPackage().concat("3"));
                }
                FileRetrieval.saveSubscriberFile(subscribers);
                services.setVisible(false);
                JOptionPane.showMessageDialog(null, "Services updated successfully.");
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
