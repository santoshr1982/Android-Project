package list.ado.to.rsantosh.com.todolist.Model;

/**
 * Created by C S Ramachandran on 31-05-2016.
 */
public class DryCleaningModel {

    public String strNameOfCloth;
    public String strNumberOfCloth;
    public String strDateOfGiving;
    public String strDateOfReceiving;

    public DryCleaningModel(String strNameOfCloth, String strNumberOfCloth, String strDateOfGiving, String strDateOfReceiving) {
        this.strNameOfCloth = strNameOfCloth;
        this.strNumberOfCloth = strNumberOfCloth;
        this.strDateOfGiving = strDateOfGiving;
        this.strDateOfReceiving = strDateOfReceiving;
    }
}
