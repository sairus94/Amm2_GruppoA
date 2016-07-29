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
public class AccountFactory {
    
    private static AccountFactory singleton;
    String connectionString;
    public static AccountFactory getInstance() {
    
        if (singleton == null) {
            singleton = new AccountFactory ();
                    }   
     return singleton;
        } 
   
    //costruttore
  
    private AccountFactory () {
    
}
    
     public Account getAccount(String id, String soldi) throws SQLException
    {
      try
        {
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            String query = "SELECT * from Account"
                    + "WHERE id = ? and soldi = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, id);
            stmt.setString(2, soldi);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
        Account account = new Account();
        account.id = set.getInt("id");
        account.soldi = set.getDouble("soldi");
        
        
            stmt.close();
            conn.close();
            return account;
            }
            
    }
     catch(SQLException e)
        {
            
        }
        return null;
    
    }
     public Account getAccountById(int id){
         
          try 
        {
           
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            // Query
            String query = "SELECT * FROM Account "
            + "WHERE id = ?";
           
            PreparedStatement stmt = conn.prepareStatement(query);
           
            stmt.setInt(1, id);
           
            ResultSet res = stmt.executeQuery();
            
             if(res.next()) 
            {
                Account current = new Account();
                current.setId(res.getInt("id"));
                current.setSoldi(res.getDouble("soldi"));
                
                
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
     public ArrayList<Account> getAccount()
     {
     ArrayList<Account> accountList = new ArrayList <> ();
     
     try 
        {
           
            Connection conn = DriverManager.getConnection(connectionString, "ciro", "0000");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Account";
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next())
            {
                Account current = new Account();
                
                    current.setId(set.getInt("id"));
                    current.setSoldi(set.getDouble("soldi"));
                    accountList.add(current);
                }
            stmt.close();
            conn.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return accountList;
     }
     public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }

}
