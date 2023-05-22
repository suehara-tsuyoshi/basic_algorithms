/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class PracticeEdge {
    int start;
    int end;
    int weight;
    public PracticeEdge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    public int getEnd(){
        return end;
    }
    public int getStart(){
        return start;
    }
    public int getWeight(){
        return weight;
    }
}
