package myCharpter2_5;

import java.util.Comparator;
//官方实现
//与练习2.5.1类似
public class California {
    public static final Comparator<String> CANDIDATE_ORDER = new CandidateComparator();

    private static class CandidateComparator implements Comparator<String> {
        private static String order = "RWQOJMVAHBSGZXNTCIEKUPDYFL";
        public int compare(String a, String b) {
            int n = Math.min(a.length(), b.length());
            for (int i = 0; i < n; i++) {
                int aindex = order.indexOf(a.charAt(i));
                int bindex = order.indexOf(b.charAt(i));
                if      (aindex < bindex) return -1;
                else if (aindex > bindex) return +1;
            }
            return a.length() - b.length();
        }
    }
}
