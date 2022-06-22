package src;

public class TreeTest
{
    public static void main(String[] args)
    {
        // Drzewo dla elementow typu String
        Tree<Integer> drzewoInt = new Tree<>();

        drzewoInt.delete(5);
        System.out.println(drzewoInt);
        drzewoInt.insert(10);
        drzewoInt.insert(8);
        drzewoInt.insert(9);
        drzewoInt.insert(20);
        drzewoInt.insert(15);
        drzewoInt.insert(25);
        drzewoInt.insert(12);
        System.out.println(drzewoInt);
        drzewoInt.delete(20);
        System.out.println(drzewoInt);
        drzewoInt.delete(10);
        System.out.println(drzewoInt);
        drzewoInt.insert(10);
        System.out.println(drzewoInt);
    }
}
