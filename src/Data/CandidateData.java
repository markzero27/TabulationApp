package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CandidateData {

    private final StringProperty num;
    private final StringProperty gend;
    private final StringProperty name;
    private final StringProperty course;
    private final StringProperty stats;
    private final StringProperty lock;

    public CandidateData(String num,String gend,String name,String course,String stats,String lock){
        this.num = new SimpleStringProperty(num);
        this.gend = new SimpleStringProperty(gend);
        this.name = new SimpleStringProperty(name);
        this.course = new SimpleStringProperty(course);
        this.stats = new SimpleStringProperty(stats);
        this.lock = new SimpleStringProperty(lock);
    }

    public String getNum() {
        return num.get();
    }

    public StringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getGend() {
        return gend.get();
    }

    public StringProperty gendProperty() {
        return gend;
    }

    public void setGend(String gend) {
        this.gend.set(gend);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCourse() {
        return course.get();
    }

    public StringProperty courseProperty() {
        return course;
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public String getStats() {
        return stats.get();
    }

    public StringProperty statsProperty() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats.set(stats);
    }

    public String getLock() {
        return lock.get();
    }

    public StringProperty lockProperty() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock.set(lock);
    }
}
