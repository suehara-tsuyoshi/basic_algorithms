
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

/**
 *
 * @author momon
 */


public class MyListTest {
    
    public static void main(String[] args){
        
        try{
            Scanner sc = new Scanner(System.in);
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            for(int i=0; i<10; i++){
                int inputNum = sc.nextInt();
                linkedList.add(inputNum);
            }
            MyList.output(linkedList);
       
            for(int i=0; i<10; i++){
                int inputNum = sc.nextInt();
                MyList.insert(inputNum, linkedList);
                MyList.output(linkedList);
            }
            for(int i=0; i<10; i++){
                int inputNum = sc.nextInt();
                MyList.delete(inputNum, linkedList);
                MyList.output(linkedList);
            }
        }catch(InputMismatchException ex){
            System.out.println("入力内容が不適切です");
        }
        
        
    }
    
}