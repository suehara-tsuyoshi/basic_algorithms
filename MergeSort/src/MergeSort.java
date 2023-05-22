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

public class MergeSort {
    public static void sort(ArrayList<Integer> arrayList){
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for(int i=0; i<arrayList.size(); i++){
            if(i<arrayList.size()/2){
                arrayList1.add(arrayList.get(i));
            }else{
                arrayList2.add(arrayList.get(i));
            }
        }
        if(arrayList1.size()>1){
            sort(arrayList1);
        }
        if(arrayList2.size()>1){
            sort(arrayList2);
        }
        
        int listNum1 = 0;
        int listNum2 = 0;
        for(int i=0; i<arrayList1.size()+arrayList2.size(); i++){
            if(listNum1 >= arrayList1.size()){
                arrayList.set(i, arrayList2.get(listNum2));
                listNum2++;
            }else if(listNum2 >=arrayList2.size()){
                arrayList.set(i, arrayList1.get(listNum1));
                listNum1++;
            }else if(arrayList1.get(listNum1)<=arrayList2.get(listNum2)){
                arrayList.set(i,arrayList1.get(listNum1));
                listNum1++;
            }else if(arrayList1.get(listNum1)>arrayList2.get(listNum2)){
                arrayList.set(i,arrayList2.get(listNum2));
                listNum2++;
            }
        }
    }
}
