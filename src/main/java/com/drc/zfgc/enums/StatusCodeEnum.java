package com.drc.zfgc.enums;

/**
 * 中标公告
 */
public enum StatusCodeEnum {

    NORMAL(1, "新版"),
    M_DEL(2, "旧版,机器预处理"),
    PEOPLE_DEL(3, "重点处理,人工干预"),
    ROBOT_PRO_NO(4,"notice字段标识,此项目编号为机器正则处理"),
    NO_PRO_NO(5,"notice字段标识,此项目编号为随机生成"),
    WIN_BID_INFO_NO_OK(6, "中标信息不明确,重点处理,人工干预"),
 //   NO_PRO_NO(5, "未成功获取项目编号"),
    DEAL(9, "已处理");



    private int code;
    private String desc;
   /* private String regex;
    private String rule;*/

    StatusCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
       /* this.regex = regex;
        this.rule = rule;
*/

    }

    /* public static TypeStatusEnum getFiledType(String key){

          for (TypeStatusEnum en : TypeStatusEnum.values()){
              if(keyIsContains(key,en.getRule())){
                  return en;
             }

         }
          return null;
     }*/
    public static String key2Type(String key) {

        String[] typeArr = new String[]{"单一来源公告", "竞争性磋商公告", "公开招标公告", "中标公告"
                , "采购合同公告", "中标候选人公告", "邀请招标公告", "废标终止公告", "资格预审公告"};

        for (String str : typeArr) {
            if (str.contains(key)) {
                return str;
            }
        }

		return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setHeaderType(String desc) {
        this.desc = desc;
    }


}
