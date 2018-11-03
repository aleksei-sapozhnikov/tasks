package tasks.hackerrank.strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BalancedBracketsTest {

    private BalancedBrackets test = new BalancedBrackets();

    @Test
    public void hasBalancedBrackets() {
        assertThat(test.hasBalancedBrackets("(a + b)"), is (true));
        assertThat(test.hasBalancedBrackets("([a] + {b})"), is (true));
        assertThat(test.hasBalancedBrackets("(a + b *[3 - 2] + {18})"), is (true));
        assertThat(test.hasBalancedBrackets("(a + b *(3 - 2] + {18})"), is (false));
        assertThat(test.hasBalancedBrackets("((a + b *[3 - 2] + {18})"), is (false));
        assertThat(test.hasBalancedBrackets(
                "{}()",
                "({()})",
                "{}(",
                "[]"),
                is(new boolean[]{
                        true,
                        true,
                        false,
                        true
                })
        );
        assertThat(test.hasBalancedBrackets(
                "({}[])",
                "(({()})))",
                "({(){}()})()({(){}()})(){()}",
                "{}()))(()()({}}{}",
                "}}}}",
                "))))",
                "{{{",
                "(((",
                "[]{}(){()}((())){{{}}}{()()}{{}{}}",
                "[[]][][]",
                "}{"
                ),
                is(new boolean[]{
                        true,
                        false,
                        true,
                        false,
                        false,
                        false,
                        false,
                        false,
                        true,
                        true,
                        false
                })
        );
        assertThat(test.hasBalancedBrackets(
                "[({})(())]",
                "(({()})))[[",
                "({(){}()})()({(){}()})(){()}{}((()))",
                "{}()))(()()({}}{}",
                "}}}}",
                "))))",
                "{{{",
                "(((",
                "{}(){()}((())){{{}}}{()()}{{}{}}",
                "{{{{{{{)))))))))))))))))))",
                "{}{}(",
                "{}}}{}",
                "()()()())))",
                "(((((()()()",
                "(){}{{}}()(()){{()()}}",
                "{}{{{}}}{{{((()))}}}",
                "((()))[]",
                "{{}}(()[])"
                ),
                is(new boolean[]{
                        true,
                        false,
                        true,
                        false,
                        false,
                        false,
                        false,
                        false,
                        true,
                        false,
                        false,
                        false,
                        false,
                        false,
                        true,
                        true,
                        true,
                        true
                })
        );
    }
}