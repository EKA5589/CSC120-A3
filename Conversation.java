import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Conversation implements ConversationRequirements {
  // Attributes 
  ArrayList<String> usefulPhrases;
  ArrayList<String> inputPronoun;
  ArrayList<String> outputPronoun;
  static ArrayList<String> printableList;
  /**
   * Constructor 
   */
  public Conversation() {      //**Constructor*
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



          

  }

  public void helloWorld(){
        System.out.println ("Hello! What's up?");
        printableList.add("Hello! What's up?");
  }

  public int numRounds(){
    int rounds;
    System.out.println ("How many rounds would you like to chat for?");
    printableList.add("How many rounds would you like to chat for?");
    Scanner input = new Scanner(System.in);  
    rounds = input.nextInt();
        while(rounds<0||rounds>9){
          System.out.println ("Please enter less than 10 rounds and no negatives! :)");
          printableList.add ("Please enter less than 10 rounds and no negatives! :)");
          System.out.println ("How many rounds would you like to chat for?");
          printableList.add ("How many rounds would you like to chat for?");
          rounds = input.nextInt();
          printableList.add (Integer.toString(rounds));
          }
        
          
          return rounds;
  }
    
  public String respond(String inputString){
    return null;
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
      System.out.println(rounds); 
      //input.reset(); 
      
      for (int i = 0; i < rounds; i++) {
        Random random = new Random();
        int randomIndex = random.nextInt(usefulPhrases.size());
        String randomPhrase = usefulPhrases.get(randomIndex);
        printableList.add(randomPhrase);
        System.out.println (randomPhrase); 
        
        blabber = input.nextLine();
        printableList.add(blabber);
        
      }
      input.close();
      System.out.println (printableList);
          
    }
      
    

  /**
   * Prints transcript of conversation
   */
  // public void printTranscript() {

  

  
      
    
    // split(" "){
    //   String s = [];
    //   for (String word) {
    //         System.out.println(word);
    // }    // Split by space
      
    //     }
    

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */


  public void stringRespond(String inputString) {
    String returnString = ""; 
    ArrayList<String> listWords;
    
    listWords = new ArrayList<>();
    
    String[]words = inputString.split("[ ,.]");
    for (String returnWord : words){
      System.out.println (returnWord);
      listWords.add(returnWord);
      
    }
    //Why is this not wordResponding?
    for (int idx = 0; idx < listWords.size(); idx++) {
      System.out.println(listWords.get(idx));
      String input = listWords.get(idx);
      
      String word = this.wordRespond(input);
      this.wordRespond("you");


      returnString = String.join(" ", returnString, word);
      // System.out.println(returnString);
        
    }
     System.out.println(returnString+".");
     printableList.add(returnString+".");


  }

  public String wordRespond(String inputString){

    for (int idx = 0; idx < inputPronoun.size(); idx++) {
      if(inputString == inputPronoun.get(idx)){
        // System.out.println (outputPronoun.get(idx));
        return outputPronoun.get(idx);
      }
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
    myConversation.chat();
    // System.out.println (myConversation.wordRespond("you"));
    myConversation.stringRespond("you are kind.");
    System.out.println (printableList);
    // myConversation.printTranscript();

  }

}


