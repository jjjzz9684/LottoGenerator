import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoadRecentNum {

	static NumList nl = new NumList();

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		String url = "https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";
		try {
			FileWriter writer = new FileWriter("RecentWinList.txt");

			for (int i = 1; i < 845; i++) {
				String str = jsonGetRequest(url + i);
				
				JSONObject obj = (JSONObject) parser.parse(str);
				nl.setBnusNo((Long) obj.get("bnusNo"));
				nl.setDrwtNo1((Long) obj.get("drwtNo1"));
				nl.setDrwtNo2((Long) obj.get("drwtNo2"));
				nl.setDrwtNo3((Long) obj.get("drwtNo3"));
				nl.setDrwtNo4((Long) obj.get("drwtNo4"));
				nl.setDrwtNo5((Long) obj.get("drwtNo5"));
				nl.setDrwtNo6((Long) obj.get("drwtNo6"));
				nl.setDrwNo((Long) obj.get("drwNo"));
				nl.setDrwNoDate((String) obj.get("drwNoDate"));

				System.out.println(nl);
				for (Long nums : nl.numbers()) {
					writer.write(nums.toString() + " ");
				}
				writer.write("\r\n");

			}
			writer.close();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private static String streamToString(InputStream inputStream) {
		String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
		return text;
	}

	public static String jsonGetRequest(String urlQueryString) {
		String json = null;
		try {
			URL url = new URL(urlQueryString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}

	/* 검증되지 않은 주소 접속 */
	static {
		disableSslVerification();
	}

	private static void disableSslVerification() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}
}