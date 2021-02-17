import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class tictactoecontrollers implements Initializable{
    @FXML
    private JFXButton btn1;
    @FXML
    private JFXButton btn2;
    @FXML
    private JFXButton btn3;
    @FXML
    private JFXButton btn4;
    @FXML
    private JFXButton btn5;
    @FXML
    private JFXButton btn6;
    @FXML
    private JFXButton btn7;
    @FXML
    private JFXButton btn8;
    @FXML
    private JFXButton btn9;
    boolean crossturn=true;
    int clicks=0;
    @FXML
    void btnclicked(ActionEvent event) {
    	JFXButton btn=(JFXButton) event.getSource();
    	Font fon=new Font("ChunkFive", 60);
    	String valx="X";
    	String val0="0";
    	if(btn.getText()=="")
    	{
    		if(crossturn==true)
    		{	btn.setFont(fon);
    		btn.setTextFill(Color.RED);
    			btn.setText(valx);
    			clicks++;
    		}
    		else
    		{btn.setFont(fon);
    		btn.setTextFill(Color.BLUE);
    			btn.setText(val0);
    			clicks++;
    		}
    		crossturn=!crossturn;
    	}
    	chkrows(clicks);
    	chkcols(clicks);
    	chkdiag(clicks);
    	
    }
    public void askagain1()
    {   	 Alert al=new Alert(AlertType.CONFIRMATION);
	    	al.setTitle("X_WINS THE GAME");
	    	al.setContentText("Click On Ok To Play Again");
	    	Optional<ButtonType> result = al.showAndWait();
	    	if (result.get() == ButtonType.OK){
	             clicks=0;
	           crossturn=true;	    
	           cleanbuttons();
	    	} else {
	    	    System.exit(0);
	    	}
    }
    public void askagain2()
    {   	 Alert al=new Alert(AlertType.CONFIRMATION);
	    	al.setTitle("0_WINS THE GAME");
	    	al.setContentText("Click On Ok To Play Again");
	    	Optional<ButtonType> result = al.showAndWait();
	    	if (result.get() == ButtonType.OK){
	             clicks=0;
	           crossturn=true;	    
	           cleanbuttons();
	    	} else {
	    	    System.exit(0);
	    	}
    }
    public void askagain3()
    {   	 Alert al=new Alert(AlertType.CONFIRMATION);
	    	al.setTitle("MATCH_TIES");
	    	al.setContentText("Click On Ok To Play Again");
	    	Optional<ButtonType> result = al.showAndWait();
	    	if (result.get() == ButtonType.OK){
	             clicks=0;
	           crossturn=true;	    
	           cleanbuttons();
	    	} else {
	    	    System.exit(0);
	    	}
    }
    public void cleanbuttons()
    {  	btn1.setText("");
    	btn2.setText("");
    	btn3.setText("");
    	btn4.setText("");
    	btn5.setText("");
    	btn6.setText("");
    	btn7.setText("");
    	btn8.setText("");
    	btn9.setText("");	
    }
    
    public void chkdiag(int clicks)
    {
    	if(btn1.getText()!=""&&btn5.getText()!=""&&btn9.getText()!="")
    	{
    		if(btn1.getText()==btn5.getText()&&btn5.getText()==btn9.getText())
        	{	if(btn1.getText()=="X")
                askagain1();
        		else
        		askagain2();
        	}
    	}
    	else if(btn3.getText()!=""&&btn5.getText()!=""&&btn7.getText()!="")
    	{
    		if(btn3.getText()==btn5.getText()&&btn5.getText()==btn7.getText())
        	{	if(btn3.getText()=="X")
        		 askagain1();
        		else
        		askagain2();
        	}
    	}
    	if(clicks==9)
    	askagain3();
    }
    public void chkrows(int clicks)
    {
    	if(btn1.getText()!=""&&btn2.getText()!=""&&btn3.getText()!="")
    	{
    	if(btn1.getText()==btn2.getText()&&btn2.getText()==btn3.getText())
    	{   if(btn1.getText()=="X")
    		askagain1();
    		else
    		askagain2();
    	}
    	}
    	else if(btn4.getText()!=""&&btn5.getText()!=""&&btn6.getText()!="")
    	{
    	   if(btn4.getText()==btn5.getText()&&btn5.getText()==btn6.getText())
    	{	if(btn4.getText()=="X")
    		askagain1();
    		else
    		askagain2();
    	}
    	}
    	else if(btn7.getText()!=""&&btn8.getText()!=""&&btn9.getText()!="")
    	{
    	 if(btn7.getText()==btn8.getText()&&btn8.getText()==btn9.getText())
    	{   if(btn7.getText()=="X")
    	    askagain1();
            else
    		askagain2();   
    	}
    	}
    	else if(clicks==9)
    	askagain3();
    	}
    public void chkcols(int clicks)
    {
        	if(btn1.getText()!=""&&btn4.getText()!=""&&btn7.getText()!="")
        	{
        	if(btn1.getText()==btn4.getText()&&btn4.getText()==btn7.getText())
        	{	if(btn1.getText()=="X")
        	    askagain1();
        		else
        	   askagain2();
        	}
        	}
        	else if(btn2.getText()!=""&&btn5.getText()!=""&&btn8.getText()!="")
        	{
        	   if(btn2.getText()==btn5.getText()&&btn5.getText()==btn8.getText())
        	{ if(btn2.getText()=="X")
        		 askagain1();
        	  else
        	   askagain2();    
        	}
        	}
        	else if(btn3.getText()!=""&&btn6.getText()!=""&&btn9.getText()!="")
        	{
        	 if(btn3.getText()==btn6.getText()&&btn6.getText()==btn9.getText())
        	{  if(btn3.getText()=="X")
        	    askagain1();
        		else
        		askagain2();
        	}
        	}
        	else if(clicks==9)
            askagain3();
        	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
