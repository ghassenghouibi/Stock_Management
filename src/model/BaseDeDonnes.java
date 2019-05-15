package model;

import java.sql.*;
import controller.*;
/**
* 
*/
import java.util.ArrayList;

public class BaseDeDonnes  { 

    public int checkLogin(String name,String password){
        System.out.println(name+password);
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from Connexion");  
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" ");  
                System.out.println(rs.getString(2).length());
                System.out.println(name.length());

                if(rs.getString(2).equals(name) && rs.getString(3).equals(password)){
                    con.close();
                    return 1;
                }
            }   
                con.close();  
        }catch(Exception e){ 
            System.out.println(e);
        }  

        return 0;
    }


    public ArrayList<Fournisseur> loadProvider(){
        ArrayList<Fournisseur> providers=new ArrayList<Fournisseur>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from Provider");  
            while(rs.next()){
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getInt(5));
                Fournisseur newFournisseur=new Fournisseur(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));  
                providers.add(newFournisseur);
            }
            con.close();     
        }catch(Exception e){ 
            System.out.println(e);
        }

        return  providers;
    }

    public void insertProvider(ArrayList<Fournisseur> providers){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");
            Statement stmt=con.createStatement();           
            for(Fournisseur x:providers){
                String sql = "INSERT INTO Provider " + "VALUES ("+1 +",'"+x.getNomFournisseur()+"','"+x.getProduct()+"','"+x.getAdresse()+"',"+x.getCodePostal()+","+x.getNumeroDeTelephone()+")";
                stmt.executeUpdate(sql);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}  
