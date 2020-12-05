package com.david.aoc.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        One one = new One();
        one.findSum(one.fileToArrayList("day1.txt"));
        one.findTripleSUm(one.fileToArrayList("day1.txt"));
    }
}

class One{

    int hit;
    int a;
    int b;
    int c;

    public One() {
    }

    public ArrayList<Integer> fileToArrayList(String fileName) throws URISyntaxException, IOException {
        ArrayList<Integer> output = new ArrayList<>();
        Files.readAllLines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))
                .forEach(x -> output.add(Integer.parseInt(x)));
        return output;
    }

    public int[] findSum(ArrayList<Integer> input){
        for(int i = 0; i < input.size(); i++){
            a = input.get(i);
            hit = 2020 - a;
            boolean present = input.stream()
                    .anyMatch(x -> x == hit);
            if(present){
                b = hit;
                System.out.printf("%d + %d = %d\n", a, b, a+b);
                System.out.printf("%d * %d = %d\n-----------\n", a, b, a*b);

                return new int[]{a, b};
            }
        }
        return null;
    }

    public int[] findTripleSUm(ArrayList<Integer> input){
        for(int i = 0 ; i < input.size(); i++){
            a = input.get(i);
            for(int j = 1; j < input.size(); j++){
                b = input.get(j);
                for(int k = 2; k < input.size(); k++){
                    c = input.get(k);
                    if(a + b + c == 2020){
                        System.out.printf("%d + %d + %d = %d\n", a, b, c, a+b+c);
                        System.out.printf("%d * %d * %d = %d\n-----------\n", a, b, c, a*b*c);
                        return new int[]{a, b, c};
                    }
                }
            }
        }
        return null;
    }

}
