/*
 * Copyright (C) 2010 Miorel-Lucian Palii
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package com.googlecode.lawu.net.spoj;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Submission {
	private static final Pattern SUBMISSION_LINE = Pattern.compile("\\s*([^\\|]+?)\\s*(?=\\|)");
	private static final DateFormat DATE_PARSER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
	private static final String SPOJ_TZ = "CET";
	
	private final User user;
	private final int id;
	private final Date date;
	private final String problem;
	private final String result;
	private final int time;
	private final int memory;
	private final Language language;
	
	public Submission(User user, int id, Date date, String problem, String result, int time, int memory, Language language) {
		if(user == null)
			throw new IllegalArgumentException("The user may not be null.");
		if(id < 0)
			throw new IllegalArgumentException("The ID may not be negative.");
		if(date == null)
			throw new IllegalArgumentException("The date may not be null.");
		if(problem == null || problem.isEmpty())
			throw new IllegalArgumentException("The problem code may not be null or zero length.");
		if(result == null || result.isEmpty())
			throw new IllegalArgumentException("The result code may not be null or zero length.");
		if(language == null)
			throw new IllegalArgumentException("The language may not be null.");
		this.user = user;
		this.id = id;
		this.date = date;
		this.problem = problem.toUpperCase(Locale.ENGLISH);
		this.result = result.toUpperCase(Locale.ENGLISH);			
		this.time = time < 0 ? 0 : time;
		this.memory = memory < 0 ? 0 : memory;
		this.language = language;
	}
	
	// TODO make exceptions more specific
	public static Submission parse(User user, String submissionLine) {
		Matcher m = SUBMISSION_LINE.matcher(submissionLine.trim());
		List<String> tokens = new ArrayList<String>();
		while(m.find())
			tokens.add(m.group(1).trim());
		if(tokens.size() != 7)
			throw new RuntimeException("Expected 7 tokens, found " + tokens.size() + ".");
		Submission ret;
		try {
			int id = Integer.parseInt(tokens.get(0));
			Date date = DATE_PARSER.parse(tokens.get(1) + " " + SPOJ_TZ);
			String problem = tokens.get(2);
			String result = tokens.get(3);
			int time = (int) Math.round(1000 * Double.parseDouble(tokens.get(4)));
			int memory = Integer.parseInt(tokens.get(5));
			Language language = Language.forSpojName(tokens.get(6));
			ret = new Submission(user, id, date, problem, result, time, memory, language);
		}
		catch(NumberFormatException e) {
			throw new RuntimeException("Error parsing numeric value.", e);
		}
		catch(IllegalArgumentException e) {
			throw new RuntimeException("Error constructing: " + e.getMessage(), e);
		}
		catch(ParseException e) {
			throw new RuntimeException("Error parsing date.", e);
		}
		return ret;
	}
	
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		return this == o || (o instanceof Submission && this.id == ((Submission) o).id);
	}

	public User getUser() {
		return user;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getProblem() {
		return problem;
	}
	
	public String getResult() {
		return result;
	}
	
	public int getTime() {
		return time;
	}

	public double getTimeSeconds() {
		return 0.001 * getTime();
	}
	
	public int getMemory() {
		return memory;
	}

	public int getMemoryMegabytes() {
		return getMemory() >> 10;
	}
	
	public Language getLanguage() {
		return language;
	}
}
