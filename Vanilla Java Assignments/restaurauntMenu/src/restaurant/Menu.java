package restaurant;


public class Menu {
    public void main (String[] args){
        MenuItem tiramisu = new MenuItem("dessert", "espresso chocolate goodness destined to fill your tummy and keep" +
                " you up all night", 6.99, true);
        System.out.println(tiramisu);
        //methods to create:
        // new Item: if item is x amount of days old then go to false
        // pulling key and using hashmap (ex: pull all appetizers and print those menu items)
    }
}
