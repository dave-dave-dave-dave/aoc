package com.david.aoc.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Day4 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Four four = new Four();
        String[] passports = four.inputToString("day4.txt");
        //part one
        int validCnt = 0;
        for (String passport : passports) {
            System.out.println(passport);
            if (four.validPassport(passport)) {
                System.out.println("valid!" + "\n--------");
                validCnt++;
            } else {
                System.out.println("invalid!" + "\n--------");
            }
        }
        System.out.println("Total valid passports: " + validCnt);


    }
}

class Four {

    String[] inputToString(String fileName) throws URISyntaxException, IOException {
        return Files.readString(Paths.get(ClassLoader.getSystemResource(fileName).toURI())).split("\r\n\r\n");
    }

    boolean validPassport(String input) {
        String[] criteria = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        return Arrays.stream(criteria).allMatch(input::contains);
    }

}
