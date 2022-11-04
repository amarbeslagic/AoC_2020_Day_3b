import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_3b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> listOfStrings = new ArrayList<>();

        String s;
        //put Strings in array
        while ((s = br.readLine()) != null) {
            if (s.isBlank()) continue;

            listOfStrings.add(s);
        }

        int numOfTrees = 0;
        long sum = 1;
        int j = 3;

        for(int a=0; a<5; a++) {
            if(a == 0 || a == 4) j=1;
            if(a == 1) j=3;
            if(a == 2) j=5;
            if(a == 3) j=7;

            numOfTrees = 0;
            for (int i = 1; i < listOfStrings.size(); i++) {
                if(a == 4) i++;
                if (j > 30)
                    j -= 31;

                if (listOfStrings.get(i).charAt(j) == '#')
                    numOfTrees++;


                if(a == 0 || a == 4) j+=1;
                if(a == 1) j+=3;
                if(a == 2) j+=5;
                if(a == 3) j+=7;


            }
            System.out.println(numOfTrees);
            sum *= numOfTrees;
            System.out.println("-----------");
        }

        System.out.println(sum);
    }
}