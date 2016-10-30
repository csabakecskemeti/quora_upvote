import java.util.ArrayList;
import java.util.List;

/**
 * Created by kecso on 10/29/16.
 */
public class App {
    public static void main(String args[]) throws Exception {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println("-= Quora challenge: Upvote =-");
        List<Integer> votesArray = new ArrayList<Integer>();
        for (int i = 2; i < args.length; i++) {
            votesArray.add(Integer.parseInt(args[i]));
        }
        for (int r: Upvote.moveWindow(n, k, votesArray)) {
            System.out.println(r);
        }
    }
}
