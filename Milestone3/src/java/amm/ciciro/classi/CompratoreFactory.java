/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.ciciro.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ciro
 */
public class CompratoreFactory {
    
    private static CompratoreFactory singleton;
    String connectionString;
    
    
    
    
    public static CompratoreFactory getInstance() {
        if (singleton == null) {
            singleton = new CompratoreFactory();
        }
        return singleton;
    }
    

    private CompratoreFactory () {
    
    }
    
    public Compratore getCompratore(String username, String password) 
    {
        
        try
        {
            Connection conn;
            conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            
            String query = "SELECT * FROM compratore "
                    + "WHERE password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, password);
            stmt.setString(2, username);
            
            ResultSet set = stmt.executeQuery();
            
            while(set.next())
            {
                Compratore compratore = new Compratore();
                compratore.userId = set.getInt("id");
                compratore.nome = set.getString("nome");
                compratore.cognome = set.getString("cognome");
                compratore.username = set.getString("username");
                compratore.password = set.getString("password");

            stmt.close();
            conn.close();
            return compratore;
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return null;
    
    }
     
     public Compratore getCompratoreById(int userId){
         
          try 
        {
           
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            
            String query = "SELECT * FROM Compratore "
            + "WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, userId);
            
            ResultSet res = stmt.executeQuery();
            
             if(res.next()) 
            {
                Compratore current = new Compratore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                
                
                stmt.close();
                conn.close();
                return current;
     }
             stmt.close();
             conn.close();
        }
             catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
     public ArrayList<Compratore> getCompratoreList()
     {
     ArrayList<Compratore> compratoreList = new ArrayList <> ();
     
     try 
        {
           
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Compratore";
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next())
            {
                Compratore current = new Compratore();
                
                    current.setId(set.getInt("id"));
                    current.setNome(set.getString("nome"));
                    current.setCognome(set.getString("cognome"));
                    current.setUsername(set.getString("username"));
                    current.setPassword(set.getString("password"));
                    compratoreList.add(current);
                }
            stmt.close();
            conn.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return compratoreList;
     }
     public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }

   
         }





