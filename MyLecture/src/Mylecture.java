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

public class Mylecture {
    
    public  String[] readFile(String intputFileName){
        
        ArrayList<String> lines = new ArrayList<>();
        
        try{
            File inputFile = new File(intputFileName);
            Scanner sc = new Scanner(inputFile);
            
            while(sc.hasNext()){
                String line = sc.next();
                lines.add(line);
                               
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("ファイル"+ intputFileName + "は見つかりませんでした");
            return null;
        }
        return lines.toArray(new String[0]);
    }
    
    public void outputFile(String outputFileName, String[] lines){
        
        try{
            File outputFile = new File(outputFileName);
            FileWriter writer = new FileWriter(outputFile);
            for(int i=0; i<lines.length; i++){
                String line = lines[i];
                int lineNum = i+1;
                writer.write(lineNum + "\t" + line + "\n");
            }
            writer.close();
            
        }catch(IOException ex){
            System.out.println("ファイルの書き込みに失敗しました。");
            
        }
        
        
    }
    
}
