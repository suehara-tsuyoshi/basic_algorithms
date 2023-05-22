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
        
public class SortTest {
    
    public static void main(String[] args){
        String fileName = args[0];
        ArrayList<Integer> arrayList = new ArrayList<>();
        inputArrayListFromFile(fileName, arrayList);
        InsertSort.sort(arrayList);
        outputArrayListToConsole(arrayList);
    }
    
    public static void inputArrayListFromFile(String fileName, ArrayList<Integer> arrayList){
        
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                int data = sc.nextInt();
                arrayList.add(data);
            }
        }catch(FileNotFoundException ex){
            System.out.println("ファイル"+ fileName + "は見つかりませんでした");
        }catch(InputMismatchException ex){
            System.out.println("入力内容が不適切です");
        }
        

    }
    public static void outputArrayListToConsole(ArrayList<Integer> arrayList){
        int max = truss(arrayList.get(arrayList.size()-1));
        if(truss(arrayList.get(0))>max) max = truss(arrayList.get(0));
        for(int i=0; i<arrayList.size(); i++){
            int size = max-truss(arrayList.get(i));
            for(int j=0;j<size;j++){
                System.out.print(" ");
            }
            System.out.print(arrayList.get(i)+"\t");
            if(i%10 == 9){
                System.out.print("\n");
            }
        }
    }
    public static int truss(int x){
        String s = String.valueOf(x);
        return s.length();
    }
}
