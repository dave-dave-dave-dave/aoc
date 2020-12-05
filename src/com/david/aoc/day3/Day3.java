package com.david.aoc.day3;

import com.david.aoc.day2.Two;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Two two = new Two();
        Three three = new Three();
        List<String> input = two.fileToArray("day3.txt");
        //part one
        three.rideTheSlopes(input, 1, 3);
        three.allTheTrees.clear();
        System.out.println("--------------------");

        //part two
        three.rideTheSlopes(input, 1, 1);
        three.rideTheSlopes(input, 1, 3);
        three.rideTheSlopes(input, 1, 5);
        three.rideTheSlopes(input, 1, 7);
        three.rideTheSlopes(input, 2, 1);
        System.out.println("Total trees: " + three.addAllTheTrees());
        System.out.println("Total trees multiplied: " + three.multiplyAllTheTrees());
    }

}

class Three {
    ArrayList<Integer> allTheTrees = new ArrayList<>();

    int getLineCount(List<String> input) {
        return input.size();
    }

    boolean isItATree(String input, int pos) {
        return input.charAt(pos) == '#';
    }

    void rideTheSlopes(List<String> input, int vertical, int horizontal) {
        int trees = 0;
        int pos = 0;
        int n = getLineCount(input);


        for (int i = 0; i < n; i += vertical) {
            if (isItATree(input.get(i), pos)) {
                trees++;
            }
            //slide right
            pos = (pos + horizontal) % 31;
        }
        allTheTrees.add(trees);
        System.out.println("Trees encoutered: " + trees);
    }

    int addAllTheTrees() {
        return allTheTrees.stream().reduce(0, Integer::sum);
    }

    BigInteger multiplyAllTheTrees() {
        return allTheTrees.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
