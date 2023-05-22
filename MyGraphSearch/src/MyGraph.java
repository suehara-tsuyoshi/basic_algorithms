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

public class MyGraph {
    ArrayList< LinkedList<MyEdge>> nodes;
    LinkedList<MyEdge> list;
    int vNum;
     
     public MyGraph(){
         nodes = new ArrayList<LinkedList<MyEdge>>();
         vNum = this.vNum;
    }
        
    
    
    public void readFromFile(String fileName){
        
        int eNum,start,end,weight;
        
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            vNum = sc.nextInt();
            eNum = sc.nextInt();
            if(vNum>50||eNum>100){
                System.out.println("頂点または辺の数が不適切です");
                System.exit(0);
            }
            for(int i=0; i<vNum; i++){
                list = new LinkedList<MyEdge>();
                nodes.add(list);
            }
            while(sc.hasNext()){
                 start = sc.nextInt();
                 end = sc.nextInt();
                 weight = sc.nextInt();
                 if(weight<1||weight>1000){
                     System.out.println("枝の重さが不適切です");
                     System.exit(0);
                 }
                 
                 nodes.get(start).add(new MyEdge(start,end,weight));
                 nodes.get(end).add(new MyEdge(end,start,weight));
            }
        }catch(FileNotFoundException ex){
            System.out.println("ファイルの読み取りに失敗しました");
            System.exit(0);
        }catch(InputMismatchException ex){
            System.out.println("入力形式が不適切です");
            System.exit(0);
        }
    }
    public LinkedList<MyEdge> getEdges(int id){
        return nodes.get(id);
    }
     public void depthFirstSearch(int vs){
        LinkedList<Integer> A = new LinkedList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        int v;
        A.add(vs);
        while(A.size()!=0){
            v = A.pop();
            if(B.contains(v)==false){
                B.add(v);
            }
            for(int i=0; i<getEdges(v).size();i++){
                if(B.contains(getEdges(v).get(i).end)==false){
                    A.push(getEdges(v).get(i).end);
                }
            }
        }
        System.out.println("深さ優先探索");
        for(Integer num: B){
            System.out.println(num);
        }
    }
    public void breadthFirstSearch(int vs){
        LinkedList<Integer> A = new LinkedList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        int v;
        A.add(vs);
        while(A.size()!=0){
            v = A.pop();
            if(B.contains(v)==false){
                B.add(v);
            }
            for(int i=0; i<getEdges(v).size();i++){
                if(B.contains(getEdges(v).get(i).end)==false){
                    A.add(getEdges(v).get(i).end);
                }
            }
        }
        System.out.println("幅優先探索");
        for(Integer num: B){
            System.out.println(num);
        }
    }
}
