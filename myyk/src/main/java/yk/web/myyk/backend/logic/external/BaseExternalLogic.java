package yk.web.myyk.backend.logic.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.exception.ApiException;

public class BaseExternalLogic extends BaseLogic {

	protected HttpsURLConnection getConn(ExternalURL url) throws ApiException {
		
		int tryCount = 0;
		
		while(true) {
			try {
				HttpsURLConnection conn = (HttpsURLConnection) new URL(url.getUrl()).openConnection();
				conn.setConnectTimeout(Constant.getUrlTimeout());
				conn.setReadTimeout(Constant.getUrlTimeout());
				conn.setDoInput(true);
				conn.setDoOutput(true);
				conn.connect();
				return conn;
			} catch (IOException e) {
				e.printStackTrace();
				tryCount++;
				if (tryCount >= Constant.getUrlTry()) {
					throw new ApiException();
				}
			}
		}
	}
	
	protected String read(HttpsURLConnection conn) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApiException();
		}
	}
	
	protected void write(HttpsURLConnection conn, String json) {
	
		try {
			OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
			osw.write(json);
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApiException();
		}
	}
	
	public enum ExternalURL {
		
		BOOTSTRAP_ICON("https://icons.getbootstrap.kr/"),
		
		;
		private String url;
		
		ExternalURL(String url) {
			this.url = url;
		}
		
		public String getUrl() {
			return url;
		}
	}
	
}
