package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import ar.uba.fi.tdd.rulogic.model.KnowledgeBase; 

public class KnowledgeBaseTest {

	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() throws Exception {
		this.knowledgeBase = new KnowledgeBase();
	}

	@Test
	public void test() throws Exception {
		Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
	}

}
