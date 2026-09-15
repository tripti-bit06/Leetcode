class MyHashSet {
    private class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    private Node find(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void add(int key) {
        int index = getHash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1); // Dummy head node
        }
        Node prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key);
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return;
        Node prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    public boolean contains(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return false;
        Node prev = find(buckets[index], key);
        return prev.next != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */