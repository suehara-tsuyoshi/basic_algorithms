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
        ArrayList<String> arrayList = new ArrayList<>();
        inputArrayListFromFile(fileName, arrayList);
        BucketSort.sort(arrayList);
        outputArrayListToConsole(arrayList);
        
        
    }
    
    public static void inputArrayListFromFile(String fileName, ArrayList<String> arrayList){
        
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String data = sc.next();
                arrayList.add(data);
            }
        }catch(FileNotFoundException ex){
            System.out.println("ファイル"+ fileName + "は見つかりませんでした");
        }catch(InputMismatchException ex){
            System.out.println("入力内容が不適切です");
        }
        

    }
    public static void outputArrayListToConsole(ArrayList<String> arrayList){
        for(int i=0; i<arrayList.size(); i++){
           System.out.println(arrayList.get(i));
        }
    }
}
