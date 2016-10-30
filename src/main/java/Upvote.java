import com.google.common.annotations.VisibleForTesting;

import java.util.List;

/**
 * Created by kecso on 10/29/16.
 */
public class Upvote {

    @VisibleForTesting
    protected static int subVote(List<Integer> votes) {
        int vl = votes.size();
        if (vl <= 1) {
            return 0;
        }
        boolean nonDecreasing = true;
        boolean nonIncreaseing = true;
        int prev = votes.get(0);
        for (int idx = 1; idx < vl; idx++) {
            if (nonDecreasing && votes.get(idx) <= prev) {
                nonDecreasing = false;
            }
            if (nonIncreaseing && votes.get(idx) > prev) {
                nonIncreaseing = false;
            }
            if (!nonDecreasing && !nonIncreaseing) {
                break;
            }
        }
        return (nonDecreasing ? 1 : 0) - (nonIncreaseing ? 1 : 0);
    }

    protected static int allSubRange(List<Integer> votesArray) {
        int vote = 0;
        int vl = votesArray.size();
        for (int srs = 2; srs <= vl; srs++) {
            int start = 0;
            int end = srs;
            while (end <= vl) {
                vote += subVote(votesArray.subList(start, end));
                start++;
                end++;
            }
        }
        return vote;
    }

    protected static int[] moveWindow(int allvotes, int window, List<Integer> allVotesArray) throws Exception {
        if (allvotes != allVotesArray.size()) {
            throw new Exception("Number of votes parameter: " + allvotes + " not equals " +
                                " with the number of elements: " + allVotesArray.size() +
                                " in the vote list");
        }
        if (allvotes < window) {
            throw new Exception("Number of votes: " + allvotes + " smaller than " +
                    "the window size: " + window);
        }
        int[] result = new int[(allvotes - window) + 1];
        int start = 0;
        int end = window;
        while (end <= allvotes) {
            result[start] = allSubRange(allVotesArray.subList(start, end));
            start++;
            end++;
        }
        return result;
    }
}
