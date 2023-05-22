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

public class BubbleSort {
    
    public static void sort(ArrayList<Integer> arrayList){
        
        int size = arrayList.size()-1;
   
        for(int i=0; i<size; i++){    
            for(int j=0; j<size; j++){
                    int smallNum = arrayList.get(j);
                    int largeNum = arrayList.get(j+1);
                    if(smallNum>largeNum){
                        arrayList.set(j, largeNum);
                        arrayList.set(j+1, smallNum);
                    }
                }
            }
            
    }
    
}
