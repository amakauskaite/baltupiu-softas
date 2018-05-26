package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.PurchaseHistoryService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
//@RequestScoped
//todo reikia requestscoped
public class PurchaseHistoryBean {
    private String product;
    private Integer count;
    private double price;
    private String state;
    private String date;
    private List<Cart> l; //todo aiskus pavadinimai
    private User user;
    //todo truksta inject
    private PurchaseHistoryService purchaseHistoryService;

    public List<Cart> getL() {
        return l;
    }

    public void setL(List<Cart> l) {
        this.l = l;
    }

    public String getProduct(){
        return product;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public Integer getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    @PostConstruct
    //todo reikia nustatyti saraso reiksme ne per set metoda, o priskiriant
    public void init(){
        setL(purchaseHistoryService.findAllCartsForPurchaseHistory(user));
    }
    //todo seno krepselio (ar prekes, pasitiksink uzsaakovo klausimuose) pridejimas i nauja
}
