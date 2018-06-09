package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryData {

    private final StringProperty catID;
    private final StringProperty catName;
    private final StringProperty catPercent;
    private final StringProperty catStatus;

    public String getCatID() {
        return catID.get();
    }

    public StringProperty catIDProperty() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID.set(catID);
    }

    public String getCatName() {
        return catName.get();
    }

    public StringProperty catNameProperty() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName.set(catName);
    }

    public String getCatPercent() {
        return catPercent.get();
    }

    public StringProperty catPercentProperty() {
        return catPercent;
    }

    public void setCatPercent(String catPercent) {
        this.catPercent.set(catPercent);
    }

    public String getCatStatus() {
        return catStatus.get();
    }

    public StringProperty catStatusProperty() {
        return catStatus;
    }

    public void setCatStatus(String catStatus) {
        this.catStatus.set(catStatus);
    }


    public CategoryData(String catID, String catName, String catPercent, String catStatus) {
        this.catID = new SimpleStringProperty(catID);
        this.catName = new SimpleStringProperty(catName);
        this.catPercent = new SimpleStringProperty(catPercent);
        this.catStatus = new SimpleStringProperty(catStatus);
    }
}
