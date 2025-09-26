import java.util.ArrayList; // Import the ArrayList class
import java.util.List;

public class Chatbot {
    
    public void helloWorld(){
        System.out.println ("Hello! What's up?");
    }

    public int numRounds(int rounds){
        System.out.println ("How many rounds would you like to chat for?");
        if (rounds<0||rounds>9){
            System.out.println ("Please enter less than 10 rounds and no negatives! :)");
            return 0;
        }
        else {
                return rounds;
        }
    }



    public String selectPhrase(){
        List<String> phrases = newArrayList<>()
    }
}











//     System.out.println ("Hello! What's up? How many rounds would you like to chat for?");
//       for (int i = rounds; i < 10; i++) {
//         if (input.equals(" I ")||input.equals(" you ")||input.equals(" You ")||input.equals(" Me ")||input.equals(" me ")||input.equals("  ")){

// }
