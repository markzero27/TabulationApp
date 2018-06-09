package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JudgeData {
    private final StringProperty judgeNum;
    private final StringProperty judgeFname;
    private final StringProperty judgeLname;
    private final StringProperty judgeStatus;
    private final StringProperty judgeConn;

    public String getJudgeNum() {
        return judgeNum.get();
    }

    public StringProperty judgeNumProperty() {
        return judgeNum;
    }

    public void setJudgeNum(String judgeNum) {
        this.judgeNum.set(judgeNum);
    }

    public String getJudgeFname() {
        return judgeFname.get();
    }

    public StringProperty judgeFnameProperty() {
        return judgeFname;
    }

    public void setJudgeFname(String judgeFname) {
        this.judgeFname.set(judgeFname);
    }

    public String getJudgeLname() {
        return judgeLname.get();
    }

    public StringProperty judgeLnameProperty() {
        return judgeLname;
    }

    public void setJudgeLname(String judgeLname) {
        this.judgeLname.set(judgeLname);
    }

    public String getJudgeStatus() {
        return judgeStatus.get();
    }

    public StringProperty judgeStatusProperty() {
        return judgeStatus;
    }

    public void setJudgeStatus(String judgeStatus) {
        this.judgeStatus.set(judgeStatus);
    }

    public String getJudgeConn() {
        return judgeConn.get();
    }

    public StringProperty judgeConnProperty() {
        return judgeConn;
    }

    public void setJudgeConn(String judgeConn) {
        this.judgeConn.set(judgeConn);
    }

    public JudgeData(String judgeNum, String judgeFname, String judgeLname, String judgeStatus, String judgeConn) {
        this.judgeNum = new SimpleStringProperty(judgeNum);
        this.judgeFname = new SimpleStringProperty(judgeFname);
        this.judgeLname = new SimpleStringProperty(judgeLname);
        this.judgeStatus = new SimpleStringProperty(judgeStatus);
        this.judgeConn = new SimpleStringProperty(judgeConn);
    }
}
