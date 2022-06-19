package utils;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static String emailDomain = "@qa.guru";

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomMessage(int min, int max) {
        String[] words = {"and", "or", "but", "because",
                "red", "white", "Jane", "John", "Bobby",
                "man", "woman", "fish", "elephant", "unicorn",
                "a", "the", "every", "some", "any", "all",
                "big", "tiny", "pretty", "bald", "small",
                "runs", "jumps", "talks", "sleeps", "walks",
                "loves", "hates", "sees", "knows", "looks for", "finds",
                ", ", ", ", ", ", ". ", ". "};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length - 1);
            message.append(words[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L) + "";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomEmail() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        return getRandomString(5) + timestamp + emailDomain;
    }

    public static String getRandomGender() {

        String result = "";
        Random rnd = new Random();
        int index = (int) (rnd.nextFloat() * 10);
        if (index>5) {
        result="Male";
        }
        else if(index<5){
            result="Female";
        }
        else if(index==5){
            result="Other";
        }

        return result;
    }

    public static String[] getRandomDateOfBirth() {

        String[] result = new String[3];
        String res0;
        long leftLimit = 0L; // 01/01/1970, 00:00
        long rightLimit = Instant.now().toEpochMilli(); // now
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        var randomDate = Instant.ofEpochMilli(generatedLong);
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
                        .withZone( ZoneId.systemDefault() );
        res0=formatter.format( randomDate );
        result[0]=res0.substring(0,2);
        String a=res0.substring(3,5);
        if (a.equals("01")) {
            result[1] = "January";
        }
        else if (a.equals("02")) {
            result[1] = "February";
        }
        else if (a.equals("03")) {
            result[1] = "March";
        }
        else if (a.equals("04")) {
            result[1] = "April";
        }
        else if (a.equals("05")) {
            result[1] = "May";
        }
        else if (a.equals("06")) {
            result[1] = "June";
        }
        else if (a.equals("07")) {
            result[1] = "July";
        }
        else if (a.equals("08")) {
            result[1] = "August";
        }
        else if (a.equals("09")) {
            result[1] = "September";
        }
        else if (a.equals("10")) {
            result[1] = "October";
        }
        else if (a.equals("11")) {
            result[1] = "November";
        }
        else if (a.equals("12")) {
            result[1] = "December";
        }
        else {result[1]=res0.substring(3,5);}

        result[2]=res0.substring(6,10);
        return result;
    }


    public static String getRandomLetter() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < 1) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String[] getRandomSubject() {
        String[] res = new String[2];
        String SALTCHARS = "ABCEHMPS";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < 1) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        res[0]=result.toString();
        switch(res[0]){
            case ("A"):res[1]="Arts";
                break;
            case ("B"):res[1]="Biology";
                break;
            case ("C"):res[1]="Computer Science";
                break;
            case ("E"):res[1]="English";
                break;
            case ("H"):res[1]="Hindi";
                break;
            case ("M"):res[1]="Maths";
                break;
            case ("P"):res[1]="Physics";
                break;
            case ("S"):res[1]="Social Studies";
                break;
        }

        return res;
    }

    public static String getRandomHobby() {

        String result = "";
        Random rnd = new Random();
        int index = (int) (rnd.nextFloat() * 100);
        if (index<34 && index>=0) {
            result="Sports";
        }
        else if(index<66 && index>=34){
            result="Reading";
        }
        else {
            result="Music";
        }

        return result;
    }

    public static String[] getRandomStateCity() {

        String[] res = new String[2];
        Random rnd = new Random();
        int index = (int) (rnd.nextFloat() * 100);

        if (index<10 && index>=0) {
            res[0]="NCR";
            res[1]="Delhi";
        }
        else if(index<20 && index>=10){
            res[0]="NCR";
            res[1]="Gurgaon";
        }
        else if(index<30 && index>=20){
            res[0]="NCR";
            res[1]="Noida";
        }
        else if(index<40 && index>=30){
            res[0]="Uttar Pradesh";
            res[1]="Agra";
        }
        else if(index<50 && index>=40){
            res[0]="Uttar Pradesh";
            res[1]="Lucknow";
        }
        else if(index<60 && index>=50){
            res[0]="Uttar Pradesh";
            res[1]="Merrut";
        }
        else if(index<70 && index>=60){
            res[0]="Haryana";
            res[1]="Karnal";
        }
        else if(index<80 && index>=70){
            res[0]="Haryana";
            res[1]="Panipat";
        }
        else if(index<90 && index>=80){
            res[0]="Rajasthan";
            res[1]="Jaipur";
        }
        else if(index<100 && index>=90){
            res[0]="NCRajasthanR";
            res[1]="Jaiselmer";
        }

        return res;
    }

}