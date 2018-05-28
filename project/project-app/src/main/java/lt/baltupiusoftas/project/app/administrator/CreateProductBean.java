package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CategoryService;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;

@RequestScoped
@Model
public class CreateProductBean {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private AdministratorLogin administratorLogin;
    private Product product;
    private String categoryName;


    @PostConstruct
    private void setUp(){
        // if admin is not logged in, redirect to error page
        if(administratorLogin.getAdministrator() == null)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            }
            catch (IOException ioe)
            {
                System.out.println("Failed to redirect to another page in "+this.getClass().getName());
            }
        }
        product = new Product();
    }



    @Transactional(Transactional.TxType.REQUIRED)
    public void addProduct(){
        product.setCategory(categoryService.addCategory(categoryName));
        productService.add(product);
        FacesContext.getCurrentInstance().addMessage("addBtn", new FacesMessage(FacesMessage.SEVERITY_INFO,"Sėkmė!",  "Prekė sėkmingai pridėta."));

    }

    private void clear(){
        product.setCategory(null);
        product.setName(null);
        product.setPhoto(null);
        product.setPrice(null);
        product.setSummary(null);
        product.setSKU(null);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
