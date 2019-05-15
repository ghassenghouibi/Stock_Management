package model;

import java.sql.*; 
/**
* 
*/
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
}  
