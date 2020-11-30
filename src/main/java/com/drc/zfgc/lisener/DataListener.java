package com.drc.zfgc.lisener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.drc.zfgc.model.CompanyInfo;
import com.drc.zfgc.model.Items;
import com.drc.zfgc.model.Region;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//@Component
public class DataListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataListener.class);

  /*  @Autowired
    private DataContentMapper mapper;*/

    //databaseId  对应  DataSet

    private static List<Region> cityClusters = new ArrayList<Region>();
    private static List<Items> itemsList = new ArrayList<Items>();
    private static List<CompanyInfo> companyList = new ArrayList<CompanyInfo>();

    public static List<Region> getRegionByName(String regionName) {
        if (regionName == null) {
            return null;
        }
        List<Region> list = new LinkedList<>();
        for (Region reg : cityClusters) {
            if (reg.getName().contains(regionName)) {
                list.add(reg);
            }
        }
        return list;

    }

    public static Region getRegionByRegionId(String regionId) {

        if (regionId == null) {
            return null;
        }

        for (Region reg : cityClusters) {
            if (reg.getRegionId().equals(regionId)) {
                return reg;
            }
        }
        return null;
    }

   /* @PostConstruct
    public void init() throws Exception {
        putCache();
    }*/

    static {

        putCache();

    }

    public static void main(String[] args) {
      //  putCache();
    }

    public static void putCache() {
        //    Reader reader = new ReaderInputStream();
        //    String[] arr = new String[]{"region.json","items.json","company.json"};
        LOGGER.info("开始加载缓存..............................................................................");
        System.out.println("开始加载缓存...");
        try {
            InputStream region_in = DataListener.class.getResourceAsStream("/json/region.json");
            InputStream company_in = DataListener.class.getResourceAsStream("/json/company.json");
            InputStream items_in = DataListener.class.getResourceAsStream("/json/items.json");
            Map regionMap = (Map) JSON.parseObject(region_in, Map.class);
            Map companyMap = (Map) JSON.parseObject(company_in, Map.class);
            Map itemMap = (Map) JSON.parseObject(items_in, Map.class);
            Object regionObj = regionMap.get("RECORDS");
            Object companyObj = companyMap.get("RECORDS");
            Object itemsObj = itemMap.get("RECORDS");



        //    Object regionObj = JSON.parseObject(FileUtils.readFileToString(new File("src/main/resources/json/region.json"),"utf-8"), Map.class).get("RECORDS");

            //    JSON.
            cityClusters = JSON.parseObject(regionObj.toString(), new TypeReference<List<Region>>(){});
        //    Object itemsObj = JSON.parseObject(FileUtils.readFileToString(new File("src/main/resources/json/items.json"),"utf-8"), Map.class).get("RECORDS");
            itemsList = JSON.parseObject(itemsObj.toString(), new TypeReference<List<Items>>(){});
        //    Object companyObj = JSON.parseObject(FileUtils.readFileToString(new File("src/main/resources/json/company.json"),"utf-8"), Map.class).get("RECORDS");
            companyList = JSON.parseObject(companyObj.toString(), new TypeReference<List<CompanyInfo>>(){});

           /* Object regionObj = JSON.parseObject(FileUtils.readFileToString(new File("src/main/resources/json/region.json"),"utf-8"), Map.class).get("RECORDS");

        //    JSON.
            cityClusters = JSON.parseObject(regionObj.toString(), new TypeReference<List<Region>>(){});
            Object itemsObj = JSON.parseObject(FileUtils.readFileToString(new File("src/main/resources/json/items.json"),"utf-8"), Map.class).get("RECORDS");
            itemsList = JSON.parseObject(itemsObj.toString(), new TypeReference<List<Items>>(){});
            Object companyObj = JSON.parseObject(FileUtils.readFileToString(new File("src/main/resources/json/company.json"),"utf-8"), Map.class).get("RECORDS");
            companyList = JSON.parseObject(companyObj.toString(), new TypeReference<List<CompanyInfo>>(){});*/

        //    System.out.println("缓存加载完成: \"region.json\",\"items.json\",\"company.json\"");
            LOGGER.info("缓存加载完成: \"region.json\",\"items.json\",\"company.json\"");
            System.out.println("加载缓存完成...");

        } catch (IOException e) {
            e.printStackTrace();
        }


       /* cityClusters = mapper.selectAllRegion();
        itemsList = mapper.selectAllItems();
        companyList = mapper.selectAllCompany();*/
        //    mapper.se
        //   cityClusters.addAll()
    }

    public static List<Region> getRegionList() {
        return cityClusters;
    }

    public static Region getRegionByName(String name, Integer level) {
        if (name == null) {
            return null;
        }
        boolean flag = false;

        if (level != null) {
            flag = true;
        }

        for (Region reg : cityClusters) {
            if (flag && reg.getName().contains(name) && reg.getLevel().equals(String.valueOf(level))) {
                return reg;
            } else if (!flag && reg.getName().contains(name)) {
                return reg;
            }
        }
        return null;
    }

    public static List<CompanyInfo> getCompanyList() {
        return companyList;
    }

    public static Items getItemByName(String name) {
        for (Items it : itemsList) {
            if (it.getItemName().equals(name)) {
                return it;
            }
        }
        return null;

    }

    public static CompanyInfo getCompanyByName(String name) {
        for (CompanyInfo it : companyList) {
            if (it.getAgentnm().equals(name)) {
                return it;
            }
        }
        return null;

    }


}
