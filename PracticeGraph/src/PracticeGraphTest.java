
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class PracticeGraphTest {
    public static void main(String[] args){
        
        PracticeGraph g = new PracticeGraph();
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        int startPoint = sc.nextInt();
        int endPoint = sc.nextInt();
        int v = startPoint;
        boolean isOver = false;
        g.readFromFile(fileName);
        ArrayList<Integer> prev = new ArrayList<Integer>();
        ArrayList<Integer> distance = new ArrayList<Integer>();
        LinkedList<Integer> a = new LinkedList<Integer>();
        a.add(v);
        for(int i=0;i< g.vNum; i++){
            if(i==v){
                prev.add(10000);
            }else{
                    prev.add(0);
            }
        }
        for(int i=0;i< g.vNum; i++){
            if(i==startPoint){
                distance.add(0);
            }else{
                distance.add(10000);
            }
        }
        while(isOver==false){
            if(v == endPoint){
                output(v, prev,distance);
                isOver = true;
            }else{
                ArrayList<Integer> tArrayList = g.getT(v);
                for(int i=0; i<tArrayList.size(); i++){
                    int w = tArrayList.get(i);
                    if(distance.get(w)==10000){
                        distance.set(w,distance.get(v) + getWeight(g,v, w) );
                        prev.set(w, v);
                        addA(a,w,distance);
                    }else if(distance.get(w)>distance.get(v)+ getWeight(g,v, w)){
                        distance.set(w,distance.get(v) + getWeight(g,v, w) );
                        prev.set(w, v);
                    }
                   
                }     
                 v = a.pop();
            }
            
        } 
    }
    public static void addA(LinkedList<Integer> a, int w, ArrayList<Integer> distance){
        boolean isNotAdd = true;
        for(int i=0; i<a.size(); i++){
           if(distance.get(a.get(i))>distance.get(w)){
               a.add(i,w);
               isNotAdd = false;
               break;
           }
        }
        if(isNotAdd==true){
            a.add(w);
        }
    }
    public static void output(int v, ArrayList<Integer> prev,ArrayList<Integer> distance){
        LinkedList<Integer> list = new LinkedList<Integer>();
        int shortestDistance = distance.get(v);
        while(v<10000){
            list.push(v);
            v = prev.get(v);
        }
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+"\t");
        }
         System.out.print("\n"+ shortestDistance);
    }
    public static int getWeight(PracticeGraph g, int v,int w){
        LinkedList<PracticeEdge> list = g.getEdges(v);
        int getWeight = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).end == w){
                 getWeight = list.get(i).weight;
                 break;
            }
        }
        return getWeight;
    }
     
}

