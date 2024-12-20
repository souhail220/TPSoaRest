/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.entity;

import java.util.List;

/**
 *
 * @author souha
 */
public interface IEtudiantRepositorie {
    
    public List<Etudiant> ConsultListEtudiant();
    
    public Etudiant ConsultEtudiant(String nom);
    
    public boolean ajouterEtudiant(Etudiant e);
    
    public boolean supprimEtudiant(Etudiant e);
    
    public boolean modifEtudiant(Etudiant e);
}
