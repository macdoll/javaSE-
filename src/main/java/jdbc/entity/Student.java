package jdbc.entity;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 17:09
 * @return
 */
public class Student {
    private Integer stuId;
    private String stuName;
    private String stuBirthday;
    private String email;
    private String stuGender;
    private Integer seat;
    private Integer classesId;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuBirthday='" + stuBirthday + '\'' +
                ", email='" + email + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", seat=" + seat +
                ", classesId=" + classesId +
                '}';
    }
}
