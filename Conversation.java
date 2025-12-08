import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Conversation implements ConversationRequirements {
  // Attributes
  ArrayList<String> usefulPhrases;
  ArrayList<String> inputPronoun;
  ArrayList<String> outputPronoun;
  ArrayList<String> printableList;
  /**
   * Constructor
   */
  public Conversation(){      //**Constructor*
        printableList = new ArrayList<>();
        usefulPhrases = new ArrayList<>();
          usefulPhrases.add("Hi there!  What's on your mind?");
          usefulPhrases.add("I'm thinking about clouds.");
          usefulPhrases.add("That's so cool.");
          usefulPhrases.add("Yay!");
          usefulPhrases.add("Mhmm.");
        inputPronoun = new ArrayList<>();
          inputPronoun.add(0, "I");
          inputPronoun.add(1, "I");
          inputPronoun.add(2, "You");
          inputPronoun.add(3, "you");
          inputPronoun.add(4, "Me");
          inputPronoun.add(5, "me");
          inputPronoun.add(6, "am");
          inputPronoun.add(7,"My");
          inputPronoun.add(8, "my");
          inputPronoun.add(9, "Your");
          inputPronoun.add(10, "your");
          inputPronoun.add(11, "are");
          inputPronoun.add(12, "am");
          inputPronoun.add(13, "we");
          inputPronoun.add(14, "We");
        outputPronoun = new ArrayList<>();
          outputPronoun.add(0, "You");
          outputPronoun.add(1, "you");
          outputPronoun.add(2, "I");
          outputPronoun.add(3, "I");
          outputPronoun.add(4, "You");
          outputPronoun.add(5, "you");
          outputPronoun.add(6, "are");
          outputPronoun.add(7, "Your");
          outputPronoun.add(8, "your");
          outputPronoun.add(9, "My");
          outputPronoun.add(10, "your");
          outputPronoun.add(11, "am");
          outputPronoun.add(12,"are");
          outputPronoun.add(13, "you all");
          outputPronoun.add(14, "You all");

  }

/**Prints the opening hello message */
  public void helloWorld(){
        System.out.println ("Hello! What's up?");
        printableList.add("Hello! What's up?");
  }


/**
 * This questions the user on how many rounds they would like to chat for, checks that it is a positive numeric integer, and then if, so returns that number
 * @return int rounds This returns the number of rounds that the user will chat for
 */
  public int numRounds(){
    int rounds;
    
    System.out.println ("How many rounds would you like to chat for?");
    printableList.add("How many rounds would you like to chat for?");
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt()==false){
      input = new Scanner(System.in);
      System.out.println ("Please enter a valid integer. Use numeric characters");
    }
    rounds = 0;
    if (input.hasNextInt()){
      rounds = input.nextInt();
      while(rounds<0||rounds>9){
        System.out.println ("Please enter less than 10 rounds and no negatives! :)");
        printableList.add ("Please enter less than 10 rounds and no negatives! :)");
        System.out.println ("How many rounds would you like to chat for?");
        printableList.add ("How many rounds would you like to chat for?");
        rounds = input.nextInt();
      }
        String strNumber = Integer.toString(rounds);
        printableList.add (strNumber);
    }
    
    return rounds;
    
    
  }

  public void printTranscript(){
    System.out.println (printableList);
  }
    
  public String respond(String inputString){
    return stringRespond(inputString);
  } 
      
    
  


    // public String selectPhrase(){
    //     Scanner input = new Scanner(System.in);
    //     // for (String input : col) {
            
    //     // }
    // }

  /**
   * Starts and runs the conversation with the user
   */
    public void chat(){
      Scanner input = new Scanner(System.in);
      int rounds;
      String blabber;
      
      helloWorld();
      rounds = numRounds();
      // System.out.println(rounds);
      //input.reset();
      Random random = new Random();
      int randomIndex = random.nextInt(usefulPhrases.size());
      String randomPhrase = usefulPhrases.get(randomIndex);
      printableList.add(randomPhrase);
      System.out.println (randomPhrase);
      
      for (int i = 0; i < rounds-1; i++) {
        blabber = input.nextLine();
        printableList.add(blabber);
        // System.out.println(i);
        // System.out.println(stringRespond(blabber));
        // System.out.println(stringRespond(blabber));
        if (stringRespond(blabber).equals(blabber)){
          randomIndex = random.nextInt(usefulPhrases.size());
          randomPhrase = usefulPhrases.get(randomIndex);
          printableList.add(randomPhrase);
          System.out.println(randomPhrase);
        }else{
          System.out.println(stringRespond(blabber));
          printableList.add(stringRespond(blabber));
          
        }
        
        
      // }else{
      //   stringRespond(input.next());
      // }
      }
        blabber = input.nextLine();
        printableList.add(blabber);
        input.close();
        System.out.println (printableList);
          
    }
  
  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */


  public String stringRespond(String inputString) {
    String returnString = "";
    ArrayList<String> listWords;
    
    listWords = new ArrayList<>();
    
    String[]words = inputString.split("[ ,.?!]");
    for(String returnWord : words){
      // System.out.println ("return word:" + returnWord);
      listWords.add(returnWord);
    }
    for (int idx = 0; idx < listWords.size(); idx++) {
      // System.out.println("input:"+listWords.get(idx));
      // System.out.println("Index of List Words:"+idx);
      String input = listWords.get(idx);
      // System.out.println("input:"+input);

      String word = this.wordRespond(input);
      // System.out.println("word:"+word);
      //this.wordRespond("you");
      if(idx==0){
        returnString = String.join(returnString, word);
      }else{
        returnString = String.join(" ", returnString, word);
      }
      // System.out.println(returnString);
        
    }
    // System.out.println(returnString);
    // printableList.add(returnString+".");
    return returnString;
    


  }
  /**
   * This provides the mirrored/original form of a word, depending on whether that words should be mirrored or not
   * @param inputString This is the word to be mirrored/left alone
   * @return word This is the word that is returned after being mirrored
   */
  public String wordRespond(String inputString){

    for (int idx = 0; idx < inputPronoun.size(); idx++) {
      if(inputString.equals(inputPronoun.get(idx))){
        // System.out.println ("output pronoun:"+outputPronoun.get(idx));
        // System.out.println("Index of output pronoun" +idx);
        // System.out.println(inputPronoun.get(idx));
        return outputPronoun.get(idx);
      }
      // System.out.println("input pronoun index:"+idx);
      // System.out.println("hi");      
    }
    // System.out.println (inputString);
    return inputString;
      
  }
        
  // public void hasMirrorWord(String inString){
  //   ArrayList<String> newWords;
    
  //   newWords = new ArrayList<>();
    
  //   String[]options = inString.split("[ ,.]");
  //   for (String retWords : options){
      
        
  //     }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    // myConversation.numRounds();
    myConversation.chat();
    // System.out.println (myConversation.wordRespond("you"));
    myConversation.wordRespond("you");
    // // myConversation.stringRespond("I am kind and fun");
    // myConversation.stringRespond("how are you");
    // // myConversation.wordRespond("you");
    // // System.out.println(myConversation.wordRespond("we"));
    
    // // myConversation.stringRespond("you are kind.");
    // // System.out.println (printableList);
    // myConversation.printTranscript();
    // System.out.println(myConversation.stringRespond("You are kind"));
    
  }
}


