

/**
 * Needles
 */
public class Needles {

    
    public static void findNeedles(String haystack, String[] needles) {
        if (needles.length > 5) {
            System.err.println("Too many words!");
        } else {
            int[] countArray = new int[needles.length];
            for (int i = 0; i < needles.length; i++) {
                String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0);
                for (int j = 0; j < words.length; j++) {
                    if (words[j].compareTo(needles[i]) == 0) {
                        countArray[i]++;
                    }
                }
            }
            for (int j = 0; j < needles.length; j++) {
                System.out.println(needles[j] + ": " + countArray[j]);
            }
        }
    }

    public static void main(String[] args) {
        String input_string = "The quick brown fox jumps over the lazy dog and asked other fox to don't be lazy";
        String[] needles = { "fox", "dog", "lazy" };
        findNeedles(input_string, needles);
    }
    
}



// Output
// fox: 2
// dog: 1
// lazy: 2