package info.codestart.glinogaprdrecrds;

/**
 * Created by Ronsoft on 11/13/2017.
 */

public class Person {

    private long id;
    private String name;
    private String age;
    private String address;
    private String date;
    private String contactnumber;
    private String lefteyegrade;
    private String righteyegrade;
    private String payment;
    private String AOD;
    private String oldRX;
    private String specialfindings;
    private String additionaltest;
    private String management;
    private String casehistory;
    private String chiefcomplaint;
    private String diagnosis;

    public Person() {
    }

    public Person(String name, String age, String address, String date, String contactnumber, String lefteyegrade, String righteyegrade, String AOD, String oldRX, String specialfindings, String additionaltest, String management, String casehistory, String chiefcomplaint, String diagnosis, String payment) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.date = date;
        this.contactnumber = contactnumber;
        this.lefteyegrade = lefteyegrade;
        this.righteyegrade = righteyegrade;
        this.AOD = AOD;
        this.oldRX = oldRX;
        this.specialfindings = specialfindings;
        this.additionaltest = additionaltest;
        this.management = management;
        this.casehistory = casehistory;
        this.chiefcomplaint = chiefcomplaint;
        this.diagnosis = diagnosis;
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getLefteyegrade() {
        return lefteyegrade;
    }

    public void setLefteyegrade(String lefteyegrade) {
        this.lefteyegrade = lefteyegrade;
    }

    public String getRighteyegrade() {
        return righteyegrade;
    }

    public void setRighteyegrade(String righteyegrade) {
        this.righteyegrade = righteyegrade;
    }

    public String getAOD() {
        return AOD;
    }

    public void setAOD(String AOD) {
        this.AOD = AOD;
    }

    public String getOldRX() {
        return oldRX;
    }

    public void setOldRX(String oldRX) {
        this.oldRX = oldRX;
    }

    public String getSpecialfindings() {
        return specialfindings;
    }

    public void setSpecialfindings(String specialfindings) {
        this.specialfindings = specialfindings;
    }

    public String getAdditionaltest() {
        return additionaltest;
    }

    public void setAdditionaltest(String additionaltest) {
        this.additionaltest = additionaltest;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getCasehistory() {
        return casehistory;
    }

    public void setCasehistory(String casehistory) {
        this.casehistory = casehistory;
    }

    public String getChiefcomplaint() {
        return chiefcomplaint;
    }

    public void setChiefcomplaint(String chiefcomplaint) {
        this.chiefcomplaint = chiefcomplaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}