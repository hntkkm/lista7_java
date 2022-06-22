package src;

class TreeElem <T extends Comparable<T>>{
    T elem;
    TreeElem<T> left;
    TreeElem<T> right;
    TreeElem(T elem){
        this.elem = elem;
        left = null;
        right = null;
    }
    public String toString(){
        return elem.toString();
    }
}