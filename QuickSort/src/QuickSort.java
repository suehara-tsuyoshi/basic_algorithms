
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
public class QuickSort {
    public static void sort(ArrayList<Integer> arrayList,int start,int end){
        if(arrayList.size()<2||start>=end){
            return;
        }     
        int pivot = getPivot(arrayList,start,end);
        int s = start;
        int e = end;
        while(s<=e){
            while(arrayList.get(s)<pivot){
                s++;
            }
            while(arrayList.get(e)>pivot){
                e--;
            }
            if(s<=e){
                int keep = arrayList.get(s);
                arrayList.set(s, arrayList.get(e));
                arrayList.set(e, keep);
                s++;
                e--;
            }
        }
        sort(arrayList,start,e);
        sort(arrayList, s, end);
      
        
    }
    public static int getPivot(ArrayList<Integer> list,int start,int end){
         return list.get((start+end)/2);
    }
}
