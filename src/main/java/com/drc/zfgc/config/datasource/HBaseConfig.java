//package com.drc.zfgc.config.datasource;
//
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.hadoop.hbase.HbaseTemplate;
//
///**
// * @author tengchao.li
// * @description
// * @date 2020/11/2
// */
//@Configuration
//@ConfigurationProperties(prefix = "spring.datasource.hbase")
//@Data
//public class HBaseConfig {
//
//   // @Value("${hbase.zookeeper.quorum}")
//    private String quorum;
//
//  //  @Value("${hbase.zookeeper.property.clientPort}")
//    private String port;
//
//    //@Value("${zookeeper.znode.parent}")
//    private String parent;
//
//
//  /*  private void HBaseHolder(@Value("${common.hbase.nodes}") String nodes,
//                             @Value("${common.hbase.maxsize:#{null}}") Long maxsize,
//                             @Value("${common.hbase.user:#{null}}") String user) {
//   //     super();
//        Configuration configuration =  HBaseConfiguration.create();
//        configuration.set("zookeeper.znode.parent", "/hbase-unsecure");
//        configuration.set("hbase.zookeeper.quorum", nodes);
//        if (maxsize != null) {
//            configuration.set("hbase.client.keyvalue.maxsize",
//                    maxsize.toString());
//        }
//
//        try {
//            if (user == null) {
//                connection = ConnectionFactory.createConnection(configuration);
//            } else {
//                connection = ConnectionFactory.createConnection(configuration,
//                        User.create(UserGroupInformation.createRemoteUser(user)));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }*/
//
//
//
//    @Bean
//    public HbaseTemplate hbaseTemplate() {
//        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
//        conf.set("hbase.zookeeper.quorum", quorum);
//        conf.set("hbase.zookeeper.property.clientPort", port);
//    //    conf.set("zookeeper.znode.parent", znodeParent);
//        return new HbaseTemplate(conf);
//    }
//}
