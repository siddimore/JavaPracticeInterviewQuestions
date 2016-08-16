/**
 * Created by MoreFamily on 5/5/2016.
 */
public class multiplyLargeInteger {

    private String s1;
    private String s2;

    public multiplyLargeInteger(String a, String b){
        s1 = new StringBuilder(a).reverse().toString();
        s2 = new StringBuilder(b).reverse().toString();

    }

    public String multiply() {

        int[] d = new int[s1.length() + s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                d[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();

        //calculate each digit

        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length)
                d[i + 1] += carry;
            sb.insert(0, mod);
        }

        //remove front 0's
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
    public static void main(String[] args){
        multiplyLargeInteger mL = new multiplyLargeInteger("2000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000","200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println("Product: " + mL.multiply());
    }
}
