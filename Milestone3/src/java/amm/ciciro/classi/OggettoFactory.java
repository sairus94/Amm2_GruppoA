/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.ciciro.classi;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ciro
 */
public class OggettoFactory {
    
        
    private static OggettoFactory singleton;
    private String connectionString;

    public static OggettoFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettoFactory();
        }
        return singleton;
    }
    
    
    private OggettoFactory() {

    }
    

    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    public ArrayList<Oggetto> getOggettoList() {
    
        ArrayList<Oggetto> oggettoList = new ArrayList<Oggetto>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String sql = "select * from Oggetti";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
             while(set.next()) 
            {
                Oggetto current = new Oggetto( set.getInt("quantita"), set.getInt("id"), set.getInt("venditoreId"), set.getDouble("prezzo"), set.getString("nome"), set.getString("url"), set.getString("descrizione"));
                oggettoList.add(current);
            }
            stmt.close();
            conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
           }
 
        return oggettoList;
}
    public ArrayList<Oggetto> getOggettoByVenditoreId(int venditoreId) {
        ArrayList<Oggetto> oggettoList = new ArrayList<Oggetto>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String sql = "select * from Oggetti " + "where venditoreId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, venditoreId);
            ResultSet set = stmt.executeQuery();
             while(set.next()) 
            {
                Oggetto current = new Oggetto( set.getInt("quantita"), set.getInt("id"), set.getInt("venditoreId"), set.getDouble("prezzo"), set.getString("nome"), set.getString("url"), set.getString("descrizione"));
                oggettoList.add(current);
            }
            stmt.close();
            conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
           }
 
        return oggettoList;
    }
     public Oggetto getOggettoById(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String sql = "select * from Oggetti " + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            if (set.next()){
                Oggetto oggetto = new Oggetto( set.getInt("quantita"), set.getInt("id"), set.getInt("venditoreId"), set.getDouble("prezzo"), set.getString("nome"), set.getString("url"), set.getString("descrizione"));
                stmt.close();
                conn.close();
                return oggetto;
            }
            
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        return null;     
    }
      public void aggiungiOggetto(int quantita, int id, int venditoreId, double prezzo, String nome, String url, String descrizione){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String sql = "INSERT INTO Oggetti" + "(id, venditoreId, quantita, nome, prezzo, url, descrizione)" + "VALUES (default,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, venditoreId);
            stmt.setInt(2, quantita);
            stmt.setString(3, nome);
            stmt.setDouble(4, prezzo);
            stmt.setString(5, url);
            stmt.setString(6, descrizione);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
           
    }
      public void cancellaOggetto(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String sql_1 = "DELETE FROM Oggetti " + "WHERE id = ? ";
            PreparedStatement deleteItem = conn.prepareStatement(sql_1);
            deleteItem.setInt(1, id);
            deleteItem.executeUpdate();
            deleteItem.close();
            conn.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        
    }
      public void caricaOggetto(int quantita, int id, int venditoreId, double prezzo, String nome, String url, String descrizione){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String sql = "UPDATE Oggetti SET " + "venditoreId = ?, quantita = ?, nome = ?, prezzo = ?, url = ?, descrizione = ? WHERE id = ?";
            PreparedStatement caricaOggetto = conn.prepareStatement(sql);
            caricaOggetto.setInt(1, venditoreId);
            caricaOggetto.setInt(2, quantita);
            caricaOggetto.setString(3, nome);
            caricaOggetto.setDouble(4, prezzo);
            caricaOggetto.setString(5, url);
            caricaOggetto.setString(6, descrizione);
            caricaOggetto.setInt(7, id);
            caricaOggetto.executeUpdate();
            caricaOggetto.close();
            conn.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
      }
        public ArrayList<Oggetto> cercaOggetto(String text){
        ArrayList<Oggetto> oggettoList = new ArrayList<Oggetto>();
        text = "%"+text+"%";
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String query = "select * from Oggetti " + 
                           "where lower(nomeoggetto) like lower(?)";         
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, text);
            ResultSet set = stmt.executeQuery();
            while(set.next())
            {
                Oggetto current = new Oggetto(set.getInt("quantita"), set.getInt("id"), set.getInt("venditoreId"), set.getDouble("prezzo"), set.getString("nome"), set.getString("url"), set.getString("descrizione"));
                oggettoList.add(current);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException ex)
        {ex.printStackTrace();}

        return oggettoList;
    }
    }







