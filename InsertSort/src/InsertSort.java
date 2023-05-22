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

public class InsertSort {
    public static LinkedList<Integer> init(ArrayList<Integer> arrayList){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i=0;i<arrayList.size();i++){
            linkedList.add(arrayList.get(i));
        }
        return linkedList;
    }
    public static void sort(ArrayList<Integer> arrayList){
        LinkedList<Integer> linkedList = init(arrayList);
        for(int i=0;i<linkedList.size();i++){
            int insertNum = linkedList.get(i);
            for(int j=0;j<i;j++){
                if(linkedList.get(j)>insertNum){
                    linkedList.add(j,insertNum);
                    linkedList.remove(i+1);
                    break;
                }
            }
        }
        arrayList.clear();
        for(int i=0;i<linkedList.size();i++){
            arrayList.add(linkedList.get(i));
        }
    }
}
