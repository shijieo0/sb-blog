# sb-blog
## API设计

GET /users : 返回用于展现用户列表的list.html页面

GET /users/{id} : 返回用于展现用户的view.html页面；

GET /users/form : 返回用于新增或者修改用户的form.html页面；

POST /users : 新增或者修改用户，成功后重定向到list.html页面；

GET /users/delete/{id} : 根据id删除相应的用户数据，成功后重定向到list.html页面；

GET /users/modify/{id} : 根据id获取相应的用户数据并返回form.html页面用来执行修改。

## 后台编码

* 实体 User

* 资源库 UserRepository

* 控制器 UserController

## 前端编码

* list.html ：用于展现用户列表
* form.html：用于新增或者修改用户的资料
* view.html：用户查看某个用户的资料

* header.html：共用的头部页面
* footer.html：共用的底部页面

## 数据持久化

> 什么是JPA

* JPA（Java Persistence API）是用于管理Java EE 和 Java SE 环境中的持久化，以及对象/关系映射的Java API
* 最新规范为“[JSR 338：Java Persistence 2.1](https://jcp.org/en/jsr/detail?id=338)”
* 实现：EclipseLink、Hibernate、Apache OpenJPA

> JPA核心概念

* 实体

  * 实体表示关系数据库中的表
  * 每个实体实例对应于该表中的行
  * 类必须用javax.persistence.Entity注解
  * 类必须有一个public或protected的无参数构造函数
  * 实体实例被当作值以分离对象方式进行传递（例如通过会话bean的远程业务接口），则该类必须实现Serializable接口
  * 唯一的对象标识符：简单主键（javax.persistence.Id）、复合主键（javax.persistence.EmbeddedId和javax.persistence.IdClass）

* 关系

  * 一对一：@OneToOne
  * 一对多：@OneToMany
  * 多对一：@ManyToOne
  * 多对多：@ManyToMany

* EntityManager接口

  * 定义用于与持久化上下文进行交互的方法
  * 创建和删除持久实体实例，通过实体的主键查找实体
  * 允许在实体上运行查询

* 获取EntityManager实例

  > @PersistenceUnit
  >
  > EntityManagerFactory emf;
  >
  > EntityManager em;
  >
  > @Resource
  >
  > UserTransaction utx;
  >
  > ...
  >
  > em = emf.createEntityManager();
  >
  > try {
  >
  > ​	utx.begin();
  >
  > ​	em.persist(someEntity);
  >
  > ​	em.merge(anotherEntity);
  >
  > ​	em.remove(thirdEntity);
  >
  > ​	utx.commit();
  >
  > } catch (Exception e) {
  >
  > ​	utx.rollback();
  >
  > }

### Spring Data JPA

> **什么是Spring Data JPA**

* 它是更大的Spring Data家族的一部分
* 对基于JPA的数据访问层的增强支持
* 更容易构建基于使用Spring数据访问技术栈的应用程序

> **Spring Data JPA 常用接口**

* CrudRepository

  > public interface CrudRepository<T, TD extends Serializable> extends Repository<T, ID> {
  >
  > ​	<S extends T> S save(S entity);
  >
  > ​	T findOne(ID primaryKey);
  >
  > ​	Iterable<T> findAll();
  >
  > ​	Long count();
  >
  > ​	void delete(T entity);
  >
  > ​	boolean exists(ID primaryKey);
  >
  > ​	// ... more functionality omitted.
  >
  > }

* PagingAndSortingRepository

  > public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
  >
  > ​	Iterable<?> findAll(Sort sort);
  >
  > ​	Page<T> findAll(Pageable pageable);
  >
  > }

> **Spring Data JPA自定义接口**

* 根据方法名创建查询

### Spring Data JPA、Hibernate 与 Spring Boot 集成

> **配置环境**

* MySQL Community Server 5.7+
* Spring Data JPA 1.11.1.RELEASE
* Hibernate 5.2.8.Final
* MySQL Connector/J 6.0.5

> 1.持久化到H2

build.gradle中添加依赖：

```
compile('org.springframework.boot:spring-boot-starter-data-jpa')
compile('mysql:mysql-connector-java:6.0.5')
runtime('com.h2database:h2:1.4.196')
```

修改application.properties

```
# 使用 H2 浏览器控制台
spring.h2.console.enabled=true
```

启动应用后，访问：http://localhost:8080/h2-console/

![1542539953655](docs\images\h2-console-login-page.png)

> 2.持久化到MySQL

启动mysql

```
# docker pull hub.c.163.com/library/mysql:latest
# docker run -d -p 3306:3306 -v /data/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=bigdata hub.c.163.com/library/mysql
```

创建blog数据库

> create database blog default charset utf8 collate utf8_general_ci;

修改application.properties，假如mysql配置

```
# DataSource
spring.datasource.url=jdbc:mysql://192.168.0.70/blog?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=bigdata
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.show-sql = true
# 每次启动时如果存在就删除，开发时很有用
spring.jpa.hibernate.ddl-auto=create-drop
```

启动应用，观察控制台，自动创建表

> Hibernate: drop table if exists user
> Hibernate: create table user (id bigint not null auto_increment, email varchar(255), name varchar(255), primary key (id))

## Bootstrap

### Bootstrap简介

* 基于HTML、CSS、JavaScript的前端框架

* 响应式布局

* 移动设备优先

* 支持HTML5标准，doctype

  `<!DOCTYPE html>`

  `<html lang="en">`

  `...`

  `</html>`

* 响应式meta标签

`<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">`

* Normalize.css
  * 使用Normalize来建立跨浏览器的一致性
  * Reboot

### Bootstrap网格系统

> 1.什么是移动设备优先策略？

* 基础的CSS是移动优先。优先设计更小的宽度
* 媒体查询。针对平板、台式机适配
* 渐进增强。随着屏幕大小的增加而添加元素

> 2.响应式布局

* viewport尺寸的增加，系统会自动分为最多12列

> 3.Bootstrap网格选项

|              | 超小手机（<768px）     | 小型平板电脑（>=768px）      | 中型台式电脑（>=992px）      | 大型台式电脑（>=1200px）     |
| :----------- | ---------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| 网格行为     | 一直是水平的           | 以折叠开始，断点以上是水平的 | 以折叠开始，断点以上是水平的 | 以折叠开始，断点以上是水平的 |
| 最大容器宽度 | None(auto)             | 750px                        | 970px                        | 1170px                       |
| Class前缀    | .col-xs-<N>            | .col-sm-<N>                  | .col-md-<N>                  | .col-lg-<N>                  |
| 列数量和     | 12                     | 12                           | 12                           | 12                           |
| 最大列宽     | Auto                   | -61px                        | -81px                        | -97px                        |
| 间隙宽度     | 30px(一列两边各分15px) | 30px(一列两边各分15px)       | 30px(一列两边各分15px)       | 30px(一列两边各分15px)       |
| 可嵌套       | yes                    | yes                          | yes                          | yes                          |
| 偏移量       | yes                    | yes                          | yes                          | yes                          |
| 列排序       | yes                    | yes                          | yes                          | yes                          |

### Bootstrap常用组件、样式

[官方组件](https://v4.bootcss.com/docs/4.0/components/alerts/)

### Bootstrap与Spring Boot集成

> 配置环境·常用前端框架

| Tether 1.4.0            | http://tether.io                             |
| ----------------------- | -------------------------------------------- |
| Bootstrap v4.0.0        | http://getbootstrap.com/                     |
| jQuery 3.3.1            | http://jquery.com/download/                  |
| Font Awesome 4.7.0      | https://fontawesome.com/?from=io             |
| NProgress 0.2.0         | http://ricostacruz.com/nprogress/            |
| Thinker-md              | https://gitee.com/benhail/thinker-md         |
| jQuery Tags Input 1.3.6 | http://xoxco.com/projects/code/tagsinput/    |
| Bootstrap Chosen 1.0.3  | https://github.com/haubek/bootstrap4c-chosen |
| toastr 2.1.1            | http://www.toastrjs.com/                     |



## 全文搜索

基于Java的开源实现的全文搜索技术：

* Lucene
* ElasticSearch
* Solr

### ElasticSearch

> 简介

* 高度可扩展的开源全文搜索和分析引擎
* 快速地、近实时地对大数据进行存储、搜索和分析
* 用来支撑有复杂的数据搜索需求的企业级应用

> 特点

* 分布式
* 高可用
* 多类型
* 多API
* 面向文档
* 异步写入
* 近实时
* 基于Lucene
* 遵循Apache协议

> 核心概念

* 近实时：index_refresh
* 集群：集群名（节点通过集群名识别和加入集群）
* 节点：节点名
* 索引
* 类型
* 文档
* 分片（默认5分片、2副本）
* 副本

### Elasticsearch与Spring Boot集成

> 配置环境

* Elasticsearch 2.4.4
* Spring Data Elasticsearch 2.1.3.RELEASE
* JNA 4.3.0

> 修改build.gradle

```
// 添加 Spring Data Elasticsearch 的依赖
compile('org.springframework.boot:spring-boot-starter-data-elasticsearch')
// 添加 JNA 的依赖
compile('net.java.dev.jna:jna:4.3.0')
```

> 修改application.properties

```
# Elasticsearch 服务地址
spring.data.elasticsearch.cluster-nodes=localhost:9300
# 设置连接超时时间
spring.data.elasticsearch.properties.transport.tcp.connect_timeout=120s
```

> 后台编码

* 文档实体 EsBlog
* 资源库 EsBlogRepository
* 资源库测试用例 EsBlogRepositoryTest
* 控制器 BlogController

## 需求分析

> 博客系统核心功能

* 用户管理：注册、登录、增加/修改/删除/搜索用户
* 安全设置：角色授权、权限管理
* 博客管理：发表、编辑、删除、分类、标签设置、上传图片、最新/最热排序、阅读量统计
* 评论管理：发表评论、删除评论、评论统计
* 点赞管理：点赞、取消点赞、点赞量统计
* 分类管理：创建分类、编辑分类、删除分类、按分类查询
* 标签管理：创建标签、删除标签、按标签查询
* 首页搜索：全文检索、最新/最热文章、热门标签/用户/文章

## 原型设计

* 首页
* 用户主页
* 博客页面

## 权限管理

