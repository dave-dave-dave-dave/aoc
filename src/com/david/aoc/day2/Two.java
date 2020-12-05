package com.david.aoc.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Two {

    int min;
    int max;
    char letter;
    long count;
    boolean isValid;

    public List<String> fileToArray(String fileName) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
    }

    void getMinMax(String line) {
        //remove everything but the integers, add those to an array
        line = line.replaceAll("[^\\d]", " ").strip();
        String[] minmax = line.split(" ");
        min = Integer.parseInt(minmax[0]);
        max = Integer.parseInt(minmax[1]);
    }

    void getLetter(String line) {
        letter = line.charAt(line.indexOf(":") - 1);
    }

    void getLetterCount(String line) {
        //-1 cause the letter itself shouldn't be counted
        count = line.chars().filter(ch -> ch == letter).count() - 1;
    }

    boolean isValidPassword() {
        return isValid = count >= min && count <= max;
    }

    boolean isValidPasswordPartTwo(String line) {
        String pw = line.substring(line.indexOf(":"));
        int iNeedToBeOne = 0;
        //+1 cause index starts at 0
        if (pw.charAt(min + 1) == letter) {
            iNeedToBeOne++;
        }
        if (pw.charAt(max + 1) == letter) {
            iNeedToBeOne++;
        }
        return iNeedToBeOne == 1;
    }
}
