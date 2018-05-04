package schwimmer.nytimes;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NYTimesServiceTest {

	@Test
	public void testGetTopStories() throws IOException {
		
		// given
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.nytimes.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		NYTimesService service = retrofit.create(NYTimesService.class);
		Call<StoriesModel> call = service.getTopStories();
		
		// when
		Response<StoriesModel> response = call.execute();
		
		// then
		assertNotNull(response.body());
		
		List<Story> stories = response.body().results;
		assertTrue(stories.size() > 0);
		
		String title = stories.get(0).title;
		assertNotNull(title);
		
	}

}
