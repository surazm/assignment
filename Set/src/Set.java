import java.util.ArrayList;
import java.util.Arrays;

public class Set extends ArrayList{
    //Instances
    public ArrayList<Object> set;

    //Constructor
    public Set(){
        this.set = new ArrayList<>();
    }

    //Method for adding elements in the set
    public void add(Object... elements){
        set.addAll(Arrays.asList(elements));
    }

    //Method to check if an element belongs to the set or not
    public void contain(Object target_element){
        boolean found = false;
        for (Object x: set){
            if (target_element == x) {
                found = true;
                break;
            }
        }
        if (found){
            System.out.println("The element '" + target_element + "' belongs to the set");
        }
        else{
            System.out.println("The element '" + target_element + "' doesn't belong to the set");
        }
    }

    //Method for displaying set
    public void show(){
        int index = 0;
        System.out.print("{");
        for (Object element: set){
            System.out.print(element);
            index++;
            if (index != set.size())
                System.out.print(", ");
        }
        System.out.println("}");
    }

    //Method to find cardinality
    public int cardinality(){
        int count = 0;
        for (Object element : set){
            if (element != "" && element != " ")
                count++;
        }
        System.out.println("The cardinality of the set is: " + count);
        return count;
    }

    //Method to find union of two sets
    public static void union(Set a, Set b){
        Set result = new Set();
        for (int i=0; i<a.cardinality(); i++){
            result.add(a.get(i));
        }
//        for (int i=0; i<b.cardinality(); i++){
//            result.add(b.get(i));
//        }

//        System.arraycopy(a, 0, result, 0, a.cardinality()-1);
//        System.arraycopy(b, 0, result, a.cardinality()-1, b.cardinality()-1);
        result.show();

    }


    //Method to find intersection of two sets
    public static void intersection(Set a, Set b){
        Set interSet = new Set();
        for (int i=0; i<b.size(); i++){
            for (int j=0; j<a.size(); j++){
                if (b.get(i) == a.get(j) && !interSet.contains(b.get(i))){
                    interSet.add(b.get(i));
                }
            }
        }
        interSet.show();
    }

    public static void main(String[] args) {
        Set set_A = new Set();
        set_A.add("a", "b", "c", 1, 2, 2);
        System.out.print("Set A: ");
        set_A.show();
        set_A.contain(2);
//        set_A.cardinality();

        Set set_B = new Set();
        set_B.add("c", "d", 2, 2, 4);
        System.out.print("Set B: ");
        set_B.show();
        System.out.println(set_B);
        int size = set_B.size();
        System.out.println(size);
//        union(set_A, set_B);
        intersection(set_A,set_B);

    }

}