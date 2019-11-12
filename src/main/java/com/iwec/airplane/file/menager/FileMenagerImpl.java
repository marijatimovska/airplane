package com.iwec.airplane.file.menager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public abstract class FileMenagerImpl<T> implements FileMenager<T> {

	@Override
	public List<T> read(String file) {
		List<T> results = new LinkedList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {
			String line;

			while ((line = br.readLine()) != null) {
				T t = createInstance(line);
				if (t != null) {
					results.add(t);
				}
			}

		} catch (IOException e) {
			System.err.println("Error while reading file" + file);
		}
		return results;
	}

	public abstract T createInstance(String line);

	@Override
	public void write(String file, List<String> list) {
		//public void write(String file, List<T> list) {
		try (PrintWriter out = new PrintWriter(file)) {
			out.write(list.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
