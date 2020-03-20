package com.frameworks.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
	private String FilePath;
	private Properties properties;
	private FileInputStream fip;

	public PropertiesReader(String FilePath) throws IOException {
		this.FilePath = FilePath;
		fip = new FileInputStream(FilePath);
		properties = new Properties();
		properties.load(fip);
	}

	public String getPropertyValue(String Key) {
		String value = "";
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent())
			value = properties.getProperty(Key);
		else
			System.out.println("Properties object is pointing to null");
		return value;
	}

	public String getPropertyValue(String Key, String DefaultValue) {
		String value = "";
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent()) {
			value = properties.getProperty(Key);

			if (value == null) {
				value = DefaultValue;
			}
		} else
			System.out.println("Properties object is pointing to null");
		return value;
	}

	public String getPropertyValue(Object Key) {
		String value = "";
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent())
			value = (String) properties.get(Key);
		else
			System.out.println("Properties object is pointing to null");
		return value;
	}

	public String getPropertyValue(Object Key, Object DefaultValue) {
		String Value = "";
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent()) {
			Value = (String) properties.getOrDefault(Key, DefaultValue);
			if (Value == null) {
				Value = (String) DefaultValue;
			}
		} else
			System.out.println("Properties object is pointing to null");
		return Value;
	}

	public void setKeyValueData(String Key, String Value) throws FileNotFoundException, IOException {
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent()) {
			properties.setProperty(Key, Value);
			properties.store(new FileOutputStream(FilePath), "File is saved successfully");
		} else
			System.out.println("Properties object is pointing to null");

	}

	public void setKeyValueData(Object Key, Object Value) throws FileNotFoundException, IOException {
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent()) {
			properties.put(Key, Value);
			properties.store(new FileOutputStream(FilePath), "File is saved successfully");
		} else
			System.out.println("Properties object is pointing to null");
	}

	public void remove(String Key) {
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent()) {
			properties.remove(Key);
		} else
			System.out.println("Properties object is pointing to null");
	}

	public void remove(String Key, String Value) {
		Optional<Properties> optional = Optional.ofNullable(properties);
		if (optional.isPresent()) {
			properties.remove(Key, Value);
		} else
			System.out.println("Properties object is pointing to null");
	}

	public Set<String> getAllKeys() {
		Set<Object> keys = properties.keySet();
		Set<String> set = new LinkedHashSet<String>();
		for (Object obj : keys) {
			String key = (String) obj;
			set.add(key);
		}
		return set;
	}

	public List<String> getAllValues() {
		Set<Object> keys = properties.keySet();
		List<String> list = new ArrayList<String>();
		for (Object obj : keys) {
			String key = (String) obj;
			String value = properties.getProperty(key);
			list.add(value);
		}
		return list;
	}

	public Map<String, String> getAllKeyValues() {
		Map<String, String> map = new HashMap<String, String>();
		Set<Object> keys = properties.keySet();
		for (Object obj : keys) {
			String key = (String) obj;
			String value = properties.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

}
