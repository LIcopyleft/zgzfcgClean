import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/4
 */
public class Test {

    public static void main(String[] args) throws IOException {

     //   getResource();
        StringUtils.reverse("10000");
        String regionCode = "123333";

        regionCode = regionCode.substring(0, 2) + "0000";
        System.out.println(regionCode);
        String a = "9999999999999999";

        String s = "0000000000000000";

        String urlId = null;
        for (int i = 1; i < 10; i++) {
            urlId = i + "";

            if (urlId.length() < 16) {
                String s1 = s.substring(0, 16 - urlId.length()) + urlId;
                //   System.out.println(s1);

                String reverse = StringUtils.reverse(s1);
                System.out.println(s1);
                System.out.println(reverse);
            }
        }


        String aa = "_";
        String aaa = "1";
        System.out.println("utf-8编码下'hello'所占的字节数:" + a.getBytes("utf-8").length);
        System.out.println("utf-8编码下'hello'所占的字节数:" + aa.getBytes("utf-8").length);
        System.out.println("utf-8编码下'hello'所占的字节数:" + aaa.getBytes("utf-8").length);


    }


}
