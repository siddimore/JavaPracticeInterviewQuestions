/**
 * Created by MoreFamily on 5/6/2016.
 */
public class AddLargeString {

    private String s1;
    private String s2;

    public AddLargeString(String s1, String s2){
        this.s1 = new StringBuilder(s1).reverse().toString();
        this.s2 = new StringBuilder(s2).reverse().toString();
    }

    public String add() {

        int[] d = new int[s1.length() + 1];

        if (s1.length() > s2.length()) {

            for (int i = 0; i < s1.length(); i++) {
                d[i] = s1.charAt(i) - '0';
            }

            for (int j = 0; j < s2.length(); j++) {
                d[j] = d[j] + s2.charAt(j) - '0';
            }
        } else {

            for (int i = 0; i < s2.length(); i++) {
                d[i] = s2.charAt(i) - '0';
            }

            for (int j = 0; j < s1.length(); j++) {
                d[j] = d[j] + s1.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();

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
       AddLargeString aLS = new AddLargeString("3560","9");
       System.out.println("Addition: " + aLS.add());
   }
}
