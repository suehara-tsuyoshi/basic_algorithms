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
    ArrayList<LinkedList<MyEdge>> nodes;
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
                LinkedList<MyEdge> list = new LinkedList<MyEdge>();
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
    
    public void outputRes(int end,int[] pre,int [] dis){
        int num = end;
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.push(num);
        while(pre[num]<10000){
            list.push(pre[num]);
            num = pre[num];
        }
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+"\t");
        }
        System.out.println("\n"+ dis[end]+"\n");
        System.exit(0);
    }
    public void pathUpdate(int start,int end,int[] pre, int[] dis,LinkedList<Integer> a){
        init(dis, pre, start);
        while(true){
            int v = a.pop();
            if(v==end){
                outputRes(end, pre, dis);
            }
            int size = nodes.get(v).size();
            for(int i=0;i<size;i++){
                int w = nodes.get(v).get(i).end;
                int l = nodes.get(v).get(i).weight;
                if(dis[w]==10000){
                    dis[w] = dis[v]+l;
                    pre[w] = v;
                    a.add(w);
                }else if(dis[w]>dis[v]+l){
                    dis[w] = dis[v]+l;
                    pre[w] = v;
                }
            }
            sort(a, dis);
        }
    }
    public static void sort(LinkedList<Integer> linkedList,int[] dis){
        int startNum = linkedList.size()/2-1;
        int n = linkedList.size();
        for(int i=startNum;i>=0;i--){
            heap(linkedList,n,i,dis);
        }       
    }
    public static void heap(LinkedList<Integer> linkedList,int n,int parent,int[] dis){
        int minimum = parent;
        int left = 2*parent+1;
        int right = 2*parent+2;
        
        if(left<n&&dis[linkedList.get(left)]<dis[linkedList.get(minimum)]){
            minimum = left;
        }
        if(right<n&&dis[linkedList.get(right)]<dis[linkedList.get(minimum)]){
            minimum  = right;
        }
        if(minimum != parent){
            int swap = linkedList.get(parent);
            linkedList.set(parent, linkedList.get(minimum));
            linkedList.set(minimum, swap);
            heap(linkedList, n, minimum, dis);
        }
        
    }
    public void init(int[] dis,int[] pre,int start){
        for(int i=0;i< vNum; i++){
            pre[i] = 10000;
            if(i==start){
                dis[i] = 0;
            }else{
                dis[i] = 10000;
            }
        }
    }
}
