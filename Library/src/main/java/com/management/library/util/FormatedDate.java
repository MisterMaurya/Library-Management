package com.management.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FormatedDate {

	public Date dateOfBirth(String dateOfBirth) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = simpleDateFormat.parse(dateOfBirth);
		return date;
	}

}
