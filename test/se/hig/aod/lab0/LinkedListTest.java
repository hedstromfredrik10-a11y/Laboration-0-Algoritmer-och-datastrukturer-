package se.hig.aod.lab0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
	private LinkedList<Integer> listUnderTest;
	private final int[] fixture = { 1, 2, 3, 4, 5 };

	/**
	 * Resets listUnderTest to a new empty LinkedList-instance
	 * before each test method is executed.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		listUnderTest = new LinkedList<Integer>();
	}

	/**
	 * Sets listUnderTest to null after each test method is executed.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		listUnderTest = null;
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testEmptyListIsEmpty() {
		assertTrue(listUnderTest.isEmpty(), "An empty listUnderTest instance should not contain any item");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testInitializedListIsNotEmpty() {
		initializeList();
		assertFalse(listUnderTest.isEmpty(), "A listUnderTest instance containing elements should not be empty");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#clear()}.
	 */
	@Test
	public void testClearOnEmptyList() {
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty(),
				"An empty listUnderTest instance that is cleared should not contain any item");
	}

	/*
	 * Skriv fler test-metoder själv........................
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.getFirst(),
				"GetFirst() on empty listUnderTest should throw ListEmptyException");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnInitializedList() {
		initializeList();
		assertEquals(1, listUnderTest.getFirst(), "GetFirst() should return first element in listUnderTest");
	}

	/*
	 * Skriv fler test-metoder själv........................
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	private void initializeList() {
		for (int i = 0; i < fixture.length; i++) {
			listUnderTest.insertLast(fixture[i]);
		}
	}

	// Enga tester------------------------------

	@Test
	public void testInsertFirstAndGetFirst() {	//Testa att lägga in element i första noden och hämta den
		listUnderTest.insertFirst(10);
		assertEquals(10, listUnderTest.getFirst());

		listUnderTest.insertFirst(20);
		assertEquals(20, listUnderTest.getFirst());
	}

	@Test
	public void testInsertLastAndGetLast() {	//Testa att lägga in i element i sista noden
		listUnderTest.insertLast(1);
		listUnderTest.insertLast(2);
		listUnderTest.insertLast(3);
		assertEquals(3, listUnderTest.getLast());
		assertEquals(1, listUnderTest.getFirst());
	}

	@Test
	public void testRemoveFirst() {	//Testa att ta bort elementet från första noden och hämta den
		listUnderTest.insertLast(1);
		listUnderTest.insertLast(2);
		assertEquals(1, listUnderTest.removeFirst());
		assertEquals(2, listUnderTest.getFirst());
	}

	@Test
	public void testRemoveLast() {	//Testa att ta bort sista elementet och hämta den
		listUnderTest.insertLast(10);
		listUnderTest.insertLast(20);
		listUnderTest.insertLast(30);

		assertEquals(30, listUnderTest.removeLast());
		assertEquals(20, listUnderTest.getLast());
		assertEquals(2, listUnderTest.numberOfElements());
	}

	@Test
	public void testNumberOfElements() {	//Testa att hämta antal element
		assertEquals(0, listUnderTest.numberOfElements());
		listUnderTest.insertLast(1);
		listUnderTest.insertLast(2);
		assertEquals(2, listUnderTest.numberOfElements());
		listUnderTest.removeFirst();
		assertEquals(1, listUnderTest.numberOfElements());
	}

	@Test
	public void testClear() {	//Testa att rensa listan
		listUnderTest.insertLast(10);
		listUnderTest.insertLast(20);
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty());
		assertEquals(0, listUnderTest.numberOfElements());
	}

}
