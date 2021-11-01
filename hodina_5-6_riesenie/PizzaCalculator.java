
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PizzaCalculator extends JFrame implements ActionListener {

    JTextArea textArea;
    JTextField priceField;
    JComboBox<MyPizza> pizzaComboBox;
    JTextField nameField;
    JLabel priceLabel;
    JButton calcButton;
    JButton clearButton;
    JButton orderButton;
    JCheckBox catchupCheckBox;
    JCheckBox garlicCheckBox;

    public PizzaCalculator() {
        setTitle("Pizza orders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 280));
        setLayout(new GridBagLayout());
        createComponents();
        pack();
        setVisible(true);
    }

    private void createComponents() {
        calcButton = new JButton("Kalkulacia");
        calcButton.addActionListener(this);
        GridBagConstraints calcConstr = new GridBagConstraints();
        calcConstr.gridx = 0;
        calcConstr.gridy = 0;
        calcConstr.insets = new Insets(10, 20, 0, 0);
        calcConstr.fill = GridBagConstraints.HORIZONTAL;
        calcConstr.weightx = 0.5;
        add(calcButton, calcConstr);

        clearButton = new JButton("Zmazat");
        clearButton.addActionListener(this);
        GridBagConstraints clearConstr = new GridBagConstraints();
        clearConstr.gridx = 1;
        clearConstr.gridy = 0;
        clearConstr.fill = GridBagConstraints.HORIZONTAL;
        clearConstr.insets = new Insets(10, 0, 0, 0);
        clearConstr.weightx = 0.5;
        add(clearButton, clearConstr);

        orderButton = new JButton("Objednat");
        orderButton.addActionListener(this);
        GridBagConstraints orderConstr = new GridBagConstraints();
        orderConstr.gridx = 2;
        orderConstr.gridy = 0;
        orderConstr.fill = GridBagConstraints.HORIZONTAL;
        orderConstr.weightx = 0.5;
        orderConstr.insets = new Insets(10, 0, 0, 20);
        add(orderButton, orderConstr);

        JLabel nameLabel = new JLabel("Tvoje meno: ");
        GridBagConstraints nameLabelConstr = new GridBagConstraints();
        nameLabelConstr.gridx = 0;
        nameLabelConstr.gridy = 1;
        nameLabelConstr.anchor = GridBagConstraints.EAST;
        nameLabelConstr.insets = new Insets(10, 0, 10, 10);
        add(nameLabel, nameLabelConstr);

        nameField = new JTextField(20);
        GridBagConstraints nameFieldConstr = new GridBagConstraints();
        nameFieldConstr.gridx = 1;
        nameFieldConstr.gridy = 1;
        nameFieldConstr.gridwidth = 2;
        nameFieldConstr.weightx = 0.5;
        nameFieldConstr.fill = GridBagConstraints.HORIZONTAL;
        nameFieldConstr.insets = new Insets(10, 0, 10, 20);
        add(nameField, nameFieldConstr);

        textArea = new JTextArea();
        GridBagConstraints textAreaConstr = new GridBagConstraints();
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        textArea.setLineWrap(true);
        textAreaConstr.gridx = 0;
        textAreaConstr.gridy = 2;
        textAreaConstr.gridwidth = 2;
        textAreaConstr.gridheight = 2;
        textAreaConstr.weighty = 1;
        textAreaConstr.fill = GridBagConstraints.BOTH;
        textAreaConstr.insets = new Insets(0, 20, 0, 20);
        add(textArea, textAreaConstr);

        priceLabel = new JLabel("Cena: ");
        GridBagConstraints priceLabelConstr = new GridBagConstraints();
        priceLabelConstr.gridx = 2;
        priceLabelConstr.gridy = 2;
        priceLabelConstr.anchor = GridBagConstraints.SOUTHWEST;
        priceLabelConstr.insets = new Insets(0, 10, 10, 20);
        add(priceLabel, priceLabelConstr);

        priceField = new JTextField(5);
        GridBagConstraints priceFieldConstr = new GridBagConstraints();
        priceFieldConstr.gridx = 2;
        priceFieldConstr.gridy = 3;
        priceFieldConstr.anchor = GridBagConstraints.NORTHWEST;
        priceFieldConstr.insets = new Insets(0, 10, 0, 20);
        add(priceField, priceFieldConstr);

        MyPizza gazdovska = new MyPizza("Gazdovska", 3.80);
        gazdovska.setDescription("Syr, paradajkovy zaklad, klobasa, vajce, salama, cibula");
        MyPizza hawai = new MyPizza("Hawai", 3.70);
        hawai.setDescription("Syr, paradajkovy zaklad, ananas, sunka");
        MyPizza provinciale = new MyPizza("Provinciale", 3.90);
        provinciale.setDescription("Syr, paradajkovy zaklad, kukurica, slanina, baranie rohy, cibula");
        MyPizza sampinonova = new MyPizza("Sampinonova", 4.10);
        sampinonova.setDescription("Syr, paradajkovy zaklad, sunka, sampinony");

        pizzaComboBox = new JComboBox<>(new MyPizza[] { gazdovska, hawai, provinciale, sampinonova });

        pizzaComboBox.insertItemAt(null, 0);
        pizzaComboBox.setSelectedIndex(0);
        GridBagConstraints pizzaConstr = new GridBagConstraints();
        pizzaConstr.gridx = 0;
        pizzaConstr.gridy = 4;
        pizzaConstr.gridwidth = 2;
        pizzaConstr.gridheight = 2;
        pizzaConstr.insets = new Insets(20, 20, 20, 20);
        pizzaConstr.fill = GridBagConstraints.BOTH;
        pizzaComboBox.addActionListener(this);
        add(pizzaComboBox, pizzaConstr);

        garlicCheckBox = new JCheckBox("cesnak " + MyPizza.GARLIC_PRICE);
        GridBagConstraints garlicConstr = new GridBagConstraints();
        garlicConstr.gridx = 2;
        garlicConstr.gridy = 4;
        garlicConstr.anchor = GridBagConstraints.WEST;
        garlicConstr.insets = new Insets(10, 20, 0, 0);
        add(garlicCheckBox, garlicConstr);

        catchupCheckBox = new JCheckBox("kecup " + MyPizza.CATCHUP_PRICE);
        GridBagConstraints catchupConstr = new GridBagConstraints();
        catchupConstr.gridx = 2;
        catchupConstr.gridy = 5;
        catchupConstr.anchor = GridBagConstraints.WEST;
        catchupConstr.insets = new Insets(0, 20, 10, 0);
        add(catchupCheckBox, catchupConstr);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PizzaCalculator();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource = e.getSource();

        if (actionSource.equals(pizzaComboBox)) {
            processComboBoxUpdateAction();
        }
        if (actionSource.equals(calcButton)) {
            processCalculateButtonAction();
        }
        if (actionSource.equals(clearButton)) {
            processClearButtonAction();
        }
        if (actionSource.equals(orderButton)) {
            processOrderButtonAction();
        }

    }

    private void processComboBoxUpdateAction() {
        Object selectedItem = pizzaComboBox.getSelectedItem();
        MyPizza selectedPizza = (MyPizza) selectedItem;
        if (selectedPizza != null){
            textArea.setText(selectedPizza.getDescription());
        } else {
            textArea.setText("");
        }
    }

    private void processCalculateButtonAction() {
        Object selectedItem = pizzaComboBox.getSelectedItem();
        MyPizza selectedPizza = (MyPizza) selectedItem;
        if (selectedPizza != null) {
            Double price = selectedPizza.getPrice();

            if (garlicCheckBox.isSelected()) {
                price += MyPizza.GARLIC_PRICE;
            }

            if (catchupCheckBox.isSelected()) {
                price += MyPizza.CATCHUP_PRICE;
            }

            Formatter formatter = new Formatter();
            formatter.format("%.2f€", price);
            priceField.setText(formatter.toString());
            formatter.close();
        }
    }

    private void processClearButtonAction() {
        priceField.setText("");
        textArea.setText("");
        pizzaComboBox.setSelectedItem(null);
        garlicCheckBox.setSelected(false);
        catchupCheckBox.setSelected(false);
    }

    private void processOrderButtonAction() {
        processCalculateButtonAction();
        try {
            File orders = new File("orders.txt");
            FileWriter fw = new FileWriter(orders, true);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
            String order = formatter.format(LocalDateTime.now()) + " - " + nameField.getText() + " - "
                    + pizzaComboBox.getSelectedItem() + " (cesnak=" + garlicCheckBox.isSelected() + ", kecup="
                    + catchupCheckBox.isSelected() + ") " + priceField.getText();
            System.out.println(order);
            fw.append(order + "\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}