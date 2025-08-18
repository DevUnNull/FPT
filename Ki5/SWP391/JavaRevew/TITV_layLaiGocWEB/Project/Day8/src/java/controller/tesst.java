/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import model.Product;

/**
 *
 * @author User
 */
public class tesst {
    public static void main(String[] args) {
        List<Product> productList = ProductDAO.getInstance().getAllProducts();
        List<Product> affterCollection = new ArrayList<>();
        int count =0;
        Collections.sort(productList, (p1, p2) -> p2.getStockQuantity()- p1.getStockQuantity());
        for (Product product : productList) {
            count ++;
            if(count <= 3){
                affterCollection.add(product);
            }
            
        }
            System.err.println(affterCollection.get(0).getName());

    }
}
