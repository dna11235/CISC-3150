// Nikita Dmitriev - Homework 6
// Reference: https://www.javatpoint.com/package

package child;

import parent.Parent;

public class Child extends Parent{
    public static void main(String[] args){
        Child child = new Child();

        System.out.println(child.x);
        System.out.println(child.i);
    }
}
