package com.graduationproject.schoolmapsystem.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityGenerator {
    private static final Logger logger = LoggerFactory.getLogger(com.graduationproject.schoolmapsystem.utils.EntityGenerator.class);

    private final static String AUTHOR = "author";

    private final static String URL = "url";

    private final static String TABLE = "table";

    private final static String PASSWORD = "password";

    private final static String USER_NAME = "username";

    private final static String MODULE_NAME = "moduleName";

    private final static String DRIVER_NAME = "driverName";

    private final static String MODULE_ROOT_PATH = "rootPath";

    private final static String TABLE_MODULE_MAPPING = "mapping";

    public static void main(String[] args) {
        //代码自动生成
        Map configData;
        try {
            ObjectMapper mapper = new ObjectMapper();
            configData = mapper.readValue(ResourceUtils.
                    getFile("classpath:config/cfg.json"), Map.class);
        } catch (Exception e){
            logger.debug("Parse the config failure , reason : {}", e);
            throw new RuntimeException("Parse config generate file failure");
        }

        List<Map<String, Object>> listMapping = (List<Map<String, Object>>) configData.get(TABLE_MODULE_MAPPING);
        for (Map<String, Object> obj : listMapping){
            String moduleName = obj.get(MODULE_NAME).toString();
            List<String> tables = (List<String>) obj.get(TABLE);
            String[] arr = new String[tables.size()];
            tables.toArray(arr);
            createCode(configData, moduleName, arr);
        }
    }

    /**
     * 生成代码
     *
     * @param configData 配置数据
     * @param moduleName 模块名称
     * @param tables     生成表名
     */

    private static void createCode(Map<String, Object> configData, String moduleName, String[] tables) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String projectPath = com.graduationproject.schoolmapsystem.utils.EntityGenerator.class.getResource("").getPath().split("target")[0];
        String author = configData.get(AUTHOR).toString();
        //全局配置
        GlobalConfig globalConfig = buildGlobalConfig(author, projectPath); //com.baomidu.mybatisplus.core和com.baomidu.mybatisplus.generator?
        mpg.setGlobalConfig(globalConfig);
        //数据库配置
        String url = configData.get(URL).toString();
        String password = configData.get(PASSWORD).toString();
        String userName = configData.get(USER_NAME).toString();
        String driverName = configData.get(DRIVER_NAME).toString();
        //数据源配置
        DataSourceConfig dataSource = buildDataSource(url, driverName, userName, password);
        mpg.setDataSource(dataSource);
        //模板配置
        mpg.setTemplate(new TemplateConfig().setXml(null));
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        String moduleRootPath = configData.get(MODULE_ROOT_PATH).toString();
        InjectionConfig injectionConfig = buildInjectionConfig(projectPath);
        mpg.setCfg(injectionConfig);
        //包配置
        PackageConfig packageConfig = buildPageConfig(moduleName, moduleRootPath);
        mpg.setPackageInfo(packageConfig);
        //策略配置
        StrategyConfig strategyConfig = buildStrategy(tables);
        mpg.setStrategy(strategyConfig);
        mpg.execute();
    }

    /**
     * 数据库表配置
     *
     * @param tables 表名
     */
    private static StrategyConfig buildStrategy(String... tables) {
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //表前缀
        strategyConfig.setTablePrefix("t_","sys_");
        //包含的表名  生成包括这里的表
//        strategyConfig.setInclude(tables);
        strategyConfig.setExclude(); //生成除了这里的表,留空则为生成所有表
        //是否为lombok模型
        strategyConfig.setEntityLombokModel(Boolean.TRUE);
        //是否为链式模型
        strategyConfig.setChainModel(Boolean.TRUE);
        //是否生成字段常量
        strategyConfig.setEntityColumnConstant(Boolean.TRUE);
        //数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.no_change);
        return strategyConfig;
    }


    /**
     * 包配置
     *
     * @param moduleName     父包模块名
     * @param moduleRootPath 父包名
     */
    private static PackageConfig buildPageConfig(String moduleName, String moduleRootPath) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(moduleName);
        packageConfig.setParent(moduleRootPath);
        return packageConfig;
    }

    /**
     * 自定义配置
     *
     * @param projectPath 项目名称
     */
    private static InjectionConfig buildInjectionConfig(String projectPath) {
        InjectionConfig config = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输入文件名称
                return projectPath + "/src/main/resources/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        //自定义输出文件
        config.setFileOutConfigList(focList);
        return config;
    }

    /**
     * 配置数据源
     *
     * @param url        数据库url
     * @param driverName 驱动名称
     * @param userName   数据库用户名
     * @param password   数据库密码
     */
    private static DataSourceConfig buildDataSource(String url, String driverName, String userName, String password) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setUsername(userName);
        dataSourceConfig.setPassword(password);
        dataSourceConfig.setDriverName(driverName);
        //数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        //类型转换
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert(){
            //自定义数据库表字段类型转换
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType){
                fieldType = fieldType.contains("decimal") ? "double" : fieldType;
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });
        return dataSourceConfig;
    }


    /**
     * 全局配置
     *
     * @param author      开发人员
     * @param projectPath 项目路径
     */
    private static GlobalConfig buildGlobalConfig(String author, String projectPath) {
        GlobalConfig globalConfig = new GlobalConfig();
        //是否覆盖现有文件
        globalConfig.setFileOverride(true);
        //时间类型对应策略
        globalConfig.setDateType(DateType.ONLY_DATE);
        //生成文件的输出目录
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        //开发人员
        globalConfig.setAuthor(author);
        //开启ActiveRecord模式
        globalConfig.setActiveRecord(Boolean.TRUE);
        //XML二级缓存
        globalConfig.setEnableCache(false);
        //XML ResultMap
        globalConfig.setBaseResultMap(true);
        //XML columnList
        globalConfig.setBaseColumnList(false);
        //service 命名方式
        globalConfig.setServiceName("%sService");
        return globalConfig;
    }


}
