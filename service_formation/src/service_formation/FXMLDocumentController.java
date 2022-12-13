/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_formation;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import etudiant.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author TASNIM
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button supp;
    @FXML
    private Button mod;
    @FXML
    private Button ajout;
    @FXML
    private Button aller;
     @FXML
    private TableView<formation> table;
    @FXML
    private TableColumn<formation,Integer> colidF;
    @FXML
    private TableColumn<formation, String> coltitre;
    @FXML
    private TableColumn<formation, String> coldescription;
    @FXML
    private TableColumn<formation, String> colniveau;
    @FXML
    private TableColumn<formation, String> coldate_creation;
     @FXML
    private TableColumn<formation, String> colfin;
    @FXML
    private TableColumn<formation, Integer> colprix1;
    @FXML
    private TableColumn<formation, Integer> colE1;
     @FXML
    private TableColumn<formation, String> colN;
   
     @FXML
    private TextField ENS;
     @FXML
    private TextField ID;
    @FXML
    private TextField TITRE;
    @FXML
    private TextField PRIX;
    @FXML
    private TextField DATE;
    @FXML
    private TextField NIVEAU;
     @FXML
    private TextField NIVEAU1;
    @FXML
    private TextField DESC;
    @FXML
    private TextField ID1;
     @FXML
    private DatePicker date;
      @FXML
    private DatePicker date1;
      @FXML
      ImageView image;
    Stage stage;
    Scene scene;
    /**
     * Initializes the controller class.
     */
    Connection conx=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       show1();
      
}
     

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        
    }
     @FXML
    private void show1() {
          service ps= new service();
        ArrayList<formation> list = new ArrayList<>();
        try {
            list=(ArrayList<formation>) ps.getAllformation();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<formation> obsl = FXCollections.observableArrayList(list);
        table.setItems(obsl);
      colidF.setCellValueFactory(new PropertyValueFactory<>("idF"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colniveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        coldate_creation.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
           colfin.setCellValueFactory(new PropertyValueFactory<>("datefin"));
          colN.setCellValueFactory(new PropertyValueFactory<>("nbplaces"));
        colprix1.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colE1.setCellValueFactory(new PropertyValueFactory<>("enseignant"));

    }
     
   private void ajouter()  {
        Connection conx = mysqlconnect.connectDB();
       LocalDate mydate=date.getValue();
       LocalDate mydate1=date1.getValue();
       System.out.println(mydate);
       System.out.println(mydate1);

   String query = "insert into formation VALUES("+ID.getText()+",'"+TITRE.getText()+"','" +DESC.getText() +"','"+date.getValue()+ "','" +date1.getValue()+ "'," +PRIX.getText()+ "," +NIVEAU1.getText()+",'" +NIVEAU.getText() + "','"+ENS.getText()+"')";
           executeQuery(query);
      
       // show1();
   JOptionPane.showMessageDialog(null, "formation ajouter avec success");
       
       show1();  
}

//        Connection cnx=mysqlconnect.connectDB();
//     
//            String req = "INSERT INTO `formation`( `titre`, `description`, `niveau`, `date_creation`, `prix`, `enseignant` )"
//                    + "VALUES (?,?,?,?,?,?)";
//   
//            
//        try {
//             PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setString(1, TITRE.getText());
//            ps.setString(2, DESC.getText());
//            ps.setString(3, NIVEAU.getText());
//            ps.setString.parse(4, date.getValue());
//            ps.setString(3, PRIX.getText());
//            ps.setString(3, ENS.getText());
//
//            
//            ps.execute();
//            JOptionPane.showMessageDialog(null, "Users Add succes");
//           show1();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        }
    
    

        

   
   private void update(){
    String query = "UPDATE formation SET titre = '" +TITRE.getText()+"',niveau='"+NIVEAU.getText()+"',description='"+DESC.getText()+"',date_creation='"+date.getValue()+"',prix="+PRIX.getText()+",enseignant='"+ENS.getText()+"' WHERE idF =" + ID.getText()+"";


      int a= JOptionPane.showConfirmDialog(null, "voulez vous vraiment MODIFIER cette formation?","select",JOptionPane.YES_NO_OPTION);
        if(a==1)
        {
           show1();
        }
        else {
            executeQuery(query);
        show1();}        

 }
   private void supp(){
    String query = "DELETE  from formation  WHERE idF =" + ID1.getText() +"";


        int a= JOptionPane.showConfirmDialog(null, "voulez vous vraiment SUPPRIMER cette formation?","select",JOptionPane.YES_NO_OPTION);
        if(a==1)
        {
           show1();
        }
        else {
            executeQuery(query);
        show1();}        
 }

   
   private void executeQuery(String query){
     Connection conx = mysqlconnect.connectDB();
      Statement st;
     try{
    st = conx.createStatement();
    st.executeUpdate(query);
      }catch(Exception ex){
      ex.printStackTrace();
 }
   }
    @FXML
    private void btnajoutClicked(ActionEvent event) {
          ajouter();

    }
   
    
   @FXML
    private void btnmodifClicked(ActionEvent event) {

  update();
    }
    @FXML
    private void btnsuppClicked(ActionEvent event) {

       supp();
    }
   @FXML
    private void getdate(ActionEvent event) {
       LocalDate mydate=date.getValue();
     System.out.println(mydate.toString());
}
     @FXML
    private void Clicked(MouseEvent event) {
       
   formation formation = table.getSelectionModel().getSelectedItem();
    ID.setText(""+formation.getIdF());
    TITRE.setText(""+formation.getTitre());
    DESC.setText(""+formation.getDescription());
    NIVEAU.setText("" +formation.getNiveau());
    //date.setDatedebut(""+formation.getDatedebut()); 
    PRIX.setText(""+formation.getPrix());
    NIVEAU1.setText(""+formation.getNbplaces());

    ENS.setText(""+formation.getEnseignant());
    
    
    }
     @FXML
    private void exit (ActionEvent event) {
        
         Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
               
        

        try {
            scene = new Scene(FXMLLoader.load(getClass().getResource("espaceFXML.fxml")));
        } catch (IOException ex) {
             Logger.getLogger(EspaceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(scene);
        stage.show();
    }

     @FXML
    private void btnaller(ActionEvent event) {}
}
//        Node node = (Node) event.getSource();
//        stage = (Stage) node.getScene().getWindow();
//               
//        
//
//        try {
//            scene = new Scene(FXMLLoader.load(getClass().getResource("etudiantFXML.fxml")));
//        } catch (IOException ex) {
//             Logger.getLogger(EtudiantFXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        stage.setScene(scene);
//        stage.show();

//        Node node = (Node) event.getSource();
//        stage  = (Stage) node.getScene().getWindow();
//         stage.setWidth(1220);
//        stage.setHeight(850);
//
//        try {
//            Scene = new Scene(FXMLLoader.load(getClass().getResource("etudiantFXML.fxml")), 1200, 800);
//        } catch (IOException ex) {
//             Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        stage.setScene(scene);
//        stage.show();
////      
////    }@FXML
//    private void onClickReset(ActionEvent event) {
//        t_content.setText("");
//        t_image.setText("");
//        t_search.setText("");
//         t_error.setText("");
//         cb_category.getSelectionModel().clearSelection();
//    }

//        
    


