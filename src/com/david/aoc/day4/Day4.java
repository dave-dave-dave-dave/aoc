package com.david.aoc.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Four four = new Four();
        String[] passports = four.inputToString("day4.txt");
        ArrayList<String> validPassports = new ArrayList<>();
        //part one
        int validCnt = 0;
        for (String passport : passports) {
            System.out.println(passport);
            if (four.validPassport(passport)) {
                System.out.println("valid!" + "\n--------");
                validPassports.add(passport);
                validCnt++;
            } else {
                System.out.println("invalid!" + "\n--------");
            }
        }
        System.out.println("Total valid passports: " + validCnt);

        //part two
        validCnt = 0;
        for(String passport : validPassports){
            HashMap<String, String> pp = four.stringToHashmap(passport);
            System.out.println(pp);
            if(four.hasValidFields(pp)){
                validCnt++;
                System.out.println("valid!");
            }
            System.out.println("---------");
        }
        System.out.println("Total valid passports with all-valid fields: " + validCnt);
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

    HashMap<String, String> stringToHashmap(String input) {
        HashMap<String, String> passport = new HashMap<>();
        //split the passport string blob on either space or new line
        String[] parts = input.split(" |\n");
        for (String part : parts) {
            String[] data = part.split(":");
            passport.put(data[0].trim(), data[1].trim());
        }
        return passport;
    }

    boolean hasValidFields(HashMap<String, String> passport) {
        return (isValidBirthYear(passport.get("byr")) &&
                isValidIssueYear(passport.get("iyr")) &&
                isValidExpirationYear(passport.get("eyr")) &&
                isValidHeight(passport.get("hgt")) &&
                isValidHairColor(passport.get("hcl")) &&
                isValidEyeColor(passport.get("ecl")) &&
                isValidPid(passport.get("pid")));
    }

    boolean isValidBirthYear(String value) {
        int by = Integer.parseInt(value);
        return (by >= 1920 && by <= 2002);
    }

    boolean isValidIssueYear(String value) {
        int iy = Integer.parseInt(value);
        return (iy >= 2010 && iy <= 2020);
    }

    boolean isValidExpirationYear(String value) {
        int ey = Integer.parseInt(value);
        return (ey >= 2020 && ey <= 2030);
    }

    boolean isValidHeight(String value) {
        if (value.contains("cm")) {
            int hgt = Integer.parseInt(value.substring(0, value.length() - 2));
            return (hgt >= 150 && hgt <= 193);
        } else if (value.contains("in")) {
            int hgt = Integer.parseInt(value.substring(0, value.length() - 2));
            return (hgt >= 59 && hgt <= 76);
        } else return false;
    }

    boolean isValidHairColor(String value) {
        return value.matches("^#[a-f0-9]{6}");
    }

    boolean isValidEyeColor(String value) {
        List<String> validColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        return validColors.contains(value);
    }

    boolean isValidPid(String value){
        return value.matches("[0-9]{9}");
    }
}


