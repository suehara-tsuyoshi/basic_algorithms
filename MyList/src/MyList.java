/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
import java.util.*;

public class MyList {
    
    public static void insert(int x, LinkedList<Integer> linkedList){
        boolean isNotInsert = true;
        int listNum;
        
        for(int i=0; i<linkedList.size();i++){
            listNum = linkedList.get(i);
            if(listNum>=x && isNotInsert==true){
                linkedList.add(i,x);
                isNotInsert =false;
            }
        }
        if(isNotInsert){
            linkedList.add(x);
        }
        
        
    }
    public static void delete(int x, LinkedList<Integer> linkedList){
        
        int listNum;
        
        for(int i=0; i<linkedList.size(); i++){
            listNum = linkedList.get(i);
            if(listNum==x){
                linkedList.remove(i);
                i--;
            }
        }
        
    }
    public static void output(LinkedList<Integer> linkedList){
        for(int num: linkedList){
        System.out.print(num + "\t");
        }
        System.out.print("\n");
    }
}
