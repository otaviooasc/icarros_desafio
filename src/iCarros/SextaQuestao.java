package iCarros;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class SextaQuestao {
	public static void respostaSextaQuestao() throws IOException {
		// essa aqui é a questão q busca dados da Web
		URL url = new URL("https://ergast.com/api/f1/2017/last/results.json");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if (responseCode != 200) {
			throw new IOException("HTTP error code: " + responseCode);
		}

		InputStream inputStream = connection.getInputStream();
		String responseBody = new String(inputStream.readAllBytes());
		JSONObject jsonObject = new JSONObject(responseBody);

		JSONArray arrayRaces = jsonObject.getJSONObject("MRData").getJSONObject("RaceTable").getJSONArray("Races");

		System.out.println("Aqui será mostrado a tabela de corridas:");
		for (int j = 0; j < arrayRaces.length(); j++) {
			System.out.println("Season: " + arrayRaces.getJSONObject(j).getString("season"));
			System.out.println("Round: " + arrayRaces.getJSONObject(j).getString("round"));
			System.out.println("URL: " + arrayRaces.getJSONObject(j).getString("url"));
			System.out.println("RaceName: " + arrayRaces.getJSONObject(j).getString("raceName"));

			System.out.println("-------CIRCUIT-------");
			System.out.println(
					"circuitId: " + arrayRaces.getJSONObject(j).getJSONObject("Circuit").getString("circuitId"));
			System.out.println(
					"circuitName: " + arrayRaces.getJSONObject(j).getJSONObject("Circuit").getString("circuitName"));
			System.out.println("url: " + arrayRaces.getJSONObject(j).getJSONObject("Circuit").getString("url"));

			System.out.println("-------LOCATION-------");
			System.out.println("lat: "
					+ arrayRaces.getJSONObject(j).getJSONObject("Circuit").getJSONObject("Location").getString("lat"));
			System.out.println("long: "
					+ arrayRaces.getJSONObject(j).getJSONObject("Circuit").getJSONObject("Location").getString("long"));
			System.out.println("locality: " + arrayRaces.getJSONObject(j).getJSONObject("Circuit")
					.getJSONObject("Location").getString("locality"));
			System.out.println("country: " + arrayRaces.getJSONObject(j).getJSONObject("Circuit")
					.getJSONObject("Location").getString("country"));

			JSONArray arrayResults = arrayRaces.getJSONObject(j).getJSONArray("Results");
			for (int k = 0; k < arrayResults.length(); k++) {
				System.out.println("-------RESULTS-------");
				System.out.println("Number: " + arrayResults.getJSONObject(k).getString("number"));
				System.out.println("Position: " + arrayResults.getJSONObject(k).getString("position"));
				System.out.println("Position Text: " + arrayResults.getJSONObject(k).getString("positionText"));
				System.out.println("Points: " + arrayResults.getJSONObject(k).getString("points"));

				System.out.println("-------RESULT DRIVER-------");
				System.out.println(
						"DriverId: " + arrayResults.getJSONObject(k).getJSONObject("Driver").getString("driverId"));
				System.out.println("permanentNumber: "
						+ arrayResults.getJSONObject(k).getJSONObject("Driver").getString("permanentNumber"));
				System.out.println("code: " + arrayResults.getJSONObject(k).getJSONObject("Driver").getString("code"));
				System.out.println("url: " + arrayResults.getJSONObject(k).getJSONObject("Driver").getString("url"));
				System.out.println(
						"givenName: " + arrayResults.getJSONObject(k).getJSONObject("Driver").getString("givenName"));
				System.out.println(
						"familyName: " + arrayResults.getJSONObject(k).getJSONObject("Driver").getString("familyName"));
				System.out.println("dateOfBirth: "
						+ arrayResults.getJSONObject(k).getJSONObject("Driver").getString("dateOfBirth"));
				System.out.println("nationality: "
						+ arrayResults.getJSONObject(k).getJSONObject("Driver").getString("nationality"));

				System.out.println("-------RESULT CONSTRUCTOR-------");
				System.out.println("ConstructorId: "
						+ arrayResults.getJSONObject(k).getJSONObject("Constructor").getString("constructorId"));
				System.out
						.println("Url: " + arrayResults.getJSONObject(k).getJSONObject("Constructor").getString("url"));
				System.out.println(
						"Name: " + arrayResults.getJSONObject(k).getJSONObject("Constructor").getString("name"));
				System.out.println("Nationality: "
						+ arrayResults.getJSONObject(k).getJSONObject("Constructor").getString("nationality"));
				System.out.println("--------------");

				System.out.println("Grid: " + arrayResults.getJSONObject(k).getString("grid"));
				System.out.println("Laps: " + arrayResults.getJSONObject(k).getString("laps"));
				System.out.println("Status: " + arrayResults.getJSONObject(k).getString("status"));

				try {
					System.out.println("-------RESULT TIME-------");
					System.out.println(
							"Millis: " + arrayResults.getJSONObject(k).getJSONObject("Time").getString("millis"));
					System.out
							.println("Time: " + arrayResults.getJSONObject(k).getJSONObject("Time").getString("time"));
				} catch (Exception e) {
				}

				System.out.println("-------RESULT FASTESTLAP-------");
				System.out.println(
						"Rank: " + arrayResults.getJSONObject(k).getJSONObject("FastestLap").getString("rank"));
				System.out
						.println("Lap: " + arrayResults.getJSONObject(k).getJSONObject("FastestLap").getString("lap"));

				System.out.println("-------RESULT FASTESTLAP TIME-------");
				System.out.println("Time: " + arrayResults.getJSONObject(k).getJSONObject("FastestLap")
						.getJSONObject("Time").getString("time"));

				System.out.println("-------RESULT FASTESTLAP AVARAGESPEED-------");
				System.out.println("units: " + arrayResults.getJSONObject(k).getJSONObject("FastestLap")
						.getJSONObject("AverageSpeed").getString("units"));
				System.out.println("units: " + arrayResults.getJSONObject(k).getJSONObject("FastestLap")
						.getJSONObject("AverageSpeed").getString("speed"));
			}
		}
	}
}
