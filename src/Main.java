import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int choosingValue(int leftValue,int rightValue) {
        int value = 1;
        boolean error;
        do {
            Scanner sc = new Scanner(System.in);
            error = false;
            try {
                value = sc.nextInt();
                if (value > rightValue || value < leftValue) {
                    System.out.println("Wrong number. Enter a number from "+leftValue+" to "+rightValue);
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error."+"Enter a number from "+leftValue+" to "+rightValue);
                error = true;
            }

        } while (error);
        return value;
    }

    static String enteringText() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    static String crypt(String[] words, int step) {
        char[] letters = new char[]{'à', 'á', 'â', 'ã', 'ä', 'å', '¸', 'æ', 'ç', 'è','é', 'ê', 'ë', 'ì', 'í', 'î', 'ï',
                'ð', 'ñ', 'ò', 'ó', 'â', 'õ', 'ö', '÷', 'ø', 'ù', 'ú', 'û', 'ü', 'ý', 'þ', 'ÿ'};
        char[] chars = new char[]{};

        String output="";
        for (int i = 0; i < words.length; i++) {
          chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < letters.length; k++) {

                  if (chars[j]== letters[k]) {

                  if (k + step >= letters.length) {
                      chars[j] = letters[step%2];
                  }else{
                      chars[j] = letters[k+step];
                  }

                    break;
                }
                }
            }
            for (int j = 0; j < chars.length; j++) {
                output+=chars[j];
            }
            output+=" ";
      }
        return output;
    }

    static String decrypt(String[] words, int step){
        char[] letters = new char[]{'à', 'á', 'â', 'ã', 'ä', 'å', '¸', 'æ', 'ç', 'è','é', 'ê', 'ë', 'ì', 'í', 'î', 'ï',
                'ð', 'ñ', 'ò', 'ó', 'â', 'õ', 'ö', '÷', 'ø', 'ù', 'ú', 'û', 'ü', 'ý', 'þ', 'ÿ'};
        char[] chars = new char[]{};
        String output="";

        for (int i = 0; i < words.length; i++) {
            chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < letters.length; k++) {
                    if (chars[j]== letters[k]) {

                        if (k - step < 0) {
                            chars[j] = letters[letters.length-(Math.abs(k-step))];
                        }else{
                            chars[j] = letters[k-step];
                        }
                        break;
                    }
                }
            }
            for (int j = 0; j < chars.length; j++) {
                output+=chars[j];
            }
            output+=" ";
        }
        return output;
    }

    public static void main(String[] args) {

        String text;
        int leftValue=1;
        int rightValue=10;
        System.out.println("Choose operation:");
        System.out.println("1-encrypt, 2-decrypt");
        int operation = choosingValue(1,2);
        int step = 1;
        System.out.println("Enter a step:");
        step = choosingValue(leftValue,rightValue);

        if (operation == 1) {
            System.out.println("Enter a text:");
            text = enteringText();
            String[] words = text.split(" ");
            System.out.println(crypt(words,step));
        } else {
            System.out.println("Enter a text:");
            text = enteringText();
            String[] words = text.split(" ");
            System.out.println(decrypt(words,step));
        }

    }
}
