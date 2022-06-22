package src;

public class Tree<T extends Comparable<T>> {
    private TreeElem<T> root;
    public Tree() {
        root = null;
    }

    //dodawanie elementu
    public void insert(T elem) {
        root = ins(elem, root);
    }
    private TreeElem<T> ins(T elem, TreeElem<T> wezel ) {
        if( wezel==null ) return new TreeElem<T>(elem);

        if( elem.compareTo(wezel.elem)<0 )
            wezel.left = ins(elem, wezel.left);
        else if( elem.compareTo(wezel.elem)>0)
            wezel.right = ins(elem, wezel.right);
        return wezel;
    }

    //sprawdzenie czy jest elementem
    public boolean search(T elem) {
        return isElem(elem,root);
    }
    private boolean isElem(T elem, TreeElem<T> w) {
        if( w==null ) return false;
        if( elem.compareTo(w.elem)==0 ) return true;
        if( elem.compareTo(w.elem)<0)
            return isElem(elem, w.left);
        else
            return isElem(elem, w.right);
    }

    // wypisywanie
    public String toString() {
        return toS(root);
    }
    private String toS(TreeElem<T> w) {
        if( w!=null )
            return "("+w.elem+":"+toS(w.left)+":"+toS(w.right)+")";
        return "()";
    }

    public void delete(T elem) {
        root = deleteRec(root, elem);
    }
    private TreeElem<T> deleteRec(TreeElem<T> root, T elem) {
        if (root == null)
            return null;

        if (elem.compareTo(root.elem) < 0)
            root.left = deleteRec(root.left, elem);
        else if (elem.compareTo(root.elem) > 0)
            root.right = deleteRec(root.right, elem);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.elem = minValue(root.right);
            root.right = deleteRec(root.right, root.elem);
        }
        return root;
    }

    private T minValue(TreeElem<T> root) {
        T minimum = root.elem;
        while (root.left != null) {
            minimum = root.left.elem;
            root = root.left;
        }
        return minimum;
    }
}