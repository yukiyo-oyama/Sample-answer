package model;

import java.io.Serializable;

public class ReportCard implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private int classNumber;
    private String name;
    private int englishScore;
    private int mathScore;
    
    public ReportCard(){
    }
    
    public ReportCard(int id,int classNumber,String name,int englishScore,int mathScore){
        this.id =id;
        this.classNumber = classNumber;
        this.name = name;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClassNumber() {
        return classNumber;
    }
    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnglishScore() {
        return englishScore;
    }
    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }
    public int getMathScore() {
        return mathScore;
    }
    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
    @Override
    public String toString() {
        return "ID:" + this.getId() + " " + this.getClassNumber() + "組 " + this.getName()
        + " 英語" + this.getEnglishScore() + "点 数学" + this.getMathScore() + "点";
    }
}
