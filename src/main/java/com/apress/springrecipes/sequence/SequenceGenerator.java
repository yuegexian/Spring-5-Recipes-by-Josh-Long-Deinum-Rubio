package com.apress.springrecipes.sequence;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Resource;
//import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

public class SequenceGenerator {

	private String prefix;

	// By default, the @Resource annotation works like Spring’s @Autowired
	// annotation and attempts to autowire by type
	@Resource
	// @Inject annotation attempts to autowire by type, like the @Resource and
	// @Autowired annotations
	// @Inject
	private PrefixGenerator prefixGeneratorProperty;

	private String suffix;
	private int initial;

	/*
	 * @Autowired private PrefixGenerator[] prefixGeneratorsArray;
	 * 
	 * @Autowired private List<PrefixGenerator> prefixGeneratorList;
	 * 
	 * @Autowired private Map<String, PrefixGenerator> prefixGeneratorsMap;
	 */

	private final AtomicInteger counter = new AtomicInteger();

	public SequenceGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Autowired(required=false) public void
	 * myOwnCustomInjectionName(PrefixGenerator prefixGenerator) {
	 * this.prefixGeneratorProperty = prefixGenerator; }
	 * 
	 * @Autowired(required=false) public void
	 * setPrefixGeneratorProperty(PrefixGenerator prefixGeneratorProperty) {
	 * this.prefixGeneratorProperty = prefixGeneratorProperty; }
	 */

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public String getSequence() {
		StringBuilder builder = new StringBuilder();
		builder.append(prefix).append(initial).append(counter.getAndIncrement()).append(suffix);
		return builder.toString();
	}

	public PrefixGenerator getPrefixGeneratorProperty() {
		return prefixGeneratorProperty;
	}

}
