package com.braintreepayments.http.serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StreamUtils {

	public static String readStream(InputStream in) throws IOException {
		if (in == null) {
			return null;
		}

		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			for (int count; (count = in.read(buffer)) != -1; ) {
				out.write(buffer, 0, count);
			}

			return new String(out.toByteArray(), UTF_8);
		} finally {
			try {
				in.close();
			} catch (IOException ignored) {}
		}
	}

	public static void writeOutputStream(OutputStream outputStream, String data) throws IOException {
		writeOutputStream(outputStream, data.getBytes());
	}

	public static void writeOutputStream(OutputStream outputStream, byte[] data) throws IOException {
		outputStream.write(data);
	}
}
