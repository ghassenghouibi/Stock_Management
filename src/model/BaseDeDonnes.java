package model;

import java.sql.*;
import controller.*;
import java.util.ArrayList;

public class BaseDeDonnes  { 

    public int checkLogin(String name,String password){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from Connexion");  
            while(rs.next()){

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

    public void registerNewRetailer(String name,String password){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");  
            Statement stmt=con.createStatement();  
            String sql = "INSERT INTO `Connexion`(`name`, `password`) VALUES ('"+name+"','"+password+"')";
            stmt.executeUpdate(sql);
            con.close();  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }

    public ArrayList<ProviderInfo> loadProvider(){
        ArrayList<ProviderInfo> providers=new ArrayList<ProviderInfo>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT `id_provider`,`name`,`product`,`adress`,`codePostal`,`telephone` FROM `Provider`");  
            while(rs.next()){
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getInt(5)+rs.getInt(6));
                ProviderInfo newProvider=new ProviderInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6) );  
                providers.add(newProvider);
            }
            con.close();     
        }catch(Exception e){ 
            System.out.println(e);
        }

        return  providers;
    }

    public void insertProvider(ProviderInfo providers){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");
            Statement stmt=con.createStatement();           
            String sql = "INSERT INTO Provider " + "VALUES ("+1 +",'"+providers.getId()+"','"+providers.getNomProvider()+"','"+providers.getProduct()+"','"+providers.getAdresse()+"','"+providers.getCodePostal()+"','"+providers.getNumeroDeTelephone()+"')";
            stmt.executeUpdate(sql);
            

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void deleteProvider(int id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");
            Statement stmt=con.createStatement();         
            String sql = "DELETE FROM Provider WHERE  `id_provider` = '"+id+"'";
            stmt.executeUpdate(sql);
           
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void modifyProvider(int id,String modifyproduit,String modifynom,String modifyadresse,int modifycodePostale,int modifytelephone){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");
            Statement stmt=con.createStatement();
            String sql = "UPDATE Provider SET  `name` = '"+modifynom+"' ,  `product`= '"+modifyproduit+"'  ,  `adress`= '"+modifyadresse+"'  ,  `codePostal`= '"+modifycodePostale+"'  ,  `telephone`='"+modifytelephone+ "' WHERE `id_provider` ='"+id+"'";
            stmt.executeUpdate(sql);
           
        }catch(Exception e){
            System.out.println(e);
        }
    }
    


    public ArrayList<Article> loadArticles(){
        ArrayList<Article> articles=new ArrayList<Article>();
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("SELECT `name`, `barcode`, `quantity_in_stock`, `seuil_of_stock`, `price`, `type_of_sell` FROM `Article`");  

            while(rs.next()){
                Article newArticle=new Article(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getBoolean(6));  
                articles.add(newArticle);
            }
            con.close();     
        }catch(Exception e){ 
            System.out.println(e);
        }

        return  articles;
    }

    public void insertArticles(ArrayList<Article> articles){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-de-stock","root","");
            Statement stmt=con.createStatement();           
            for(Article x:articles){
                String sql = "INSERT INTO Article " + "VALUES ("+1 +",'"+x.getNom()+"','"+x.getCodeBarre()+"','"+x.getQuantiteEnStock()+"','"+x.getSeuilDeReassortiment()+"','"+x.getPrixDeVente()+"','"+x.getTypeDeVente()+"')";

                stmt.executeUpdate(sql);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}  
