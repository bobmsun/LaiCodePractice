package datastructures;

/**
 * A hashtable implementation of map, demonstration purpose, generic type is provided
 *
 * suppo
 */
public class HashTable {

    private Node[] bucket = new Node[1];
    private int size = 0;
    private static final double rehashThreshold = 1.75;

    private int getBucketIndex(String key) {
        if (key == null) {
            return 0;
        }
        int hashCode = key.hashCode();
        int bucketSize = bucket.length;
        return hashCode % bucketSize >= 0 ? hashCode % bucketSize : hashCode % bucketSize + bucketSize;
    }

    public int getSize() {
        return this.size;
    }

    public Integer put(String key, Integer value) {
        // get bucket index
        int bucketIndex = getBucketIndex(key);

        Node curNode = bucket[bucketIndex];
        while (curNode != null) {
            if (key == null && curNode.getKey() == null) {
                int preValue = curNode.getValue();
                curNode.setValue(value);
                return preValue;
            } else if (key != null && key.equals(curNode.getKey())) {
                int preValue = curNode.getValue();
                curNode.setValue(value);
                return preValue;
            } else {
                curNode = curNode.getNext();
            }
        }
        Node newNode = new Node(key, value);
        newNode.setNext(bucket[bucketIndex]);
        bucket[bucketIndex] = newNode;

        // update size & rehash if necessary
        size++;
        double loadFactor = size * 1.0 / bucket.length;
        if (loadFactor > rehashThreshold) {
            rehash();
        }
        return null;
    }

    public Integer get(String key) {
        // get bucket index
        int bucketIndex = getBucketIndex(key);

        Node curNode = bucket[bucketIndex];
        while (curNode != null) {
            if (key == null && curNode.getKey() == null) {
                return curNode.getValue();
            } else if (key != null && key.equals(curNode.getKey())) {
                return curNode.getValue();
            } else {
                curNode = curNode.getNext();
            }
        }
        return null;
    }

    private void rehash() {
        Node[] newBucket = new Node[(int)(this.bucket.length * 1.5)];
        for (Node curNode : this.bucket) {
            while (curNode != null) {
                addToNewBucket(curNode, newBucket);
                curNode = curNode.getNext();
            }
        }
        this.bucket = newBucket;
    }

    private void addToNewBucket(Node node, Node[] newBucket) {
        int hashCode = node.getKey().hashCode();
        int newBucketSize = newBucket.length;
        int newBucketIndex = hashCode % newBucketSize >= 0 ? hashCode % newBucketSize : hashCode % newBucketSize + newBucketSize;

        Node newNode = new Node(node.getKey(), node.getValue());
        newNode.setNext(newBucket[newBucketIndex]);
        newBucket[newBucketIndex] = newNode;
    }

    public static void main(String[] args) {
        HashTable map = new HashTable();
        map.put("Google", 1);
        System.out.println(map.get("Google"));
        System.out.println(map.get("Facebook"));
        System.out.println(map.getSize());
        map.put("Google", 10);
        System.out.println(map.get("Google"));
        System.out.println(map.get("Facebook"));
        System.out.println(map.getSize());

        map.put("Facebook", 2);
        System.out.println(map.get("Facebook"));
        System.out.println(map.getSize());

        map.put("Facebook", 20);
        System.out.println(map.get("Google"));
        System.out.println(map.get("Facebook"));
        System.out.println(map.getSize());
    }
}

class Node {
    private final String key;
    private Integer value;
    private Node next;

    public Node(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String getKey() {
        return this.key;
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer setValue(Integer newValue) {
        Integer previous = this.value;
        this.value = newValue;
        return previous;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
