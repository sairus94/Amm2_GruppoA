/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.ciciro.classi;

/**
 *
 * @author Ciro
 */
public class Account {
    
    
     public int id;
     public double soldi; 
     
     public Account(){
        
    }
    
    public Account(int userId, double balance){
        this.id = id;
        this.soldi = soldi;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the soldi
     */
    public double getSoldi() {
        return soldi;
    }

    /**
     * @param soldi the soldi to set
     */
    public void setSoldi(double soldi) {
        this.soldi = soldi;
    }

}