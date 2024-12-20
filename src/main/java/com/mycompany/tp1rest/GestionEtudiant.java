/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.tp1rest;

import com.mycompany.entity.Etudiant;
import com.mycompany.entity.IEtudiantRepositorie;
import com.mycompany.entity.ListEtudiant;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

/**
 * REST Web Service
 *
 * @author souha
 */
@Path("etudiant")
public class GestionEtudiant {
    
    private final ListEtudiant listEtudiant = new ListEtudiant();
    
    /*@GET
    @Produces("text/plain")
    public String get() {
        return "Hamma";
    }*/
    
    @GET
    //@Path("/et")
    @Produces("application/json")
    public String getStudents() {
        List<Etudiant> etudiants = listEtudiant.ConsultListEtudiant();
        if (etudiants == null || etudiants.isEmpty()) {
            throw new WebApplicationException("No students found", 404);
        }
        // Build JSON array using JSON-P
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Etudiant e : etudiants) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                    .add("nom", e.nom)
                    .add("age", e.prenom); // Assuming Etudiant has an 'age' field
            arrayBuilder.add(objectBuilder);
        }
        
        return arrayBuilder.build().toString();
    }
    
    @GET
    @Path("get")
    @Produces("text/plain")
    public String Consulter(@QueryParam("nom") String nom) {
        Etudiant e = listEtudiant.ConsultEtudiant(nom);
        return e.nom + " " + e.prenom;
        //return "etudiant";
    }
   
    @POST
    @Path("add")
    @Produces("text/plain")
    public String Create(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom) {
        Etudiant e = new Etudiant(nom, prenom);
        if(listEtudiant.ajouterEtudiant(e)){
            return "Etudiant est creer";
        }else{
            return "Etudiant n'est pas creer";
        }
    }
    
    @DELETE
    @Path("delete")
    @Produces("text/plain")
    public String Delete(@QueryParam("nom") String nom) {
        Etudiant e = listEtudiant.ConsultEtudiant(nom);
        if(listEtudiant.supprimEtudiant(e)){
            return "Etudiant est suprimer";
        }else{
            return "Etudiant n'est pas suprimer";
        }
    }
    
    @PUT
    @Path("update")
    @Produces("text/plain")
    public String Update(@QueryParam("nomOriginal") String nomOriginal ,@QueryParam("nom") String nom, @QueryParam("prenom") String prenom) {
        Etudiant e = listEtudiant.ConsultEtudiant(nomOriginal);
        if(listEtudiant.modifEtudiant(e)){
            return "Etudiant est modifer";
        }else{
            return "Etudiant n'est pas modifier";
        }
    }

}
