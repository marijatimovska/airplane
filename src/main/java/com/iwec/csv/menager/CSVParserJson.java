package com.iwec.csv.menager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CSVParserJson {
	public <T> List<String> convertToString(List<T> objectList) {

	    if(objectList.isEmpty())
	        return Collections.emptyList();

	    T entry = objectList.get(0);

	    List<String> stringList = new ArrayList<>();
	    char delimiter = ',';
	    char quote = '"';
	    String lineSep = "\n";

	    CsvMapper mapper = new CsvMapper();
	    CsvSchema schema = mapper.schemaFor(entry.getClass());

	    for (T object : objectList) {

	        try {
	            String csv = mapper.writer(schema
	                    .withColumnSeparator(delimiter)
	                    .withQuoteChar(quote)
	                   .withLineSeparator(lineSep)).writeValueAsString(object);

	            stringList.add(csv);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    return stringList;
	}

}
