/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_formation;

/**
 *
 * @author TASNIM
 */
 

 public class formation {
    private int idF;
    private String titre; 
    private String description;
    private String niveau;
    private String datedebut;
    private String datefin;
    private int prix;
    private int nbplaces;

    public formation(int idF, String titre, String description, String niveau, String datedebut, String datefin, int prix, int nbplaces, String enseignant) {
        this.idF = idF;
        this.titre = titre;
        this.description = description;
        this.niveau = niveau;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.prix = prix;
        this.nbplaces = nbplaces;
        this.enseignant = enseignant;
    }

    public void setDatedebut(String datdebut) {
        this.datedebut = datdebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public int getNbplaces() {
        return nbplaces;
    }
    private String enseignant;

    public int getIdF() {
        return idF;
    }

    public String getTitre() {
        return titre;
    }
    public String getEnseignant() {
        return enseignant;
    }

    public String getDescription() {
        return description;
    }

   
    public String getNiveau() {
        return niveau;
    }
    public int getPrix() {
        return prix;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

 
    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "formation{" + "idF=" + idF + ", titre=" + titre + ", description=" + description + ", niveau=" + niveau + ", datdebut=" + datedebut + ", datefin=" + datefin + ", prix=" + prix + ", nbplaces=" + nbplaces + ", enseignant=" + enseignant + '}';
    } 

  
        
           
    
}