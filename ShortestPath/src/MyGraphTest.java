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
    

public class MyGraphTest {
    
    public static void main(String[] args){
        MyGraph g = new MyGraph();
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        g.readFromFile(fileName);
        int startPoint = sc.nextInt();
        int endPoint = sc.nextInt();
        if(startPoint>=g.vNum||endPoint>=g.vNum){
            System.out.println("入力された頂点は存在しません");
            System.exit(0);
        }
        int[] distance = new int[g.vNum];
        int[] prev = new int[g.vNum];
        LinkedList<Integer> a = new LinkedList<Integer>();
        a.add(startPoint);
        g.pathUpdate(startPoint,endPoint, prev, distance, a);   
    }
}
    

