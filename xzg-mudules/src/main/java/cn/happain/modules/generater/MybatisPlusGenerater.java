package cn.happain.admin.generater;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

public class MybatisPlusGenerater {
    static String url ="jdbc:mysql://127.0.0.1:3306/happain-alm?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    static String username ="root";
    static String password ="123456";

    public static void main(String[] args) {

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("happain") // 设置作者
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd")
                            .outputDir("code"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.happain.admin.modules") // 设置父包名
                            .moduleName("almModule") // 设置父包模块名
                            .entity("model")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .controller("controller")
                            .other("other")
                            .xml("xml");
                            ; // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("alm_menu_permission") // 设置需要生成的表名
                            .addTablePrefix("");
                })
                .templateConfig(builder -> {
                    builder.entity("/generaterTemplates/entity.java")
                            .service("/generaterTemplates/service.java")
                            .serviceImpl("/generaterTemplates/serviceImpl.java")
                            .mapper("/generaterTemplates/mapper.java")
                            .xml("/generaterTemplates/mapper.xml")
                            .controller("/generaterTemplates/controller.java");

                })
                .strategyConfig(builder -> {
                      builder.entityBuilder()
                            .enableChainModel()
                            .enableLombok()
                            .idType(IdType.AUTO)
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                            .formatFileName("%sModel");
                })
                .strategyConfig(builder -> {
                    builder.controllerBuilder()
                            .enableRestStyle()
                            .formatFileName("%sController");
                })
                .strategyConfig(builder -> {
                    builder.mapperBuilder()
                            .enableMapperAnnotation()
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper");
                })

                .execute();
    }
}
