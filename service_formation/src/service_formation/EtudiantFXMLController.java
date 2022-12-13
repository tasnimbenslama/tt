/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_formation;

import etudiant.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service_formation.mysqlconnect;
import static service_formation.mysqlconnect.connectDB;

/**
 * FXML Controller class
 *
 * @author TASNIM
 */
public class EtudiantFXMLController implements Initializable {

    @FXML
    private ListView<String> list4;
Stage stage;
    Scene scene;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Connection conx = mysqlconnect.connectDB();
   
    String connectQuery = "SELECT * FROM formation";
    try{
        Statement statement = connectDB().createStatement();
        ResultSet queryOutput = statement. executeQuery(connectQuery);
        
        while (queryOutput.next()){
            String titre=queryOutput.getString("titre");
            String description=queryOutput.getString("description");
             String niveau=queryOutput.getString("niveau");
            String date_creation=queryOutput.getString("datedebut");
           
            Integer prix=queryOutput.getInt("prix");
            String enseignant=queryOutput.getString("enseignant");
            String listOut= "LA FORMATION : "+titre+" est  "+description+" LES NIVEAUX { "+niveau+" }COMMENCE[ "+date_creation+" ]PRIX" +prix+" PESENTE PAR "+enseignant;
            list4.getItems().add(listOut);
    
        }
    }catch(Exception e){
    }
    }    
    

    @FXML
    private void addCliked(MouseEvent event) {
    }
    
    @FXML
    private void reset(ActionEvent event) {
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
    }
    

