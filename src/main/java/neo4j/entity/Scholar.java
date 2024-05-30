package neo4j.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NoArgsConstructor
@ToString
@NodeEntity
@JsonIgnoreProperties(value = {"scholarId","entityId","teacherId"})
public class Scholar {

    @Id
    @GeneratedValue
    private Long id;

    @Property("teacher_id")
    private String teacherId;
    private String name;
    private String sex;
//    private String organization;
    @Property("sub_organization")
    private String subOrganization;
    private String education;
    @Property("study_speciality")
    private String studySpeciality;
    private String title;
    @Property("tutor_type")
    private String tutorType;
    private String email;
    private String maxPageCount;
//TODO:这三个属性映射不过来
//        private String affiliate;
//    private String scholarId;
//    private String entityId;

    private String doMain;
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(String teacherId) {
//        this.teacherId = teacherId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getOrganization() {
//        return organization;
//    }
//
//    public void setOrganization(String organization) {
//        this.organization = organization;
//    }
//
//    public String getSubOrganization() {
//        return subOrganization;
//    }
//
//    public void setSubOrganization(String subOrganization) {
//        this.subOrganization = subOrganization;
//    }
//
//    public String getEducation() {
//        return education;
//    }
//
//    public void setEducation(String education) {
//        this.education = education;
//    }
//
//    public String getStudySpeciality() {
//        return studySpeciality;
//    }
//
//    public void setStudySpeciality(String studySpeciality) {
//        this.studySpeciality = studySpeciality;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getTutorType() {
//        return tutorType;
//    }
//
//    public void setTutorType(String tutorType) {
//        this.tutorType = tutorType;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMaxPageCount() {
//        return maxPageCount;
//    }
//
//    public void setMaxPageCount(String maxPageCount) {
//        this.maxPageCount = maxPageCount;
//    }
//
//    public String getAffiliate() {
//        return affiliate;
//    }
//
//    public void setAffiliate(String affiliate) {
//        this.affiliate = affiliate;
//    }
//
//    public String getScholarId() {
//        return scholarId;
//    }
//
//    public void setScholarId(String scholarId) {
//        this.scholarId = scholarId;
//    }
//
//    public String getEntityId() {
//        return entityId;
//    }
//
//    public void setEntityId(String entityId) {
//        this.entityId = entityId;
//    }
//
//    public String getDoMain() {
//        return doMain;
//    }
//
//    public void setDoMain(String doMain) {
//        this.doMain = doMain;
//    }
}
