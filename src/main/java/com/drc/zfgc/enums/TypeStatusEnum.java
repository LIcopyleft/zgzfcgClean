package com.drc.zfgc.enums;

/**
 * 中标公告
 */
public enum TypeStatusEnum {

    NO_DEAL("0", "未处理"),
    OTHER_ROBOT_PRE_DEAL("5", "其他公告机器预处理"),
    OTHER_ROBOT_NO_PRE_DEAL("6", "其他公告机器未预处理,需要人工协助处理"),
    DEAL("2", "已处理");


    private String code;
    private String desc;
   /* private String regex;
    private String rule;*/

    TypeStatusEnum(String code, String desc) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setHeaderType(String desc) {
        this.desc = desc;
    }


}
