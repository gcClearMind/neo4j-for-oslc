package neo4j.tool;

import neo4j.entity.Block;

import java.util.ArrayList;
import java.util.List;

public class ConventToRdf {
    private static final String RDF_PREFIX =
            "@prefix ex: <http://example.org/block#> .\n" +
                    "@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .\n" +
                    "@prefix xsd: <http://www.w3.org/2001/XMLSchema#> .\n\n";

    // 将Block实体集合转换为RDF格式的字符串
    public static String blocksToRdf(List<Block> blocks) {
        StringBuilder rdf = new StringBuilder(RDF_PREFIX);

        for (Block block : blocks) {
            // 为每个Block实体生成一个RDF描述
            rdf.append("ex:block").append(block.getId())
                    .append(" a ex:Block ;\n")
                    .append("  ex:name \"").append(escapeRdfString(block.getName())).append("\" ;\n")
                    .append("  ex:XmiType \"").append(escapeRdfString(block.getXmiType())).append("\" ;\n")
                    .append("  ex:XmiId \"").append(escapeRdfString(block.getXmiId())).append("\" ;\n")
                    .append("  ex:visibility \"").append(escapeRdfString(block.getVisibility())).append("\" .\n\n");
        }

        return rdf.toString();
    }

    // 转义RDF字符串中的非法字符
    private static String escapeRdfString(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    // 示例主函数，展示如何使用blocksToRdf函数
    public static void main(String[] args) {
        // 假设这是从数据库检索到的Block实体列表
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(1L, "Example Block", "uml:Class", "12345", "public"));
        // ... 添加更多Block实体

        // 转换为RDF格式
        String rdfData = blocksToRdf(blocks);
        System.out.println(rdfData);
    }
}
