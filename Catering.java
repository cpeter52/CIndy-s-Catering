import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
//import java.lang.Object;
//import java.text.NumberFormat;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.Math;


public class Catering extends Application{
	
	@Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
		GridPane mainPane = new GridPane();	//Position mainPane for center
		mainPane.setAlignment(Pos.CENTER);	//Set spaces between controls
		mainPane.setVgap(20);				//Vertical spacing to 20
		mainPane.setHgap(10); 				//Horizontal spacing to 10
		
		TextField cusName = new TextField();      //Customer Name
		TextField cusNum = new TextField();       //Customer Number
		TextField cusGuests = new TextField();    //Number of Guests
		cusName.setAlignment(Pos.BOTTOM_RIGHT);
		cusNum.setAlignment(Pos.BOTTOM_RIGHT);
		cusGuests.setAlignment(Pos.BOTTOM_RIGHT);
		Label lbName = new Label("Enter Your Name");
		Label lbNum = new Label("Your Phone Number");
		Label lbGuests = new Label("Number of Guests Invited");
		mainPane.add(lbName, 0 , 0);
		mainPane.add(cusName, 1 , 0);
		mainPane.add(lbNum, 0 , 1); 
		mainPane.add(cusNum, 1 , 1);
		mainPane.add(lbGuests, 0 , 2);
		mainPane.add(cusGuests, 1 , 2);
		
		Font ckFont = Font.font("Arial", FontWeight.BOLD, 16);   //Set Font
		
		//Drop-Down w/ 4 Entrées--------------------------------------------------------------------------
		ComboBox <String> cbEntrees = new ComboBox <> ();    
        cbEntrees.setEditable(true);
        cbEntrees.setPromptText("Choose an Entrée");
        cbEntrees.getItems().addAll(
        		"Grilled Chicken",
        		"Steak and Potatoes",
        		"Honey Glazed Ham",
                "Vegan Spaghetti"
        		);
        cbEntrees.setVisibleRowCount(4);
        TextField tfEntree = new TextField("Chosen Entree: ");
        tfEntree.setPrefWidth(500);
        tfEntree.setFont(ckFont);
        mainPane.add(cbEntrees, 0, 4); 
        mainPane.add(tfEntree, 5, 4);
        
        cbEntrees.setOnAction(e -> { 
        	tfEntree.setText("Chosen Entree: " + cbEntrees.getValue());     
        	
        });
        
        
      //Choose Side Dishes--------------------------------------------------------------------------------
		Button btChoose = new Button("Choose at Least 2 Sides");       
		btChoose.setTextFill(Color.BLUE);
		TextField tfChoice = new TextField("Chosen Sides: ");
		tfChoice.setPrefWidth(200);
		tfChoice.setFont(ckFont);
		
		CheckBox ckBeansNRice = new CheckBox(" Red Beans and Rice");
		ckBeansNRice.setTextFill(Color.BROWN);
		ckBeansNRice.setFont(ckFont);

        CheckBox ckVeggies = new CheckBox(" Grilled Veggies");
        ckVeggies.setTextFill(Color.GREEN);
        ckVeggies.setFont(ckFont);
        
        CheckBox ckSalad= new CheckBox(" Ceasar Salad");
        ckSalad.setTextFill(Color.ORANGE);
        ckSalad.setFont(ckFont); 
        
        CheckBox ckQuinoa = new CheckBox(" Quinoa");
        ckQuinoa.setTextFill(Color.GREY);
        ckQuinoa.setFont(ckFont);

        mainPane.add(btChoose, 0, 6);      
        mainPane.add(ckBeansNRice, 1 , 6);        
        mainPane.add(ckVeggies, 2 , 6);        
        mainPane.add(ckSalad, 3, 6);
        mainPane.add(ckQuinoa, 4, 6);
        mainPane.add(tfChoice, 5, 6);
        
        
        btChoose.setOnAction(e -> {    
            // Java code to execute on event fired to test check boxes 
            String ckResult = "Sides Chosen are ";
            int count = 0;
           
            if(ckBeansNRice.isSelected())
            {
                 ckResult = ckResult + " Red Beans and Rice";
            		count++;
            }
            if(ckVeggies.isSelected())
            {
                 ckResult = ckResult + " Grilled Veggies";
            		count++;
            }
            if(ckSalad.isSelected())
            {
                 ckResult = ckResult + " Ceasar Salad"; 
            		count++;
            }
            if(ckQuinoa.isSelected()){
            	ckResult = ckResult + " Quinoa";
            }
            if(count < 3 )	
            {
            	tfChoice.setText(ckResult);
            }
            else
            {
            	ckBeansNRice.setSelected(false);
            	ckVeggies.setSelected(false);
            	ckSalad.setSelected(false);
            	ckQuinoa.setSelected(false);
            	tfChoice.setText("none");
            }
            });
        
        
        //Radio Buttons---------------------------------------------------------------------------------------
        RadioButton rbCheeseCake = new RadioButton("Cheescake");
        rbCheeseCake.setTextFill(Color.NAVY);
        rbCheeseCake.setFont(ckFont);
        
        RadioButton rbCookie = new RadioButton("Cookie");
        rbCookie.setTextFill(Color.MAGENTA);
        rbCookie.setFont(ckFont);
        
        RadioButton rbFruit = new RadioButton("Fruit");
        rbFruit.setTextFill(Color.BLUE);
        rbFruit.setFont(ckFont);
        
        RadioButton rbCake = new RadioButton("Red Velvet Cake");
        rbCake .setTextFill(Color.CYAN);
        rbCake .setFont(ckFont);

        ToggleGroup rbGroup = new ToggleGroup();
        
        rbCheeseCake.setToggleGroup(rbGroup);
        rbCookie.setToggleGroup(rbGroup);
        rbFruit.setToggleGroup(rbGroup);
        rbCake.setToggleGroup(rbGroup);

        Button btFavorite = new Button("Choose Desert");
        btFavorite.setTextFill(Color.BLUE);

        TextField tfChoice3 = new TextField("Chosen Desert: ");
        tfChoice3.setFont(ckFont);
        tfChoice3.setPrefWidth(250);
        mainPane.add(btFavorite, 0, 7);
        mainPane.add(rbCheeseCake, 1 , 7);        
        mainPane.add(rbCookie, 2 , 7);        
        mainPane.add(rbFruit, 3 , 7);        
        mainPane.add(rbCake, 4, 7);              
        mainPane.add(tfChoice3, 5, 7);

        btFavorite.setOnAction(e -> {         
            // Java code to execute when the event is fired         
            // Code to evaluate Radio Buttons
            String rbResult = "Desert chosen is ";
            
            if(rbCheeseCake.isSelected())
            {
               rbResult = rbResult + "Cheesecake";
            }
            if (rbCookie.isSelected())
            {
               rbResult = rbResult + "Cookie";
            }
            if (rbFruit.isSelected())
            {
               rbResult = rbResult + "Assorted Fruit";
            } 
            if (rbCake.isSelected())
            {
               rbResult = rbResult + "Red Velvet Cake";
            }
            else
            {
            	rbResult= "none"; 
            	tfChoice3.setText(rbResult);
            }
            
            tfChoice3.setText(rbResult);
            
           });
        
        //Calculate Cost and set numeric limit
        TextField tfTotal = new TextField();
		tfTotal.setEditable(false);
		tfTotal.setAlignment(Pos.BOTTOM_RIGHT);
		Label lbTotal = new Label("Total Amount ($35 Per Guest)");
		Button btCalc = new Button("Calculate Cost");
		mainPane.add(tfTotal, 0 , 8);
		mainPane.add(btCalc, 1 , 8);
		
		btCalc.setOnAction(e ->{
			try {
				double check = Double.parseDouble(cusGuests.getText()); 
				if (check ==(int)check){
					double total = 35.00 * check; 
					tfTotal.setText(Double.toString(total));
			}} catch (NumberFormatException nfe){
				int check = 0; 
				double total = 35.00 * check;
				tfTotal.setText(Double.toString(total));
			}
			
			//Write to file------------------------------------------------------------------------------------
			try {
				FileWriter fw = new FileWriter("C:/Users/Chris/Desktop/event.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(cusName.getText());
		        bw.newLine();
		        bw.write(cusNum.getText());
		        bw.newLine();
		        bw.write(cusGuests.getText());
		        bw.newLine();
		        bw.write(tfEntree.getText());
		        bw.newLine();
		        bw.write(tfChoice.getText());
		        bw.newLine();
		        bw.write(tfChoice3.getText());
		        bw.newLine();
		        bw.newLine();
		        bw.close();
		    } catch (IOException e1) 
	    	{
		        e1.printStackTrace();
		    }
	  
		});
				
        Scene ckScene = new Scene(mainPane, 1400, 600);
        
        primaryStage.setTitle("Cindy's Catering");
        primaryStage.setScene(ckScene);
        primaryStage.show();
	}
	
	public static void main(String[] args) { 
        launch(args);
	}
}
