
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class PracticeTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        System.out.println("please input 10 natural numbers");
        for(int i=0; i<10; i++){
            String inputData = sc.next();
            int inputNum = Integer.parseInt(inputData);
            linkedList.add(inputNum);
        }
        Practice.output(linkedList);
        System.out.println("please input 1 natural number");
       
        for(int i=0; i<10; i++){
            String inputData = sc.next();
            int inputNum = Integer.parseInt(inputData);
            Practice.insert(inputNum, linkedList);
            Practice.output(linkedList);
        }
        for(int i=0; i<2; i++){
            String inputData = sc.next();
            int inputNum = Integer.parseInt(inputData);
            Practice.delete(inputNum, linkedList);
            Practice.output(linkedList);
        }
        
        
        
       
        

       
     
        
    }
}
