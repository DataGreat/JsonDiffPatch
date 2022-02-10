package de.recus.jsonDiff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.recus.jsonDiff.JsonDiff;

public class JsonDiffTest {

	@Test(expected = NullPointerException.class)
	public void compileTest() {
		JsonDiff.asJson(null, null);
	}

	@Test
	public void testNoChanges() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceNoChanges.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	private void printMethodeName(Throwable ex) {
		StackTraceElement stackTop = ex.getStackTrace()[0];
		String methodName = stackTop.getMethodName();
		System.out.println("Methode: " + methodName);
	}

	@Test
	public void testMoveKey() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceMoveKey.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	@Test
	public void testNewKey() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceNewKey.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	@Test
	public void testRemoveKey() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceRemoveKey.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	@Test
	public void testRemoveValue() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceRemoveValue.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	@Test
	public void testUpdateValue() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceUpdateValue.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	@Test
	public void testAllChanges() throws IOException {
		printMethodeName(new Exception());
		String crmJson = getFile("jsonExamples/source/ah4rSourceAllChanges.json");
		String elkJson = getFile("jsonExamples/target/ah4rTarget.json");
		diffJson(elkJson, crmJson);
		System.out.println("End test\n");
	}

	private void diffJson(String source, String target) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode sourceNode = mapper.readValue(source, JsonNode.class);

		JsonNode targetNode = mapper.readValue(target, JsonNode.class);

		JsonNode diff1 = JsonDiff.asJson(sourceNode, targetNode, true);
		JsonNode diff2 = JsonDiff.asJson(sourceNode, targetNode, false);

		System.out.println("Diff with COPY:\n" + diff1);
		System.out.println("----------------------------");
		System.out.println("Diff without COPY:\n" + diff2);
	}

	private String getFile(String path) throws IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());

		return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
	}
}
