package Dictionary;

// Dictionary that stores values of type Object indexed by keys of type String
interface DictionaryInterface {
    public boolean isEmpty(); // returns true if the Dictionary is empty, false otherwise.

    public int size(); // Returns the number of key/value pairs stored in the dictionary.

    // Adds a value stored under the given key. If the key has already been stored in the Dictionary,
    // replaces the value associated with the key and returns the old value. If the key isn't in the dictionary
    // returns null.
    public Object put(String key, Object value);

    public Object get(String key); // Retrieves the value stored with the key.

    public void remove(String key); // Deletes the key/value pair stored with the given key.

    public void clear(); // Empties the dictionary.

    public String[] getKeys(); // Returns an array of all the keys currently stored in the Dictionary.
}