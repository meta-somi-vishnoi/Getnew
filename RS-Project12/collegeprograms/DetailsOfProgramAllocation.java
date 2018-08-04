package collegeprograms;

class DetailsOfProgramAllocation {
    private String name;
    private int capacity;
    DetailsOfProgramAllocation(String name, int capacity) {
        this.name=name;
        this.capacity=capacity;
    }
    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity() {
        capacity--;
    }
}
class Student {
    private  String name;
    private String firstPreference;
    private String secondPreference;
    private String thirdPreference;
    private String fourthPreference;
    private String fifthPreference;
    private String subjectAllocated;
    Student(String name, String firstPreference, String secondPreference, String thirdPreference, String fourthPreference, String fifthPreference) {
        this.name=name;
        this.firstPreference=firstPreference;    
        this.secondPreference=secondPreference;
        this.thirdPreference=thirdPreference;
        this.fourthPreference=fourthPreference;
        this.fifthPreference=fifthPreference;
        subjectAllocated=" ";
    }
    public String getStudentName() {
        return name;
    }
    public String getFirstPreference() {
        return firstPreference;
    }
    public String getSecondPreference() {
        return secondPreference;
    }
    public String getThirdPreference() {
        return thirdPreference;
    }
    public String getFourthPreference() {
        return fourthPreference;
    }
    public String getFifthPreference() {
        return fifthPreference;
    }
    public String getSubjectAllocated() {
        return subjectAllocated;
    }
    public void setSubjectAllocated(String subject) {
        subjectAllocated=subject;
    }
}

class Output{
    String name;
    String course;
    Output(String name, String course) {
        this.name=name;
        this.course=course;
    }
    public String getNameOfStudent() {
        return name;
    }
    public String getCourse() {
        return course;
    }
}