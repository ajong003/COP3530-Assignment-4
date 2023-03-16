import Dictionary.MyHashtable;
import Dictionary.RhymingDict;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AssignmentTest {

    @Test
    public void test_2_puts() {
        MyHashtable testTable = new MyHashtable(100);
        testTable.put("f", "food");
        testTable.put("c", "candy");
        Assertions.assertTrue(testTable.toString().trim().equals("key: f, value: food\n" +
                "key: c, value: candy"));
    }

    @Test
    public void test_3_puts() {
        MyHashtable testTable = new MyHashtable(100);
        testTable.put("f", "food");
        testTable.put("c", "candy");
        testTable.put("b", "bar");
        Assertions.assertTrue(testTable.toString().trim().equals("key: f, value: food\n" +
                "key: b, value: bar\n" +
                "key: c, value: candy"));
    }

    @Test
    public void test_3_puts_and_a_replace_put() {
        MyHashtable testTable = new MyHashtable(100);
        testTable.put("f", "food");
        testTable.put("c", "candy");
        testTable.put("b", "bar");
        testTable.put("b", "box");
        Assertions.assertTrue(testTable.toString().trim().equals("key: f, value: food\n" +
                "key: b, value: box\n" +
                "key: c, value: candy"));
    }

    @Test
    public void test_3_puts_and_1_remove() {
        MyHashtable testTable = new MyHashtable(100);
        testTable.put("f", "food");
        testTable.put("b", "box");
        testTable.put("c", "cat");
        testTable.remove("b");
        Assertions.assertTrue(testTable.toString().trim().equals("key: f, value: food\n" +
                "key: c, value: cat"));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Test
    public void test_map_dictionary() {
        MyHashtable rhymingDict = new MyHashtable(20000);
        RhymingDict.loadDictionary(rhymingDict);
        String[] keys = rhymingDict.getKeys();
        Assertions.assertEquals(14662, keys.length);
        Assertions.assertEquals(6, rhymingDict.biggestBucket());
        // actual expected: <1.4137499332427979>
        Assertions.assertEquals(1.414, round(rhymingDict.averageBucket(),3));
    }

    @Test
    public void test_removeUnrhymables_OPTIONAL() {
        MyHashtable rhymingDict = new MyHashtable(20000);
        RhymingDict.loadDictionary(rhymingDict);
        RhymingDict.removeUnrhymables(rhymingDict);
        String[] keys = rhymingDict.getKeys();
        Assertions.assertEquals(3841, keys.length);
        Assertions.assertEquals(4, rhymingDict.biggestBucket());
        // actual expected: <1.4137499332427979>
        Assertions.assertEquals(0.370, round(rhymingDict.averageBucket(),3));
    }

}