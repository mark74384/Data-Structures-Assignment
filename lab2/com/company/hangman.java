package lab2.com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

import static java.lang.String.*;
// name : mark magdy nasr
// id : 18011304
public class hangman implements IHangman {
String [] words;
String [] dictionary;
private String ran;
private int max;
private int correctGuess;
char [] dashes;

    public void readfile() {
        try {
            Scanner input = new Scanner(new File("dictionary.txt"));
            int count =0;
            while (input.hasNextLine()){
                input.nextLine();
                count ++ ;
            }
            input.close();
            BufferedReader in = new BufferedReader(new FileReader("dictionary.txt"));
            String [] words = new String[count];
            String [] dictionary = new String[count];
            for (int i = 0 ; i < count ; i++){
                words[i] = in.readLine();
            }
            setDictionary(words);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setDictionary(String[] words) {
        this.dictionary = words;
    }

    @Override
    public String selectRandomSecretWord() {
        Random random = new Random();
        int randomIdx = random.nextInt(dictionary.length);
        if(dictionary[randomIdx] !=null){
            this.ran = dictionary[randomIdx];
            char [] dashes = new  char[ran.length()];
            int i =0;
            int correctGuess=0;
            while (i<ran.length()){
                dashes[i] = '-';
                if (ran.charAt(i)==' '){
                    dashes[i] = ' ';
                }
                i++;
            }
            this.dashes = dashes;
            return dictionary[randomIdx];}
        else
            return null;
    }



    @Override
    public String guess(Character c) throws Exception {
        ran = ran.toLowerCase(Locale.forLanguageTag(ran));
        if (isBuggyWord(ran)) {
            throw new Exception("Buggy word is chosen from dictionary");
        }
        if (c == null) {
            String string = new String(dashes);
            return string;
        }
        c = Character.toLowerCase(c);
        if (Character.isLowerCase(c)) {
            if (ran.contains(c + "")) {
                for (int j = 0; j < ran.length(); j++) {
                    if (ran.charAt(j) == c) {
                        if (dashes[j]!=c){
                        dashes[j] = c;}
                        else continue;
                        if (correctGuess!=ran.length()){
                        correctGuess++;
                    }}
                }
            } else
                if (max !=0){
                max--;}
        }
        else {
            throw new Exception("enter  character");
        }
        if (correctGuess==ran.length()){
            return null;
        }
        if (max == 0){
        return null;
    }
        String string = new String(dashes);
        return string;

    }

    @Override
    public void setMaxWrongGuesses(Integer max) {
        if (max == null) this.max = 1;
        else if (max >= 0) this.max = max;
    }

    private Boolean isBuggyWord(String ran) {
        for (int i = 0; i < ran.length(); i++) {
            if(!Character.isLetter(ran.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        hangman han = new hangman();
        //System.out.println(System.getProperty("user.dir"));
        han.readfile();
        han.selectRandomSecretWord();
        han.setMaxWrongGuesses(5);
        try {
            System.out.println(han.guess('a'));
            System.out.println(han.guess('c'));
            System.out.println(han.guess('z'));
            System.out.println(han.guess('d'));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}