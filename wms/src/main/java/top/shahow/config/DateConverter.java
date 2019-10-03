package top.shahow.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	private static final List<String> formarts = new ArrayList<String>(4);

	static {
		formarts.add("yyyy-MM");
		formarts.add("yyyy-MM-dd");
		formarts.add("yyyy-MM-dd HH:mm");
		formarts.add("yyyy-MM-dd HH:mm:ss");
	}

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		try {
			if (source.matches("^\\d{4}-\\d{1,2}$")) {
				return parseDate(source, formarts.get(0));
			} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
				return parseDate(source, formarts.get(1));
			} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
				return parseDate(source, formarts.get(2));
			} else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
				return parseDate(source, formarts.get(3));
			} else {
				throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化日期
	 * 
	 * @param dateStr String 字符型日期
	 * @param format  String 格式  
	 * @return Date 日期    
	 * 
	 * @throws ParseException
	 */
	public Date parseDate(String dateStr, String format) throws ParseException {
		Date date = null;
		DateFormat dateFormat = new SimpleDateFormat(format);
		date = dateFormat.parse(dateStr);
		return date;
	}

}
