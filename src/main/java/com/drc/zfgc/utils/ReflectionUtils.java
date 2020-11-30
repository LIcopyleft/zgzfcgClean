package com.drc.zfgc.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tengchao.li
 * @description
 * @date 2020/3/9
 */
public class ReflectionUtils {

    public static Object mapToField(Map<String, String> map, Object data, Set set) throws InvocationTargetException, IllegalAccessException {

        // 合并
        // Set set = Contant.filedValueSet();
        //遍历 Map中key
        //proNo ： 项目标号，编号，
        // 合并后打印出所有内容
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = "";
            try {

             key = entry.getKey();
            }catch (Exception e){
                throw e;
            }
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                //   if (next.contains(key) /*|| keyIsContains(key, next)*/) {
                if (HtmlUtils.keyIsContains(key, next)) {
                    //   DataContentWithBLOBs data = new DataContentWithBLOBs();
                    //   Field[] declaredFields = data.getClass().getDeclaredFields();
                    BeanInfo beanInfo;
                    try {
                        beanInfo = Introspector.getBeanInfo(data.getClass());
                    } catch (IntrospectionException e) {
                        return data;
                    }
                    List<PropertyDescriptor> descriptors = Arrays.stream(beanInfo.getPropertyDescriptors()).filter(p -> {
                        String name = p.getName();
                        //过滤掉不需要修改的属性
                        return !"class".equals(name) && !"id".equals(name);
                    }).collect(Collectors.toList());

                    for (PropertyDescriptor descriptor : descriptors) {
                        //descriptor.getWriteMethod()方法对应set方法
                        if (descriptor.getName().equals(next.split(":")[0])) {
                            Method writeMethod = descriptor.getWriteMethod();
                            try {

                            writeMethod.invoke(data, HtmlUtils.maxStrLen(entry.getValue()));
                            }catch (Exception e){
                                String.valueOf(1);
                            }
                        }
                    }
                }
            }
        }

        return data;
    }




}
