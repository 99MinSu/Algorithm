import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for(int i=0; i<test_case; i++)
        {
            long number = Long.parseLong(br.readLine());
            BigInteger next_Prime_number  = new BigInteger(String.valueOf(number));

            if(next_Prime_number.isProbablePrime(10))
            {
                System.out.println(next_Prime_number);
            }
            else
            {
                System.out.println(next_Prime_number.nextProbablePrime());
            }
        }
    }
}