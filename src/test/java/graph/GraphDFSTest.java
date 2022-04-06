package graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.stefanbirkner.systemlambda.SystemLambda;

public class GraphDFSTest {

	private static Graph g;
	
	@BeforeAll
	static void creatGraph() {
		g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
	}

	@Test
	void testDFSRec() throws Exception {
		
		g.dfsRec(g.getAdj());

		String text = SystemLambda.tapSystemOut(() -> {
			g.dfsRec(g.getAdj());
		});
		assertEquals("0 1 2 3 ", text);
	}

	@Test
	void testDFSIterative() throws Exception {
		String text = SystemLambda.tapSystemOut(() -> {
			g.dfsIterative();
		});
		assertEquals("0 2 3 1 ", text);
	}
	
	@Test
	void testBFSRec() throws Exception {
		String text = SystemLambda.tapSystemOut(() -> {
			g.bfsRec();
		});
		assertEquals("0 1 2 3 ", text);
	}
	
	@Test
	void testBFSIterative() throws Exception {
		String text = SystemLambda.tapSystemOut(() -> {
			g.bfsIterative();
		});
		assertEquals("0 1 2 3 ", text);
	}
}
