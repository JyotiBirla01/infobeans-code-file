/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericclasss;

class Box<T> {

    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class Demo {
    public static void main(String[] args) {
        Box<String> b = new Box<String>();
        
        b.set("23");
//        b.set(33);
        System.out.println(b.get());
        
    }
}
