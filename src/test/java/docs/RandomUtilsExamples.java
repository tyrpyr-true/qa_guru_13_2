package docs;

import static utils.RandomUtils.*;

public class RandomUtilsExamples {
    public static void main(String[] args) {
        String[] p1= new String[3];
        String[] p2= new String[2];
        String[] p3= new String[2];
        p1=getRandomDateOfBirth();
        p2=getRandomSubject();
        p3=getRandomStateCity();
        System.out.println("Random string 10: " + getRandomString(10));
        System.out.println("Random gender: " + getRandomGender());
        System.out.println("Random phone: " + getRandomPhone());
        System.out.println("Random date: " + p1[0]+" "+p1[1]+" "+p1[2]);
        System.out.println("Random letter: " + getRandomLetter());
        System.out.println("Random Subject: " + p2[0]+" "+p2[1]);
        System.out.println("Random hobby: " + getRandomHobby());
        System.out.println("Random address: " + getRandomMessage(10,30));
        System.out.println("Random address: " +  p3[0]+" "+p3[1]);
    }
}
