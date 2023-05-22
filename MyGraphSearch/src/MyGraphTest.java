
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
public class MyGraphTest {
    public static void main(String[] args){
        
        MyGraph g = new MyGraph();
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        int inputNum = sc.nextInt();
        g.readFromFile(fileName);
        if(inputNum>=g.vNum){
            System.out.println("入力された頂点は存在しません");
            System.exit(0);
        }
        g.depthFirstSearch(inputNum);
        g.breadthFirstSearch(inputNum);
    }
}
