/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author momon
 */
public class MyLectureTest {
    public static void main(String[] args) {
        Mylecture lecture = new Mylecture();
        String[] lines = lecture.readFile("mylecture.txt");
        if(lines != null){
            lecture.outputFile("mylecture.txt2",lines);
        }
        
    }
}
