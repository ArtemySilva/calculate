import java.util.Scanner;

public class Main {

    public static String calc(String input) throws Exception {

        String [] inputArr = input.split(" ", 3);
        int firstNum = 0;
        int secondNum = 0;
        char oper = inputArr[1].charAt(0);
        int inputArrLength = inputArr.length;
        if (inputArrLength != 3){
            throw new Exception();
        }

        if ((chekAvaArabic(inputArr[0])) == true && chekAvaArabic(inputArr[2]) == true){
            firstNum = Integer.parseInt(inputArr[0]);
            secondNum = Integer.parseInt((inputArr[2]));
            input = String.valueOf((calculate(firstNum, secondNum, oper)));
        }else if ((chekAvaRoman(inputArr[0])) == true && chekAvaRoman(inputArr[2]) == true){
            firstNum = romanToArabic(inputArr[0]);
            secondNum = romanToArabic(inputArr[2]);
            int chekNegativeRoman = calculate(firstNum, secondNum, oper);
            if(chekNegativeRoman <= 0){
                throw new Exception();
            }else {
                input = String.valueOf(arabicToRoman(chekNegativeRoman));
            }
        }else {
            throw new Exception();
        }

        return input;

    }

    public static boolean chekAvaArabic(String a){
        String [] arabicNumArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String str: arabicNumArr){
            if(a.equals(str)){
                return true;
            }
        }
        return false;
    }

    public static boolean chekAvaRoman(String a){
        String [] romanNumArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String str: romanNumArr){
            if(a.equals(str)){
                return true;
            }
        }
        return false;
    }

    public static int getArabic(char roman){
        if ('I' == roman) return 1;
        else if ('V' == roman) return 5;
        else if ('X' == roman) return 10;
        else if('L' == roman) return 50;
        else if('C' == roman) return 100;
        return 0;
    }

    public static int romanToArabic(String a){
        int end = a.length()-1;
        char [] arr = a.toCharArray();
        int arabic;
        int result = getArabic(arr[end]);
        for(int i = end - 1; i>=0; i--){
            arabic = getArabic(arr[i]);
            if (arabic < getArabic(arr[i + 1])){
                result -= arabic;
            } else {
                result += arabic;
            }
        }
        return result;
    }

    public static String arabicToRoman(int arabic){
        String s = "";
        while (arabic >= 500){
            s += "D";
            arabic -= 500;
        }
        while (arabic >= 100){
            s += "C";
            arabic -= 100;
        }
        while (arabic >= 90){
            s += "XC";
            arabic -= 90;
        }
        while (arabic >= 50){
            s += "L";
            arabic -= 50;
        }
        while (arabic >= 40){
            s += "XL";
            arabic -= 40;
        }
        while (arabic >= 10){
            s += "X";
            arabic -= 10;
        }
        while (arabic >= 9){
            s += "IX";
            arabic -= 9;
        }
        while (arabic >= 5){
            s += "V";
            arabic -= 5;
        }
        while (arabic >= 4){
            s += "IV";
            arabic -= 4;
        }
        while (arabic >= 1){
            s += "I";
            arabic -= 1;
        }
        return s;
    }


    public static void main(String[] args) throws Exception {

        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Output:");
        System.out.println(calc(input));

    }

    public static int calculate(int a, int b, char oper) throws Exception {
        int c = 0;
        switch (oper) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a - b;
                break;
            case '*':
                c = a * b;
                break;
            case '/':
                c = a / b;
                break;
            default:
                throw new Exception();
        }
        return c;
    }
}

   
