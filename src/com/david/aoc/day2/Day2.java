package com.david.aoc.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Two two = new Two();
        List<String> input = two.fileToArray("day2.txt");
        int validPws = 0;
        int validPws2 = 0;
        for (String item : input) {
            System.out.println(item);
            two.getMinMax(item);
            two.getLetter(item);
            two.getLetterCount(item);
            if (two.isValidPassword()) {
                validPws++;
                System.out.println("Part 1: valid!");
            }
            if (two.isValidPasswordPartTwo(item)) {
                validPws2++;
                System.out.println("Part 2: valid!");
            }
            System.out.println("-----------");
        }
        System.out.println("Valid passwords part 1: " + validPws);
        System.out.println("Valid passwords part 2: " + validPws2);
    }
}

