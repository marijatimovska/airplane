package com.iwec.airplane.file.menager;

import java.util.List;

public interface FileMenager<T> {
	public List<T> read(String file);
	public void write(String file, List<String> lp);
	//public void write(String file, List<T> lp);
}
