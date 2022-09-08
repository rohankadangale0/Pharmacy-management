/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement;

import pharmacymanagement.Splash;

/**
 * This class is driver class.
 * This class calls Splash.java to load initial page when the program start.
 * @author ANIS
 * Date: 26-03-2022
 * @version 1.0
 * @since 1.0
 */
public class PharmacyManagement {
    
    /**
     * It creates an object sp of class Splash and call load function.
     * <p> Diver Class creates an object sp of a class Splash and then object 
     * calls the load function  load. This function loads the initial page 
     * which is loading page. </p> 
     * @param args the command line arguments.
    */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Splash sp = new Splash();
        sp.load();
         
    }
    
}
