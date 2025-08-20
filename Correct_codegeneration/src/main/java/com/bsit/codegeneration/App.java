package com.bsit.codegeneration;

import com.bsit.codegeneration.metadata.YamlParser;

public class App {
  public static void main(String[] args) throws Exception {
    YamlParser yamlParser = new YamlParser();
    yamlParser.generate();
  }
}
