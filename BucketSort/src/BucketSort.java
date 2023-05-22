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

public class BucketSort {
    public static int[] szlist = new int[26];
    public static void sort(ArrayList<String> arrayList){
        int[][][] bucket = new int[26][100][20];
       
        for(int i=0;i<arrayList.size();i++){
            String str = arrayList.get(i);
            
            cton(str, szlist,bucket);
        }
        arrayList.clear();
        for(int i=0;i<26;i++){
            for(int j=0;j<100;j++){
                String s  = "";
                for(int k=0;k<20;k++){
                    String str = ntos(bucket[i][j][k]);
                    s.concat(str);
                    
                }
                if(s!="") arrayList.add(s);
            }      
        }
       
        
    }
    public static void input(String fileName){
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String data = sc.nextLine();
            }
        }catch(FileNotFoundException ex){
            System.out.println("ファイル"+ fileName + "は見つかりませんでした");
        }catch(InputMismatchException ex){
            System.out.println("入力内容が不適切です");
        }
    }
    public static String ntos(int x){
        String s = "";
          
            if(x==0) s.concat("a");
            else if(x==1) s.concat("b");
            else if(x==2) s.concat("c");
            else if(x==3) s.concat("d");
            else if(x==4) s.concat("e");
            else if(x==5) s.concat("f");
            else if(x==6) s.concat("g");
            else if(x==7) s.concat("h");
            else if(x==8) s.concat("i");
            else if(x==9) s.concat("j");
            else if(x==10) s.concat("k");
                     
        return s;
    }
    public static void cton(String str,int [] szlist, int [][][] bucket){
       boolean isNotWord = false;
       ArrayList<Integer> list = new ArrayList<Integer>();
       for(int i=0;i<str.length();i++){
           char x = str.charAt(i);
           int num = 0;
           boolean count = false;
           if(x=='A'||x=='a') num=0;
           else if(x=='B'||x=='b') num=1;
           else if(x=='C'||x=='c') num=2;
           else if(x=='D'||x=='d') num=3;
           else if(x=='E'||x=='e') num=4;
           else if(x=='F'||x=='f') num=5;
           else if(x=='G'||x=='g') num=6;
           else if(x=='H'||x=='h') num=7;
           else if(x=='I'||x=='i') num=8;
           else if(x=='J'||x=='j') num=9;
           else if(x=='K'||x=='k') num=10;
           else if(x=='L'||x=='l') num=11;
           else if(x=='M'||x=='m') num=12;
           else if(x=='N'||x=='n') num=13;
           else if(x=='O'||x=='o') num=14;
           else if(x=='P'||x=='p') num=15;
           else if(x=='Q'||x=='q') num=16;
           else if(x=='R'||x=='r') num=17;
           else if(x=='S'||x=='s') num=18;
           else if(x=='T'||x=='t') num=19;
           else if(x=='U'||x=='u') num=20;
           else if(x=='V'||x=='v') num=21;
           else if(x=='W'||x=='w') num=22;
           else if(x=='X'||x=='x') num=23;
           else if(x=='Y'||x=='y') num=24;
           else if(x=='Z'||x=='z') num=25;
           else if(x==' '||x==','||x=='.') {
               count = true;
               num = -1;
           }
           else isNotWord = true;
           list.add(num);
           if(i!=0&&count) {
               int bNum = list.get(0);
               int szNum = szlist[bNum];
               szlist[bNum]++;
               for(int j=0;j<list.size();j++){
                   bucket[bNum][szNum][j] = list.get(j);
               }              
           }
       }
    }
}
