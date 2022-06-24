package addaccount;

import javafx.fxml.FXML;




import javafx.scene.control.Button;
import java.sql.*;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.control.DatePicker;

public class AddaccountController 
{

@FXML
private TextField address;

@FXML
private DatePicker birthdate;

@FXML
private TextField name;

@FXML
private TextField nid;

@FXML
private PasswordField password;

@FXML
private TextField phone;

@FXML
private Button signup;

Connection con;
PreparedStatement pst;
ResultSet rs=null;


	// Event Listener on Button[#signup].onAction
	@FXML
	public void signup(ActionEvent event) 
	{
		// TODO Autogenerated
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/train_ticket?useTimezone=true&serverTimezone=UTC", "","");
			
			//String query="INSERT INTO account_section (name, address, nid, birthdate, phone, password) VALUES (?,?,?,?,?,?)";
			//pst=con.prepareStatement("INSERT INTO account_section(Name, Address, Nid, Phone, Password) VALUES ('?','?','?','?','?');"
			
			pst.setString(1, name.getText());
			pst.setString(2, address.getText());
			pst.setString(3, nid.getText());
			//pst.setString(4,((Datepicker).birthdate.getEditor()).getText());
			pst.setString(5, phone.getText());
			pst.setString(6, password.getText());
			
			rs=pst.executeQuery();
			if(rs.next())
			{
				JOptionPane.showConfirmDialog(null, "Success");
			}
			else 
			{
				JOptionPane.showConfirmDialog(null, "Failed");
				/*name.setText("");
				address.setText("");
				nid.setText("");
				//birthdate.setTex
				phone.setText("");
				password.setText("");*/
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
		


