package com.bsit.codegeneration.model;

import java.util.List;

public class DatabaseConfig {
  private String name;
  private String dialect;
  private String driver;
  private String url;
  private String user;
  private String password;
  private String schema;
  private List<String> includes;
  private List<String> excludes;
  private InputFilterConfig inputFilter;
  private NamingStrategyConfig namingStrategy;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDialect() {
    return dialect;
  }

  public void setDialect(String dialect) {
    this.dialect = dialect;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public List<String> getIncludes() {
    return includes;
  }

  public void setIncludes(List<String> includes) {
    this.includes = includes;
  }

  public List<String> getExcludes() {
    return excludes;
  }

  public void setExcludes(List<String> excludes) {
    this.excludes = excludes;
  }

  public InputFilterConfig getInputFilter() {
    return inputFilter;
  }

  public void setInputFilter(InputFilterConfig inputFilter) {
    this.inputFilter = inputFilter;
  }

  public NamingStrategyConfig getNamingStrategy() {
    return namingStrategy;
  }

  public void setNamingStrategy(NamingStrategyConfig namingStrategy) {
    this.namingStrategy = namingStrategy;
  }
}
