/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class Human {
    public String firstname;
    
    public Human(String name){
        firstname = name;
    }
    
    public void SayHello(){
        System.out.println("Hello,I'm"+ firstname);
    }
}
