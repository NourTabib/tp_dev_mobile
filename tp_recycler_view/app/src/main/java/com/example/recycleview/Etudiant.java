package com.example.recycleview;

public class Etudiant implements Comparable<Etudiant>{
    private String Matricule;
    private String Nom;

    public Etudiant(String matricule, String Nom) {
        Matricule = matricule;
       this.Nom = Nom;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    @Override
    public int compareTo(Etudiant etudaint) {
        return this.Matricule.compareTo(etudaint.Matricule);
    }
}
