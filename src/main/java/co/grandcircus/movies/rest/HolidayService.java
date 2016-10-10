package co.grandcircus.movies.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.movies.model.Holiday;
import co.grandcircus.movies.model.Weather;

@Service
public class HolidayService {
	private final static String key = "16988214-ad9e-47c0-954e-831473fb5417";
	private final static String country = "us";
	private final static Integer year = 2015;
	private final static Integer month = 10;

	public ArrayList<Holiday> getCurrentHolidays() {
		return getCurrentHolidayAt(key, country, year, month);
	}

	public ArrayList<Holiday> getCurrentHolidayAt(String key, String country, Integer year, Integer month) {
		String url = "https://holidayapi.com/v1/holidays?key=" + key + "&country=" + country + "&year=" + year
				+ "&month=" + month + "&FcstType=json";

		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}

			JsonElement root = new JsonParser().parse(reader);
			JsonArray holidays = root.getAsJsonObject().get("holidays").getAsJsonArray();

			ArrayList<Holiday> holidayList = new ArrayList<Holiday>();

			for (int i = 0; i < holidays.size(); i++) {

				Holiday holiday = new Holiday();
				holiday.setName(holidays.get(i).getAsJsonObject().get("name").getAsString());
				holiday.setDate(holidays.get(i).getAsJsonObject().get("date").getAsString());

				holidayList.add(holiday);

			}

			return holidayList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}