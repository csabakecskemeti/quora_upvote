# quora_upvote
This repository contains a java solution for the Quora Upvotes (https://www.quora.com/challenges#upvotes) challenge.
## Call the solution
java -jar target/upvote-1.0-SNAPSHOT.jar N K vote1 vote2 ... voteN
N - number of all votes
K - window size 

example:
java -jar target/upvote-1.0-SNAPSHOT.jar 5 3 1 2 3 1 1

## Note
I belive that the example on the challenge description is wrong:
"For the third window of [3, 1, 1], there is 1 non-decreasing subrange and 3 non-increasing, so the answer is -2."
As the non-decreasing subrange is defined as: "A non-decreasing subrange is defined as a contiguous range of indices [a,b], a < b, where each element is at least as large as the previous element."
Neigther or the subranges [3, 1, 1], [3, 1], [1, 1] fullfill this criteria.
So I belive that the right result for the example is 3, 0, -3.
