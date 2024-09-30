import java.util.HashSet;
import java.util.Set;

public class Set2<T> {
    private Set<T> set;

    // Constructor to initialize a set
    public Set2(T... elements) {
        set = new HashSet<>();
        for (T element : elements) {
            set.add(element);
        }
    }

    // Add element to the set
    public void addElement(T element) {
        set.add(element);
    }

    // Remove element from the set
    public void removeElement(T element) {
        set.remove(element);
    }

    // Check if an element belongs to the set (Î operation)
    public boolean contains(T element) {
        return set.contains(element);
    }

    // Union of two sets A Union B
    public Set2<T> union(Set2<T> otherSet) {
        Set<T> unionSet = new HashSet<>(this.set);
        unionSet.addAll(otherSet.set);
        return new Set2<>((T[]) unionSet.toArray());
    }

    // Intersection of two sets A Ç B
    public Set2<T> intersection(Set2<T> otherSet) {
        Set<T> intersectionSet = new HashSet<>(this.set);
        intersectionSet.retainAll(otherSet.set);
        return new Set2<>((T[]) intersectionSet.toArray());
    }

    // Difference of two sets A - B
    public Set2<T> difference(Set2<T> otherSet) {
        Set<T> differenceSet = new HashSet<>(this.set);
        differenceSet.removeAll(otherSet.set);
        return new Set2<>((T[]) differenceSet.toArray());
    }

    // Check if set A is a subset of set B (A Ì B)
    public boolean isSubsetOf(Set2<T> otherSet) {
        return otherSet.set.containsAll(this.set);
    }

    // Find the cardinality of the set |A|
    public int cardinality() {
        return set.size();
    }

    // Display the elements of the set
    public void displaySet() {
        System.out.println(set);
    }

    public static void main(String[] args) {
        // Example usage with integer values
        Set2<Object> setA = new Set2<>('a', "Test", 3);

        Set2<Object> setB = new Set2<>(3, 4, 5);

        System.out.println("Set A: ");
        setA.displaySet();

        System.out.println("Set B: ");
        setB.displaySet();

        // Add 5 to set A
        setA.addElement(10);
        System.out.println("After adding 10 to set A: ");
        setA.displaySet();

        // Remove 5 from set A
        setA.removeElement(10);
        System.out.println("After removing 10 from set A: ");
        setA.displaySet();

        // Union of A and B
        Set2<Object> unionAB = setA.union(setB);
        System.out.println("A Union B: ");
        unionAB.displaySet();

        // Intersection of A and B
        Set2<Object> intersectionAB = setA.intersection(setB);
        System.out.println("A Intersection B: ");
        intersectionAB.displaySet();

        // Difference of A and B
        Set2<Object> differenceAB = setA.difference(setB);
        System.out.println("Difference A - B: ");
        differenceAB.displaySet();

        // Check if A is subset of B
        System.out.println("Is A a subset of B? " + setA.isSubsetOf(setB));

        // Check if element belongs to the set
        System.out.println("Does A contain 2? " + setA.contains(2));

        // Find the cardinality of set A
        System.out.println("Cardinality of A: " + setA.cardinality());
    }
}
