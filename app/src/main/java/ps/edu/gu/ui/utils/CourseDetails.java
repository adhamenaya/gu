package ps.edu.gu.ui.utils;

public class CourseDetails {
    public String name, programId, priceBeforeSch, priceAfterSch,
            degreeType, percentage, comments, degree, schPercentage;
    public boolean isHeader = false;

    public CourseDetails(String programId ,String name,String degree,
                         String degreeType,String percentage,
                         String priceBeforeSch,String schPercentage, String priceAfterSch,  String comments
                          ){
        this.name= name;
        this.programId= programId;
        this.priceBeforeSch= priceBeforeSch;
        this.priceAfterSch= priceAfterSch;
        this.degreeType= degreeType;
        this.percentage= percentage;
        this.comments= comments;
        this.degree= degree;
        this.schPercentage= schPercentage;
    }
}
