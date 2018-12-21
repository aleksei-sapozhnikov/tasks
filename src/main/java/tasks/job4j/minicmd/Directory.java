package tasks.job4j.minicmd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/*
 * Please solve the followig puzzle which simulates generic directory structures.
 * The solution should be directory agnostic.
 * Be succinct yet readable. You should not exceed more than 200 lines.
 * Consider adding comments and asserts to help the understading.
 * Code can be compiled with javac Directory.java
 * Code should be executed as: java -ea Directory (-ea option it's to enabled the assert)
 */

/**
 * Date: 21.12.2018.
 * <p>
 * Class to start program (it was given by task).
 */
public class Directory {
    public static void main(String[] args) {

        final Shell shell = new Shell();
        assert shell.path().equals("/");

        shell.cd("/");
        assert shell.path().equals("/");

        shell.cd("usr/..");
        assert shell.path().equals("/");

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assert shell.path().equals("/usr/local");

        shell.cd("..");
        assert shell.path().equals("/usr");

        shell.cd("//lib///");
        assert shell.path().equals("/lib");
    }
}

/**
 * Class to change.
 */
class Shell {
    /**
     * The list contains current path as: [usr] [local] ...
     */
    private LinkedList<String> path = new LinkedList<>();

    /**
     * Changes current path by changing items in list.
     *
     * @param path Given string path.
     * @return This shell object.
     */
    Shell cd(final String path) {
        String p = this.normalizePath(path);
        this.clearIfPathStartsFromRoot(p);
        List<String> dirs = this.getElementsExcludeRedundant(p);
        for (String element : dirs) {
            this.parseElement(element);
        }
        return this;
    }

    /**
     * Replaces all many-time symbols like "///" to one "/" symbol.
     *
     * @param path Not-normalized path.
     * @return Normalized path.
     */
    private String normalizePath(String path) {
        return path.replaceAll("/+", "/");
    }

    /**
     * Gets elements from given path string, using "/" delimiter.
     * Gets rid of empty elements (length == 0) and elements not changing directory (".").
     *
     * @param path Path string.
     * @return Array of elements from path.
     */
    private List<String> getElementsExcludeRedundant(String path) {
        return Arrays.stream(path.split("/"))
                .filter(s -> s.length() > 0 && !s.equals("."))
                .collect(Collectors.toList());
    }

    /**
     * Checks if given path defines path from root (starts with '/' symbol.
     * If so - clears our current path.
     *
     * @param path String path.
     */
    private void clearIfPathStartsFromRoot(String path) {
        if (path.startsWith("/")) {
            this.path.clear();
        }
    }

    /**
     * Analyzes element and changes path according to analyze result.
     *
     * @param element Element to analyze.
     */
    private void parseElement(String element) {
        if ("..".equals(element) && this.path.size() > 0) {
            this.path.removeLast();
        } else {
            this.path.addLast(element);
        }
    }

    /**
     * Prints saved path as string path.
     *
     * @return String path representation.
     */
    public String path() {
        StringJoiner result = new StringJoiner("/", "/", "");
        for (String dir : this.path) {
            result.add(dir);
        }
        return result.toString();
    }
}