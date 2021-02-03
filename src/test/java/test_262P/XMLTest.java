package test_262P;

import org.json.*;
import org.json.junit.Util;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Tests for JSON-Java XML.java methods:
 * 1) public static JSONObject toJSONObject(Reader reader, JSONPointer path)
 * 2) public static JSONObject toJSONObject(Reader reader, JSONPointer path, JSONObject replacement)
 */


public class XMLTest {
    /**
     * test on "JSONObject toJSONObject(Reader reader, JSONPointer path)"
     * expect return a valid JSONObject
     */
    @Test
    public void testExtractJSONObject() {
        try {
            FileReader reader = new FileReader("src/test/java/test_262P/books.xml");
            JSONPointer path = new JSONPointer("/catalog/book");

            JSONObject actual = XML.toJSONObject(reader, path);
//            System.out.println("here " + actual);
            reader.close();

            String expect = "{\"book\": [\n" +
                    "    {\n" +
                    "        \"author\": \"Gambardella, Matthew\",\n" +
                    "        \"price\": 44.95,\n" +
                    "        \"genre\": \"Computer\",\n" +
                    "        \"description\": \"An in-depth look at creating applications \\n      with XML.\",\n" +
                    "        \"id\": \"bk101\",\n" +
                    "        \"title\": \"XML Developer's Guide\",\n" +
                    "        \"publish_date\": \"2000-10-01\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Ralls, Kim\",\n" +
                    "        \"price\": 5.95,\n" +
                    "        \"genre\": \"Fantasy\",\n" +
                    "        \"description\": \"A former architect battles corporate zombies, \\n      an evil sorceress, and her own childhood to become queen \\n      of the world.\",\n" +
                    "        \"id\": \"bk102\",\n" +
                    "        \"title\": \"Midnight Rain\",\n" +
                    "        \"publish_date\": \"2000-12-16\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Corets, Eva\",\n" +
                    "        \"price\": 5.95,\n" +
                    "        \"genre\": \"Fantasy\",\n" +
                    "        \"description\": \"After the collapse of a nanotechnology \\n      society in England, the young survivors lay the \\n      foundation for a new society.\",\n" +
                    "        \"id\": \"bk103\",\n" +
                    "        \"title\": \"Maeve Ascendant\",\n" +
                    "        \"publish_date\": \"2000-11-17\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Corets, Eva\",\n" +
                    "        \"price\": 5.95,\n" +
                    "        \"genre\": \"Fantasy\",\n" +
                    "        \"description\": \"In post-apocalypse England, the mysterious \\n      agent known only as Oberon helps to create a new life \\n      for the inhabitants of London. Sequel to Maeve \\n      Ascendant.\",\n" +
                    "        \"id\": \"bk104\",\n" +
                    "        \"title\": \"Oberon's Legacy\",\n" +
                    "        \"publish_date\": \"2001-03-10\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Corets, Eva\",\n" +
                    "        \"price\": 5.95,\n" +
                    "        \"genre\": \"Fantasy\",\n" +
                    "        \"description\": \"The two daughters of Maeve, half-sisters, \\n      battle one another for control of England. Sequel to \\n      Oberon's Legacy.\",\n" +
                    "        \"id\": \"bk105\",\n" +
                    "        \"title\": \"The Sundered Grail\",\n" +
                    "        \"publish_date\": \"2001-09-10\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Randall, Cynthia\",\n" +
                    "        \"price\": 4.95,\n" +
                    "        \"genre\": \"Romance\",\n" +
                    "        \"description\": \"When Carla meets Paul at an ornithology \\n      conference, tempers fly as feathers get ruffled.\",\n" +
                    "        \"id\": \"bk106\",\n" +
                    "        \"title\": \"Lover Birds\",\n" +
                    "        \"publish_date\": \"2000-09-02\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Thurman, Paula\",\n" +
                    "        \"price\": 4.95,\n" +
                    "        \"genre\": \"Romance\",\n" +
                    "        \"description\": \"A deep sea diver finds true love twenty \\n      thousand leagues beneath the sea.\",\n" +
                    "        \"id\": \"bk107\",\n" +
                    "        \"title\": \"Splish Splash\",\n" +
                    "        \"publish_date\": \"2000-11-02\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Knorr, Stefan\",\n" +
                    "        \"price\": 4.95,\n" +
                    "        \"genre\": \"Horror\",\n" +
                    "        \"description\": \"An anthology of horror stories about roaches,\\n      centipedes, scorpions  and other insects.\",\n" +
                    "        \"id\": \"bk108\",\n" +
                    "        \"title\": \"Creepy Crawlies\",\n" +
                    "        \"publish_date\": \"2000-12-06\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Kress, Peter\",\n" +
                    "        \"price\": 6.95,\n" +
                    "        \"genre\": \"Science Fiction\",\n" +
                    "        \"description\": \"After an inadvertant trip through a Heisenberg\\n      Uncertainty Device, James Salway discovers the problems \\n      of being quantum.\",\n" +
                    "        \"id\": \"bk109\",\n" +
                    "        \"title\": \"Paradox Lost\",\n" +
                    "        \"publish_date\": \"2000-11-02\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"O'Brien, Tim\",\n" +
                    "        \"price\": 36.95,\n" +
                    "        \"genre\": \"Computer\",\n" +
                    "        \"description\": \"Microsoft's .NET initiative is explored in \\n      detail in this deep programmer's reference.\",\n" +
                    "        \"id\": \"bk110\",\n" +
                    "        \"title\": \"Microsoft .NET: The Programming Bible\",\n" +
                    "        \"publish_date\": \"2000-12-09\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"O'Brien, Tim\",\n" +
                    "        \"price\": 36.95,\n" +
                    "        \"genre\": \"Computer\",\n" +
                    "        \"description\": \"The Microsoft MSXML3 parser is covered in \\n      detail, with attention to XML DOM interfaces, XSLT processing, \\n      SAX and more.\",\n" +
                    "        \"id\": \"bk111\",\n" +
                    "        \"title\": \"MSXML3: A Comprehensive Guide\",\n" +
                    "        \"publish_date\": \"2000-12-01\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"author\": \"Galos, Mike\",\n" +
                    "        \"price\": 49.95,\n" +
                    "        \"genre\": \"Computer\",\n" +
                    "        \"description\": \"Microsoft Visual Studio 7 is explored in depth,\\n      looking at how Visual Basic, Visual C++, C#, and ASP+ are \\n      integrated into a comprehensive development \\n      environment.\",\n" +
                    "        \"id\": \"bk112\",\n" +
                    "        \"title\": \"Visual Studio 7: A Comprehensive Guide\",\n" +
                    "        \"publish_date\": \"2001-04-16\"\n" +
                    "    }\n" +
                    "]}";

            Util.compareActualVsExpectedJsonObjects(actual, new JSONObject(expect));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fail to close file.");
            e.printStackTrace();
        }
    }


    /**
     * test on "JSONObject toJSONObject(Reader reader, JSONPointer path, JSONObject replacement)"
     * expect return a new JSONObject
     */
    @Test
    public void testReplaceJSONObject() {
        try {
            FileReader reader = new FileReader("src/test/java/test_262P/books.xml");
            JSONPointer path = new JSONPointer("/catalog/book");
            JSONObject newSubObject = new JSONObject();
            newSubObject.put("author", "NA");
            newSubObject.put("price", "NA");
            newSubObject.put("genre", "NA");
            newSubObject.put("description", "NA");
            newSubObject.put("id", "NA");
            newSubObject.put("title", "NA");
            newSubObject.put("publish_date", "NA");
            JSONObject actual = XML.toJSONObject(reader, path, newSubObject);

            String actualString = actual.toString();
            String expectString = "{\"catalog\":{\"book\":{\"author\":\"NA\",\"price\":\"NA\",\"genre\":\"NA\",\"description\":\"NA\",\"id\":[\"bk101\",\"NA\"],\"title\":\"NA\",\"publish_date\":\"NA\"}}}";
            assertEquals(actualString, expectString);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fail to close file.");
            e.printStackTrace();
        }
    }

    /**
     * test on "JSONObject toJSONObject(Reader reader, JSONPointer path, JSONObject replacement)"
     * expect actual and expect JSONObject is different
     */
    @Test
    public void testReplaceJSONObjectWithInvalidPath() {
        try {
            FileReader reader = new FileReader("src/test/java/test_262P/books.xml");
            JSONPointer path = new JSONPointer("/catalog/test");
            JSONObject newSubObject = new JSONObject();
            newSubObject.put("author", "NA");
            newSubObject.put("price", "NA");
            newSubObject.put("genre", "NA");
            newSubObject.put("description", "NA");
            newSubObject.put("id", "NA");
            newSubObject.put("title", "NA");
            newSubObject.put("publish_date", "NA");
            JSONObject actual = XML.toJSONObject(reader, path, newSubObject);

            String actualString = actual.toString();
            String expectString = "{\"catalog\":{\"book\":{\"author\":\"NA\",\"price\":\"NA\",\"genre\":\"NA\",\"description\":\"NA\",\"id\":[\"bk101\",\"NA\"],\"title\":\"NA\",\"publish_date\":\"NA\"}}}";
            assertNotEquals(actualString, expectString);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fail to close file.");
            e.printStackTrace();
        }
    }
}