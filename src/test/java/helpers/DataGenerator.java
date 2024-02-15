package helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    // Number generators
    public static String generateFourteenNumber() {
        var faker = new Faker (new Locale("en"));
        String x = faker.numerify("##############");
        String z;
        if (x != "00000000000000") {
            z = x;
        } else {
            z = faker.numerify("##############");
        }
        return z;
    }

    // Month generators
    public static String generateMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String generateMonthPlus(int shift) {
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String generateMonthWithMinus(int negativeShift) {
        return LocalDate.now().minusMonths(negativeShift).format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String generateInvalidNumberForMonthField() {
        var number = new String[]{"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
                "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
                "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56",
                "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73",
                "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
                "91", "92", "93", "94", "95", "96", "97", "98", "99"
        };
        return number[new Random().nextInt(number.length)];
    }

    // Year generators
    public static String generateYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String generateYearPlus(int shift) {
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String generateYearPlusYears(int years){
        return LocalDate.now().plusYears(years).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateYearWithMinus(int negativeShift) {
        return LocalDate.now().minusMonths(negativeShift).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String generateYearMinusYears(int negativeYears){
        return LocalDate.now().minusYears(negativeYears).format(DateTimeFormatter.ofPattern("yy"));
    }

    // Name generators
    public static String generateValidName() {
        var faker = new Faker(new Locale("en-GB"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateRuName() {
        var faker = new Faker(new Locale("ru-RU"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateJapaneseName() {
        var faker = new Faker(new Locale("ja"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }
    public static String generateBothify() {
        var faker = new Faker (new Locale("en"));
        return faker.bothify("???######?????##%^");
    }
    public static String generateManyLetters() {
        var faker = new Faker (new Locale("en"));
        return faker.letterify("??????????????????????????????????????????????????????????????????????????????" +
                "???????????????????????????????????????????????????????????????????????????????????????????????????????" +
                "?????????????????????????????????????????????????????????????????????????");
    }
    public static String generateSingleLetter() {
        var faker = new Faker(new Locale("en"));
        return faker.letterify("?");
    }

    // CVC generators
    public static String generateTripleNumber(){
        var faker = new Faker (new Locale("en"));
        String x = faker.numerify("###");
        String z;
        if (x != "000") {
            z = x;
        } else {
            z = faker.numerify("###");
        }
        return z;
    }
    public static String generateDoubleNumber() {
        var faker = new Faker (new Locale("en"));
        String x = faker.numerify("##");
        String z;
        if (x != "00") {
            z = x;
        } else {
            z = faker.numerify("##");
        }
        return z;
    }

    // General data generators
    public static String generateLetters() {
        var faker = new Faker(new Locale("en"));
        return faker.letterify("???????");
    }

    public static String generateSingleNumber(){
        var faker = new Faker (new Locale("en"));
        String x = faker.numerify("#");
        String z;
        if (x != "0") {
            z = x;
        } else {
            z = faker.numerify("#");
        }
        return z;
    }
}