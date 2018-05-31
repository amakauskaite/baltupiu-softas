package lt.baltupiusoftas.project.domain.data;

/**
*/
public class Payment {

    private Integer amount;

    private String number;

    private String holder;

    private Integer exp_year;

    private Integer exp_month;

    private String cvv;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getExp_year() {
        return exp_year;
    }

    public void setExp_year(Integer exp_year) {
        this.exp_year = exp_year;
    }

    public Integer getExp_month() {
        return exp_month;
    }

    public void setExp_month(Integer exp_month) {
        this.exp_month = exp_month;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
