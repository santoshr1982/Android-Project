package list.ado.to.rsantosh.com.todolist.Model;

/**
 * Created by C S Ramachandran on 30-05-2016.
 */
public class ListDetails {

    public String strProductName;
    public String strDate;
    public String strTime;
    public int Id;




    public ListDetails(int id, String strProductName, String strDate, String strTime) {
        this.strProductName = strProductName;
        this.strDate = strDate;
        this.strTime = strTime;
        Id=id;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStrProductName() {
        return strProductName;
    }

    public void setStrProductName(String strProductName) {
        this.strProductName = strProductName;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }
}
