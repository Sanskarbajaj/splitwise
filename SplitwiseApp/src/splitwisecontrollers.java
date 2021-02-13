import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
public class splitwisecontrollers implements Initializable {
	@FXML
    private JFXButton computeresbtn;
    @FXML
    private JFXTextField pn1tf;
    @FXML
    private JFXTextField pn2tf;
    @FXML
    private JFXTextField amounttf;
    @FXML
    private JFXButton nextamountbtn;
    @FXML
    private JFXTextArea previewta;
    @FXML
    private JFXTextArea resultsta;
    public class pair
    {
    	String first;
    	String second;
    	public pair(String first,String second) {
			this.first=first;
			this.second=second;
		}
    }
    public class pairs
    {
    	String name;
    	int amt;
    	public pairs(int amt,String name) {
			this.amt=amt;
			this.name=name;
		}
    }
    ArrayList<pairs> ms=new ArrayList<>();
    HashMap<String,Integer>net=new HashMap<String, Integer>();
    @FXML
    void addnextpair(ActionEvent event) {
    	chkernxt();
    	String p1=pn1tf.getText();
    	String p2=pn2tf.getText();
    	int amn= Integer.parseInt(amounttf.getText());
    	String ss=p1+" gives "+amn+" Rs to "+p2;
    	previewta.appendText(ss+"\n");
    	if(!net.containsKey(p1))
    	{
    		net.put(p1,0);
    	}
    	if(!net.containsKey(p2))
    	{
    		net.put(p2,0);
    	}
    	net.put(p1,net.get(p1)-amn);
    	net.put(p2,net.get(p2)+amn);
    }
    public void clears()
    {  	pn1tf.setText("");
    	pn2tf.setText("");
    	amounttf.setText("");
    }
    @FXML
    void computeresults(ActionEvent event) {
    	chkernxt();
    	int count=0;
         for(Map.Entry<String ,Integer>ent:net.entrySet())
         {
        	 if(ent.getValue()!=0)
        	 {
        		 pairs pp=new pairs(ent.getValue(),ent.getKey());
        		 ms.add(pp);
        		 ms.sort(new Comparator<pairs>() {
        				@Override
        				public int compare(pairs o1, pairs o2) {
        					if (o1.amt > o2.amt) {
        		                return 1;
        		            } else if ((o1.amt)==(o2.amt)) {
        		                return 0; 
        		            } else {
        		                return -1;
        		            }
        				}
        			});
        	 }
         }
         //Make Settlements
         while(!ms.isEmpty())
         {  
        	 pairs low=ms.get(0);
        	 pairs high=ms.get(ms.size()-1);
        	 int debit=low.amt;
        	 String debiter_name=low.name;
        	 int credit=high.amt;
        	 String crediter_name=high.name;
        	 ms.remove(0);
        	 ms.remove(ms.size()-1);
        	 int settlement_amount=Math.min(-debit,credit);
        	 debit+=settlement_amount;
        	 credit-=settlement_amount;
        	 String ress=crediter_name+" will pay "+settlement_amount+" to "+debiter_name+"\n";
        	 resultsta.appendText(ress);
        	 if(debit!=0)
        	 {
        		 pairs pp=new pairs(debit,debiter_name);
        		 ms.add(pp);
        		 ms.sort(new Comparator<pairs>() {
        				@Override
        				public int compare(pairs o1, pairs o2) {
        					if (o1.amt > o2.amt) {
        		                return 1;
        		            } else if ((o1.amt)==(o2.amt)) {
        		                return 0; 
        		            } else {
        		                return -1;
        		            }
        				}
        			});
        	 }
        	 if(credit!=0)
        	 {
        		 pairs pp=new pairs(credit,crediter_name);
        		 ms.add(pp);
        		 ms.sort(new Comparator<pairs>() {
        				@Override
        				public int compare(pairs o1, pairs o2) {
        					if (o1.amt > o2.amt) {
        		                return 1;
        		            } else if ((o1.amt)==(o2.amt)) {
        		                return 0; 
        		            } else {
        		                return -1;
        		            }
        				}
        			});
        	 }
        	 count++;
         }
         resultsta.appendText("No Of Transaction is "+count+"\n"+"\n");
         askagain();
         
    }
    public void askagain()
    {   	 Alert al=new Alert(AlertType.CONFIRMATION);
	    	al.setTitle("Transaction Completed");
	    	al.setContentText("Click On Ok To Check New Transaction");
	    	Optional<ButtonType> result = al.showAndWait();
	    	if (result.get() == ButtonType.OK){
	            clears();
	            previewta.setText("");
	            resultsta.setText("");
	            ms.clear();
	            net.clear();
	    	} else {
	    	    System.exit(0);
	    	}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		previewta.setEditable(false);
		resultsta.setEditable(false);
		previewta.setScrollTop(0);
    	previewta.setScrollLeft(0);
    	resultsta.setScrollTop(0);
    	resultsta.setScrollLeft(0);
	}
	public boolean isint(String str)
	{	for(int i=0;i<str.length();i++)
		{ if(!Character.isDigit(str.charAt(i)))
			return false;
		}
	return true;}
	public void chkernxt()
	{ if(pn1tf.getText().length()==0||pn2tf.getText().length()==0||amounttf.getText().length()==0)
    	{	Alert a=new Alert(AlertType.ERROR);
    		a.setTitle("Error");
    		a.setContentText("Fields can't be Empty");
    		a.showAndWait();
    	}
    String tempamount=amounttf.getText();
    if(!isint(tempamount)||tempamount.length()>6)
    {  	Alert a=new Alert(AlertType.ERROR);
    	if(!isint(tempamount)&&tempamount.length()>6)
    	{	a.setTitle("Error");
    		a.setContentText("Invalid Amount...");
    		a.showAndWait();
    	}
    	else if(!isint(tempamount))
    	{	a.setTitle("Error");
    		a.setContentText("Only Integer Values Are Allowed");
    		a.showAndWait();
    	}
    	else
    	{	a.setTitle("Error");
    		a.setContentText("Amount Must Be In Range Of 0-100000 ");
    		a.showAndWait();
    	}
    }
	}
}
