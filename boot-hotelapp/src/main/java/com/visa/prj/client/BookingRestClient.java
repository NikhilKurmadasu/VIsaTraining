package com.visa.prj.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;;

public class BookingRestClient {

	public static void main(String[] args) {

				String url = "http://localhost:8080/bookings";
				RestTemplate template = new RestTemplate();
			 	methodOne(template, url);
				methodTwo(template, url);
				methodThree(template, url);
			}

			private static void methodThree(RestTemplate template, String url) {

				HttpHeaders headers = new HttpHeaders();
				 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				 headers.setContentType(MediaType.APPLICATION_JSON);
				 Hotel h=new Hotel();
				 h.setName("Raj");
				 h.setAddress("kakinada");
				 h.setCity("AP");
				 h.setCountry("india");
				 h.setPrice(null);
				 User u =new User();
				 u.setEmail("mm@gmail.com");
				 u.setEnabled(true);
				 u.setName("mohan");
				 u.setPassword("mm");
				 u.setUsername("mohanmm");
				Booking b = new Booking(h,u);
				HttpEntity<Booking> requestEntity = new HttpEntity<Booking>(b, headers);

				ResponseEntity<Booking> result = template.postForEntity(url, requestEntity, Booking.class);
				System.out.println(result.getStatusCode()); // 201
				System.out.println(result.getBody().getId());
			}

			private static void methodOne(RestTemplate template, String url) {

				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				String json = template.getForObject(url, String.class);
				System.out.println(json);

			}

			private static void methodTwo(RestTemplate template, String url) {
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

				ResponseEntity<List<Booking>> response = 
						template.exchange(url, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<Booking>>() {});

				System.out.println(response.getStatusCode());
				List<Booking> bookings = response.getBody();
				for (Booking b : bookings) {
					System.out.println(b.getId() + "," + b.getUser());
				}
			}
}
