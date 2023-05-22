
import java.io.File;
import java.io.FileNotFoundException;
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
public class PracticeGraph {
    
    ArrayList< LinkedList<PracticeEdge>> nodes;
    LinkedList<PracticeEdge> list;
    int vNum,eNum,start,end,weight;
     
     public PracticeGraph(){
         nodes = new ArrayList<LinkedList<PracticeEdge>>();
         
    }
        
    
    
    public void readFromFile(String fileName){
        
        
        
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            vNum = sc.nextInt();
            eNum = sc.nextInt();
            for(int i=0; i<vNum; i++){
                list = new LinkedList<PracticeEdge>();
                nodes.add(list);
            }
            while(sc.hasNext()){
                 start = sc.nextInt();
                 end = sc.nextInt();
                 weight = sc.nextInt();
                
                 
                 nodes.get(start).add(new PracticeEdge(start,end,weight));
                 nodes.get(end).add(new PracticeEdge(end,start,weight));
            }
        }catch(FileNotFoundException ex){
            System.out.println("ファイルの読み取りに失敗しました");
        }
    }
    public LinkedList<PracticeEdge> getEdges(int id){
        return nodes.get(id);
    }
    public ArrayList<Integer> getT(int id){
         ArrayList<Integer> t = new ArrayList<Integer>();
         
         for(int i=0;i<getEdges(id).size();i++){
             t.add(getEdges(id).get(i).end);
         }
         return t;
    }
    
}
