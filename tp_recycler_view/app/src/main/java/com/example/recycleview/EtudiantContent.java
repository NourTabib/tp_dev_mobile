package com.example.recycleview;

import java.util.ArrayList;

public class EtudiantContent {
    public static ArrayList<Etudiant> getEtudaints(){
        ArrayList<Etudiant> etudaints=new ArrayList<Etudiant>();
        etudaints.add(new Etudiant("21366","Nour"));
        etudaints.add(new Etudiant("21355","Salah"));
        etudaints.add(new Etudiant("21344","Fatma"));
        return etudaints;
    }
}
