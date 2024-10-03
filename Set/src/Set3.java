import java.util.ArrayList;
import java.util.List;

public class Set3<T> {
    private List<T> set;

    // Constructor to initialize a set with elements
    @SafeVarargs
    public Set3(T... elements) {
        set = new ArrayList<>();
        for (T element : elements) {
            if (!set.contains(element)) { // Ensure unique elements like a set
                set.add(element);
            }
        }
    }

    // Add element to the set
    public void addElement(T element) {
        if (!set.contains(element)) {
            set.add(element);
        }
    }

    // Remove element from the set
    public void removeElement(T element) {
        set.remove(element);
    }

    // Check if an element belongs to the set (Î operation)
    public boolean contains(T element) {
        return set.contains(element);
    }

    // Union of two sets A È B
    public Set3<T> union(Set3<T> otherSet) {
        Set3<T> unionSet = new Set3<>();
        unionSet.set.addAll(this.set);
        for (T element : otherSet.set) {
            if (!unionSet.contains(element)) {
                unionSet.addElement(element);
            }
        }
        return unionSet;
    }

    // Intersection of two sets A Ç B
    public Set3<T> intersection(Set3<T> otherSet) {
        Set3<T> intersectionSet = new Set3<>();
        for (T element : this.set) {
            if (otherSet.contains(element)) {
                intersectionSet.addElement(element);
            }
        }
        return intersectionSet;
    }

    // Difference of two sets A - B
    public Set3<T> difference(Set3<T> otherSet) {
        Set3<T> differenceSet = new Set3<>();
        for (T element : this.set) {
            if (!otherSet.contains(element)) {
                differenceSet.addElement(element);
            }
        }
        return differenceSet;
    }

    // Check if set A is a subset of set B (A Ì B)
    public boolean isSubsetOf(Set3<T> otherSet) {
        for (T element : this.set) {
            if (!otherSet.contains(element)) {
                return false;
            }
        }
        return true;
    }

    // Find the cardinality of the set |A|
    public int cardinality() {
        return set.size();
    }

    // Display the elements of the set
    public void displaySet() {
        System.out.println(set);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Example usage with integer values
        Set3<Integer> setA = new Set3<>(1, 2, 3, 4);
        Set3<Integer> setB = new Set3<>(3, 4, 5, 6);

        System.out.println("Set A: ");
        setA.displaySet();

        System.out.println("Set B: ");
        setB.displaySet();

        // Union of A and B
        Set3<Integer> unionAB = setA.union(setB);
        System.out.println("Union A U B: ");
        unionAB.displaySet();

        // Intersection of A and B
        Set3<Integer> intersectionAB = setA.intersection(setB);
        System.out.println("Intersection A Ç B: ");
        intersectionAB.displaySet();

        // Difference of A and B (A - B)
        Set3<Integer> differenceAB = setA.difference(setB);
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
