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
import java.io.*;

public class NonRecursiveHeapSort {
    
    public static void sort(ArrayList<Integer> arrayList){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i=0;i<arrayList.size();i++){
            linkedList.add(arrayList.get(i));
        }
        int startNum = linkedList.size()/2-1;
        
        for(int i=startNum;i>=0;i--){
            heap(linkedList, i);
        }
        for(int j=0;j<arrayList.size();j++){
            arrayList.set(j,linkedList.get(0));
            linkedList.set(0, linkedList.get(linkedList.size()-1));
            linkedList.remove(linkedList.size()-1);
            heap(linkedList, 0);
        }
    }
    public static void heap(LinkedList<Integer> linkedList, int x){
        boolean numChanged = true;
        int nextNum = x;
        while(numChanged&&nextNum<linkedList.size()){
            int min = linkedList.get(nextNum);
            int startNum = nextNum;
            if(2*startNum+1<linkedList.size()&&linkedList.get(2*startNum+1)<min){
                min = linkedList.get(2*startNum+1);
                nextNum = 2*startNum+1;
            }
            if(2*startNum+2<linkedList.size()&&linkedList.get(2*startNum+2)<min){
                min = linkedList.get(2*startNum+2);
                nextNum = 2*startNum+2;
                
            }
            if(startNum !=nextNum){
                linkedList.set(nextNum, linkedList.get(startNum));
                linkedList.set(startNum, min);
            }else{
                numChanged = false;
            }
           
            
            
            
        }
    }
        
    
}
