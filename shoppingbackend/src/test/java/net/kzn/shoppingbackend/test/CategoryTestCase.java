package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Mobile"); category.setDescription(
	 * "This is some description for mobile!");
	 * category.setImageURL("CAT_107.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory(){
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully fetched a single category from the table!",
	 * "Laptop", category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory(){
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully fetched a single category from the table!",
	 * true, categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory(){
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully delete a single category from the table!",
	 * true, categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory(){
	 * 
	 * assertEquals("Successfully fetched the list of category from the table!",
	 * 2, categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// adding category records

		category = new Category();

		category.setName("Mobile");
		category.setDescription("This is some description for mobile!");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for loptop!");
		category.setImageURL("CAT_3.png");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		// get single category

		category = categoryDAO.get(2);

		assertEquals("Successfully fetched a single category from the table!", "Television", category.getName());

		// rename category

		category.setName("TV");

		assertEquals("Successfully fetched a single category from the table!", true, categoryDAO.update(category));

		// delete single category

		assertEquals("Successfully delete a single category from the table!", true, categoryDAO.delete(category));

		// fetched list of records

		assertEquals("Successfully fetched the list of category from the table!", 2, categoryDAO.list().size());
	}

}
