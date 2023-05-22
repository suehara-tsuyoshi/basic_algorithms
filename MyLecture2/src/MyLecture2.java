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

public class MyLecture2 {
    
    //入出力ファイル名を受け取り、入力ファイルの内容を変換してファイルを作成するメソッド
    public void convert(String inputFileName, String outputFileName){
        
        //読み込んだテキストを格納するクラス
        ArrayList<String> listLines = new ArrayList<>();
        //各講義の開講時限を表す配列
        String[] tabs = {"Mo2","Mo5","Tu1","Tu2","We1","We2","We3","Th1","Th2","Th3","Th4","Fr3"};
        
        try{
            //ファイルを読み取るためのscannerオブジェクトを用意
            File inputFile = new File(inputFileName);
            Scanner sc = new Scanner(inputFile);
            //読み込める行がなくなるまで以下を繰り返す
            while(sc.hasNext()){
                String listLine = sc.next();
                listLines.add(listLine);
            }
            //ArrayList<String>をString[]の型に変換
            String[] lines = listLines.toArray(new String[0]);
            
            //出力ファイルに文字列を書き込むためのwriterオブジェクトを用意する
            File outputFile = new File(outputFileName);
            FileWriter writer = new FileWriter(outputFile);
            //与えられた文字列の行数分、以下を繰り返す
            for(int i=0; i<lines.length; i++){
                String tab = tabs[i];
                String line = lines[i];
                writer.write(tab + "\t" + line + "\n");
            }
            //出力ファイルを閉じる
            writer.close();
        }catch(IOException ex){
            //何らかの理由でファイルの出入力に問題が発生したとき、ここにとぶ
            System.out.println("エラーが発生しました");
        }
        
    }
}
