/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
<<<<<<< HEAD
import model.Product;
/**
 *
 * @author Surface pro
 */
public class ProductDao {
    public static void save(Product product){
     String query ="insert into product (name,category,price) values ('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
     DbOperation.setDataOrDelete(query,"product added Successfully");
    }
=======

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;

/**
 *
 * @author hp
 */
public class ProductDao {
    public static void save(Product product){
        String query = "insert into product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperation.setDataOrDelete(query,"Product Added Successflly");
      
   }
    public static ArrayList<Product> getAllRecords(){
         
          ArrayList<Product> arrayList = new ArrayList<>();
          try{
             ResultSet rs= DbOperation.getData("select * from product");
             while(rs.next()){
                  Product product=new Product();
                  product.setId(rs.getInt("id"));
                  product.setName(rs.getString("name"));
                  product.setCategory(rs.getString("category"));
                  product.setPrice(rs.getString("price"));
                  arrayList.add(product);
                  
             }
          
          }
          catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
          
          }
          return arrayList;
          
    }
    
    public static void update(Product product){
         
         String query = "update product set name ='"+product.getName()+"',category ='"+product.getCategory()+"',price ="+product.getPrice()+"'where id ='"+product.getId()+"'";
         DbOperation.setDataOrDelete(query,"Product Updated Successflly");

    }
    
    public static void delete(String id){
    
        String query = "delete from product where id='"+id+"'";
        DbOperation.setDataOrDelete(query,"Product Deleted Successflly");
        
    
    }
    
>>>>>>> 499dd5c938f00b52cada10a91fb9eafd63dd9c15
}
