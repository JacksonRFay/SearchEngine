import java.util.*;


public class App {
    public static void main(String[] args) {
        
        String userInput = introductionMessage();
        //Process userInput word by word.
        Set<String> words = processInput(userInput);
        System.out.println("Words " + words);
        //compare each word
        Set<String> nouns = extractNouns(words);
        System.out.println("Nouns: " + nouns);
    }

    //Prints out the prompt for input, returns userInput.
    public static String introductionMessage() {
        System.out.println("This is a demo search engine algorithm");
        System.out.println("What are you searching for?");

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        return userInput;
    }

    //This method will take in a String (userInput) and return a set
    //that is sorted by alphabet. (With no douplicates)
    public static Set<String> processInput(String userInput) {
        Set<String> words = new TreeSet<>();
        String[] wordsArr = userInput.split(" ");

        for (String s : wordsArr) {
            words.add(s);
        }
        return words;
    }

    //Current noun extractor, can derive better results from external libraries.
    //Checks to see if the word ends with s and declares it a noun.
    //returns a set of nouns.
    public static Set<String> extractNouns(Set<String> wordSet) {
        Set<String> nouns = new HashSet<>();
        for (String word : wordSet) {
          // Convert the word to lowercase for easier comparison
          String lowerCaseWord = word.toLowerCase();
          
          // Check if the word is a noun by checking if it ends with "s"
          if (lowerCaseWord.endsWith("s")) {
            // Remove the "s" from the end of the word to get the singular form
            String singularForm = lowerCaseWord.substring(0, lowerCaseWord.length() - 1);
            // Add the singular form of the word to the noun set
            nouns.add(singularForm);
          }
        }
    
        return nouns;
      }
}