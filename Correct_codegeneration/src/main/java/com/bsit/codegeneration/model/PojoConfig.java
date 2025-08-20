package com.bsit.codegeneration.model;

import java.util.List;

public class PojoConfig {
    private boolean generate;
    private List<String> annotations;
    private List<String> implementInterfaces;
    private boolean serializable;
    private boolean useJavaTime;
    private boolean addBuilderPattern;
    private boolean validationAnnotations;
    private boolean includeRelationships;
    private boolean includeReverseRelationships;
    private boolean removeForeignKeyIdFields;
	public boolean isRemoveForeignKeyIdFields() {
		return removeForeignKeyIdFields;
	}
	public void setRemoveForeignKeyIdFields(boolean removeForeignKeyIdFields) {
		this.removeForeignKeyIdFields = removeForeignKeyIdFields;
	}
	public boolean isIncludeRelationships() {
		return includeRelationships;
	}
	public void setIncludeRelationships(boolean includeRelationships) {
		this.includeRelationships = includeRelationships;
	}
	public boolean isIncludeReverseRelationships() {
		return includeReverseRelationships;
	}
	public void setIncludeReverseRelationships(boolean includeReverseRelationships) {
		this.includeReverseRelationships = includeReverseRelationships;
	}
	public boolean isGenerate() {
		return generate;
	}
	public void setGenerate(boolean generate) {
		this.generate = generate;
	}
	public List<String> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(List<String> annotations) {
		this.annotations = annotations;
	}
	public List<String> getImplementInterfaces() {
		return implementInterfaces;
	}
	public void setImplementInterfaces(List<String> implementInterfaces) {
		this.implementInterfaces = implementInterfaces;
	}
	public boolean isSerializable() {
		return serializable;
	}
	public void setSerializable(boolean serializable) {
		this.serializable = serializable;
	}
	public boolean isUseJavaTime() {
		return useJavaTime;
	}
	public void setUseJavaTime(boolean useJavaTime) {
		this.useJavaTime = useJavaTime;
	}
	public boolean isAddBuilderPattern() {
		return addBuilderPattern;
	}
	public void setAddBuilderPattern(boolean addBuilderPattern) {
		this.addBuilderPattern = addBuilderPattern;
	}
	public boolean isValidationAnnotations() {
		return validationAnnotations;
	}
	public void setValidationAnnotations(boolean validationAnnotations) {
		this.validationAnnotations = validationAnnotations;
	}

    
}
