package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

	


public class projcontroller {
	String url="jdbc:mysql://localhost:3306/"+"l2_projet?zeroDateTimeBehaviour"+"=CONVERT_TO_NULL&serverTimezone=UTC";
	String login="root";
	String password=""; 
	public String mail;
	
	@FXML private Button testid;
	public void testaction(ActionEvent event) {

	        try {
	        	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("fxmlaccountcreate.fxml"));
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root,600,400));
	            stage.show();
	            ((Node) event.getSource()).getScene().getWindow().hide();
	            System.out.println(mail);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	@FXML private Button rprinc;
	public void retourprinc(ActionEvent event) {

			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("fxmlproj.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root,600,400));
				stage.show();
				((Node) event.getSource()).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML private Button retourm;
	public void gomenu(ActionEvent event) {

			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("choix.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root,600,400));
				stage.show();
				((Node) event.getSource()).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML private Button trans;
	public void gotrans(ActionEvent event) {

			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("transcription.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root,830,560));
				stage.show();
				((Node) event.getSource()).getScene().getWindow().hide();
				
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML private Button ouvra;
	public void goouvra(ActionEvent event) {

			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ouvrage.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root,600,400));
				stage.show();
				((Node) event.getSource()).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	@FXML private ImageView imgv;
	@FXML private Button sendb;
	public void sendimage(ActionEvent event) throws ClassNotFoundException, SQLException, FileNotFoundException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,login,password);
			Statement stmt = con.createStatement(); 
		
			String filemail = "email.txt";
	        try(BufferedReader br = new BufferedReader(new FileReader(filemail))) 
	        {
	            String emailtxt;
	            while ((emailtxt = br.readLine()) != null) {
	            System.out.println(emailtxt);
	            String sql = "SELECT id_utilisateur FROM utilisateur WHERE adresse_mail = '"+ emailtxt +"'";
				ResultSet rs;
				rs = stmt.executeQuery(sql);
				int id = 0;
			    while(rs.next()){
			    	id = rs.getInt("id_utilisateur");
	                System.out.println(id);

	            }
				
					FileChooser fC = new FileChooser();

			        fC.getExtensionFilters().add(new FileChooser.ExtensionFilter("mediaFile","*.jpg"));
			        List<File> f = fC.showOpenMultipleDialog(null);//stores files in f object list of type: File
			        if (f != null){
			            for (File file : f) {
			            	FileInputStream input = new FileInputStream(file);
			            	PreparedStatement ps = con.prepareStatement("INSERT INTO  image (image, id_utilisateur) VALUES (?,?)");
			            	ps.setBinaryStream(1,(InputStream)input,(int)file.length());
			            	System.out.println(id);
			            	ps.setInt(2,id);
			            	ps.execute();
			                ps.close();
			                Image image = new Image(file.getAbsolutePath());
			                imgv.setImage(image);
			            }
			        }
	            }
	        }
	        catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
		
			
			
      
	}
	
	@FXML private TextField email;
	@FXML private PasswordField mdp;
	
	@FXML private Button loginb;
	public void login(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		mail = email.getText();
		String pass = mdp.getText();
		ResultSet rs;
		
		if(mail.equals("") && pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Email ou mot de passe vide");
		}
		else {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,login,password);
			PreparedStatement prepsta;
			prepsta = con.prepareStatement("SELECT * FROM utilisateur WHERE adresse_mail=? and mdp=?");
			prepsta.setString(1, mail);
			prepsta.setString(2, pass);
			rs = prepsta.executeQuery();
			
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "Connexion réussie");
				try {
					AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("choix.fxml"));
					Stage stage = new Stage();
					stage.setScene(new Scene(root,600,400));
					stage.show();
					((Node) event.getSource()).getScene().getWindow().hide();
					File file = new File("email.txt");
					if (!file.exists()) {
					    file.createNewFile();
					   }
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(mail);
					bw.close();

					System.out.println(mail);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        } 
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Connexion impossible");
				email.setText("");
				mdp.setText("");
				email.requestFocus();
				System.out.print(rs);

			}
			
		}			
	}
	
		public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}

	@FXML private Button inscription;
	public void creacompte(ActionEvent event) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,login,password);
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");
            con = DriverManager.getConnection(url, login, password);
            System.out.println("Connection reussie");
        }
        catch(ClassNotFoundException e){
            System.err.println("Erreur de chargement");
            e.printStackTrace();
        }
        catch(SQLException e){
            System.err.println("Erreur d'etablissement");
            e.printStackTrace();
        }
		
		Statement stmt = con.createStatement(); 
			String mail = email.getText();
			String pass = mdp.getText();
		
			if(mail.equals("") || mdp.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Email ou mot de passe vide");
			}
			else {
			if(!validate(mail)) {
				JOptionPane.showMessageDialog(null, "Format invalide");

			}
			else {
			String sql = "INSERT INTO `utilisateur` (`adresse_mail`, `mdp`) VALUES ('"+mail+"', '"+pass+"');";
			
			int i = stmt.executeUpdate(sql);
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("choix.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root,600,400));
				stage.show();
				((Node) event.getSource()).getScene().getWindow().hide();
			}
			catch (IOException e) {
				e.printStackTrace();
        	} 
			} 
			}
	}
	
	
	@FXML private TextField titre;
	@FXML private TextField lieux;
	@FXML private TextField nbpages;
	@FXML private TextField dateed;
	@FXML private TextField comm;


	
	
	@FXML private Button ajoutb;
	public void ajoute(ActionEvent event) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,login,password);
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver OK");
            con = DriverManager.getConnection(url, login, password);
            System.out.println("Connection reussie");
        }
        catch(ClassNotFoundException e){
            System.err.println("Erreur de chargement");
            e.printStackTrace();
        }
        catch(SQLException e){
            System.err.println("Erreur d'etablissement");
            e.printStackTrace();
        }
		
		Statement stmt = con.createStatement(); 
			String titreo = titre.getText();
			String lieuxo = lieux.getText();
			String nbpageso = nbpages.getText();
			String dateedo = dateed.getText();
			String commo = comm.getText();
		
			if(titreo.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Titre vide");
			}
			else {
			String sql = "INSERT INTO `ouvrage` (`titre`, `lieux_associés`, `nombres_pages`, `année_édition`, `commentaire`) VALUES ('"+titreo+"', '"+lieuxo+"', '"+nbpageso+"' , '"+dateedo+"', '"+commo+"');";
			
			int i = stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Ouvrage ajouté");
			}
	}
	
	
	@FXML private Button decob;
	public void deco(ActionEvent event) {

	        try {
	        	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("fxmlproj.fxml"));
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root,600,400));
	            stage.show();
	            ((Node) event.getSource()).getScene().getWindow().hide();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
}
