/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souha
 */
public class ListEtudiant implements IEtudiantRepositorie {
    List<Etudiant> listEtudiant = new ArrayList<>();
    
    public ListEtudiant(){
        listEtudiant.add(new Etudiant("hamma", "hamma"));
        listEtudiant.add(new Etudiant("gana", "souhail"));
    }
    
    @Override
    public List<Etudiant> ConsultListEtudiant() {
        return listEtudiant;
    }

    @Override
    public Etudiant ConsultEtudiant(String nom) {
        Etudiant e = listEtudiant.stream()
            .filter(student -> student.nom.equals(nom))
            .findFirst()
            .orElse(null);
        return (e != null) ? e : new Etudiant();
    }


    @Override
    public boolean ajouterEtudiant(Etudiant e) {
        if((listEtudiant.stream().filter(et -> et.nom.equals(e.nom))) != null){
            listEtudiant.add(e);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean supprimEtudiant(Etudiant e) {
        try{
            listEtudiant.remove(e);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean modifEtudiant(Etudiant e) {
        try{
            listEtudiant.stream().map(etudiant ->  {
                if(etudiant.nom.equals(e.nom)){
                    etudiant.nom = e.nom;
                    etudiant.prenom = e.prenom;
                    
                }
                return etudiant;
            });
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    
}
