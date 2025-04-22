package SeleniumInterviewQuestions;

import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.Subtraction;
import org.testng.annotations.Test;
import stringExamples.OccuranceOfEachElement;

import javax.swing.text.DateFormatter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JavaInterviewQuestions {

    public static void main(String[] args) {
        //String = “Iam an SDET student, also an QA”, get output as “ Iam = 1, an =2, SDET =1 , Student =1, also =1 , QA =1”.
        String str = "Iam an SDET student, also an QA";
        String words[] = str.split(" ");
        Map<String, Integer> mapCount = new HashMap<String, Integer>();
        for (String word : words) {
            if (mapCount.containsKey(word)) {
                mapCount.put(word, mapCount.get(word) + 1);
            } else {
                mapCount.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : mapCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @Test
    public void VerifySumOfTwoValuesAsATargetOutput() {
        int[] arr = {10, 12, 15, 2, 17, 7, 5};
        int Target = 17;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] + arr[j] == Target) {
                    System.out.println("Target sum of digits are:" + arr[i] + " " + arr[j] + "Index of numbers are" + i + j);
                }
            }
        }
    }

    @Test(priority = 1)
    public void ReverseCurrentTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formateString = time.format(Formatter);

        String reverseTime = new StringBuffer(formateString).reverse().toString();
        System.out.println(reverseTime);


    }

    @Test
    public void DuplicateValuesInArray() {
        String[] S1 = {"Drive", "QA", "SDET", "QA", "Testing"};
        List<String> l1 = new ArrayList<String>(Arrays.asList(S1));
        List<String> l2 = new ArrayList<>();
        for (String word : l1) {
            if (l2.contains(word)) {
                System.out.println("Duplicate words are:" + word);
            } else {
                l2.add(word);
            }
        }
        //unique
        Set<String> set = new HashSet<String>(l1);
        List<String> unique = new ArrayList<>(set);
        for (String words : unique) {
            System.out.println("Unique words are" + words);
        }
    }

    @Test
    public void ReplaceletterInaString() {
        String S1 = "Java is Programming language";
        String S2 = S1.replaceAll("a", "@");
        System.out.println(S2);
    }

    @Test
    public void AutoGenerateUsernameAndPassword() {
        String username = "user" + UUID.randomUUID().toString().substring(0, 8);
        String password = "passw" + UUID.randomUUID().toString().substring(0, 6);
        System.out.println(username);
        System.out.println(password);

    }

    @Test
    public void RemoveVowelsOnString() {
        String S1 = "Java is Programming language";
        String StringWithoutVowels = S1.replaceAll("(?i)[aeiou]", "");
        System.out.println(StringWithoutVowels);
    }

    @Test
    public void ReverseAnArray() {
        int[] arr = {10, 20, 30, 40, 50};

        for (int i = arr.length - 1; i >= 0; i--) {
            //int[] rev = Arrays.stream(arr).toArray();
            System.out.print(arr[i] + " ");
        }

    }

    @Test
    public void reverseAString() {
        String S1 = "JavaProgramming";
        char[] c = S1.toCharArray();
        String rev = " ";
        for (int i = c.length - 1; i >= 0; i--) {
            rev = rev + c[i];
        }
        System.out.println(rev.toString());
    }

    @Test
    public void reverseStringUsingBuffter() {
        String S1 = "Priyanka Singaladevi";
        // StringBuffer Sb = new StringBuffer(S1);
        String rev = new StringBuffer(S1).reverse().toString();
        System.out.println(rev);
    }

    @Test
    public void reverseStringUsingBuilder() {
        String S1 = "Priyanka Singaladevi";
        StringBuilder sb = new StringBuilder(S1).reverse();
        System.out.println(sb);
    }

    @Test
    public void swapTwoStrings() {
        String S1 = "Karthik";
        String S2 = "Priyanka";
        S1 = S1 + S2;
        S2 = S1.substring(0, S1.length() - S2.length());
        S1 = S1.substring(S2.length());
        System.out.println(S1 + S2);
    }

    @Test
    public void SwapTwoIntegers() {
        int n1 = 10;
        int n2 = 9;
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;
        System.out.print(n1 + " ");
        System.out.println(n2);
    }

    @Test
    public void SwapTwoIntergersWithTemp() {
        int n1 = 10;
        int n2 = 9;
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println(n1 + " " + n2);

    }

    @Test
    public void SumOfArrayElements() {
        int[] a = {10, 30, 40, 60, 90};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        System.out.println(sum);
    }

    @Test
    public void MaxDifferenceBetweenAdjecentNumbers() {
        int[] i = {10, 20, 40, 50, 42};
        int diff = 0;
        for (int j = 0; j <= i.length - 1; j++) {
            if (i[j + 1] - i[j] > diff) {
                diff = i[j + 1] - i[j];
            }

        }
        System.out.println(diff);
    }

    @Test
    public void printAlternativeNumbers() {
        int[] a = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < a.length; i += 2) {
            System.out.println(a[i]);
        }
    }

    @Test
    public void printRightAngleTriangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");

        }

    }

    @Test
    public void pyramid() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= (5 - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (i * 2 - 1); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    @Test
    public void ReverseANumber() {
        int a = 543;
        int reverse = 0;
        while (a != 0) {
            int digit = a % 10;
            reverse = digit + reverse * 10;
            a = a / 10;
        }
        System.out.println(reverse);
    }

    @Test
    public void PrimeNumber() {
        int n = 10;

        for (int i = 2; i <= 50; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(i + " ");
            }
        }
    }

    @Test
    public void fibnocci() {
        ////0, 1,1, 2 3 5 8 13 21 34
        int i = 0;
        int j = 1;
        int n = 1;
        int sum = 0;
        while (n < 10) {

            sum = i + j;
            System.out.print(sum + " ");
            i = j;
            j = sum;
            n++;

        }

    }

    @Test
    public void stringOccurrenceInWord() {
        String word = "aaaafjhdjfh";
        char ch = 'a';
        int count = 0;
        for (int i = 0; i <= word.length() - 1; i++) {
            if (word.charAt(i) == ch) {
                count++;
            }

        }
        System.out.println(count);
    }

    @Test
    public void listOfCommonElementsInArrays() {
        int[] a1 = {10, 20, 30, 40};
        int[] a2 = {20, 30, 10, 50};
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i <= a1.length-1; i++) {
            for (int j = 0; j <= a2.length - 1; j++) {
                if (a1[i] == a2[j]) {
                    al.add(a1[i]);
                }
            }
        }
            for(Integer c: al){  // calling class objects using wrapper class Integer
                System.out.print(c + " ");
            }

    }
    @Test
    public void sortAnArray(){
        int[] a1 = {1,9,8,3,4,2,53,78};
        int temp ;
        for(int i=0; i<= a1.length-1; i++){
            for(int j= i+1; j<= a1.length-1; j++){
               if(a1[i]>a1[j]){

                   temp = a1[i];
                   a1[i]= a1[j];
                   a1[j] = temp;

               }

            }
            System.out.println(a1[i]); // sorting in ascending order
        }
        for(int k= a1.length-1; k>=0; k--){
            System.out.print(a1[k]+ " "); // sorting in descending order
        }
    }
    @Test
    public void largestTwoNumbersInAnArray(){
        int[] a1 = {10, 20, 60, 40, 70};
        int larg = 0;
        for(int i = 0; i<= a1.length-1; i++){
            for(int j=i+1; j<=a1.length-1; j++){
                if(a1[i]>a1[j]){
                        larg = a1[i];
                }

            }
            System.out.print(larg);

        }
    }
    @Test
    public void DuplicateCharacters(){
        String str = "programming";
        HashSet<Character> seen = new HashSet<>();
        HashSet<Character> duplicate = new HashSet<>();
        for(char c : str.toCharArray()){
            if (!seen.add(c)) {
                duplicate.add(c);
            }

        }
        System.out.println(duplicate);
    }
    @Test
    public void DuplicateCharactersUsingString(){
        String str = "Programming";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        for(int i=0; i<=ch.length-1; i++){
            if(ch[i]==ch[i]+1){
                System.out.println(ch[i]+ " ");
            }
    }
    }
    @Test
    public void DuplicateCharacterWithCount(){
        String str = "Java is a Programming language";
        Map<Character, Integer> mapCount = new HashMap<>();
        for(char word : str.toCharArray()){
            if(mapCount.containsKey(word)){
                mapCount.put(word, mapCount.get(word)+1);

            }else {
                mapCount.put(word,1);
            }

        }
        for(Map.Entry<Character, Integer> entry: mapCount.entrySet()){
            System.out.print(entry.getKey() + entry.getValue());
        }
    }
    @Test
    public void expandEncodedString(){
        String str = "a2b3c4";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<=str.length()-1; i+=2){
            char ch = str.charAt(i);
            int count = Character.getNumericValue(str.charAt(i)+1);
            for(int j =0; j<count; j++){
                sb.append(ch);

            }

        }
        System.out.print(sb);

    }
    @Test
    public void mostRepetativeElement(){
        String str = "Programming";
        int max = 0;
        char mostRepetative;
        HashMap<Character, Integer> mapCount = new HashMap<>();
        for(char c : str.toCharArray()){
            if(mapCount.containsKey(c)){
               mapCount.put(c, mapCount.get(c)+1);
               if(mapCount.get(c)>max){
                   max = mapCount.get(c);
                   //mostRepetative = c;
               }
                System.out.print(max + c);
            }

        }

    }
}



