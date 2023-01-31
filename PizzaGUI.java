
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class PizzaGUI extends JFrame implements ActionListener{
    
    public JLabel infoLable=new JLabel("Please fill out the following fields to create your pizza ");
    public JRadioButton smallBtn=new JRadioButton("small pizza");
    public JRadioButton medBtn= new JRadioButton("medium pizza",true);
    public JRadioButton largeBtn=new JRadioButton("large pizza");
    public ButtonGroup sizeGroup= new ButtonGroup();
    public JLabel crustLable= new JLabel("crust Type:     ");
    public JRadioButton thinCrustBtn=new JRadioButton("thin crust",true);
    public JRadioButton thickCrustBtn=new JRadioButton("thick crust");
    public ButtonGroup crustGroup= new ButtonGroup();
    public JLabel pepperoniLable=new JLabel("Pepperoni?");
    public JRadioButton addPepperoni= new JRadioButton("With Pepperoni");
    public JRadioButton noPepperoni=new JRadioButton("No Pepperoni",true);
    public ButtonGroup pepperoniGroup = new ButtonGroup();
    public JButton addBtn= new JButton("Add to order");
    public JLabel orderTotalLable= new JLabel("");
    public JLabel bakeTotalLable= new JLabel("");
    public JTextArea listArea= new JTextArea(5,25);
    private Pizza pizza1=null;
    private Order order1=null;
    
    //public JLabel pizzaListLabel= new JLabel("");
    
    

    public static void main(String[] args){
        
        
        new PizzaGUI("Pizza Order");
        
    }
    PizzaGUI(String title){
        try{
            order1= new Order("Muna", "3309854");
        }
        catch(Exception e){
            System.out.println(e.toString());
        } 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p=new JPanel();
        JPanel listPanel=new JPanel(new BorderLayout());
        listArea.setLineWrap(true);
        listArea.setLayout(new BoxLayout(listArea, BoxLayout.Y_AXIS));
        addBtn.addActionListener(this);
        sizeGroup.add(smallBtn);
        sizeGroup.add(medBtn);
        sizeGroup.add(largeBtn);
        p.add(infoLable);
        p.add(smallBtn);
        p.add(medBtn);
        p.add(largeBtn);
        crustGroup.add(thinCrustBtn);
        crustGroup.add(thickCrustBtn);
        p.add(crustLable);
        p.add(thinCrustBtn);
        p.add(thickCrustBtn);
        pepperoniGroup.add(addPepperoni);
        pepperoniGroup.add(noPepperoni);
        p.add(pepperoniLable);
        p.add(addPepperoni);
        p.add(noPepperoni);
        p.add(addBtn);
        p.add(orderTotalLable);
        p.add(bakeTotalLable);
        listPanel.add(new JScrollPane(listArea));
        p.add(listPanel);
        this.getContentPane().add(p);
        this.setSize(350,400);
        
    }
    public void actionPerformed(ActionEvent e){
    
        String pizzaSize;
        if (smallBtn.isSelected()){
            pizzaSize="S";
        }
        else if(medBtn.isSelected()){
            pizzaSize="M";
        }
        else{
            pizzaSize="L";
        }
        String crust;
        if(thinCrustBtn.isSelected()){
            crust="thin";
        }
        else{
            crust="thick";
        }
        boolean pepperoni=addPepperoni.isSelected();
        try{
            pizza1= new Pizza(pizzaSize,crust,pepperoni);
            
        }
        catch(Exception error){
            listArea.setText(error.toString());
        }
        if(pizza1==null){
            listArea.setText(listArea.getText()+ ",can not add this pizza to order");

        }
        else{
            
            listArea.setText("");
            order1.addPizza(pizza1);
            ArrayList<Pizza> pizzaList=order1.getListofPizzas();
            orderTotalLable.setText("Order total Cost: $" + String.format("%.2f",order1.calculateCost()));
            bakeTotalLable.setText("and the time is: "+ order1.calculateBakeTime()+" minutes");
            for(Pizza pizza:pizzaList){
                listArea.append( pizza.getSize()+" pizza,"+pizza.getCrust()+" crust and with pepperoni:"+pizza.getHasPepperoni()+"\n" );
                listArea.append("**************************************\n");
                
            }
            
            
        }
        

       
    }
  
}