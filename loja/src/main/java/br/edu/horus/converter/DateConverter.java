package br.edu.horus.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.Specializes;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;

@Specializes
@Convert(Date.class)
public class DateConverter 
	extends br.com.caelum.vraptor.converter.DateConverter 
	implements Converter<Date>{

	@Override
	public Date convert(String value, Class<? extends Date> type) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date data = df.parse(value);
			return data;
		}catch(ParseException e){
			throw new RuntimeException(e);
		}
	}

}
