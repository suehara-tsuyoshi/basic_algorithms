
import java.util.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class RecursiveHeapSort {
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
        if(2*x+1<linkedList.size()){
            int min = linkedList.get(x);
            int nextNum = x;
            if(linkedList.get(2*x+1)<min){
                min = linkedList.get(2*x+1);
                nextNum = 2*x+1;
            }
            if(2*x+2<linkedList.size()){
                if(linkedList.get(2*x+2)<min){
                    min = linkedList.get(2*x+2);
                    nextNum = 2*x+2;
                }
            }
            if(nextNum !=x){
                linkedList.set(nextNum, linkedList.get(x));
                linkedList.set(x, min);
                heap(linkedList, nextNum);
            }
           
            
            
            
        }
    }
    
}
