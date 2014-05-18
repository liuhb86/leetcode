import java.math.BigInteger;
public class Solution {
    public String multiply(String num1, String num2) {
        BigInteger Num1 = new BigInteger(num1);
        BigInteger Num2 = new BigInteger(num2);
        Num1 = Num1.multiply(Num2);
        return Num1.toString();
    }
}