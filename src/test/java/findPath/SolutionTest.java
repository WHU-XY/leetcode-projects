package findPath;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("单元测试开始前相关操作");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("单元测试结束后相关操作");
    }

    @Test
    public void findPath() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        f.left = g;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(3);
        result.add(5);
        results.add(result);
        assertEquals(results , new Solution().FindPath(a, 9));
    }
}