package com.drc.zfgc.model;

import lombok.Data;

@Data
public class CompanyDBInfo extends CompanyDBInfoKey {
    private String name;

    private String connect;

    private String phoneNum;

    private String registeredAddr;

    private String regDate;

    private String regAddr;

    private String remarks;



}
