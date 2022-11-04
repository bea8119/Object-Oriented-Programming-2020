import warehouse.*;

public class Example {

    public static void main(String[] args) throws InvalidSupplier, MultipleDelivery{
        Warehouse m = new Warehouse();
        
        Product banane = m.newProduct("BNN","Banane");
        banane.setQuantity(33);
        Product kiwi = m.newProduct("KWI","Kiwi");
        kiwi.setQuantity(44);
        Product mele = m.newProduct("MLL","Mele");
        banane.setQuantity(355);
        Product pere = m.newProduct("PER","Pere");
        banane.setQuantity(66);
        Product ananas = m.newProduct("ANNS","Ananas");
        banane.setQuantity(77);
        
        Supplier chiquita = m.newSupplier("CQT", "Chiquita");
        Supplier delmonte = m.newSupplier("DMT", "Del Monte");
        
        
        chiquita.newSupply(banane);
        chiquita.newSupply(kiwi);
        chiquita.newSupply(mele);
        chiquita.newSupply(pere);
        
        delmonte.newSupply(banane);
        delmonte.newSupply(ananas);
        
        Order ord1 = m.issueOrder(banane,67,chiquita);
        Order ord2 = m.issueOrder(banane,100,delmonte);
        Order ord3 = m.issueOrder(ananas,50,delmonte);
        Order ord4 = m.issueOrder(pere,50,chiquita);
        Order ord5 = m.issueOrder(mele,50,chiquita);

        ord1.setDelivered();
        ord3.setDelivered();
        ord4.setDelivered();
        
        System.out.println(ord2.toString());
        
        System.out.println( m.pendingOrders());
        
        System.out.println(m.ordersByProduct());
        
        System.out.println(m.orderNBySupplier());
        
        ord2.setDelivered();
        ord5.setDelivered();
        
        System.out.println(m.countDeliveredByProduct());
    }
}
