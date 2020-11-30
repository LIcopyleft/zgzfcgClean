package com.drc.zfgc.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.spring.springbootdemo.mapper.mysql", sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlDataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource applogDataSource() {
        return new DruidDataSource();
    }
    @Primary
    @Bean(name = "mysqlSqlSessionFactory")
    public SqlSessionFactory applogSqlSessionFactory(
        @Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.spring.springbootdemo.model");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:mapper/mysql/**/*.xml"));
       /* bean.setConfigLocation(new PathMatchingResourcePatternResolver()
            .getResource("classpath:mybatis-config.xml"));*/
        return bean.getObject();
    }

}
