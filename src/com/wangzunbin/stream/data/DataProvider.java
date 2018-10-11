package com.wangzunbin.stream.data;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class DataProvider {

	private static DataProvider instance = new DataProvider();
	private List<Director> directors;

	private DataProvider() {
		try {
			URL uri = DataProvider.class.getClassLoader().getResource("data.json");
			Path path = Paths.get(uri.toURI());
			String jsonStr = new String(Files.readAllBytes(path), "UTF8");
			directors = JSON.parseArray(jsonStr, Director.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataProvider getInstance() {
		return instance;
	}

	public List<Director> getData() {
		return directors;
	}
}
