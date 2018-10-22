package tasks.hackerrank.simplelogic;

/**
 * Name: Drawing Book. From: hackerrank.com. Date: 20.10.2018
 * <p>
 * We have a book with pages going like: 1 <--> (2, 3) <--> (4, 5) <--> (6, 7) <--> ...
 * Each <--> means one pages turn. (2, 3) means we see pages 2 and 3.
 * <p>
 * We can turn pages from start forwards or from the end backwards.
 * Find minimum number of pages we have to turn to see given N-th page.
 *
 * <p>
 * Constraints: 1 <= number of pages <= 10_000, 1 <= needed page number <= n
 * <p>
 * Example: we have 6 pages in book and need to get to page 2.
 * Book is like: (1) <--> (2, 3) <--> (4, 5) <--> (6)
 * We can move forwards: 1 --> (2, 3) - it takes 1 turn.
 * We can move backwards: (6) --> (4, 5) --> (2, 3) - it takes 2 turns.
 * Min (1, 2) = 1 => answer is 1.
 */
public class HowManyPagesToTurn {

    /**
     * Idea: each time we turn page we get to previous page + 2: (i, i+1) --> (i+2, i+3), so there must
     * be something like: turns = (function(pageNum)) / 2.
     * <p>
     * Now let's see forwards:
     * We need page 1 - we do 0 turns. 1 / 2 == 0 .
     * We need page 2 --> we do 1 turn. 2 / 2 == 1.
     * We need page 3 --> we do 1 turn. 3 / 2 == 1.
     * We need page 4 --> we do 2 turns. 4 / 2 == 2.
     * So forwards we count turns like: turns = pageNum / 2.
     * <p>
     * No let's see backwards. Let the last page be 7 (odd):
     * (1) -- (2, 3) -- (4, 5) -- (6, 7)
     * We need page 7 --> we do 0 turns. (7 - 7) / 2 == 0.
     * We need page 6 --> we do 0 turns. (7 - 6) / 2 == 0.
     * We need page 5 --> we do 1 turns. (7 - 5) / 2 == 1
     * So formula is: turns = (maxPage - pageNum) / 2
     * <p>
     * Now let the last page be 6 (even):
     * (1) -- (2, 3) -- (4, 5) -- (6)
     * We need page 6 --> we do 0 turns. (6 - 6) / 2 == 0.
     * We need page 5 --> we do 1 turn. (6 - 5) / 2 == 0!
     * IT'S A PROBLEM!
     * <p>
     * But if we had odd page (7), everything would be fine!
     * So, in case of even page we just need to imagine there is
     * one more page with an odd number. So we take not 6 but 7.
     *
     * @param total  Number of pages in the book.
     * @param needed Page number to open.
     * @return Minimum number of turns.
     */
    public int countPages(int total, int needed) {
        if (total % 2 == 0) {
            total += 1;
        }
        int forwards = needed / 2;
        int backwards = (total - needed) / 2;
        return Math.min(forwards, backwards);
    }

}
