import java.util.Arrays;
import java.util.Random;

public class GeneratePass {
    private final String smallLetters = "qwertyuiopasdfghjklzxcvbnm";
    private final String capitalLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final String numbers = "1234567890";
    private final String special = "@#$%^&*()_+-={[}]<.";
    private Random rand = new Random();

    private String PickElement(int quantity, String elementGroup){
        //Randomly choose characters according to user demands
        String result = "";
        for(int i = 0; i< quantity; i++){
            int position = rand.nextInt(elementGroup.length());
            result = result + elementGroup.charAt(position);
        }
        return result;
    }

    private String Shuffle(String inicial){
        //Shuffle the entered word, to match a password aspect
        String[] randonNum = new String[inicial.length()];
        for(int i = 0; i < randonNum.length; i++){
            randonNum[i] = "" + rand.nextInt(inicial.length()) + ";" + i;
        }
        Arrays.sort(randonNum);
        int pos;
        String shuffled = "";
        for(String j : randonNum){
            pos = Integer.parseInt(j.split(";")[1]);
            shuffled = shuffled + inicial.charAt(pos);
        }
        return shuffled;
    }

    public String GeneratePass(int qtdNumbers, int qtdSmallLetters, int qtdCapitalLetters, int qtdSpecialCaracters){
        //Execute the main objective of this class
        String pass = PickElement(qtdNumbers, numbers) + PickElement(qtdSmallLetters, smallLetters) + PickElement(qtdCapitalLetters, capitalLetters) + PickElement(qtdSpecialCaracters, special);
        pass = Shuffle(pass);
        return pass;
    }
}
