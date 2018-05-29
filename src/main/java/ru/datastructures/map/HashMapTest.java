package ru.datastructures.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void isEmpty_whenEmpty_returnTrue() {
        Map<String, Integer> hashMap = new HashMap<>();
        boolean result = hashMap.isEmpty();
        assertTrue(result);
    }

    @Test
    public void isEmpty_whenNotEmpty_returnFalse() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        boolean result = hashMap.isEmpty();
        assertFalse(result);
    }

    @Test
    public void put_whenContainsSize_returnSize() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Ann", 98);
        int size = hashMap.size();
        assertEquals(2, size);
    }

    @Test
    public void get_whenGetByExistingKey_returnValue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        int value = hashMap.get("Mary");
        assertEquals(98, value);
    }

    @Test
    public void get_whenGetByNotExistingKey_returnNull() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        Integer value = hashMap.get("Ann");
        assertNull(value);
    }

    @Test
    public void get_whenGetByExistingNullKey_returnValue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 98);
        Integer value = hashMap.get(null);
        assertEquals(98, value);
    }

    @Test
    public void get_whenGetByNotExistingNullKey_returnNull() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        Integer value = hashMap.get(null);
        assertNull(value);
    }

    @Test
    public void clear_whenTestBySize_returnNullSize() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.clear();
        int size = hashMap.size();
        assertEquals(0, size);
    }

    @Test
    public void clear_whenTestByPut_returnNull() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.clear();
        Integer value = hashMap.get("Mary");
        assertNull(value);
    }

    @Test
    public void size_whenPutAndRemoveElements() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Ann", 45);
        hashMap.remove("Ann");
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
    public void remove_whenRemoveAndGetTheSameElement_returnNull() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.remove("Mary");
        Integer value = hashMap.get("Mary");
        assertEquals(null, value);
    }

    @Test
    public void remove_whenTestRemovableValue_returnRemovableValue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        Integer removableValue = hashMap.remove("Mary");
        assertEquals(98, removableValue);
    }

    @Test
    public void remove_whenRemoveByNotExistingKey_returnNull() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        Integer removableValue = hashMap.remove("Ann");
        assertNull(removableValue);
    }

    @Test
    public void remove_whenRemoveByExistingNullKey_returnRemovableValue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 98);
        Integer removableValue = hashMap.remove(null);
        assertEquals(98, removableValue);
    }

    @Test
    public void remove_whenRemoveByNotExistingNullKey_returnNull() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        Integer removableValue = hashMap.remove(null);
        assertNull(removableValue);
    }

    @Test
    public void containsKey_whenTestByExistingKey_returnTrue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Ann", 45);
        boolean result = hashMap.containsKey("Ann");
        assertTrue(result);
    }

    @Test
    public void containsKey_whenTestByNotExistingKey_returnFalse() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Ann", 45);
        boolean result = hashMap.containsKey("John");
        assertFalse(result);
    }

    @Test
    public void containsKey_whenTestByExistingNullKey_returnTrue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put(null, 45);
        boolean result = hashMap.containsKey(null);
        assertTrue(result);
    }

    @Test
    public void containsKey_whenTestByNotExistingNullKey_returnFalse() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        boolean result = hashMap.containsKey(null);
        assertFalse(result);
    }

    @Test
    public void containsValue_whenTestByExistingValue_returnTrue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Ann", 45);
        boolean result = hashMap.containsValue(45);
        assertTrue(result);
    }

    @Test
    public void containsValue_whenTestByNotExistingValue_returnFalse() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Ann", 45);
        boolean result = hashMap.containsValue(100);
        assertFalse(result);
    }

    @Test
    public void containsValue_whenTestByExistingNullValue_returnTrue() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        hashMap.put("Angy", null);
        boolean result = hashMap.containsValue(null);
        assertTrue(result);
    }

    @Test
    public void containsValue_whenTestByNotExistingNullValue_returnFalse() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mary", 98);
        boolean result = hashMap.containsValue(null);
        assertFalse(result);
    }
}