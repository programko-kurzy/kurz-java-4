
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PizzaCalculator extends JFrame implements ActionListener {

    private PizzaInfo pizzaInfo = new PizzaInfo();

    JTextArea textArea;
    JTextField priceField;
    JComboBox<Pizza> pizzaComboBox;
    JTextField nameField;
    JLabel priceLabel;
    JButton calcButton;
    JButton clearButton;
    JButton orderButton;
    JCheckBox catchupCheckBox;
    JCheckBox garlicCheckBox;

    public PizzaCalculator(){
        setTitle("Pizza orders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 280));
        setLayout(new GridBagLayout());                
        createComponents();
        pack();
        setVisible(true);
    }

    private void createComponents(){
        calcButton = new JButton("Kalkulacia");
        calcButton.addActionListener(this);
        GridBagConstraints calcConstr = new GridBagConstraints();
        calcConstr.gridx = 0;
        calcConstr.gridy = 0;
        // calcConstr.insets = new Insets(10, 20, 0, 0);
        // calcConstr.fill = GridBagConstraints.HORIZONTAL;
        // calcConstr.weightx = 0.5;
        add(calcButton, calcConstr);        

        clearButton = new JButton("Zmazat");
        clearButton.addActionListener(this);
        GridBagConstraints clearConstr = new GridBagConstraints();
        clearConstr.gridx = 1;
        clearConstr.gridy = 0;     
        // clearConstr.fill = GridBagConstraints.HORIZONTAL;
        // clearConstr.insets = new Insets(10, 0, 0, 0);
        // clearConstr.weightx = 0.5;
        add(clearButton, clearConstr);

        orderButton = new JButton("Objednat");
        orderButton.addActionListener(this);
        GridBagConstraints orderConstr = new GridBagConstraints();
        orderConstr.gridx = 2;
        orderConstr.gridy = 0;        
        // orderConstr.fill = GridBagConstraints.HORIZONTAL;
        // orderConstr.weightx = 0.5;
        // orderConstr.insets = new Insets(10, 0, 0, 20);        
        add(orderButton, orderConstr);

        JLabel nameLabel = new JLabel("Tvoje meno: ");
        GridBagConstraints nameLabelConstr = new GridBagConstraints();
        nameLabelConstr.gridx = 0;
        nameLabelConstr.gridy = 1;
        // nameLabelConstr.anchor = GridBagConstraints.EAST;        
        // nameLabelConstr.insets = new Insets(10, 0, 10, 10);
        add(nameLabel, nameLabelConstr);

        nameField = new JTextField(20);
        GridBagConstraints nameFieldConstr = new GridBagConstraints();
        nameFieldConstr.gridx = 1;
        nameFieldConstr.gridy = 1;
        nameFieldConstr.gridwidth = 2;
        // nameFieldConstr.weightx = 0.5;
        // nameFieldConstr.fill = GridBagConstraints.HORIZONTAL;
        // nameFieldConstr.insets = new Insets(10, 0, 10, 20);
        add(nameField, nameFieldConstr);

        textArea = new JTextArea();
        GridBagConstraints textAreaConstr = new GridBagConstraints();
        textArea.setEnabled(false);  //ci je text area editovatelna
        textArea.setDisabledTextColor(Color.BLACK);  //nastavenie farby textu needitovatelnej text arey
        textArea.setLineWrap(true); //nastavi zalomenie textu na konci riadku
        textAreaConstr.gridx = 0;
        textAreaConstr.gridy = 2;
        textAreaConstr.gridwidth = 2;
        textAreaConstr.gridheight = 2;        
        // textAreaConstr.weighty = 1;                               
        // textAreaConstr.fill = GridBagConstraints.BOTH;
        // textAreaConstr.insets = new Insets(0, 20, 0, 20);        
        add(textArea, textAreaConstr);

        priceLabel = new JLabel("Cena: ");
        GridBagConstraints priceLabelConstr = new GridBagConstraints();
        priceLabelConstr.gridx = 2;
        priceLabelConstr.gridy = 2;
        // priceLabelConstr.anchor = GridBagConstraints.SOUTHWEST;        
        // priceLabelConstr.insets = new Insets(0, 10, 10, 20);
        add(priceLabel, priceLabelConstr);

        priceField = new JTextField(5);
        GridBagConstraints priceFieldConstr = new GridBagConstraints();
        priceFieldConstr.gridx = 2;
        priceFieldConstr.gridy = 3;
        // priceFieldConstr.anchor = GridBagConstraints.NORTHWEST;        
        // priceFieldConstr.insets = new Insets(0, 10, 0, 20);
        add(priceField, priceFieldConstr);

        pizzaComboBox = new JComboBox<>(Pizza.values());
        pizzaComboBox.insertItemAt(null, 0);
        pizzaComboBox.setSelectedIndex(0);        
        pizzaComboBox.addActionListener(this);        
        GridBagConstraints pizzaConstr = new GridBagConstraints();
        pizzaConstr.gridx = 0;
        pizzaConstr.gridy = 4;
        pizzaConstr.gridwidth = 2;
        pizzaConstr.gridheight = 2;
        // pizzaConstr.insets = new Insets(20, 20, 20, 20);
        // pizzaConstr.fill = GridBagConstraints.BOTH;
        add(pizzaComboBox, pizzaConstr);

        garlicCheckBox = new JCheckBox("cesnak");
        GridBagConstraints garlicConstr = new GridBagConstraints();
        garlicConstr.gridx = 2;
        garlicConstr.gridy = 4;      
        // garlicConstr.anchor = GridBagConstraints.WEST;
        // garlicConstr.insets = new Insets(10, 20, 0, 0); 
        add(garlicCheckBox, garlicConstr);

        catchupCheckBox = new JCheckBox("kecup");
        GridBagConstraints catchupConstr = new GridBagConstraints();
        catchupConstr.gridx = 2;
        catchupConstr.gridy = 5;        
        // catchupConstr.anchor = GridBagConstraints.WEST;
        // catchupConstr.insets = new Insets(0, 20, 10, 0);  
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

        if (actionSource.equals(pizzaComboBox)){
            //TODO: zavolajte predpripravenu funkciu, ktora zareaguje zmenu na combo boxe
        }
        if (actionSource.equals(clearButton)){
            //TODO: zavolajte predpripravenu funkciu, ktora vycisti formular
        } 

        // TODO: v pripade, ze nastala udalost stlacenie buttonu na kalkulaciu, zavolajte funkciu, ktora na to zareaguje

        // TODO: v pripade, ze nastala udalost stlacenie buttonu na objednavku, zavolajte funkciu, ktora na to zareaguje
        

    }

    /**
     * pri zmene comboboxu nastavi popis v text area podla aktualnej hodnoty combo boxu
     */
    private void processComboBoxUpdateAction(){
        Object selectedItem = pizzaComboBox.getSelectedItem(); //ziska aktualne vybranu hodnotu v combo boxe
        //TODO: ziskajte mapu z PizzaInfo, ktora mapuje Pizzu na jej popis a nastavte tento popis ako text do textoveho pola                
    }

    /**
     * vykona kalkulaciu
     */
    private void processCalculateButtonAction(){        
        Double price = 0.00;
        //TODO: podobne ako pre popis Pizze v predoslej funkcii, ziskajte z dalsej mapy v PizzaInfo cenu aktualne vybranej Pizze, 
        //TODO: uvodny riadok v tejto funkcii s nastavenim ceny na 0.00 vymazte
        

        if (garlicCheckBox.isSelected()){
            //TODO ak bol zaskrtnuty cesnak priratajte k cene Pizze cenu cesnaku, ktoru ziskate taktiez z PizzaInfo
        }

        //TODO ak bol zaskrtnuty kecup priratajte k doterajsej cene aj cenu kecupu
        
        //nasleduje zobrazenie ceny s formatom na dve desatinne miesta a znakom euro
        Formatter formatter = new Formatter();
        formatter.format("%.2f€", price);
        priceField.setText(formatter.toString()); 
        formatter.close();       
    }

    /**
     * vycisti formular
     */
    private void processClearButtonAction(){ 
        //nastavi combo box na null hodnotu (ziadna hodnota)       
        pizzaComboBox.setSelectedItem(null);
        //TODO: nastavte prazdny string pre text area 
        //TODO: nastavte prazdny string pre text field urceny pre meno
        //TODO: nastavte prazdny string pre text field s cenou
        garlicCheckBox.setSelected(false);
        //TODO: vycistite checkbox pre kecup

    }

    /**
     * zapise objednavku do suboru
     */
    private void processOrderButtonAction(){
        processCalculateButtonAction(); //pred spracovanim objednavky simulujeme stlacenie tlacidla "Kalkulacia", 
                                        //aby sme spracovali spravnu cenu, pokial tlacidlo nebolo stlacene manualne
        try {
            File orders =  new File("orders.txt");
            FileWriter fw = new FileWriter(orders, true); //true znamena, ze do suboru budeme pridavat riadky, inak by sa subor premazaval
            
            //TODO: nahradte nastavenie nasledujucej premennej "order", tak aby string obsahoval: aktualny cas a datum objednavky ...
            //TODO: ...meno uvedene vo formulari, objednanu pizzu, informaciu, ci bol objednany cesnak a kecup a vyslednu cenu ...
            //TODO: ...kludne si to rozpiste na viac riadkov
            String order = "Not implemented";            
            System.out.println(order);

            fw.append(order + "\n");
            fw.close();        
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}