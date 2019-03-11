package com.chaoxing.config;

import com.chaoxing.mybatis.BaseDataSource;
import com.chaoxing.mybatis.MyBatisRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "${chaoxing.mybatis.basePackage:com.chaoxing.dao}", annotationClass = MyBatisRepository.class, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig extends BaseDataSource implements TransactionManagementConfigurer {

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Value("${chaoxing.mybatis.typeAliasPackage:com.chaoxing.model}") String typeAliasPackage) throws Exception {
        return sqlSessionFactory(dataSource, typeAliasPackage, "mysql");

    }

    @Bean(name = "transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}