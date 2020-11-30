package com.drc.zfgc.model;

public class CompanyInfo {
    private Integer urlId;

    private String corptel;

    private String auditplace;

    private String contactnm;

    private String bizlicregno;

    private String agentnm;

    private String officeaddr;

    private String regvaliddatestr;

    private String hashcode;

    private String allData;

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getCorptel() {
        return corptel;
    }

    public void setCorptel(String corptel) {
        this.corptel = corptel == null ? null : corptel.trim();
    }

    public String getAuditplace() {
        return auditplace;
    }

    public void setAuditplace(String auditplace) {
        this.auditplace = auditplace == null ? null : auditplace.trim();
    }

    public String getContactnm() {
        return contactnm;
    }

    public void setContactnm(String contactnm) {
        this.contactnm = contactnm == null ? null : contactnm.trim();
    }

    public String getBizlicregno() {
        return bizlicregno;
    }

    public void setBizlicregno(String bizlicregno) {
        this.bizlicregno = bizlicregno == null ? null : bizlicregno.trim();
    }

    public String getAgentnm() {
        return agentnm;
    }

    public void setAgentnm(String agentnm) {
        this.agentnm = agentnm == null ? null : agentnm.trim();
    }

    public String getOfficeaddr() {
        return officeaddr;
    }

    public void setOfficeaddr(String officeaddr) {
        this.officeaddr = officeaddr == null ? null : officeaddr.trim();
    }

    public String getRegvaliddatestr() {
        return regvaliddatestr;
    }

    public void setRegvaliddatestr(String regvaliddatestr) {
        this.regvaliddatestr = regvaliddatestr == null ? null : regvaliddatestr.trim();
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode == null ? null : hashcode.trim();
    }

    public String getAllData() {
        return allData;
    }

    public void setAllData(String allData) {
        this.allData = allData == null ? null : allData.trim();
    }
}
