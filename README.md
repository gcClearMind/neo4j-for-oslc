# 主要文件和功能模块

## 配置文件

pom.xml：Maven 项目配置文件，定义了项目的依赖和插件。
application.yml：Spring Boot 项目配置文件，配置了 Neo4j 数据库连接信息、Thymeleaf 模板引擎和服务器端口等。

## 词汇表文件

vocabulary.rdf：定义了知识图谱的节点类和属性，以及词汇表的元数据。

## 实体类

neo4j.entity.Block：表示知识图谱中的块（Block）节点，包含节点的基本属性。

## 数据访问层（DAO）

neo4j.dao.BlockDao：提供了对块（Block）节点的数据库查询方法。
neo4j.dao.NodeDao：提供了对节点的数据库查询方法。

## 服务层（Service）

neo4j.service.BlockService：定义了块（Block）节点的业务逻辑接口。
neo4j.service.BlockServiceImpl：实现了块（Block）节点的业务逻辑。
neo4j.service.VocabService：定义了获取词汇表的业务逻辑接口。
neo4j.service.VocabServiceImpl：实现了获取词汇表的业务逻辑。
neo4j.service.NodeService：定义了节点的业务逻辑接口。

## 控制层（Controller）

neo4j.controller.BlockController：提供了对块（Block）节点的 RESTful 接口。
neo4j.controller.vocabController：提供了获取词汇表的 RESTful 接口。
neo4j.controller.NodeController：提供了对节点的 RESTful 接口。

## 工具类

neo4j.tool.CoreOWLUtil：提供了对 OWL 本体模型的操作工具方法。
neo4j.tool.Pair：定义了一个简单的键值对类。
neo4j.tool.CorsConfig：配置了跨域访问。
Servlet 类
neo4j.servlet.RoadServlet：实现了查找路径的功能，并将结果存储在文件中。

## 前端页面

src/main/resources/static/index.html：简单的 HTML 页面，用于测试。
src/main/resources/templates/test.html：Thymeleaf 模板页面，用于展示数据。

## 依赖库

Spring Boot：提供了快速开发的框架和工具。
Spring Data Neo4j：用于与 Neo4j 数据库进行交互。
Apache Jena：用于处理 RDF 和 OWL 数据。
FastJSON：用于 JSON 数据的处理。
Thymeleaf：用于构建动态 HTML 页面。

## 启动方式

项目使用 Spring Boot 框架，可以通过运行 neo4j.Neo4jApplication 类的 main 方法来启动项目。启动后，项目将监听 8080 端口，通过访问 http://localhost:8080/neo4j 可以访问项目的接口和页面