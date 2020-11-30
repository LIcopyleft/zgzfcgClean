package com.drc.zfgc.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/4
 */
public class PropertiesUtil {
    static Properties properties = new Properties();

    public static Properties getResource(String filepath) throws IOException {

        if (StringUtils.isNotBlank(filepath)) {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));

            properties.load(bufferedReader);

            return properties;
        }
        return null;
    }


}
