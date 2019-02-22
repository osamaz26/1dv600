package oz222am_hangman.UI;

/**
 * The type Hangman image.
 */
public class HangmanImage {
    /*
     * ground, vertical pole, horizontal pole, head, body, left arm, right arm, left leg, right arm
     * 1        2             3                4     5     6         7          8         9
     * */


    /**
     * Draw string.
     *
     * @param count the count
     * @return the string
     */
    public static String draw(int count) {
        var sb = new StringBuilder();
        sb.append(count >= 3 ? "    =======    \n" : "\n");
        sb.append(count >= 2 ? "    |     |\n" : "\n");
        sb.append(count >= 2 ? "    |     |\n" : "\n");
        if (count >= 2) {
            sb.append("    |     ").append((count >= 4) ? "0\n" : "\n");
        } else {
            sb.append("\n");
        }
        if (count >= 2) {
            sb.append("    |    ").append((count >= 6) ? "/" : " ").append((count >= 5) ? "|" : " ").append((count >= 7) ? "\\\n" : "\n");
        } else {
            sb.append("\n");
        }
        if (count >= 2) {
            sb.append("    |     ").append((count >= 5) ? "|\n" : "\n");
        } else {
            sb.append("\n");
        }
        if (count >= 2) {
            sb.append("    |    ").append((count >= 8) ? "/" : " ").append(" ").append((count >= 9) ? "\\\n" : "\n");
        } else {
            sb.append("\n");
        }
        sb.append(count >= 2 ? "    |     \n" : "\n");
        sb.append(count >= 2 ? "    |     \n" : "\n");
        if (count >= 0) {
            sb.append("    ========\n");
        }
        return sb.toString();
    }
}
